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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public SlotType getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(SlotType itemSlot) {
        this.itemSlot = itemSlot;
    }
}
