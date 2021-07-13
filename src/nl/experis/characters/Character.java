package nl.experis.characters;

import nl.experis.attributes.PrimaryAttributes;
import nl.experis.attributes.SecondaryAttributes;
import nl.experis.exceptions.InvalidArmorException;
import nl.experis.exceptions.InvalidWeaponException;
import nl.experis.items.Armor;
import nl.experis.items.Item;
import nl.experis.items.SlotType;
import nl.experis.items.Weapon;

import java.util.HashMap;

public abstract class Character {
    private String name;
    private int level;
    private PrimaryAttributes basePrimaryAttributes;
    private PrimaryAttributes totalPrimaryAttributes;
    private SecondaryAttributes secondaryAttributes;
    private HashMap<SlotType, Item> equipment;

    public Character(String name, int vitality, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.level = 1;
        this.basePrimaryAttributes = new PrimaryAttributes(vitality, strength, dexterity, intelligence);
        this.totalPrimaryAttributes = this.basePrimaryAttributes;
        this.secondaryAttributes = new SecondaryAttributes(vitality * 10, strength + dexterity, intelligence);
        this.equipment = new HashMap<>();
    }

    public void calculateSecondaryStats() {
        int vitality = basePrimaryAttributes.getVitality();
        int strength = basePrimaryAttributes.getStrength();
        int dexterity = basePrimaryAttributes.getDexterity();
        int intelligence = basePrimaryAttributes.getIntelligence();

        this.secondaryAttributes = new SecondaryAttributes(vitality * 10, strength + dexterity, intelligence);
    }

    public double calculateDamagePerSecond() {
        Weapon weapon = (Weapon) this.equipment.get(SlotType.WEAPON);
        double weaponDPS = 1;
        if(weapon != null) {
            weaponDPS = weapon.getAttackSpeed() * weapon.getDamage();
        }

        calculateArmorBonus();
        double multiplier = 1 + this.totalPrimaryAttributes.getStrength() / 100.0;

        return weaponDPS * multiplier;
    }

    private void calculateArmorBonus() {
        int vitalityBonus = 0;
        int strengthBonus = 0;
        int dexterityBonus = 0;
        int intelligenceBonus = 0;

        Armor headArmor = (Armor) this.equipment.get(SlotType.HEADER);
        Armor bodyArmor = (Armor) this.equipment.get(SlotType.BODY);
        Armor legsArmor = (Armor) this.equipment.get(SlotType.LEGS);

        if(headArmor != null) {
            vitalityBonus += headArmor.getAttributes().getVitality();
            strengthBonus += headArmor.getAttributes().getStrength();
            dexterityBonus += headArmor.getAttributes().getDexterity();
            intelligenceBonus += headArmor.getAttributes().getIntelligence();
        }

        if(bodyArmor != null) {
            vitalityBonus += bodyArmor.getAttributes().getVitality();
            strengthBonus += bodyArmor.getAttributes().getStrength();
            dexterityBonus += bodyArmor.getAttributes().getDexterity();
            intelligenceBonus += bodyArmor.getAttributes().getIntelligence();
        }

        if(legsArmor != null) {
            vitalityBonus += legsArmor.getAttributes().getVitality();
            strengthBonus += legsArmor.getAttributes().getStrength();
            dexterityBonus += legsArmor.getAttributes().getDexterity();
            intelligenceBonus += legsArmor.getAttributes().getIntelligence();
        }

        PrimaryAttributes armorBonus = new PrimaryAttributes(vitalityBonus, strengthBonus, dexterityBonus, intelligenceBonus);
        this.totalPrimaryAttributes.add(armorBonus);
    }

    public abstract boolean equip(Weapon weapon) throws InvalidWeaponException;

    public abstract boolean equip(Armor armor) throws InvalidArmorException;

    public abstract void levelUp(int levels);

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PrimaryAttributes getBasePrimaryAttributes() {
        return basePrimaryAttributes;
    }

    public void setBasePrimaryAttributes(PrimaryAttributes basePrimaryAttributes) {
        this.basePrimaryAttributes = basePrimaryAttributes;
    }

    public PrimaryAttributes getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }

    public void setTotalPrimaryAttributes(PrimaryAttributes totalPrimaryAttributes) {
        this.totalPrimaryAttributes = totalPrimaryAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public void setSecondaryAttributes(SecondaryAttributes secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }

    public HashMap<SlotType, Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(SlotType type, Item item) {
        this.equipment.put(type, item);
    }
}
