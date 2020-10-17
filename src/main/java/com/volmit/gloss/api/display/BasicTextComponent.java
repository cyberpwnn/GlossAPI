package com.volmit.gloss.api.display;

import com.volmit.gloss.api.util.CC;

import java.util.Objects;

public class BasicTextComponent implements TextComponent
{
	private CC c;
	private String t;

	public BasicTextComponent(CC c)
	{
		this.c = c;
	}

	public BasicTextComponent(String t)
	{
		this.t = t;
	}

	@Override
	public boolean isColor()
	{
		return c != null;
	}

	@Override
	public CC getColor()
	{
		return c;
	}

	@Override
	public String get()
	{
		if(isColor())
		{
			return c.toString();
		}

		return t;
	}

	@Override
	public String mojangValue() {
		return isColor() ? c.mojangValue() : t;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BasicTextComponent that = (BasicTextComponent) o;

		if (!Objects.equals(c, that.c)) return false;
		return Objects.equals(t, that.t);
	}

	@Override
	public int hashCode() {
		int result = c != null ? c.hashCode() : 0;
		result = 31 * result + (t != null ? t.hashCode() : 0);
		return result;
	}
}
