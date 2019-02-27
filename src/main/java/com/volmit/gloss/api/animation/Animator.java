package com.volmit.gloss.api.animation;

import mortar.compute.math.M;

@FunctionalInterface
public interface Animator
{
	public static final long MSS = M.ms();

	public Frame getTemporalFrame(double targetFramerate, Animation animation);
}
