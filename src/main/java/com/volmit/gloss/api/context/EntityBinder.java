package com.volmit.gloss.api.context;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import com.volmit.volume.lang.collections.GSet;

public class EntityBinder implements Binder<EntityType>
{
	private GSet<EntityType> materials;

	public EntityBinder()
	{
		materials = new GSet<EntityType>();
	}

	@Override
	public EntityBinder accept(EntityType m)
	{
		materials.add(m);
		return this;
	}

	@Override
	public EntityBinder remove(EntityType m)
	{
		materials.remove(m);
		return this;
	}

	@Override
	public boolean has(EntityType m)
	{
		return materials.contains(m);
	}

	@Override
	public GSet<EntityType> get()
	{
		return materials;
	}

	@Override
	public boolean shouldBind(Material m)
	{
		return false;
	}

	@Override
	public boolean shouldBind(EntityType e)
	{
		return has(e);
	}
}
