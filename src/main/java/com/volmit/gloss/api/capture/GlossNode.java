package com.volmit.gloss.api.capture;

import com.volmit.gloss.api.context.Node;
import com.volmit.gloss.api.context.NodeActionListener;
import com.volmit.gloss.api.display.DisplayRenderer;

import mortar.lang.collection.GList;
import mortar.lang.collection.GMap;

public class GlossNode implements Node
{
	private DisplayRenderer renderer;
	private NodeActionListener listener;
	private GMap<String, VC<?>> captures;
	private String id;
	private int priority;
	private boolean focus;

	public GlossNode(DisplayRenderer renderer, GMap<String, VC<?>> captures, String id, boolean focus)
	{
		this(renderer, captures, id, focus, new UselessNodeListener(), 0);
	}

	public GlossNode(DisplayRenderer renderer, GMap<String, VC<?>> captures, String id, boolean focus, NodeActionListener listener, int priority)
	{
		this.renderer = renderer;
		this.captures = captures;
		this.id = id;
		this.priority = priority;
		this.focus = focus;
		this.listener = listener;
	}

	@Override
	public DisplayRenderer getRenderer()
	{
		return renderer;
	}

	@Override
	public void assign(String node, VC<?> capture)
	{
		captures.put(node, capture);
	}

	@Override
	public VC<?> getCapture(String node)
	{
		return captures.get(node);
	}

	@Override
	public GList<String> getCaptures()
	{
		return captures.k();
	}

	@Override
	public String getId()
	{
		return id;
	}

	@Override
	public boolean isFocusTraversable()
	{
		return focus;
	}

	@Override
	public NodeActionListener getListener()
	{
		return listener;
	}

	@Override
	public void setActionListener(NodeActionListener listener)
	{
		this.listener = listener;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((captures == null) ? 0 : captures.hashCode());
		result = prime * result + (focus ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listener == null) ? 0 : listener.hashCode());
		result = prime * result + ((renderer == null) ? 0 : renderer.hashCode());
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
		if(!(obj instanceof GlossNode))
		{
			return false;
		}
		GlossNode other = (GlossNode) obj;
		if(captures == null)
		{
			if(other.captures != null)
			{
				return false;
			}
		}
		else if(!captures.equals(other.captures))
		{
			return false;
		}
		if(focus != other.focus)
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
		if(listener == null)
		{
			if(other.listener != null)
			{
				return false;
			}
		}
		else if(!listener.equals(other.listener))
		{
			return false;
		}
		if(renderer == null)
		{
			if(other.renderer != null)
			{
				return false;
			}
		}
		else if(!renderer.equals(other.renderer))
		{
			return false;
		}
		return true;
	}

	@Override
	public int getProirity()
	{
		return priority;
	}
}
