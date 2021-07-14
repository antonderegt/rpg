package nl.experis.attributes;

import java.util.Objects;

public class SecondaryAttributes {
    private int health;
    private int armorRating;
    private int elementalResistance;

    public SecondaryAttributes(int health, int armorRating, int elementalResistance) {
        this.health = health;
        this.armorRating = armorRating;
        this.elementalResistance = elementalResistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecondaryAttributes that = (SecondaryAttributes) o;
        return health == that.health && armorRating == that.armorRating && elementalResistance == that.elementalResistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, armorRating, elementalResistance);
    }
}
