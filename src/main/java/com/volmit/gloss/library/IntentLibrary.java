package com.volmit.gloss.library;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

import com.volmit.gloss.api.context.Intent;
import com.volmit.volume.lang.collections.GList;

public interface IntentLibrary extends Library<Intent>
{
	public GList<Intent> getIntents(Material material);

	public GList<Intent> getIntents(EntityType entityType);

	public void register(Plugin plugin, String superPackage);
}
