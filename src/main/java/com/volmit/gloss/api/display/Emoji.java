package com.volmit.gloss.api.display;

import com.volmit.gloss.api.util.IDD;
import com.volmit.gloss.api.util.IJSON;

public interface Emoji extends IDD, IJSON
{
	public String getTrigger();

	public String getEmoji();
}
