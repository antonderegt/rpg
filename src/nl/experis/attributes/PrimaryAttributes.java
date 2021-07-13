package nl.experis.attributes;

import java.util.Objects;

public class PrimaryAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;

    public PrimaryAttributes(int vitality, int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.vitality = vitality;
    }

    public void add(PrimaryAttributes additionalAttributes) {
        this.strength += additionalAttributes.getStrength();
        this.dexterity += additionalAttributes.getDexterity();
        this.intelligence += additionalAttributes.getIntelligence();
        this.vitality += additionalAttributes.getVitality();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimaryAttributes that = (PrimaryAttributes) o;
        return strength == that.strength && dexterity == that.dexterity && intelligence == that.intelligence && vitality == that.vitality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, dexterity, intelligence, vitality);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
}
