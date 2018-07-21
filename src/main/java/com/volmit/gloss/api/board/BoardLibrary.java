package com.volmit.gloss.api.board;


import org.bukkit.entity.Player;

import com.volmit.gloss.api.library.Library;

public interface BoardLibrary extends Library<BoardMeta>
{
	public void registerBoard(BoardMeta meta);

	public void setBoard(Player p, BoardMeta meta);

	public BoardMeta getBoard(Player p);

	public void removeBoard(Player p);
}
