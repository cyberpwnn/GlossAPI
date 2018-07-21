package com.volmit.gloss.api.board;

import com.volmit.gloss.api.context.Context;

public interface BoardContext extends Context
{
	public Board getBoard();

	public BoardMeta getMeta();

	public void setBoard(Board board);

	public void setMeta(BoardMeta meta);
}
