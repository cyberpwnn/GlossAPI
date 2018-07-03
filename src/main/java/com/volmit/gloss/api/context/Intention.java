package com.volmit.gloss.api.context;

import com.volmit.gloss.api.GLOSS;
import com.volmit.gloss.api.source.SourceType;

public abstract class Intention<T> implements CompiledIntent<T>
{
	private final String id;
	private final SourceType sourceType;
	private final Binder<?> binder;

	public Intention(String id, SourceType sourceType, Binder<?> binder)
	{
		this.id = id;
		this.sourceType = sourceType;
		this.binder = binder;
		GLOSS.registerIntent(this);
	}

	@Override
	public String getId()
	{
		return id;
	}

	@Override
	public Binder<?> getBinder()
	{
		return binder;
	}

	@Override
	public SourceType getSourceType()
	{
		return sourceType;
	}
}
