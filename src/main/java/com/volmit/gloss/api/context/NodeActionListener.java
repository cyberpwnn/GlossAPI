package com.volmit.gloss.api.context;

import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.api.util.ActionType;

public interface NodeActionListener
{
	public void onAction(Context ctx, Source src, ActionType type);
}
