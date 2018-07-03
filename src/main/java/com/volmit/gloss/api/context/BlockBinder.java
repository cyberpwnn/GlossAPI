package com.volmit.gloss.api.context;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import com.volmit.volume.lang.collections.GSet;

public class BlockBinder implements Binder<Material>
{
	private GSet<Material> materials;

	public BlockBinder()
	{
		materials = new GSet<Material>();
	}

	@Override
	public BlockBinder accept(Material m)
	{
		materials.add(m);
		return this;
	}

	@Override
	public BlockBinder remove(Material m)
	{
		materials.remove(m);
		return this;
	}

	@Override
	public boolean has(Material m)
	{
		return materials.contains(m);
	}

	@Override
	public GSet<Material> get()
	{
		return materials;
	}

	@Override
	public boolean shouldBind(Material m)
	{
		return has(m);
	}

	@Override
	public boolean shouldBind(EntityType e)
	{
		return false;
	}
}
