package com.volmit.gloss.api.binder;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import com.volmit.volume.lang.collections.GSet;

public class VoidBinder implements Binder<Void>
{
	@Override
	public boolean shouldBind(Material m)
	{
		return false;
	}

	@Override
	public boolean shouldBind(EntityType e)
	{
		return false;
	}

	@Override
	public VoidBinder accept(Void m)
	{
		return this;
	}

	@Override
	public VoidBinder remove(Void m)
	{
		return this;
	}

	@Override
	public boolean has(Void m)
	{
		return false;
	}

	@Override
	public GSet<Void> get()
	{
		return new GSet<Void>();
	}
}
