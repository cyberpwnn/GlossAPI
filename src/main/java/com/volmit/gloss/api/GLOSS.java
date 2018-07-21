package com.volmit.gloss.api;

import org.bukkit.plugin.Plugin;

import com.volmit.gloss.api.binder.Binder;
import com.volmit.gloss.api.board.BoardLibrary;
import com.volmit.gloss.api.capture.Capture;
import com.volmit.gloss.api.capture.VC;
import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.context.Node;
import com.volmit.gloss.api.context.NodeActionListener;
import com.volmit.gloss.api.display.DisplayRenderer;
import com.volmit.gloss.api.intent.CompiledIntent;
import com.volmit.gloss.api.intent.Intent;
import com.volmit.gloss.api.library.CaptureLibrary;
import com.volmit.gloss.api.library.FunctionLibrary;
import com.volmit.gloss.api.library.IntentLibrary;
import com.volmit.gloss.api.library.NodeLibrary;
import com.volmit.gloss.api.source.Source;
import com.volmit.gloss.api.source.SourceType;

public class GLOSS
{
	private static IntentLibrary intentLibrary;
	private static CaptureLibrary captureLibrary;
	private static NodeLibrary nodeLibrary;
	private static BoardLibrary boardLibrary;
	private static FunctionLibrary functionLibrary;

	public static void registerIntentions(Plugin plugin, String superPackage)
	{
		intentLibrary.register(plugin, superPackage);
	}

	public static <T> void registerIntent(CompiledIntent<T> intent)
	{
		createIntentNode(intent.getId(), intent, intent, intent.getBinder(), intent.getSourceType(), intent.isFocusTraversable(), intent);
	}

	public static <T> void createIntentNode(String id, Capture<Context, Source, T> capture, DisplayRenderer renderer, Binder<?> binder, SourceType assume, boolean focus, NodeActionListener listener)
	{
		//@builder
		getCaptureLibrary().register(new VC<T>(id, capture));
		getNodeLibrary().register(Node.builder()
				.id(id)
				.capture(id)
				.renderer(renderer)
				.focusTraversable(focus)
				.listener(listener)
				.build());
		getIntentLibrary().register(Intent.builder()
				.assume(assume)
				.binder(binder)
				.id(id)
				.node(id)
				.build());
		//@done
		System.out.println("Registered " + id);
	}

	public static void init(IntentLibrary intentLibrary, CaptureLibrary captureLibrary, NodeLibrary nodeLibrary, BoardLibrary boardLibrary, FunctionLibrary functionLibrary)
	{
		GLOSS.intentLibrary = intentLibrary;
		GLOSS.captureLibrary = captureLibrary;
		GLOSS.nodeLibrary = nodeLibrary;
		GLOSS.boardLibrary = boardLibrary;
		GLOSS.functionLibrary = functionLibrary;
	}

	public static FunctionLibrary getFunctionLibrary()
	{
		return functionLibrary;
	}

	public static BoardLibrary getBoardLibrary()
	{
		return boardLibrary;
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
