package com.volmit.gloss.api.display;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.volmit.gloss.api.util.CC;

import mortar.lang.collection.GList;

public interface TextFilter
{
	public String filter(Player p, boolean isClicking, Location l, TextComponent... components);

	public static boolean compression = true;

	public static String implode(GList<String> basex)
	{
		return compress(basex.toString(""));
	}

	public static GList<String> explode(String text)
	{
		GList<String> s = new GList<>();
		String stripped = CC.stripColor(text);
		boolean formatter = false;
		int realIndex = 0;

		for(int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i);

			if(c == CC.COLOR_CHAR)
			{
				formatter = true;
				continue;
			}

			if(formatter)
			{
				formatter = false;
				continue;
			}

			s.add(CC.getLastColors(text.substring(0, i)) + stripped.charAt(realIndex));
			realIndex++;
		}

		return s;
	}

	public static String compress(String c)
	{
		if(!compression)
		{
			return c;
		}

		TextComponent[] f = extract(c);
		CC lastColor = CC.WHITE;
		CC lastFormat = null;
		String m = "";

		for(TextComponent i : f)
		{
			if(i.isColor())
			{
				if(i.getColor().isFormat())
				{
					if(lastFormat == null || !lastFormat.equals(i.getColor()))
					{
						lastFormat = i.getColor();
						m += lastFormat;
					}
				}

				else
				{
					if(!lastColor.equals(i.getColor()))
					{
						lastColor = i.getColor();
						lastFormat = null;
						m += lastColor;
					}
				}
			}

			else
			{
				m += i.get();
			}
		}

		return m;
	}

	public static TextComponent[] extract(String src)
	{
		GList<TextComponent> cs = new GList<TextComponent>();
		char s = CC.COLOR_CHAR;
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

				CC cv = CC.getByChar(v[i + 1]);
				cs.add(new BasicTextComponent(cv));
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
