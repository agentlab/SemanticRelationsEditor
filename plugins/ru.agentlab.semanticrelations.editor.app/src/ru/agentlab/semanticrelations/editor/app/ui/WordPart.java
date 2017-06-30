package ru.agentlab.semanticrelations.editor.app.ui;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.eclipse.gef.common.adapt.AdapterKey;
import org.eclipse.gef.fx.nodes.InfiniteCanvas;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.gef.zest.fx.ZestFxModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import javafx.scene.layout.BorderPane;

public class WordPart extends GraphLayout {
	//private String dotExecutablePath = "C:/Program Files (x86)/Graphviz2.38/bin";

	@PostConstruct
	void initUIPane(BorderPane pane){
		graph = createGraph();
		// configure application
		Injector injector = Guice.createInjector(createModule());
	    domain = injector.getInstance(IDomain.class);
	    viewer = domain.getAdapter(AdapterKey.get(IViewer.class, IDomain.CONTENT_VIEWER_ROLE));
	    InfiniteCanvas canvas = (InfiniteCanvas)viewer.getCanvas();
	    pane.setCenter(canvas);
	    canvas.sceneProperty().addListener((observable, oldValue, newValue) -> {
	      if (canvas.getScene() != null) {
	        domain.activate();
	        try {
	        	viewer.getContents().setAll(Collections.singletonList(graph));
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	      }
	    });
	}

	protected Module createModule() {
		return new ZestFxModule();
	}
}
