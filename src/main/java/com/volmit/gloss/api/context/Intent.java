package com.volmit.gloss.api.context;

import com.volmit.gloss.api.GLOSS;
import com.volmit.gloss.api.source.SourceType;
import com.volmit.gloss.util.IDD;
import com.volmit.volume.lang.collections.GList;

public interface Intent extends IDD
{
	public GList<Node> getNodes();

	public SourceType getAssumedType();

	public Binder<?> getBinder();

	public static Builder builder()
	{
		return new Builder();
	}

	class Builder
	{
		private String id;
		private GList<Node> nodes;
		private Binder<?> binder;
		private SourceType assumedType;

		public Builder()
		{
			nodes = new GList<Node>();
		}

		public Builder node(String string)
		{
			return node(GLOSS.getNodeLibrary().get(string));
		}

		public Builder node(Node node)
		{
			nodes.add(node);
			return this;
		}

		public Builder id(String id)
		{
			this.id = id;
			return this;
		}

		public Builder binder(Binder<?> binder)
		{
			this.binder = binder;
			return this;
		}

		public Builder assume(SourceType assumedType)
		{
			this.assumedType = assumedType;
			return this;
		}

		public Intent build()
		{
			if(id == null)
			{
				throw new RuntimeException("ID is null");
			}

			if(binder == null)
			{
				throw new RuntimeException("Binder is null");
			}

			if(assumedType == null)
			{
				throw new RuntimeException("Assumed type is null");
			}

			return new GlossIntent(nodes, binder, assumedType, id);
		}
	}
}
