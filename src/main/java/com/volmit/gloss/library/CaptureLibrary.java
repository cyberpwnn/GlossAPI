package com.volmit.gloss.library;

import com.volmit.gloss.api.capture.VC;

public interface CaptureLibrary extends Library<VC<?>>
{
	public <V> VC<V> getCapture(String id);
}
