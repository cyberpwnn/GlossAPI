package com.volmit.gloss.api.display;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.volmit.gloss.util.CC;
import com.volmit.volume.lang.collections.GList;

public interface TextFilter
{
	public String filter(Player p, boolean isClicking, Location l, TextComponent... components);

	public static TextComponent[] extract(String src)
	{
		GList<TextComponent> cs = new GList<TextComponent>();
		char s = '§';
		char[] v = src.toCharArray();
		boolean skip = false;
		String buffer = "";

		for(int i = 0; i < v.length; i++)
		{
			if(skip)
			{
				skip = false;
				continue;
			}

			if(v[i] == s)
			{
				if(!buffer.isEmpty())
				{
					cs.add(new BasicTextComponent(buffer));
					buffer = "";
				}

				cs.add(new BasicTextComponent(CC.getByChar(v[i + 1])));
				skip = true;
			}

			else
			{
				buffer += v[i];
			}
		}

		if(!buffer.isEmpty())
		{
			cs.add(new BasicTextComponent(buffer));
			buffer = "";
		}

		return cs.toArray(new TextComponent[cs.size()]);
	}

	public static String combine(TextComponent[] components)
	{
		String c = "";

		for(TextComponent i : components)
		{
			c += i.get();
		}

		return c;
	}
}
