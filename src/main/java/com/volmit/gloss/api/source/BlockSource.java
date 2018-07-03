package com.volmit.gloss.api.source;

import org.bukkit.Material;
import org.bukkit.block.Block;

public interface BlockSource extends Source
{
	public Block getBlock();

	public Material getBlockType();
}
