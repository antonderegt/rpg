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

        double weaponDPS = weapon != null ? weapon.getAttackSpeed() * weapon.getDamage() : 1;

        calculateArmorBonus();

        double multiplier = 1 + this.totalPrimaryAttributes.getStrength() / 100.0;

        return weaponDPS * multiplier;
    }

    private void calculateArmorBonus() {
        Armor headArmor = (Armor) this.equipment.get(SlotType.HEADER);
        Armor bodyArmor = (Armor) this.equipment.get(SlotType.BODY);
        Armor legsArmor = (Armor) this.equipment.get(SlotType.LEGS);

        PrimaryAttributes headBonus = getBonus(headArmor);
        PrimaryAttributes bodyBonus = getBonus(bodyArmor);
        PrimaryAttributes legsBonus = getBonus(legsArmor);

        this.totalPrimaryAttributes.add(headBonus);
        this.totalPrimaryAttributes.add(bodyBonus);
        this.totalPrimaryAttributes.add(legsBonus);
    }

    private PrimaryAttributes getBonus(Armor armor) {
        if(armor == null) {
            return new PrimaryAttributes(0, 0, 0, 0);
        }

        return new PrimaryAttributes(
                armor.getAttributes().getVitality(),
                armor.getAttributes().getStrength(),
                armor.getAttributes().getDexterity(),
                armor.getAttributes().getIntelligence()
        );
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

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public void setEquipment(SlotType type, Item item) {
        this.equipment.put(type, item);
    }
}
