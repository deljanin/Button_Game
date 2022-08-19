package com.deljanin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Easy {
    private int M = 10, N = 10;
    private int k = 4;
    int setK[] = new int[k];
    private JFrame frame;
    private String title;
    private int width, height;
    BlockAction blockAction = new BlockAction();
    public static Block grid[][];

    public Easy(String title) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    public Easy(String title, boolean eto) throws IOException {
        this.title = title;
        loadGame();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(1000, 1000);
        //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Color[][] MatrixColor = new Color[N][M];
        frame.setLayout(new GridLayout(N, M));

        grid = new Block[M][N];
        BlockAction.N = this.N;
        BlockAction.M = this.M;
        Colors s = new Colors();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {//Here we make buttons in the grid 10x10, to each button we add it's coordinates and color
                grid[i][j] = new Block(i, j);
                grid[i][j].setBackground(s.easy());
                grid[i][j].addActionListener(blockAction);
                frame.add(grid[i][j]);
            }
        }
        frame.addWindowListener(new SaveOnExit("Easy", grid));
        frame.repaint();
        frame.validate();

        frame.setVisible(true);
    }

    private void loadGame() throws IOException {
        frame = new JFrame(title);
        frame.setSize(1000, 1000);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(N, M));
        grid = new Block[M][N];
        BlockAction.N = this.N;
        BlockAction.M = this.M;
        int i = 0;
        int j = 0;
        String[] cols = new String[100];
        try {
            Scanner scanner = new Scanner(new File("game.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                cols = line.split(" ");
                for (String c : cols) {
                    System.out.println(i + "" + j + c);
                    if (c.equals("java.awt.Color[r=255,g=75,b=75]")) {
                        grid[i][j] = new Block(i, j);
                        grid[i][j].setBackground(new Color(255, 75, 75));
                    } else if (c.equals("java.awt.Color[r=255,g=255,b=255]")) {
                        grid[i][j] = new Block(i, j);
                        grid[i][j].setBackground(new Color(255, 255, 255));
                    } else if (c.equals("java.awt.Color[r=100,g=100,b=255]")) {
                        grid[i][j] = new Block(i, j);
                        grid[i][j].setBackground(new Color(100, 100, 225));
                    }
                    grid[i][j].addActionListener(blockAction);
                    frame.add(grid[i][j]);
                    j++;
                }
                j=0;
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        frame.addWindowListener(new SaveOnExit("Easy", grid));
        frame.repaint();
        frame.validate();

        frame.setVisible(true);
    }
}
