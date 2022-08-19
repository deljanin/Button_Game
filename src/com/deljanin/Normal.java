package com.deljanin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Normal{
    private int M = 25,N = 25;
    private int k = 4;
    int setK[] = new int[k];
    private JFrame frame;
    private String title;
    private int width, height;
    BlockActionNormal blockActionNormal = new BlockActionNormal();
    public static Block grid[][];
    public static Color[][] MatrixColor;

    public Normal(String title) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(1000,1000);
        //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(N,M));
        MatrixColor = new Color[M][N];
        grid = new Block[M][N];
        BlockAction.N=this.N;
        BlockAction.M=this.M;
        Colors s = new Colors();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {//Here we make buttons in the grid 10x10, to each button we add it's coordinates and color
                grid[i][j] = new Block(i,j);
                grid[i][j].setBackground(s.normal());
                MatrixColor[i][j] = grid[i][j].getBackground();
                grid[i][j].addActionListener(blockActionNormal);
                frame.add(grid[i][j]);
            }
        }
        frame.addWindowListener(new SaveOnExit("Normal", grid));
        frame.repaint();
        frame.validate();

        frame.setVisible(true);
    }

}
