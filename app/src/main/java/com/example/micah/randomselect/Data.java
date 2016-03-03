package com.example.micah.randomselect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micah on 2/6/2016.
 */
public class Data {

    private static List<String> data = new ArrayList<>();

    public static int getLength() {return data.size();}

    public static String getData(int x) { return data.get(x); }

    static{
        data.add("Boomtown");
        data.add("Jerry's");
        data.add("McDonald's");
        data.add("Arby's");
        data.add("Carl's Jr");
        data.add("The Mark");
        data.add("Double 6 Diner");
        data.add("Sonic");
        data.add("KFC");
        data.add("El Patio");
        data.add("The Point");
        data.add("Braums");
        data.add("Little Caesars");
        data.add("Subway");
        data.add("Quiznos");
        data.add("Lucille's");
        data.add("Hibachi Buffet");
        data.add("Lavie Garden");
        data.add("Pecina's");
        data.add("T-Bone Steak House");
        data.add("Luigi's");
        data.add("Pizza Hut");
        data.add("Taco Mayo");
        data.add("Downtown Diner");
        data.add("Benchwarmer Brown's");
    }
}
