package model;

import java.io.Serializable;

public class PizzaData implements Serializable {
    private String namePizza;
    private int numOrder;

    public String getNamePizza() {
        return namePizza;
    }

    public void setNamePizza(String namePizza) {
        this.namePizza = namePizza;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    public PizzaData() {
    }
}
