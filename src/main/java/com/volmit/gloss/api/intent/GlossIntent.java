package com.volmit.gloss.api.intent;

import com.volmit.gloss.api.binder.Binder;
import com.volmit.gloss.api.context.Node;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assumedType == null) ? 0 : assumedType.hashCode());
		result = prime * result + ((binder == null) ? 0 : binder.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
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
		if(!(obj instanceof GlossIntent))
		{
			return false;
		}
		GlossIntent other = (GlossIntent) obj;
		if(assumedType != other.assumedType)
		{
			return false;
		}
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
		if(nodes == null)
		{
			if(other.nodes != null)
			{
				return false;
			}
		}
		else if(!nodes.equals(other.nodes))
		{
			return false;
		}
		return true;
	}
}
