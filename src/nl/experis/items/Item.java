package nl.experis.items;

public abstract class Item {
    private String name;
    private int itemLevel;
    private SlotType itemSlot;

    public Item(String name, int itemLevel, SlotType itemSlot) {
        this.name = name;
        this.itemLevel = itemLevel;
        this.itemSlot = itemSlot;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public SlotType getItemSlot() {
        return itemSlot;
    }
}
