package com.volmit.gloss.api.display;

public interface LineEditor
{
	public int getSelectedLine();

	public void selectLine(int line);

	public void deselectLine();

	public int getMaxLine();

	public boolean isLineSelected();
}
