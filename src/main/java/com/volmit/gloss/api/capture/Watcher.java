package com.volmit.gloss.api.capture;

public class Watcher<T>
{
	public T current;
	public T last;

	public T last()
	{
		return last;
	}

	public Watcher(T init)
	{
		this.current = init;
		this.last = init;
	}

	public T get()
	{
		return current;
	}

	public void set(T t)
	{
		current = t;
	}

	public boolean isStale()
	{
		return current == null || !current.equals(last);
	}

	public void mark()
	{
		last = current;
	}
}
