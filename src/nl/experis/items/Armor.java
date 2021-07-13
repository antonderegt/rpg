package nl.experis.items;

import nl.experis.attributes.PrimaryAttributes;

public class Armor extends Item {
    private ArmorType armorType;
    private PrimaryAttributes attributes;

    public Armor(String name, int itemLevel, SlotType itemSlot, ArmorType armorType, PrimaryAttributes attributes) {
        super(name, itemLevel, itemSlot);
        this.armorType = armorType;
        this.attributes = attributes;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public PrimaryAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(PrimaryAttributes attributes) {
        this.attributes = attributes;
    }
}
