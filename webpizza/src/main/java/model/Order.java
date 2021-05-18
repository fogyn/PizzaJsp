package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private String nameCustomer;
    private String phone;
    private String email;
    private String adres;

    private List<PizzaData> pizzaDataList = new ArrayList<>();


    public Order() {
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<PizzaData> getPizzaDataList() {
        return pizzaDataList;
    }

    public void setPizzaDataList(List<PizzaData> pizzaDataList) {
        this.pizzaDataList = pizzaDataList;
    }
}
