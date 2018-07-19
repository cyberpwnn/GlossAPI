package com.volmit.gloss.api.parse;

import com.volmit.gloss.api.context.Context;

@FunctionalInterface
public interface PHandler
{
	public String parse(Context ctx);
}
