package model;

import java.util.List;

public interface Data {

    public String getNamePizza();

    public void setNamePizza(String namePizza);

    public int getNumOrder();

    public void setNumOrder(int numOrder);

    public List<String> getPizzaElement();

    public void setPizzaElement(List<String> pizzaElement);


}
