package com.volmit.gloss.api.parse;

import com.volmit.gloss.api.util.IJSON;
import com.volmit.volume.lang.json.JSONObject;

public class PNode implements IJSON
{
	private String text;
	private String action;

	public PNode(String text, String action)
	{
		this.text = text;
		this.action = action;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public PNode(String text)
	{
		this(text, null);
	}

	public PNode(JSONObject o)
	{
		this("");
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
		j.put("text", text);

		if(action != null)
		{
			j.put("action", action);
		}

		return j;
	}

	@Override
	public void fromJSON(JSONObject j)
	{
		text = j.getString("text");
		action = null;

		if(j.has("action"))
		{
			action = j.getString("action");
		}
	}
}
