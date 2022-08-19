package com.deljanin;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.util.Stack;

public class BlockAction implements ActionListener {
    Block source;
    Block destination;
    //Stack<Block> stack = new Stack<>();
    public static int N,M;


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (source == null) {
            source = (Block) actionEvent.getSource();
            source.setText("S");
            source.setFont(new Font("Arial", Font.BOLD, 35));
        } else {
            destination = (Block) actionEvent.getSource();

            if (checkNaber()) {
                floodfill(destination, destination.getBackground(), source.getBackground());
                CheckIfGameWin();
            }
            source.setText(null);
            destination = null;
            source = null;

        }
    }

    private boolean checkNaber() {
        if (Math.abs(destination.getmyX() - source.getmyX()) == 1 && source.getmyY() == destination.getmyY()
         || Math.abs(destination.getmyY() - source.getmyY()) == 1 && source.getmyX() == destination.getmyX()) {
            return true;
        } else return false;
    }
    private boolean isValid(Block block){
        if(block.getmyX()>=0 && block.getmyX()<=9 && block.getmyY()>=0 && block.getmyY()<=9){ return true;}
        else {return false;}
    }
    private void floodfill(Block block, Color target_color, Color replacement_color) {
        if (isValid(block)) {
            if (target_color.equals(replacement_color) || !block.getBackground().equals(target_color)) return;
            else {
                block.setBackground(replacement_color);
                if (block.getmyX() +1 < Easy.grid.length) {
                    floodfill(Easy.grid[block.getmyX() + 1][block.getmyY()], target_color, replacement_color); }
                if (block.getmyX()-1 >=0){
                floodfill(Easy.grid[block.getmyX() - 1][block.getmyY()], target_color, replacement_color);}
                if (block.getmyY() + 1< Easy.grid.length){
                floodfill(Easy.grid[block.getmyX()][block.getmyY() + 1], target_color, replacement_color);}
                if (block.getmyY() - 1 >= 0) {
                floodfill(Easy.grid[block.getmyX()][block.getmyY() - 1], target_color, replacement_color);}
            }
        }
    }
    private void CheckIfGameWin() {
        int counter = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (CheckColor(Easy.grid[i][j])) counter++;
            }
        }
        if (counter == 100) {
            JFrame gg = new JFrame("You won!");
            gg.setSize(300,180);
            JLabel l = new JLabel("YOU WON!");
            l.setFont(new Font("Arial",Font.BOLD,50));
            gg.setLocationRelativeTo(null);
            gg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gg.add(l,BorderLayout.CENTER);
            gg.setVisible(true);
        }
        else if (counter == 0){
            JFrame gg = new JFrame("You lost!");
            gg.setSize(300,180);
            JLabel l = new JLabel("YOU LOST!");
            l.setFont(new Font("Arial",Font.BOLD,50));
            gg.setLocationRelativeTo(null);
            gg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gg.add(l,BorderLayout.CENTER);
            gg.add(l);
            gg.setVisible(true);
        }
    }

    private boolean CheckColor(Block block){
        if(block.getBackground().equals(Color.WHITE)){
            return true;
        }
        else return false;
    }


        //stack.push(block);
        //                                                                                                                   nevem kako da napravim da ne ustavi v stack predhodni gumb
        /*if (Easy.grid[block.getmyX() + 1][block.getmyY()].getBackground() == target_color) {
            stack.push(Easy.grid[block.getmyX() + 1][block.getmyY()]);
            floodfill(Easy.grid[block.getmyX() + 1][block.getmyY()], target_color, replacement_color);
        }
        if (Easy.grid[block.getmyX() - 1][block.getmyY()].getBackground() == block.getBackground()) {
            stack.push(Easy.grid[block.getmyX() - 1][block.getmyY()]);
            floodfill(Easy.grid[block.getmyX() - 1][block.getmyY()], target_color, replacement_color);
        }
        if (Easy.grid[block.getmyX()][block.getmyY() + 1].getBackground() == block.getBackground()) {
            stack.push(Easy.grid[block.getmyX()][block.getmyY() + 1]);
            floodfill(Easy.grid[block.getmyX()][block.getmyY() + 1], target_color, replacement_color);
        }
        if (Easy.grid[block.getmyX()][block.getmyY() - 1].getBackground() == block.getBackground()) {
            stack.push(Easy.grid[block.getmyX()][block.getmyY() - 1]);
            floodfill(Easy.grid[block.getmyX()][block.getmyY() - 1], target_color, replacement_color);
        }*/


}


