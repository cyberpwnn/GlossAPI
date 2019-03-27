package com.volmit.gloss.api.intent;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import com.volmit.gloss.api.display.LineEditor;
import com.volmit.gloss.api.display.SignalType;
import com.volmit.gloss.api.util.IDD;
import com.volmit.gloss.api.util.IJSON;
import com.volmit.gloss.api.util.Named;

import mortar.lang.collection.GList;

public interface Descriptor extends Named, IDD, IJSON, LineEditor, Emissive
{
	public PlayerList getPlayerList();

	public Location getLocation();

	public void setLocation(Location l);

	public GList<String> getLines();

	public void addLine(String s);

	public void removeLine(int id);

	public void removeLine(String s);

	public void insertLine(String s, int id);

	public void clearLines();

	public Intent createIntent();

	public ItemStack toBook();

	public void fromBook(ItemStack bm);

	public void pulse(SignalType type);

	public void setLine(String s, int id);
}
