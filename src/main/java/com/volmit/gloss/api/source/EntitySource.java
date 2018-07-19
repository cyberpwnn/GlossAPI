package com.volmit.gloss.api.source;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public interface EntitySource extends Source
{
	public Entity getEntity();

	public EntityType getEntityType();

	public boolean isMountable();

	public void setMountable(boolean m);
}
