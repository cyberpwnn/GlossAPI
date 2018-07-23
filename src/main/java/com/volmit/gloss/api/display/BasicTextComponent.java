package com.volmit.gloss.api.display;

import com.volmit.gloss.api.util.CC;

public class BasicTextComponent implements TextComponent
{
	private CC c;
	private String t;
	private boolean cc;

	public BasicTextComponent(CC c)
	{
		cc = true;
		this.c = c;
	}

	public BasicTextComponent(String t)
	{
		cc = false;
		this.t = t;
	}

	@Override
	public boolean isColor()
	{
		return cc;
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
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + (cc ? 1231 : 1237);
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(!(obj instanceof BasicTextComponent))
		{
			return false;
		}
		BasicTextComponent other = (BasicTextComponent) obj;
		if(c != other.c)
		{
			return false;
		}
		if(cc != other.cc)
		{
			return false;
		}
		if(t == null)
		{
			if(other.t != null)
			{
				return false;
			}
		}
		else if(!t.equals(other.t))
		{
			return false;
		}
		return true;
	}
}
