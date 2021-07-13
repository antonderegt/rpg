package nl.experis;

import nl.experis.attributes.PrimaryAttributes;
import nl.experis.attributes.SecondaryAttributes;
import nl.experis.characters.Mage;
import nl.experis.characters.Warrior;
import nl.experis.exceptions.InvalidArmorException;
import nl.experis.exceptions.InvalidWeaponException;
import nl.experis.items.*;

public class Main {

    public static void main(String[] args) {

        // CHARACTER TESTS
        System.out.println("\nCharacter tests");

        // Test 1
        Mage mageSean = new Mage("Sean");
        System.out.println("1. Level should be 1: " + mageSean.getLevel());

        // Test 2
        mageSean.levelUp(1);
        System.out.println("2. Level should be 2: " + mageSean.getLevel());

        // Test 3
        try {
            mageSean.levelUp(0);
        } catch (IllegalArgumentException exception) {
            System.out.println("3. Should throw exception: " + exception);
        }

        // Test 4 (ToDo: other character types)
        Mage mage = new Mage("mage");
        PrimaryAttributes baseMage = mage.getBasePrimaryAttributes();
        System.out.println("4a: Mage - vitality (5): " + baseMage.getVitality() + ", strength (1): " + baseMage.getStrength() + ", dexterity (1): " + baseMage.getDexterity() + ", intelligence (8): " + baseMage.getIntelligence());

        Warrior warrior = new Warrior("warrior");
        PrimaryAttributes baseWarrior = warrior.getBasePrimaryAttributes();
        System.out.println("4d: Warrior - vitality (10): " + baseWarrior.getVitality() + ", strength (5): " + baseWarrior.getStrength() + ", dexterity (2): " + baseWarrior.getDexterity() + ", intelligence (1): " + baseWarrior.getIntelligence());

        // Test 5 (ToDo: other character types)
        mage.levelUp(1);
        System.out.println("5a: Mage - vitality (8): " + baseMage.getVitality() + ", strength (2): " + baseMage.getStrength() + ", dexterity (2): " + baseMage.getDexterity() + ", intelligence (13): " + baseMage.getIntelligence());

        warrior.levelUp(1);
        System.out.println("5d: Warrior - vitality (15): " + baseWarrior.getVitality() + ", strength (8): " + baseWarrior.getStrength() + ", dexterity (2): " + baseWarrior.getDexterity() + ", intelligence (2): " + baseWarrior.getIntelligence());

        // Test 6
        Warrior warrior6 = new Warrior("Warrior");
        warrior.levelUp(1);
        SecondaryAttributes secondariesWarrior = warrior6.getSecondaryAttributes();
        System.out.println("6: Warrior - health (150): " + secondariesWarrior.getHealth() + ", armor rating (12): " + secondariesWarrior.getArmorRating() + ", elemental resistance (2): " + secondariesWarrior.getElementalResistance());

        // END CHARACTER TESTS

        // ITEMS TESTS
        System.out.println("\nItems tests");

        // Test 1
        Weapon lvl2Axe = new Weapon("Common Axe", 2, SlotType.WEAPON, WeaponType.AXE, 7, 1.1);
        Warrior lvl1Warrior = new Warrior("Warrior");
        try {
            lvl1Warrior.equip(lvl2Axe);
        } catch (InvalidWeaponException exception) {
            System.out.println("1. Should throw InvalidWeaponException: " + exception);
        }

        // Test 2
        Armor lvl2PlateBody = new Armor("Common Plate Body", 2, SlotType.BODY, ArmorType.PLATE, new PrimaryAttributes(1, 0, 0, 2));
        try {
            lvl1Warrior.equip(lvl2PlateBody);
        } catch (InvalidArmorException exception) {
            System.out.println("2. Should throw InvalidArmorException: " + exception);
        }

        // Test 3
        Weapon lvl1Bow = new Weapon("Common Bow", 1, SlotType.WEAPON, WeaponType.BOW, 12, 0.8);
        try {
            lvl1Warrior.equip(lvl1Bow);
        } catch (InvalidWeaponException exception) {
            System.out.println("3. Should throw InvalidWeaponException: " + exception);
        }

        // Test 4
        Armor lvl1Cloth = new Armor("Common Cloth Head Armor", 1, SlotType.HEADER, ArmorType.CLOTH, new PrimaryAttributes(0, 0, 5, 1));
        try {
            lvl1Warrior.equip(lvl1Cloth);
        } catch (InvalidArmorException exception) {
            System.out.println("4. Should throw InvalidArmorException: " + exception);
        }

        // Test 5
        Weapon lvl1Axe = new Weapon("Common Axe", 1, SlotType.WEAPON, WeaponType.AXE, 7, 1.1);
        try {
            boolean equipped = lvl1Warrior.equip(lvl1Axe);
            if (equipped) {
                System.out.println("5. Should return true: " + equipped);
            }
        } catch (InvalidWeaponException exception) {
            System.out.println("5. Should return true: " + exception);
        }

        // Test 6
        Armor lvl1PlateBody = new Armor("Common Plate Body", 1, SlotType.BODY, ArmorType.PLATE, new PrimaryAttributes(2, 1, 0, 0));
        try {
            boolean equipped = lvl1Warrior.equip(lvl1PlateBody);
            if (equipped) {
                System.out.println("6. Should return true: " + equipped);
            }
        } catch (InvalidArmorException exception) {
            System.out.println("6. Should return true: " + exception);
        }

        // Test 7
        Warrior dpsWarrior = new Warrior("Warrior");
        double warriorDps = dpsWarrior.calculateDamagePerSecond();
        if (warriorDps == 1 * (1 + (5 / 100.0))) {
            System.out.println("7. Should return 1.05: " + warriorDps);
        }

        // Test 8
        try {
            dpsWarrior.equip(lvl1Axe);
        } catch (InvalidWeaponException e) {
            System.out.println("8. Error: " + e);
        }

        double warriorDpsWithAxe = dpsWarrior.calculateDamagePerSecond();
        if (warriorDpsWithAxe == ((7 * 1.1) * (1 + (5 / 100.0)))) {
            System.out.println("8. Should return 8.085: " + warriorDpsWithAxe);
        }

        // Test 9
        try {
            dpsWarrior.equip(lvl1PlateBody);
        } catch (InvalidArmorException e) {
            System.out.println("9. Error: " + e);
        }

        double warriorDpsWithAxeAndPlateBody = dpsWarrior.calculateDamagePerSecond();
        if (warriorDpsWithAxeAndPlateBody == ((7 * 1.1) * (1 + ((5 + 1) / 100.0)))) {
            System.out.println("9. Should return 8.162: " + warriorDpsWithAxeAndPlateBody);
        }

        // END ITEM TESTS
    }
}
