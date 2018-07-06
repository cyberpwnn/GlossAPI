package com.volmit.gloss.api.binder;

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
		if(!(obj instanceof EntityBinder))
		{
			return false;
		}
		EntityBinder other = (EntityBinder) obj;
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
