/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import Model.Alternative;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

/**
 *
 * @author mauricio
 */
public class GraphVisual extends JFrame {
  private static final long serialVersionUID = 1428287443354946650L;
  
  private Map<Alternative, List<Alternative>> graph;
  private DirectedGraph<String, String> g;

  private Stack<Alternative> s = new Stack<>();
  private TreeSet<Alternative> visited = new TreeSet<>();

  private void dfs(Alternative node, boolean first) {
    //if(visited.contains(node)) return;
    visited.add(node);

    for (Alternative nei : graph.get(node)) {
      if (!visited.contains(nei)) {
        if (!first) g.addEdge(
          node.getName() + nei.getName(),
          node.getName(),
          nei.getName()
        );
        dfs(nei, first);
      }
    }

    if (first) s.add(node);
  }

  public GraphVisual(Map<Alternative, List<Alternative>> graph) {
    super("Solución PROMETHEE 2");
    this.graph = graph;
    showGraph();
  }

  public void showGraph() {
    g = new DirectedSparseGraph<>();

    for (Alternative a : graph.keySet()) {
      g.addVertex(a.getName());
      if (!visited.contains(a)) {
        dfs(a, true);
      }
      /*for (Alternative e : graph.get(a)) {
                g.addEdge(a.getName() + e.getName(), a.getName(), e.getName());
            }*/
    }
    visited.clear();

    ArrayList<Alternative> alternatives = new ArrayList<>();
    alternatives.addAll(graph.keySet());
    Collections.sort(alternatives);

    for (Alternative a : alternatives) {
      if (!visited.contains(a)) {
        dfs(a, false);
      }
    }

    /*
        while(!s.empty()){
            if(!visited.contains(s.peek())){
                dfs(s.peek(),false);
            }
            s.pop();
        }*/

    Layout<String, String> layout = (Layout<String, String>)new CircleLayout<String, String>(g);
    layout.setSize(new Dimension(370, 300));

    Transformer<String, Paint> vertexPaint = new Transformer<String, Paint>() {

      @Override
      public Paint transform(String i) {
        return Color.GREEN;
      }
    };

    BasicVisualizationServer<String, String> vv = new BasicVisualizationServer<>(
      layout
    );
    vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
    vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
    vv.setPreferredSize(new Dimension(420, 350));

    this.setLocation(750, 0);
    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.getContentPane().add(vv);
  }
}
