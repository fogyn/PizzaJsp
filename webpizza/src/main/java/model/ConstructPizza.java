package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConstructPizza extends PizzaData implements Serializable {

    private List<String> pizzaElement = new ArrayList<>();

    public ConstructPizza() {

    }

    public List<String> getPizzaElement() {
        return pizzaElement;
    }

    public void setPizzaElement(List<String> pizzaElement) {
        this.pizzaElement = pizzaElement;
    }
}
