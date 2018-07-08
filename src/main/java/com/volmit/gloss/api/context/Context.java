package com.volmit.gloss.api.context;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.volmit.gloss.api.display.Display;
import com.volmit.gloss.api.intent.Intent;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.util.ActionType;
import com.volmit.gloss.util.ScrollGate;
import com.volmit.gloss.util.ScrollResult;
import com.volmit.gloss.util.Updateable;
import com.volmit.volume.lang.collections.GList;

public interface Context extends Updateable
{
	public void unbind();

	public void target(Location l);

	public void push(GList<Intent> intents);

	public Source getSource();

	public boolean onScroll(ScrollResult r);

	public Location getTarget();

	public Player getPlayer();

	public Display getDisplay();

	public ScrollGate getScrollGate();

	public boolean isSneaking();

	public void setSneaking(boolean sneaking);

	public Vector getDirection();

	public void setDirection(Vector direction);

	public boolean isActive();

	public boolean isBound();

	public void bind(Source source, GList<Intent> intents);

	public void setActive(boolean active);

	public void fireAction(ActionType type);

	public void destroy();
}
