package com.volmit.gloss.api.intent;

import com.volmit.gloss.api.GLOSS;
import com.volmit.gloss.api.binder.Binder;
import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.api.source.SourceType;
import com.volmit.gloss.util.ActionType;

public abstract class Intention<T> implements CompiledIntent<T>
{
	protected final String id;
	private final SourceType sourceType;
	private final Binder<?> binder;
	private final int priority;

	public Intention(String id, SourceType sourceType, Binder<?> binder, int priority)
	{
		this.id = id;
		this.priority = priority;
		this.sourceType = sourceType;
		this.binder = binder;
		GLOSS.registerIntent(this);
	}

	public Intention(String id, SourceType sourceType, Binder<?> binder)
	{
		this(id, sourceType, binder, 0);
	}

	@Override
	public void onAction(Context ctx, Source src, ActionType type)
	{

	}

	@Override
	public int getPriority()
	{
		return priority;
	}

	@Override
	public boolean isFocusTraversable()
	{
		return false;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((binder == null) ? 0 : binder.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sourceType == null) ? 0 : sourceType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(!(obj instanceof Intention))
		{
			return false;
		}
		Intention<?> other = (Intention<?>) obj;
		if(binder == null)
		{
			if(other.binder != null)
			{
				return false;
			}
		}
		else if(!binder.equals(other.binder))
		{
			return false;
		}
		if(id == null)
		{
			if(other.id != null)
			{
				return false;
			}
		}
		else if(!id.equals(other.id))
		{
			return false;
		}
		if(sourceType != other.sourceType)
		{
			return false;
		}
		return true;
	}
}
