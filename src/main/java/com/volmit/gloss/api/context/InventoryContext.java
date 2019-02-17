package com.volmit.gloss.api.context;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface InventoryContext
{
	public void updateInventoryItem(int slot, ItemStack is);

	public void resetInventoryItem(int slot, ItemStack is);

	public ItemStack filterItemStack(ItemStack is);

	public boolean updateInventoryItems();

	public Player getPlayer();
}
