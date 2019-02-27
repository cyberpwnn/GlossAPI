package com.volmit.gloss.api.binder;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import mortar.lang.collection.GSet;
import mortar.lang.json.JSONObject;

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

	@Override
	public JSONObject toJSON()
	{
		JSONObject o = new JSONObject();
		toJSON(o);

		return o;
	}

	@Override
	public JSONObject toJSON(JSONObject j)
	{
		j.put("void", "void");

		return j;
	}

	@Override
	public void fromJSON(JSONObject j)
	{

	}
}
