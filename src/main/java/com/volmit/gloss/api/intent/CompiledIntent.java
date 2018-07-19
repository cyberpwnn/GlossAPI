package com.volmit.gloss.api.intent;

import com.volmit.gloss.api.binder.Binder;
import com.volmit.gloss.api.capture.Capture;
import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.context.NodeActionListener;
import com.volmit.gloss.api.display.DisplayRenderer;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.api.source.SourceType;
import com.volmit.gloss.api.util.IJSON;

public interface CompiledIntent<T> extends DisplayRenderer, Capture<Context, Source, T>, NodeActionListener, IJSON
{
	public String getId();

	public Binder<?> getBinder();

	public SourceType getSourceType();

	public boolean isFocusTraversable();

	public int getPriority();
}
