package com.example.demo.dataManagers;

import org.springframework.stereotype.Component;

@Component
public class Notebook extends Data{
    protected int size;

    public Notebook(int id, int seriesNumber, String maker, int price, int counter, int size){
        super(id, seriesNumber, maker, price, counter);
        this.size = size;
    }

    public void init(int seriesNumber, String maker, int price, int counter, int size) {
        super.init(seriesNumber, maker, price, counter);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "seriesNumber=" + seriesNumber +
                ", price=" + price +
                ", counter=" + counter +
                ", maker='" + maker + '\'' +
                ", size=" + size +
                '}';
    }

    public int getSize() {
        return size;
    }
}
