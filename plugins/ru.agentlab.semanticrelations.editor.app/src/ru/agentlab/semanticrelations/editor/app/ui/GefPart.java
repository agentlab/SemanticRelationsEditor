package ru.agentlab.semanticrelations.editor.app.ui;

import javax.annotation.PostConstruct;

import org.eclipse.gef.common.adapt.AdapterKey;
import org.eclipse.gef.fx.nodes.InfiniteCanvas;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.viewer.IViewer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import javafx.scene.layout.BorderPane;

public class GefPart extends GraphLayout {

	@PostConstruct
	void initUIPane(BorderPane pane){
		// configure application
		Injector injector = Guice.createInjector(createModule());
	    domain = injector.getInstance(IDomain.class);
	    viewer = domain.getAdapter(AdapterKey.get(IViewer.class, IDomain.CONTENT_VIEWER_ROLE));
	    InfiniteCanvas canvas = (InfiniteCanvas)viewer.getCanvas();
	    pane.setCenter(canvas);
	    canvas.sceneProperty().addListener((observable, oldValue, newValue) -> {
	      if (canvas.getScene() != null) {
	        domain.activate();
	      }
	    });
	}

	protected Module createModule() {
		return new CustomModule();
	}
}
