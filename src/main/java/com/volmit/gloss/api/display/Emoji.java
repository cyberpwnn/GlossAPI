package com.volmit.gloss.api.display;

import com.volmit.gloss.api.util.IDD;
import com.volmit.gloss.api.util.IJSON;
import org.bukkit.entity.Player;

public interface Emoji extends IDD, IJSON
{
	public boolean isEnabled();

	public String getTrigger();

	public String getEmoji();

	public boolean canUse(Player player);
}
