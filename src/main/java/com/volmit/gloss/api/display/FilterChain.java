package com.volmit.gloss.api.display;

import primal.lang.collection.GList;

public interface FilterChain
{
	public GList<TextFilter> getFilters();

	public void addFilter(TextFilter f);

	public void removeFilter(TextFilter f);

	public void clearFilters();
}
