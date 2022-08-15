package com.networkc.model;

import java.sql.Timestamp;

public class Rectangle {
  private int id;
  private double length;
  private double height;
  private double result;
  private Formula formula;
  private Timestamp dateCreated;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getResult() {
    return result;
  }

  public void setResult(double result) {
    this.result = result;
  }

  public Formula getFormula() {
    return formula;
  }

  public void setFormula(Formula formula) {
    this.formula = formula;
  }

  public Timestamp getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }

  @Override
  public String toString() {
    return "Rectangle{" +
        "id=" + id +
        ", length=" + length +
        ", height=" + height +
        ", result=" + result +
        ", formula=" + formula +
        ", dateCreated=" + dateCreated +
        '}';
  }
}
