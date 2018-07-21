package com.volmit.gloss.api.binder;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import com.volmit.volume.lang.collections.GSet;
import com.volmit.volume.lang.json.JSONArray;
import com.volmit.volume.lang.json.JSONObject;

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
		j.put("type", "block");
		JSONArray ja = new JSONArray();

		for(Material i : get())
		{
			ja.put(i.name());
		}

		j.put("bind", ja);

		return j;
	}

	@Override
	public void fromJSON(JSONObject j)
	{
		if(j.getString("type").equals("block"))
		{
			materials.clear();
			JSONArray ja = j.getJSONArray("bind");

			for(int i = 0; i < ja.length(); i++)
			{
				Material ee = null;

				try
				{
					ee = Material.valueOf(ja.getString(i));
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
