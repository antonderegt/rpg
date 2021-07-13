package nl.experis.characters;

import nl.experis.attributes.PrimaryAttributes;
import nl.experis.exceptions.InvalidArmorException;
import nl.experis.exceptions.InvalidWeaponException;
import nl.experis.items.Armor;
import nl.experis.items.ArmorType;
import nl.experis.items.Weapon;
import nl.experis.items.WeaponType;

public class Ranger extends Character {
    public Ranger(String name) {
        super(name, 8, 1, 7, 1);
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() != WeaponType.BOW) {
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
        if(armor.getArmorType() != ArmorType.MAIL && armor.getArmorType() != ArmorType.LEATHER) {
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
        PrimaryAttributes levelUpAttributes = new PrimaryAttributes(2 * levels, 1 * levels, 5 * levels, 1 * levels);
        getBasePrimaryAttributes().add(levelUpAttributes);

        calculateSecondaryStats();
    }
}
