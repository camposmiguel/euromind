package com.miguelcr.listviewcustom;

/**
 * Created by miguelcampos on 11/1/16.
 */
public class FruitItem {
    int icon;
    String name;

    public FruitItem(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
