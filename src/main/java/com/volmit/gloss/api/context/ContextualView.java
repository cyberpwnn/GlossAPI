package com.volmit.gloss.api.context;

import java.util.concurrent.ExecutorService;

import org.bukkit.entity.Player;

import com.volmit.volume.lang.collections.GList;

public interface ContextualView
{
	public Player getPlayer();

	public StaticContext getStaticContext(String id);

	public Context getHandContext();

	public GList<StaticContext> getStaticContexts();

	public void addStaticContext(StaticContext stx);

	public void removeStaticContext(StaticContext stx);

	public void removeStaticContext(String id);

	public boolean hasStaticContext(String id);

	public void update(ExecutorService svc);

	public StaticContext getStaticContextLooking();

	public void destroy();

	public void justClicked();
}
