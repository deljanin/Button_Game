package com.deljanin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class mainMenu{
    private JFrame frame;
    private String title;
    private int width, height;
    public JButton NewGame = new JButton("New Game");
    private JButton LoadGame = new JButton("Load Game");
    private JButton ExitGame = new JButton("Exit Game");
    //private JPanel panel = new JPanel(new GridLayout());

    public mainMenu(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(3,1));
        NewGame.setSize(125,300);
        frame.add(NewGame);
        frame.add(LoadGame);
        frame.add(ExitGame);
        //NewGame.setForeground(Color.red);
            //Button functionality
        NewGame.setFont(new Font("Arial",Font.BOLD,35));
        NewGame.setBackground(Color.WHITE);
        LoadGame.setBackground(Color.WHITE);
        ExitGame.setBackground(Color.BLACK);
        ExitGame.setForeground(Color.WHITE);
        NewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Difficoulty("Difficoulty",400,500);
                frame.setVisible(false);
            }
        });
        LoadGame.setFont(new Font("Arial",Font.BOLD,35));
        LoadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                String s = "";
                try {
                Scanner scanner = new Scanner(new File("dif.txt"));
                while (scanner.hasNextLine()) {
                    s = scanner.next();
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
                if (s.equals("Easy")){
                try {
                    new Easy("Easy",true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                else if(s.equals("Normal")){
                System.out.println("aaaaaa");
            }
                else if(s.equals("Hard")){
                System.out.println("BUREK");
            }
        }
        });
        ExitGame.setFont(new Font("Arial",Font.BOLD,35));
        ExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
/*panel.add(NewGame);
        panel.add(ExitGame);
        panel.add(LoadGame);*/
