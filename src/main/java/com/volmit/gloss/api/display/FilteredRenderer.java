package com.volmit.gloss.api.display;

import com.volmit.volume.lang.collections.GList;

public interface FilteredRenderer
{
	public GList<TextFilter> getFilters();

	public void addFilter(TextFilter f);

	public void removeFilter(TextFilter f);

	public void clearFilters(TextFilter f);

	public String filter(String r);
}
