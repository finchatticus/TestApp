package com.gjevass.pixels.testapp.app.ui;

public enum ViewType {
    EMPTY(0), PART1(1), PART2(2);
    private int type;

    private ViewType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
