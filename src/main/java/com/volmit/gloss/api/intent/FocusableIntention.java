package com.volmit.gloss.api.intent;

import com.volmit.gloss.api.binder.Binder;
import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.api.source.SourceType;
import com.volmit.gloss.util.ActionType;

public abstract class FocusableIntention<T> extends Intention<T>
{
	public FocusableIntention(String id, SourceType sourceType, Binder<?> binder, int priority)
	{
		super(id, sourceType, binder, priority);
	}

	public FocusableIntention(String id, SourceType sourceType, Binder<?> binder)
	{
		super(id, sourceType, binder);
	}

	@Override
	public boolean isFocusTraversable()
	{
		return true;
	}

	@Override
	public abstract void onAction(Context ctx, Source src, ActionType type);
}
