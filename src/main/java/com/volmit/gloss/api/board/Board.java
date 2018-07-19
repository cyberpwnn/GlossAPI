package com.volmit.gloss.api.board;

import org.bukkit.entity.Player;

import com.volmit.volume.lang.collections.GList;

public interface Board
{
	public void setFromMeta(BoardMeta meta);

	public boolean isVisible();

	public void setVisible(boolean visible);

	public void update();

	public void addLine(String text);

	public String getTitle();

	public void setTitle(String title);

	public String getId();

	public GList<String> getContent();

	public void setLine(int index, String c);

	public void removeLine(int index);

	public String getLine(int index);

	public void clear();

	public Player getPlayer();

	public void hide();

	public void show();
}
