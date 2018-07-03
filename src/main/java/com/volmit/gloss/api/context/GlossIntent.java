package com.volmit.gloss.api.context;

import com.volmit.gloss.api.source.SourceType;
import com.volmit.volume.lang.collections.GList;

public class GlossIntent implements Intent
{
	private GList<Node> nodes;
	private Binder<?> binder;
	private SourceType assumedType;
	private String id;

	public GlossIntent(GList<Node> nodes, Binder<?> binder, SourceType assumedType, String id)
	{
		this.nodes = nodes;
		this.binder = binder;
		this.assumedType = assumedType;
		this.id = id;
	}

	@Override
	public GList<Node> getNodes()
	{
		return nodes;
	}

	@Override
	public SourceType getAssumedType()
	{
		return assumedType;
	}

	@Override
	public Binder<?> getBinder()
	{
		return binder;
	}

	@Override
	public String getId()
	{
		return id;
	}
}
