/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author THAO LINH
 */
public class Dependent {
    private double income;
    private ArrayList<Children> children;
    private ArrayList<Parent> parent;

    public Dependent(double income, ArrayList<Children> children, ArrayList<Parent> parent) {
        this.income = income;
        this.children = children;
        this.parent = parent;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }

    public ArrayList<Parent> getParent() {
        return parent;
    }

    public void setParent(ArrayList<Parent> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Dependent{" + "income=" + income + ", children=" + children + ", parent=" + parent + '}';
    }


    
    
}
