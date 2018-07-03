package com.volmit.gloss.api.context;

import com.volmit.gloss.api.capture.Capture;
import com.volmit.gloss.api.display.DisplayRenderer;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.api.source.SourceType;

public interface CompiledIntent<T> extends DisplayRenderer, Capture<Context, Source, T>
{
	public String getId();

	public Binder<?> getBinder();

	public SourceType getSourceType();
}
