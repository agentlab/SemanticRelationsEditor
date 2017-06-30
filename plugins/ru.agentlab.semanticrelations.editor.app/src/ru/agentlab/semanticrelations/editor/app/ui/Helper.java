
package ru.agentlab.semanticrelations.editor.app.ui;

import java.util.Collections;

import org.eclipse.gef.graph.Graph;
import org.eclipse.gef.graph.Graph.Builder;
import org.eclipse.gef.layout.algorithms.HorizontalShiftAlgorithm;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.gef.zest.fx.ZestProperties;

public class Helper {

	protected static final String ID = ZestProperties.CSS_ID__NE;
	protected static final String LABEL = ZestProperties.LABEL__NE;
	protected static final String CSS_CLASS = ZestProperties.CSS_CLASS__NE;
	protected static final String LAYOUT_IRRELEVANT = ZestProperties.LAYOUT_IRRELEVANT__NE;
	protected static IDomain domain;
	protected static IViewer viewer;
	protected static Graph graph;
	static String[] tokens; //Array of words of a sentence

	static Graph createGraph() {
		Builder builder = new Graph.Builder().attr(ZestProperties.LAYOUT_ALGORITHM__G, new HorizontalShiftAlgorithm());
		for (int i = 0; i < tokens.length; i++) {
			builder
			.node(i)
			.attr(LABEL, tokens[i])
			.edge(i - 1, i).attr(LABEL, "edge" + i);//add edges

		}
		Graph g = builder.build();
		//System.out.println(g);
		return g;
	}

	static Graph createGraphnull() {
		return graph;
	}

	public static void handleButton(String textbox) {
		String str = textbox;
		String delims = "[ .,?!]+";
		tokens = str.split(delims);
		graph = createGraph();
		viewer.getContents().setAll(Collections.singletonList(graph));
	}

}
