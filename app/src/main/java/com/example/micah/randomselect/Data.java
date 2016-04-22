package com.example.micah.randomselect;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * data is the name of a location
 * LatLng is the latitude and longitude of the location
 */
public class Data {

    private static List<String> data = new ArrayList<>();
    private static List<LatLng> latLng = new ArrayList<>();

    public static int getLength() {return data.size();}

    public static String getData(int x) { return data.get(x); }
    public static LatLng getLatLng(int x) { return latLng.get(x); }

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

    static{
        latLng.add(new LatLng(35.528337,-98.690911));
        latLng.add(new LatLng(35.525735,-98.696147));
        latLng.add(new LatLng(35.526931,-98.694559));
        latLng.add(new LatLng(35.526346,-98.697048));
        latLng.add(new LatLng(35.526390,-98.696555));
        latLng.add(new LatLng(35.526355,-98.700868));
        latLng.add(new LatLng(35.525639,-98.697123));
        latLng.add(new LatLng(35.525735,-98.705664));
        latLng.add(new LatLng(35.527464,-98.693669));
        latLng.add(new LatLng(35.527438,-98.693442));
        latLng.add(new LatLng(35.536704,-98.677709));
        latLng.add(new LatLng(35.526212,-98.704226));
        latLng.add(new LatLng(35.528398,-98.693028));
        latLng.add(new LatLng(35.528415,-98.693650));
        latLng.add(new LatLng(35.526163,-98.699507));
        latLng.add(new LatLng(35.538428,-98.659589));
        latLng.add(new LatLng(35.527036,-98.692728));
        latLng.add(new LatLng(35.537233,-98.695058));
        latLng.add(new LatLng(35.532627,-98.684348));
        latLng.add(new LatLng(35.533305,-98.683458));
        latLng.add(new LatLng(35.526141,-98.708394));
        latLng.add(new LatLng(35.528094,-98.694765));
        latLng.add(new LatLng(35.525751,-98.702089));
        latLng.add(new LatLng(35.526210,-98.708875));
        latLng.add(new LatLng(35.525952,-98.707237));
    }


}



