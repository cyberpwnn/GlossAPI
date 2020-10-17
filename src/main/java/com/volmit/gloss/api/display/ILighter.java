package com.volmit.gloss.api.display;

import org.bukkit.Location;

public interface ILighter {
    void light(Location location, int level);

    void unlight(Location location);

    void setLight(Location location, int level);

    void refresh(Location location);
}
