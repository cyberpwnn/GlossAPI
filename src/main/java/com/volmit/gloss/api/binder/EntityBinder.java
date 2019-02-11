package com.volmit.gloss.api.binder;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import primal.lang.collection.GSet;
import primal.lang.json.JSONArray;
import primal.lang.json.JSONObject;

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

	@Override
	public JSONObject toJSON()
	{
		JSONObject ja = new JSONObject();
		toJSON(ja);
		return ja;
	}

	@Override
	public JSONObject toJSON(JSONObject j)
	{
		j.put("type", "entity");
		JSONArray ja = new JSONArray();

		for(EntityType i : get())
		{
			ja.put(i.name());
		}

		j.put("bind", ja);

		return j;
	}

	@Override
	public void fromJSON(JSONObject j)
	{
		if(j.getString("type").equals("entity"))
		{
			materials.clear();
			JSONArray ja = j.getJSONArray("bind");

			for(int i = 0; i < ja.length(); i++)
			{
				EntityType ee = null;

				try
				{
					ee = EntityType.valueOf(ja.getString(i));
				}

				catch(Exception e)
				{

				}

				if(ee != null)
				{
					materials.add(ee);
				}
			}
		}
	}
}
