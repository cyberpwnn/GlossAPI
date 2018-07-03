package com.volmit.gloss.api.capture;

import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.util.IDD;
import com.volmit.volume.lang.collections.GMap;
import com.volmit.volume.math.M;

public class VC<T> implements IDD
{
	protected GMap<Context, T> t;
	protected GMap<Context, Long> last;
	private String id;
	private int rate;
	private Capture<Context, Source, T> capture;

	public VC(String id, int rate, Capture<Context, Source, T> capture)
	{
		this.t = new GMap<Context, T>();
		this.rate = rate;
		last = new GMap<Context, Long>();
		this.capture = capture;
		this.id = id;
	}

	public VC(String id, Capture<Context, Source, T> capture)
	{
		this(id, 0, capture);
	}

	public long getLast(Context ctx)
	{
		return last.containsKey(ctx) ? last.get(ctx) : 0;
	}

	public int getRate()
	{
		return rate;
	}

	public boolean hasValue(Context c)
	{
		return t.containsKey(c);
	}

	public T value(T t, Context c)
	{
		return hasValue(c) ? this.t.get(c) : t;
	}

	public T value(Context c)
	{
		return value(null, c);
	}

	public boolean shouldCapture(Context c)
	{
		if(M.ms() - getLast(c) > (50 * getRate()))
		{
			last.put(c, M.ms());
			return true;
		}

		return false;
	}

	public void capture(Context ctx, Source src)
	{
		t.put(ctx, capture.apply(ctx, src));
	}

	@Override
	public String getId()
	{
		return id;
	}
}
