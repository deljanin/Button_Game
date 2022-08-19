package com.deljanin;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveOnExit extends WindowAdapter {
    private Block[][] block;
    private String difenh;
    public SaveOnExit(String game,Block[][] block){
        this.difenh = game;
        this.block = block;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //SAVES TO 2 FILES!
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to save before closing the game", "Quit game", dialogButton);
        if (dialogResult == 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < block.length; i++)//for each row
            {
                for (int j = 0; j < block.length; j++)//for each column
                {
                    builder.append(block[i][j].getBackground() + "");
                    if (j < block.length - 1)//if this is not the last row element
                        builder.append(" ");//then add comma (if you don't like commas you can use spaces)
                }
                builder.append("\n");//append new line at the end of the row
            }
            BufferedWriter writer = null;
            BufferedWriter writerDif = null;
            try {
                writer = new BufferedWriter(new FileWriter("game.txt"));
                writerDif = new BufferedWriter(new FileWriter("dif.txt"));
                writerDif.write(difenh);
                writer.write(builder.toString());//save the string representation of the block
                writerDif.close();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.exit(0);
        }


        else{
            System.exit(0);
        }
    }
}
