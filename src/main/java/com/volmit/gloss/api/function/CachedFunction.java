package com.volmit.gloss.api.function;

import org.bukkit.entity.Player;

import com.volmit.gloss.api.util.IDD;

public interface CachedFunction extends IDD
{
	public void setFunction(Function f);

	public Function getFunction();

	public String parse(Player p);
}
