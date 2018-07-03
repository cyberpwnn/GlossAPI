package com.volmit.gloss.api.context;

import com.volmit.gloss.api.GLOSS;
import com.volmit.gloss.api.capture.GlossNode;
import com.volmit.gloss.api.capture.VC;
import com.volmit.gloss.api.display.DisplayRenderer;
import com.volmit.gloss.util.IDD;
import com.volmit.volume.lang.collections.GList;
import com.volmit.volume.lang.collections.GMap;

public interface Node extends IDD
{
	public DisplayRenderer getRenderer();

	public void assign(String node, VC<?> capture);

	public VC<?> getCapture(String node);

	public GList<String> getCaptures();

	public static Builder builder()
	{
		return new Node.Builder();
	}

	class Builder
	{
		private DisplayRenderer renderer;
		private GMap<String, VC<?>> captures;
		private String id;

		public Builder()
		{
			captures = new GMap<String, VC<?>>();
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

			return new GlossNode(renderer, captures, id);
		}
	}
}
