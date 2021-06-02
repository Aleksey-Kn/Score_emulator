package com.example.demo.dataManagers;


import org.springframework.stereotype.Component;

@Component
public class HardDisk extends Data {
    protected int volume;

    public HardDisk(int id, int seriesNumber, String maker, int price, int counter, int volume){
        super(id, seriesNumber, maker, price, counter);
        this.volume = volume;
    }

    public void init(int seriesNumber, String maker, int price, int counter, int volume) {
        super.init(seriesNumber, maker, price, counter);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "HardDisk{" +
                "seriesNumber=" + seriesNumber +
                ", price=" + price +
                ", counter=" + counter +
                ", maker='" + maker + '\'' +
                ", volume=" + volume +
                '}';
    }

    public int getVolume() {
        return volume;
    }
}
