package com.volmit.gloss.api.capture;

@FunctionalInterface
public interface Capture<CTX, SRC, T>
{
	public T apply(CTX ctx, SRC src);
}
