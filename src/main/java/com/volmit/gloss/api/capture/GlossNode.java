package com.volmit.gloss.api.capture;

import com.volmit.gloss.api.context.Node;
import com.volmit.gloss.api.display.DisplayRenderer;
import com.volmit.volume.lang.collections.GList;
import com.volmit.volume.lang.collections.GMap;

public class GlossNode implements Node
{
	private DisplayRenderer renderer;
	private GMap<String, VC<?>> captures;
	private String id;

	public GlossNode(DisplayRenderer renderer, GMap<String, VC<?>> captures, String id)
	{
		this.renderer = renderer;
		this.captures = captures;
		this.id = id;
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
}
