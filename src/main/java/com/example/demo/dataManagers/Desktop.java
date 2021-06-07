package com.example.demo.dataManagers;

import org.springframework.stereotype.Component;

@Component
public class Desktop extends Data {
    protected String formFactor;

    public Desktop(int id, int seriesNumber, String maker, int price, int counter, String formFactor){
        super(id, seriesNumber, maker, price, counter);
        this.formFactor = formFactor;
    }

    public void init(int seriesNumber, String maker, int price, int counter, String formFactor) {
        super.init(seriesNumber, maker, price, counter);
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return "Desktop{" +
                "seriesNumber=" + seriesNumber +
                ", price=" + price +
                ", counter=" + counter +
                ", maker='" + maker + '\'' +
                ", formFactor='" + formFactor + '\'' +
                '}';
    }

    public String getFormFactor() {
        return formFactor;
    }
}
