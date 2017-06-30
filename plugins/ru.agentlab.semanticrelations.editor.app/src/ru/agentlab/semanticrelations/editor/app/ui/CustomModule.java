/**
 *
 */
package ru.agentlab.semanticrelations.editor.app.ui;

import org.eclipse.gef.mvc.fx.MvcFxModule;
import org.eclipse.gef.mvc.fx.gestures.IHandlerResolver;

/**
 * @author SadPyro
 *
 */
public class CustomModule extends MvcFxModule {
    // ...
    @Override
    protected void bindIHandlerResolver() {
        binder().bind(IHandlerResolver.class).to(CustomHandlerResolver.class);
    }
}