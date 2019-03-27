package com.volmit.gloss.api.inject;

import org.bukkit.plugin.Plugin;

public interface PluginViolator
{
	public String getTargetName();

	public void engage(Plugin src);

	public void disengage(Plugin src);

	public boolean isSafe();
}
