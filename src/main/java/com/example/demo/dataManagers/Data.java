package com.example.demo.dataManagers;

abstract public class Data {
    protected int id, seriesNumber, price, counter;
    protected String maker;

    protected Data(int id, int seriesNumber, String maker, int price, int counter){
        this.id = id;
        this.seriesNumber = seriesNumber;
        this.maker = maker;
        this.price = price;
        this.counter = counter;
    }

    public void init(int seriesNumber, String maker, int price, int counter){
        this.seriesNumber = seriesNumber;
        this.maker = maker;
        this.price = price;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public int getPrice() {
        return price;
    }

    public String getMaker() {
        return maker;
    }

    public int getSeriesNumber() {
        return seriesNumber;
    }

    public int getId() {
        return id;
    }
}
