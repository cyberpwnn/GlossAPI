package com.volmit.gloss.api.display;

import com.volmit.gloss.api.source.Source;

@FunctionalInterface
public interface DisplayRenderer
{
	public String render(DisplayState state, Source source);
}
