package com.volmit.gloss.api.library;

import org.bukkit.Location;

import com.volmit.gloss.api.intent.Descriptor;
import com.volmit.gloss.api.intent.TemporaryDescriptor;

public interface SourceLibrary extends Library<Descriptor>
{
	public TemporaryDescriptor createTemporaryDescriptor(String id, Location initial, long duration);
}
