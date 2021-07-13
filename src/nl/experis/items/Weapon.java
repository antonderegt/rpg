package nl.experis.items;

public class Weapon extends Item {
    private WeaponType weaponType;
    private int damage;
    private double attackSpeed;

    public Weapon(String name, int itemLevel, SlotType itemSlot, WeaponType weaponType, int damage, double attackSpeed) {
        super(name, itemLevel, itemSlot);
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
