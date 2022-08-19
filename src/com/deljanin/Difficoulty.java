package com.deljanin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficoulty {
    private JFrame frame;
    private String title;
    private int width, height;
    public JButton Easy = new JButton("Easy");
    private JButton Normal = new JButton("Normal");
    private JButton Hard = new JButton("Hard");
    private JLabel label = new JLabel("Pick a difficoulty: ");

    public Difficoulty(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }
    private void createDisplay(){
        Easy.setFont(new Font("Arial",Font.BOLD,35));
        Normal.setFont(new Font("Arial",Font.BOLD,35));
        Hard.setFont(new Font("Arial",Font.BOLD,35));
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4,1));
        frame.add(label);
        label.setFont(new Font("Arial",Font.BOLD,35));
        frame.add(Easy);
        Easy.setBackground(Color.WHITE);
        Easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Easy("Easy");
                frame.setVisible(false);
            }
        });
        frame.add(Normal);
        Normal.setBackground(Color.GRAY);
        Normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Normal("Normal");
                frame.setVisible(false);
            }
        });
        frame.add(Hard);
        Hard.setBackground(Color.BLACK);
        Hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Hard("Hard");
                frame.setVisible(false);
            }
        });
        frame.setVisible(true);
    }
}