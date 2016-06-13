package com.gjevass.pixels.testapp.app.json;

public enum JSONName {
    NFO("nfo"), NWS("nws"), PST("pst");
    private String name;

    private JSONName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        switch (this) {
            case NFO:
                return name;
            case NWS:
                return name;
            case PST:
                return name;
            default:
                return name;
        }
    }
}
