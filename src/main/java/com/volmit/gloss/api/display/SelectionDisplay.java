package com.volmit.gloss.api.display;

import org.bukkit.Location;

import com.volmit.gloss.api.context.Node;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.api.util.ScrollResult;

import primal.lang.collection.GMap;

public interface SelectionDisplay
{
	public boolean hasAnyFocus();

	public int getSelection();

	public void setSelection(int selection, Source src);

	public void scroll(ScrollResult r, Source source);

	public boolean isFocusTraversable(int selection);

	public boolean hasSelection();

	public Node getSelectedNode();

	public int getMinFocus();

	public int getMaxFocus();

	public GMap<Integer, Location> computeHotspots();
}
