package com.volmit.gloss.api.source;

import java.util.concurrent.ExecutorService;

import org.bukkit.World;

import primal.lang.collection.GList;

public interface SourceWorld
{
	public World getWorld();

	public GList<StaticSource> getSources();

	public void createSource(StaticSource source);

	public StaticSource getSource(String id);

	public void removeSource(StaticSource source);

	public void removeSource(String id);

	public boolean hasSource(String id);

	public void update(ExecutorService svc);
}
