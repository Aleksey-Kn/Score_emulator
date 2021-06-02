package com.example.demo.dataManagers;

import org.springframework.stereotype.Component;

@Component
public class Monitor extends Data{
    protected int diagonal;

    public Monitor(int id, int seriesNumber, String maker, int price, int counter, int diagonal){
        super(id, seriesNumber, maker, price, counter);
        this.diagonal = diagonal;
    }

    public void init(int seriesNumber, String maker, int price, int counter, int diagonal) {
        super.init(seriesNumber, maker, price, counter);
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "seriesNumber=" + seriesNumber +
                ", price=" + price +
                ", counter=" + counter +
                ", maker='" + maker + '\'' +
                ", diagonal=" + diagonal +
                '}';
    }

    public int getDiagonal() {
        return diagonal;
    }
}
