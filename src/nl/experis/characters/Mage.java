package nl.experis.characters;

import nl.experis.attributes.PrimaryAttributes;
import nl.experis.exceptions.InvalidArmorException;
import nl.experis.exceptions.InvalidWeaponException;
import nl.experis.items.Armor;
import nl.experis.items.ArmorType;
import nl.experis.items.Weapon;
import nl.experis.items.WeaponType;

public class Mage extends Character {

    public Mage(String name) {
        super(name, 5, 1, 1, 8);
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() != WeaponType.STAFF && weapon.getWeaponType() != WeaponType.WAND) {
            throw new InvalidWeaponException();
        }

        if(weapon.getItemLevel() > this.getLevel()) {
            throw new InvalidWeaponException();
        }

        this.setEquipment(weapon.getItemSlot(), weapon);

        return true;
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() != ArmorType.CLOTH) {
            throw new InvalidArmorException();
        }

        if(armor.getItemLevel() > this.getLevel()) {
            throw new InvalidArmorException();
        }

        this.setEquipment(armor.getItemSlot(), armor);

        return true;
    }

    @Override
    public void levelUp(int levels) {
        if(levels < 1) throw new IllegalArgumentException();

        setLevel(getLevel() + levels);
        PrimaryAttributes levelUpAttributes = new PrimaryAttributes(3 * levels, 1 * levels, 1 * levels, 5 * levels);
        getBasePrimaryAttributes().add(levelUpAttributes);

        calculateSecondaryStats();
    }
}
