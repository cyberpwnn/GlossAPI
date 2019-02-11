package com.volmit.gloss.api.context;

import com.volmit.gloss.api.GLOSS;
import com.volmit.gloss.api.capture.GlossNode;
import com.volmit.gloss.api.capture.UselessNodeListener;
import com.volmit.gloss.api.capture.VC;
import com.volmit.gloss.api.display.DisplayRenderer;
import com.volmit.gloss.api.util.IDD;

import primal.lang.collection.GList;
import primal.lang.collection.GMap;

public interface Node extends IDD
{
	public NodeActionListener getListener();

	public void setActionListener(NodeActionListener listener);

	public boolean isFocusTraversable();

	public DisplayRenderer getRenderer();

	public void assign(String node, VC<?> capture);

	public VC<?> getCapture(String node);

	public GList<String> getCaptures();

	public int getProirity();

	public static Builder builder()
	{
		return new Node.Builder();
	}

	class Builder
	{
		private DisplayRenderer renderer;
		private NodeActionListener listener;
		private GMap<String, VC<?>> captures;
		private String id;
		private int priority;
		private boolean focus;

		public Builder()
		{
			focus = false;
			captures = new GMap<String, VC<?>>();
			priority = 0;
		}

		public Builder listener(NodeActionListener listener)
		{
			this.listener = listener;
			return this;
		}

		public Builder priority(int priority)
		{
			this.priority = priority;
			return this;
		}

		public Builder focusTraversable()
		{
			this.focus = true;
			return this;
		}

		public Builder focusTraversable(boolean fc)
		{
			this.focus = fc;
			return this;
		}

		public Builder renderer(DisplayRenderer renderer)
		{
			this.renderer = renderer;
			return this;
		}

		public Builder capture(VC<?> capture)
		{
			captures.put(capture.getId(), capture);
			return this;
		}

		public Builder id(String id)
		{
			this.id = id;
			return this;
		}

		public Builder capture(String id)
		{
			return capture(GLOSS.getCaptureLibrary().get(id));
		}

		public Node build()
		{
			if(renderer == null)
			{
				throw new RuntimeException("Display Renderer must be defined!");
			}

			if(listener == null)
			{
				listener = new UselessNodeListener();
			}

			return new GlossNode(renderer, captures, id, focus, listener, priority);
		}
	}
}
