package com.volmit.gloss.api.display;

import com.volmit.gloss.util.ScrollResult;
import com.volmit.volume.lang.collections.GSet;

public interface SelectionDisplay
{
	public GSet<Integer> getTraversableComponents();

	public int getSelection();

	public void setSelection(int selection);

	public void scroll(ScrollResult r);

	public void setFocusTraversable(int selection, boolean canFocus);

	public boolean isFocusTraversable(int selection);

	public boolean hasSelection();

	public int getMinFocus();

	public int getMaxFocus();
}
