package com.volmit.gloss.api.library;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.context.ContextualView;

public interface ContextLibrary extends Library<ContextualView>
{
	public Context getContext(Player p);

	public ContextualView getView(Player p);

	public File getConfigFor(Plugin plugin);
}
