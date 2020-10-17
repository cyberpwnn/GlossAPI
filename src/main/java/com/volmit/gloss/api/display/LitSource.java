package com.volmit.gloss.api.display;

import org.bukkit.Location;

public class LitSource {
    private int level;
    private Location current;
    private final ILighter lighter;

    public LitSource(Location initial, ILighter lighter, int level) {
        this.current = initial.clone();
        this.lighter = lighter;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;

        if (current == null) return;

        lighter.setLight(current, level);
        lighter.refresh(current);
    }

    public void unlight() {
        setLevel(0);
    }

    public void setPosition(Location newLocation) {
        if (newLocation == null) return;

        if (current != null) lighter.unlight(current);

        current = newLocation.clone();

        if (level > 0) lighter.light(current, level);
        lighter.refresh(current);
    }
}
