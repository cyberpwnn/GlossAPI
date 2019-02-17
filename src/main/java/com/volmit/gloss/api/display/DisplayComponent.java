package com.volmit.gloss.api.display;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.volmit.gloss.api.source.Source;

public interface DisplayComponent extends StickyDisplay, PivotDisplay
{
	public void justClicked();

	public Location getPosition();

	public String getRawText();

	public void setPosition(Location l);

	public void setDisplay(String content);

	public String getDisplay(String content);

	public Player getPlayer();

	public void destroy();

	public boolean isActive();

	public void create();

	public void update();

	public void update(DisplayState state, Source source);

	public DisplayRenderer getRenderer();

	public String getText();

	public Location getActualPosition();

	public int getEntityId();
}
