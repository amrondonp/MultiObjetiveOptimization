/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Model.Alternative;
import Model.Criterion;
/**
 *
 * @author mauricio
 */
import Model.Promethee;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPromethee {
  private Promethee promethee;

  public TestPromethee() {}

  @BeforeClass
  public static void setUpClass() {}

  @AfterClass
  public static void tearDownClass() {}

  @Before
  public void setUp() throws Exception {
    this.promethee = new Promethee();
    List<Criterion> criteria = new ArrayList<Criterion>();

    Criterion c = new Criterion();
    c.setMax(false);
    c.setWeight(1);
    c.setType(2);
    c.addParam("l", 10);
    c.setName("f1");
    criteria.add(c);

    c = new Criterion();
    c.setMax(true);
    c.setWeight(1);
    c.setType(3);
    c.addParam("m", 30);
    c.setName("f2");
    criteria.add(c);

    c = new Criterion();
    c.setWeight(1);
    c.setMax(false);
    c.setType(5);
    c.addParam("s", 5);
    c.addParam("r", 45);
    c.setName("f3");
    criteria.add(c);

    c = new Criterion();
    c.setWeight(1);
    c.setMax(false);
    c.setType(4);
    c.addParam("q", 1);
    c.addParam("p", 5);
    c.setName("f4");
    criteria.add(c);

    c = new Criterion();
    c.setWeight(1);
    c.setMax(false);
    c.setType(1);
    c.setName("f5");
    criteria.add(c);

    c = new Criterion();
    c.setWeight(1);
    c.setMax(true);
    c.setType(6);
    c.addParam("sigma", 5);
    c.setName("f6");
    criteria.add(c);

    promethee.setCriteria(criteria);

    double[][] mat = {
      { 80, 65, 83, 40, 52, 94 },
      { 90, 58, 60, 80, 72, 96 },
      { 60, 20, 40, 100, 60, 70 },
      { 5.4, 9.7, 7.2, 7.5, 2, 3.6 },
      { 8, 1, 4, 7, 3, 5 },
      { 5, 1, 7, 10, 8, 6 },
    };

    int n = 6;
    List<Alternative> alternatives = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Alternative alternative = new Alternative();
      alternative.setName("a" + (i + 1));
      for (int j = 0; j < n; j++) {
        alternative.addValue(mat[j][i]);
      }
      alternatives.add(alternative);
    }
    promethee.setAlternatives(alternatives);
  }

  @After
  public void tearDown() {}

  @Test
  public void testPreferenceDegree() {
    promethee.computeFlows();

    double[][] mat = {
      { 0.000, 0.296, 0.250, 0.269, 0.100, 0.185 },
      { 0.463, 0.000, 0.389, 0.333, 0.296, 0.500 },
      { 0.235, 0.180, 0.000, 0.333, 0.056, 0.429 },
      { 0.399, 0.506, 0.305, 0.000, 0.224, 0.212 },
      { 0.444, 0.515, 0.487, 0.380, 0.000, 0.448 },
      { 0.287, 0.399, 0.250, 0.431, 0.133, 0.000 },
    };

    int n = promethee.getAlternatives().size();
    // System.out.println("***************************************");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // System.out.printf("%8.3f", promethee.getPreferenceIndex()[i][j]);
        assertFalse(
          Math.abs(promethee.getPreferenceIndex()[i][j] - mat[i][j]) > 0.001
        );
      }
      // System.out.println("");
    }
  }

  @Test
  public void testFlows() {
    promethee.computeFlows();
    double[] rightPosFlows = { 1.099, 1.980, 1.234, 1.644, 2.274, 1.500 };
    double[] rightNegFlows = { 1.827, 1.895, 1.681, 1.746, 0.808, 1.774 };

    /*
     * System.out.println("Neg correct: "); for(int i=0 ; i<rightPosFlows.length ;
     * i++){ System.out.print(rightNegFlows[i]+" "); }System.out.println("");
     *
     * System.out.println("Neg out: "); for(int i=0 ; i<rightPosFlows.length ; i++){
     * System.out.printf("%5.3f ",promethee.getNegFlux()[i]);
     * }System.out.println("");
     *
     * System.out.println("Pos right: "); for(int i=0 ; i<rightPosFlows.length ;
     * i++){ System.out.printf("%5.3f ",rightPosFlows[i]); }System.out.println("");
     *
     *
     * System.out.println("Pos out: "); for(int i=0 ; i<rightPosFlows.length ; i++){
     * System.out.printf("%5.3f ",promethee.getPosFlux()[i]);
     * }System.out.println("");
     */

    for (int i = 0; i < rightPosFlows.length; i++) {
      // System.out.println("Neg = " + rightNegFlows[i]+ " " +
      // promethee.getNegFlux()[i]);
      assertFalse(
        Math.abs(rightNegFlows[i] - promethee.getNegFlux()[i]) > 0.01
      );
      // System.out.println("Pos = " + rightPosFlows[i]+"
      // "+promethee.getPosFlux()[i]);
      assertFalse(
        Math.abs(rightPosFlows[i] - promethee.getPosFlux()[i]) > 0.01
      );
    }
  }

  @Test
  public void testTotalOrder() {
    String[] correct = { "a5", "a2", "a4", "a6", "a3", "a1" };
    List<Alternative> alternatives = promethee.getTotalOrder();
    assertTrue(correct.length == alternatives.size());
    for (int i = 0; i < correct.length; i++) {
      // System.out.println(a.getName());
      assertTrue(correct[i].equals(alternatives.get(i).getName()));
    }
  }

  @Test
  public void testPartialOrder() {
    Map<Alternative, List<Alternative>> graph = promethee.getPartialOrder();

    Alternative a1 = new Alternative();
    a1.setName("a1");

    Alternative a2 = new Alternative();
    a2.setName("a2");

    Alternative a3 = new Alternative();
    a3.setName("a3");

    Alternative a4 = new Alternative();
    a4.setName("a4");

    Alternative a5 = new Alternative();
    a5.setName("a5");

    Alternative a6 = new Alternative();
    a6.setName("a6");

    assertTrue("No a1 found", graph.containsKey(a1));
    assertTrue("No a2 found", graph.containsKey(a2));
    assertTrue("No a3 found", graph.containsKey(a3));
    assertTrue("No a4 found", graph.containsKey(a4));
    assertTrue("No a5 found", graph.containsKey(a5));
    assertTrue("No a6 found", graph.containsKey(a6));

    // System.out.println(graph.get(a5));
    assertTrue("a5 doesn't have 5 childs", graph.get(a5).size() == 5);
    // assert(graph.get(a5).contains(a4));
    // assert(graph.get(a5).contains(a3));
    // assert(graph.get(a5).contains(a2));

    assert (graph.get(a4).size() == 2);
    assert (graph.get(a4).contains(a6));
    assert (graph.get(a4).contains(a1));

    assert (graph.get(a2).isEmpty());

    assert (graph.get(a1).isEmpty());

    assert (graph.get(a6).size() == 1);
    assert (graph.get(a6).contains(a1));

    assert (graph.get(a3).size() == 1);
    assert (graph.get(a3).contains(a1));
  }
}
