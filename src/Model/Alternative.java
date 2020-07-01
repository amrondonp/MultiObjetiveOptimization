/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mauricio
 */
public class Alternative implements Comparable<Alternative> {
  private String name;
  private List<Double> values;
  private double posFlux;
  private double negFlux;
  private double netFlux;

  public Alternative() {
    name = "";
    values = new ArrayList<>();
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name + " " + getValues();
  }

  /**
   * @return the values
   */
  public List<Double> getValues() {
    return values;
  }

  /**
   * @param values the values to set
   */
  public void setValues(List<Double> values) {
    this.values = values;
  }

  public void addValue(double parseDouble) {
    this.values.add(parseDouble);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Alternative) {
      Alternative aux = (Alternative) o;
      return this.name.equals(aux.name);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 83 * hash + Objects.hashCode(this.name);
    return hash;
  }

  /**
   * @return the posFlux
   */
  public double getPosFlux() {
    return posFlux;
  }

  /**
   * @param posFlux the posFlux to set
   */
  public void setPosFlux(double posFlux) {
    this.posFlux = posFlux;
  }

  /**
   * @return the negFlux
   */
  public double getNegFlux() {
    return negFlux;
  }

  /**
   * @param negFlux the negFlux to set
   */
  public void setNegFlux(double negFlux) {
    this.negFlux = negFlux;
  }

  /**
   * @return the netFlux
   */
  public double getNetFlux() {
    return netFlux;
  }

  /**
   * @param netFlux the netFlux to set
   */
  public void setNetFlux(double netFlux) {
    this.netFlux = netFlux;
  }

  @Override
  public int compareTo(Alternative o) {
    if (this.netFlux > o.netFlux) return -1; else if (
      this.netFlux < o.netFlux
    ) return 1; else return 0;
  }
}
