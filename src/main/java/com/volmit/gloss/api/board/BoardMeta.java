package com.volmit.gloss.api.board;

import org.bukkit.entity.Player;

import com.volmit.gloss.api.display.FilteredRenderer;
import com.volmit.gloss.api.util.IDD;
import com.volmit.gloss.api.util.IJSON;
import com.volmit.gloss.api.util.Named;
import com.volmit.volume.lang.collections.GList;

public interface BoardMeta extends Named, IDD, IJSON, FilteredRenderer
{
	public GList<String> getLines();

	public String getPrimaryWorld();

	public void setPrimaryWorld(String world);

	public void addLine(String s);

	public void removeLine(int id);

	public void removeLine(String s);

	public void insertLine(String s, int id);

	public void setLine(String s, int id);

	public void clearLines();

	public void setTempPlayer(Player p);
}
