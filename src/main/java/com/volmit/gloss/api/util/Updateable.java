package com.volmit.gloss.api.util;

import com.volmit.gloss.api.context.Context;

public interface Updateable
{
	public boolean sync();

	public void update(Context ctx);

	public int rate();
}
