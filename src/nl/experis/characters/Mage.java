package nl.experis.characters;

import nl.experis.attributes.PrimaryAttributes;
import nl.experis.exceptions.InvalidArmorException;
import nl.experis.exceptions.InvalidWeaponException;
import nl.experis.items.Armor;
import nl.experis.items.Weapon;

public class Mage extends Character {

    public Mage(String name) {
        super(name, 5, 1, 1, 8);
    }

    @Override
    public boolean equip(Weapon item) throws InvalidWeaponException {
return true;
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
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
