package com.volmit.gloss.api.binder;

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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materials == null) ? 0 : materials.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(!(obj instanceof BlockBinder))
		{
			return false;
		}
		BlockBinder other = (BlockBinder) obj;
		if(materials == null)
		{
			if(other.materials != null)
			{
				return false;
			}
		}
		else if(!materials.equals(other.materials))
		{
			return false;
		}
		return true;
	}
}
