package com.volmit.gloss.api.animation;

import com.volmit.gloss.api.util.IDD;
import com.volmit.gloss.api.util.IJSON;
import com.volmit.volume.lang.collections.GList;

public interface Animation extends IDD, IJSON
{
	public double getTargetFramerate();

	public AnimationType getType();

	public void setType(AnimationType type);

	public void setTargetFramerate(double framerate);

	public int getFrameCount();

	public GList<Frame> getFrames();

	public void addFrame(Frame frame);

	public void clearFrames();

	public void removeFrame(Frame frame);

	public Animator getAnimator();

	public void setAnimator(Animator animator);
}
