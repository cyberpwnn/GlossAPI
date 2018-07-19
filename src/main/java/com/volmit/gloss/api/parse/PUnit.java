package com.volmit.gloss.api.parse;

import com.volmit.gloss.api.source.SourceType;
import com.volmit.gloss.api.util.IJSON;
import com.volmit.volume.lang.collections.GList;
import com.volmit.volume.lang.json.JSONArray;
import com.volmit.volume.lang.json.JSONObject;

public class PUnit implements IJSON
{
	private GList<PNode> nodes;
	private PBinder binder;

	public PUnit(PBinder binder)
	{
		this.binder = binder;
		this.nodes = new GList<PNode>();
	}

	public PUnit(JSONObject o)
	{
		this(new PBinder(SourceType.POSITIONAL, new GList<String>()));
		fromJSON(o);
	}

	public void addNode(PNode node)
	{
		nodes.add(node);
	}

	public GList<PNode> getNodes()
	{
		return nodes;
	}

	public void setNodes(GList<PNode> nodes)
	{
		this.nodes = nodes;
	}

	public PBinder getBinder()
	{
		return binder;
	}

	public void setBinder(PBinder binder)
	{
		this.binder = binder;
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
		j.put("binder", binder.toJSON());
		JSONArray ja = new JSONArray();

		for(PNode i : nodes)
		{
			ja.put(i.toJSON());
		}

		j.put("nodes", ja);
		return j;
	}

	@Override
	public void fromJSON(JSONObject j)
	{
		binder = new PBinder(j.getJSONObject("binder"));
		nodes.clear();
		JSONArray ja = j.getJSONArray("nodes");
		for(int i = 0; i < ja.length(); i++)
		{
			nodes.add(new PNode(ja.getJSONObject(i)));
		}
	}
}
