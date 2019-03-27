package com.volmit.gloss.api.wrapper;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.volmit.gloss.api.GLOSS;
import com.volmit.gloss.api.board.BoardMeta;
import com.volmit.gloss.api.context.TabMeta;
import com.volmit.gloss.api.intent.Descriptor;
import com.volmit.gloss.api.intent.TemporaryDescriptor;

public interface GlossAPI
{
	public void setTabMeta(Player p, String header, String footer);

	public void resetTabMeta(Player p);

	public TabMeta getTabMeta(Player p);

	public Descriptor createHologram(String id, Location position);

	public boolean hasHologram(String id);

	public TemporaryDescriptor createTemporaryHologram(String id, Location initialLocation, long ms);

	public Descriptor getHologram(String id);

	public void deleteHologram(String id);

	public void deleteHologram(Descriptor d);

	public List<Descriptor> getHolograms();

	public void setBoard(Player p, BoardMeta meta);

	public void removeBoard(Player p);

	public List<BoardMeta> getBoards();

	public BoardMeta getBoard(Player p);

	public BoardMeta createBoard(String id);

	public BoardMeta getBoard(String id);

	public BoardMeta getOrCreateBoard(String id);

	public void deleteBoard(String id);

	public void deleteBoard(BoardMeta meta);

	public boolean hasBoard(String id);

	public boolean hasBoard(Player p);

	public String filter(Player p, String raw);

	public static GlossAPI getInstance()
	{
		return GLOSS.getAPIWrapper();
	}
}
