package com.volmit.gloss.api.capture;

@FunctionalInterface
public interface SpecialEvent<A, B, C>
{
	public C add(A a, B b);
}
