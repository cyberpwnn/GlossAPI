package com.volmit.gloss.api.library;

import com.volmit.volume.lang.collections.GList;

public interface Library<T>
{
	public GList<T> getRegistries();

	public void register(T t);

	public T get(String id);
}
