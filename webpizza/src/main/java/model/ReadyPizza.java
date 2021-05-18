package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadyPizza implements Serializable {
    private List<String> listPizza = new ArrayList<>();

    public ReadyPizza() {
        listPizza.add("Маргарита");
        listPizza.add("Четыре сыра");
        listPizza.add("Капричоза");
        listPizza.add("Гавайская");
    }

    public List<String> getListPizza() {
        return listPizza;
    }

    public void setListPizza(List<String> listPizza) {
        this.listPizza = listPizza;
    }

}
