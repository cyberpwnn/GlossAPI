package com.volmit.gloss.api.context;

import org.bukkit.entity.Entity;

public interface Mountable
{
	public boolean isMounted();

	public Entity getMount();

	public void mount(Entity e);

	public void dismount();
}