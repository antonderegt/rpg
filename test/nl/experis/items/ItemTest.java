package nl.experis.items;

import nl.experis.attributes.PrimaryAttributes;
import nl.experis.characters.Warrior;
import nl.experis.exceptions.InvalidArmorException;
import nl.experis.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    public void equipWeapon_highLevelWeapon_InvalidWeaponException() {
        // Arrange
        Weapon lvl2Axe = new Weapon("Common Axe", 2, SlotType.WEAPON, WeaponType.AXE, 7, 1.1);
        Warrior lvl1Warrior = new Warrior("Warrior");

        // Act && Assert
        assertThrows(InvalidWeaponException.class, () -> lvl1Warrior.equip(lvl2Axe));
    }

    @Test
    public void equipArmor_highLevelArmor_InvalidArmorException() {
        // Arrange
        Armor lvl2PlateBody = new Armor("Common Plate Body", 2, SlotType.BODY, ArmorType.PLATE, new PrimaryAttributes(1, 0, 0, 2));
        Warrior lvl1Warrior = new Warrior("Warrior");

        // Act && Assert
        assertThrows(InvalidArmorException.class, () -> lvl1Warrior.equip(lvl2PlateBody));
    }

    @Test
    public void equipWeapon_wrongWeapon_InvalidWeaponException() {
        // Arrange
        Weapon lvl1Bow = new Weapon("Common Bow", 1, SlotType.WEAPON, WeaponType.BOW, 12, 0.8);
        Warrior lvl1Warrior = new Warrior("Warrior");

        // Act && Assert
        assertThrows(InvalidWeaponException.class, () -> lvl1Warrior.equip(lvl1Bow));
    }

    @Test
    public void equipArmor_wrongArmor_InvalidArmorException() {
        // Arrange
        Armor lvl1Cloth = new Armor("Common Cloth Head Armor", 1, SlotType.HEADER, ArmorType.CLOTH, new PrimaryAttributes(0, 0, 5, 1));
        Warrior lvl1Warrior = new Warrior("Warrior");

        // Act && Assert
        assertThrows(InvalidArmorException.class, () -> lvl1Warrior.equip(lvl1Cloth));
    }

    @Test
    public void equipWeapon_validWeapon_true() {
        // Arrange
        Weapon lvl1Axe = new Weapon("Common Axe", 1, SlotType.WEAPON, WeaponType.AXE, 7, 1.1);
        Warrior lvl1Warrior = new Warrior("Warrior");
        boolean expected = true;

        // Act
        boolean actual = false;
        try {
            actual = lvl1Warrior.equip(lvl1Axe);
        } catch (InvalidWeaponException e) {
        }

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void equipArmor_validArmor_true() {
        // Arrange
        Armor lvl1PlateBody = new Armor("Common Plate Body", 1, SlotType.BODY, ArmorType.PLATE, new PrimaryAttributes(2, 1, 0, 0));
        Warrior lvl1Warrior = new Warrior("Warrior");
        boolean expected = true;

        // Act
        boolean actual = false;
        try {
            actual = lvl1Warrior.equip(lvl1PlateBody);
        } catch (InvalidArmorException e) {
        }

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDPS_levelOneWarrior_CorrectDPS() {
        // Arrange
        Warrior lvl1Warrior = new Warrior("Warrior");
        double expected = 1 * (1 + (5 / 100.0));

        // Act
        double actual = lvl1Warrior.calculateDamagePerSecond();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDPS_levelOneWarriorWithAxe_CorrectDPS() {
        // Arrange
        Warrior lvl1Warrior = new Warrior("Warrior");
        Weapon lvl1Axe = new Weapon("Common Axe", 1, SlotType.WEAPON, WeaponType.AXE, 7, 1.1);
        double expected = (7 * 1.1) * (1 + (5 / 100.0));

        // Act
        try {
            lvl1Warrior.equip(lvl1Axe);
        } catch (InvalidWeaponException e) {
        }
        double actual = lvl1Warrior.calculateDamagePerSecond();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDPS_levelOneWarriorWithAxeAndPlateBody_CorrectDPS() {
        // Arrange
        Warrior lvl1Warrior = new Warrior("Warrior");
        Weapon lvl1Axe = new Weapon("Common Axe", 1, SlotType.WEAPON, WeaponType.AXE, 7, 1.1);
        Armor lvl1PlateBody = new Armor("Common Plate Body", 1, SlotType.BODY, ArmorType.PLATE, new PrimaryAttributes(2, 1, 0, 0));
        double expected = (7 * 1.1) * (1 + ((5 + 1) / 100.0));

        // Act
        try {
            lvl1Warrior.equip(lvl1Axe);
            lvl1Warrior.equip(lvl1PlateBody);
        } catch (InvalidWeaponException e) {
        } catch (InvalidArmorException e) {
        }

        double actual = lvl1Warrior.calculateDamagePerSecond();

        // Assert
        assertEquals(expected, actual);
    }
}