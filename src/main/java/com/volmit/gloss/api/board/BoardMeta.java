package com.volmit.gloss.api.board;

import org.bukkit.entity.Player;

import com.volmit.gloss.api.display.FilteredRenderer;
import com.volmit.gloss.api.util.IDD;
import com.volmit.gloss.api.util.IJSON;
import com.volmit.gloss.api.util.Named;

import primal.lang.collection.GList;

public interface BoardMeta extends Named, IDD, IJSON, FilteredRenderer
{
	public GList<String> getLines();

	public void setBoardPermission(String d);

	public String getBoardPermission();

	public void clearBoardPermission();

	public boolean hasBoardPermission();

	public String getBoardPermissionNode();

	public boolean isPrimary();

	public void setPrimary(boolean primary);

	public void addLine(String s);

	public void removeLine(int id);

	public void removeLine(String s);

	public void insertLine(String s, int id);

	public void setLine(String s, int id);

	public void clearLines();

	public void setTempPlayer(Player p);
}
