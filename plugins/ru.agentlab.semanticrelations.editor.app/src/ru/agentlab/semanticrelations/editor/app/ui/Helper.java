
package ru.agentlab.semanticrelations.editor.app.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.graph.Graph;
import org.eclipse.gef.graph.Graph.Builder;
import org.eclipse.gef.graph.Node;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.gef.zest.fx.ZestProperties;

public class Helper {

	private static int id = 0;
	protected static final String ID = ZestProperties.CSS_ID__NE;
	protected static final String LABEL = ZestProperties.LABEL__NE;
	protected static final String CSS_CLASS = ZestProperties.CSS_CLASS__NE;
	protected static final String LAYOUT_IRRELEVANT = ZestProperties.LAYOUT_IRRELEVANT__NE;
	protected IDomain domain;
	protected IViewer viewer;
	protected Graph graph;
	static String[] tokens;

	static Graph createGraph() {
		Builder b = new Graph.Builder();



		Graph g = b.build();
		return g;
	}


	private void addNodes(Graph.Builder graphBuilder, int count,int startNumber) {
	List<Node> nodes = new ArrayList<>();

	for (int i = 0; i < count; i++) {
//		nodes.add(new Node.Builder().attr(label, (startNumber + i)).buildNode());
	}
	graphBuilder.nodes(nodes);
}
	public static void handleButton(String textbox)  {
		System.out.println(textbox);
        String str = textbox;
        String delims = "[ .,?!]+";
			tokens = str.split(delims);
			createGraph();
	}

}

