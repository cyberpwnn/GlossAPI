package com.volmit.gloss.api.display;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.volmit.gloss.api.util.CC;

import mortar.lang.collection.GList;

import java.util.Arrays;
import java.util.List;

public interface TextFilter
{
	String filter(Player p, boolean isClicking, Location l, TextComponent... components);

	boolean compression = true;

	static String implode(GList<String> basex)
	{
		return compress(basex.toString(""));
	}

	static GList<String> explode(String text)
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

	static String compress(String c)
	{
		if(!compression)
		{
			return c;
		}

		TextComponent[] f = extract(c);
		CC lastColor = CC.WHITE;
		CC lastFormat = null;
		StringBuilder m = new StringBuilder();

		for(TextComponent i : f)
		{
			if(i.isColor())
			{
				if(i.getColor().isFormat())
				{
					if(lastFormat == null || !lastFormat.equals(i.getColor()))
					{
						lastFormat = i.getColor();
						m.append(lastFormat);
					}
				}

				else
				{
					if(!lastColor.equals(i.getColor()))
					{
						lastColor = i.getColor();
						lastFormat = null;
						m.append(lastColor.mojangValue());
					}
				}
			}

			else
			{
				m.append(i.get());
			}
		}

		return m.toString().replace(Character.MAX_VALUE, '&');
	}

    List<Character> HEX_CHARS = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F');

	static TextComponent[] extract(String src)
	{
		GList<TextComponent> cs = new GList<>();

		if (src == null || src.length() == 0) {
			return new TextComponent[0];
		}

		src = src.replace("\\&", Character.MAX_VALUE + "");

		char[] v = src.toCharArray();
		StringBuilder buffer = new StringBuilder();
		char character;
		for(int i = 0; i < v.length; i++)
		{
			character = v[i];

			if(character == CC.COLOR_CHAR)
			{
				if(buffer.length() > 0)
				{
					cs.add(new BasicTextComponent(buffer.toString()));
					buffer = new StringBuilder();
				}

				CC cv = CC.getByChar(v[i + 1]);
				if (cv == null) continue;
				cs.add(new BasicTextComponent(cv));
				i++;
			}
            else if (character == '[') {
                if (i + 7 < src.length()
                        && HEX_CHARS.contains(src.charAt(i + 2))
                        && HEX_CHARS.contains(src.charAt(i + 3))
                        && HEX_CHARS.contains(src.charAt(i + 4))
                        && HEX_CHARS.contains(src.charAt(i + 5))
                        && HEX_CHARS.contains(src.charAt(i + 6))
                        && HEX_CHARS.contains(src.charAt(i + 7))) {
					if(buffer.length() > 0)
					{
						cs.add(new BasicTextComponent(buffer.toString()));
						buffer = new StringBuilder();
					}
                    cs.add(new BasicTextComponent(CC.fromHex(src.substring(i + 1, i + 8))));
                    i += 8;
                }
            }
			else
			{
				buffer.append(character);
			}
		}

		if(buffer.length() > 0)
		{
			cs.add(new BasicTextComponent(buffer.toString()));
        }

		return cs.toArray(new TextComponent[0]);
	}

	static String combine(TextComponent[] components)
	{
		StringBuilder c = new StringBuilder();

		for(TextComponent i : components)
		{
			c.append(i.get());
		}

		return c.toString();
	}
}
