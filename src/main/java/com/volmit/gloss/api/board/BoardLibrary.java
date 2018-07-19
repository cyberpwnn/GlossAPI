package com.volmit.gloss.api.board;

import org.bukkit.entity.Player;

public interface BoardLibrary
{
	public void registerBoard(BoardMeta meta);

	public void setBoard(Player p, BoardMeta meta);

	public BoardMeta getBoard(Player p);

	public void removeBoard(Player p);
}
