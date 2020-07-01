/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mauricio
 */
public class Criterion {
  private int type;
  private final Map<String, Double> params;
  private String name;
  private double weight;
  private boolean max;

  public Criterion() {
    type = 0;
    params = new HashMap<>();
    name = "";
    weight = 0;
  }

  /**
   * @return the type
   */
  public int getType() {
    return type;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the weight
   */
  public double getWeight() {
    return weight;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setType(int type) throws Exception {
    if (type > 6 || type < 1) throw new Exception(
      type + " is an invalid criterion type"
    );
    this.type = type;
  }

  public void addParam(String name, double value) {
    params.put(name, value);
  }

  public void setWeight(double weight) throws Exception {
    if (weight < 0) throw new Exception("Weight cannot be negative");
    this.weight = weight;
  }

  private double getParam(String param) throws Exception {
    Double value = params.get(param);
    if (value == null) throw new Exception("No param named " + param);
    return value;
  }

  public double compute(double a1, double a2) throws Exception {
    double ans = 0.0;

    if (!max) {
      a1 = -a1;
      a2 = -a2;
    }

    double x = a1 - a2;

    if (x < 0) return 0;

    switch (getType()) {
      case 1:
        if (x > 0) ans = 1.0; else ans = 0.0;
        break;
      case 2:
        double l = getParam("l");
        if (x > l) ans = 1.0; else ans = 0.0;
        break;
      case 3:
        double m = getParam("m");
        if (x < m) ans = x / m; else ans = 1;
        break;
      case 4:
        double q = getParam("q");
        double p = getParam("p");
        if (x < q) ans = 0.0; else if (x > q + p) ans = 1.0; else ans = 0.5;
        break;
      case 5:
        double r = getParam("r");
        double s = getParam("s");

        if (x < s) ans = 0.0; else if (x > s + r) ans = 1.0; else ans =
          (x - s) / r;
        break;
      case 6:
        double sigma = getParam("sigma");
        if (x < 0) ans = 0.0; else ans =
          1 - Math.exp(-(x * x / (2 * sigma * sigma)));
        break;
    }
    return ans;
  }

  @Override
  public String toString() {
    String max = "max";
    if (!this.max) max = "min";
    return String.format(
      "%-25s%-6s%-6s%-9s%-20s\n",
      name,
      type,
      weight,
      max,
      params
    );
  }

  /**
   * @return the max
   */
  public boolean isMax() {
    return max;
  }

  /**
   * @param max the max to set
   */
  public void setMax(boolean max) {
    this.max = max;
  }
}
