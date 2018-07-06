package com.volmit.gloss.api.binder;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import com.volmit.volume.lang.collections.GSet;

public interface Binder<T>
{
	public boolean shouldBind(Material m);

	public boolean shouldBind(EntityType e);

	public Binder<T> accept(T m);

	public Binder<T> remove(T m);

	public boolean has(T m);

	public GSet<T> get();
}
