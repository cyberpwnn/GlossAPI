package com.volmit.gloss.util;

import com.volmit.volume.lang.json.JSONObject;

public interface IJSON
{
	public JSONObject toJSON();

	public JSONObject toJSON(JSONObject j);

	public void fromJSON(JSONObject j);
}
