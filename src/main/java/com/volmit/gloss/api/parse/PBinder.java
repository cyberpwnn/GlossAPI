package com.volmit.gloss.api.parse;

import org.bukkit.entity.EntityType;

import com.volmit.gloss.api.source.SourceType;
import com.volmit.gloss.api.util.IJSON;
import com.volmit.volume.lang.collections.GList;
import com.volmit.volume.lang.json.JSONArray;
import com.volmit.volume.lang.json.JSONObject;

public class PBinder implements IJSON
{
	private SourceType type;
	private GList<String> bind;

	public PBinder(SourceType type, GList<String> bind)
	{
		this.type = type;
		this.bind = bind;
	}

	public SourceType getType()
	{
		return type;
	}

	public void setType(SourceType type)
	{
		this.type = type;
	}

	public GList<String> getBind()
	{
		return bind;
	}

	public void setBind(GList<String> bind)
	{
		this.bind = bind;
	}

	public void accept(EntityType e)
	{
		bind.add(e.name());
	}

	public PBinder(JSONObject o)
	{
		this(SourceType.POSITIONAL, new GList<String>());
		fromJSON(o);
	}

	@Override
	public JSONObject toJSON()
	{
		JSONObject j = new JSONObject();
		toJSON(j);
		return j;
	}

	@Override
	public JSONObject toJSON(JSONObject j)
	{
		j.put("type", type.name());
		JSONArray ja = new JSONArray();

		for(String i : bind)
		{
			ja.put(i);
		}

		j.put("bind", ja);
		return j;
	}

	@Override
	public void fromJSON(JSONObject j)
	{
		type = SourceType.valueOf(j.getString("type"));
		bind.clear();
		JSONArray ja = j.getJSONArray("bind");

		for(int i = 0; i < ja.length(); i++)
		{
			bind.add(ja.getString(i));
		}
	}
}
