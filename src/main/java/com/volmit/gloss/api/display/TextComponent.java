package com.volmit.gloss.api.display;

import org.bukkit.ChatColor;

public interface TextComponent
{
	public boolean isColor();

	public ChatColor getColor();

	public String get();
}
