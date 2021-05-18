package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadyTopinges implements Serializable {
    private List<String> listTopinges = new ArrayList<>();

    public ReadyTopinges() {
        listTopinges.add("Томаты");
        listTopinges.add("Шпинат");
        listTopinges.add("Халапеньо");
        listTopinges.add("Маслины");
        listTopinges.add("Грибы");
        listTopinges.add("Купица");
        listTopinges.add("Свинина");
        listTopinges.add("Пепперони");
        listTopinges.add("Сыр Гауда");
        listTopinges.add("Сыр Моцарелла");
        listTopinges.add("Сыр Фета");
    }


    public List<String> getListTopinges() {
        return listTopinges;
    }

    public void setListTopinges(List<String> listTopinges) {
        this.listTopinges = listTopinges;
    }
}
