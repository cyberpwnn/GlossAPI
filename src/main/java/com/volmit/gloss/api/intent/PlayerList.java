package com.volmit.gloss.api.intent;

import java.util.UUID;

import mortar.lang.collection.GList;

public interface PlayerList
{
	public GList<UUID> getList();

	public void add(UUID id);

	public void remove(UUID id);

	public ListMode getMode();

	public void clear();

	public void setMode(ListMode mode);

	public boolean isAllowed(UUID id);
}
