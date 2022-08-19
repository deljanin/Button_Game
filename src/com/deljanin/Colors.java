package com.deljanin;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Colors {
    public HashMap<Integer, Color> color = new HashMap<Integer, Color>();


    public void setColor(HashMap<Integer, Color> color) {
        this.color = color;
    }

    public Colors() {
        color.put(0,new Color(255,255,255));
        color.put(1,new Color(255,75,75));
        color.put(2,new Color(100,100,255));
        color.put(3,new Color(255,255, 0));
        color.put(4,new Color(50,150,50));
        color.put(5,new Color(0,0,0));
    }

    public Color easy(){
        Random r = new Random();
        color.put(0,Color.WHITE);
        color.put(1,new Color(255,75,75));
        color.put(2,new Color(100,100,255));
        return this.color.get(r.nextInt(3));
    }
    public Color normal(){
        Random r = new Random();
        color.put(0,Color.WHITE);
        color.put(1,new Color(255,75,75));
        color.put(2,new Color(100,100,255));
        color.put(3,new Color(255,255, 0));
        return this.color.get(r.nextInt(4));
    }
    public Color hard(){
        Random r = new Random();
        color.put(0,Color.WHITE);
        color.put(1,new Color(255,75,75));
        color.put(2,new Color(100,100,255));
        color.put(3,new Color(255,255, 0));
        color.put(4,new Color(50,150,50));
        color.put(5,Color.BLACK);
        return this.color.get(r.nextInt(6));
    }
}
