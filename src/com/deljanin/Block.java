package com.deljanin;

import javax.swing.*;
import java.awt.*;

public class Block extends JButton {// These are our buttons with x and y coords that we need for recursion
    private int x;
    private int y;


    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getmyX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getmyY(){
        return this.y;
    }


    public void setY(int y) {
        this.y = y;
    }

}