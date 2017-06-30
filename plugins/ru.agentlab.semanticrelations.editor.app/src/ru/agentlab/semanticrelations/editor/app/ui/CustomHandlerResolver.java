/**
 *
 */
package ru.agentlab.semanticrelations.editor.app.ui;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.mvc.fx.gestures.DefaultHandlerResolver;
import org.eclipse.gef.mvc.fx.gestures.IGesture;
import org.eclipse.gef.mvc.fx.handlers.IHandler;
import org.eclipse.gef.mvc.fx.viewer.IViewer;

import javafx.scene.Node;

public class CustomHandlerResolver extends DefaultHandlerResolver {
	@Override
	public <T extends IHandler> List<? extends T> resolve(IGesture gesture, Node target, IViewer viewer,Class<T> handlerType) {
        if (viewer == null) {
            return Collections.emptyList();
        }
        return super.resolve(gesture, target, viewer, handlerType);
    }
}