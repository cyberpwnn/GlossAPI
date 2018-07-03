package com.volmit.gloss.api;

import org.bukkit.plugin.Plugin;

import com.volmit.gloss.api.capture.Capture;
import com.volmit.gloss.api.capture.VC;
import com.volmit.gloss.api.context.Binder;
import com.volmit.gloss.api.context.CompiledIntent;
import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.context.Intent;
import com.volmit.gloss.api.context.Node;
import com.volmit.gloss.api.display.DisplayRenderer;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.api.source.SourceType;
import com.volmit.gloss.library.CaptureLibrary;
import com.volmit.gloss.library.IntentLibrary;
import com.volmit.gloss.library.NodeLibrary;

public class GLOSS
{
	private static IntentLibrary intentLibrary;
	private static CaptureLibrary captureLibrary;
	private static NodeLibrary nodeLibrary;

	public static void registerIntentions(Plugin plugin, String superPackage)
	{
		intentLibrary.register(plugin, superPackage);
	}

	public static <T> void registerIntent(CompiledIntent<T> intent)
	{
		create1IntentNode(intent.getId(), intent, intent, intent.getBinder(), intent.getSourceType());
	}

	public static <T> void create1IntentNode(String id, Capture<Context, Source, T> capture, DisplayRenderer renderer, Binder<?> binder, SourceType assume)
	{
		//@builder
		getCaptureLibrary().register(new VC<T>(id, capture));
		getNodeLibrary().register(Node.builder()
				.id(id)
				.capture(id)
				.renderer(renderer)
				.build());
		getIntentLibrary().register(Intent.builder()
				.assume(assume)
				.binder(binder)
				.id(id)
				.node(id)
				.build());
		//@done
	}

	public static void init(IntentLibrary intentLibrary, CaptureLibrary captureLibrary, NodeLibrary nodeLibrary)
	{
		GLOSS.intentLibrary = intentLibrary;
		GLOSS.captureLibrary = captureLibrary;
		GLOSS.nodeLibrary = nodeLibrary;
	}

	public static IntentLibrary getIntentLibrary()
	{
		return intentLibrary;
	}

	public static NodeLibrary getNodeLibrary()
	{
		return nodeLibrary;
	}

	public static CaptureLibrary getCaptureLibrary()
	{
		return captureLibrary;
	}
}
