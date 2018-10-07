package com.volmit.gloss.api.library;

import org.bukkit.entity.Player;

import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.context.ContextualView;

public interface ContextLibrary extends Library<ContextualView>
{
	public Context getContext(Player p);

	public ContextualView getView(Player p);
}
