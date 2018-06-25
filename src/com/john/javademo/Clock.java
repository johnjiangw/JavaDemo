package com.john.javademo;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    private int delay;
    private boolean runFlag;
    public Clock(int delay,boolean flag){
        this.delay=delay;
        this.runFlag=flag;
    }

    public void start(){
        /*class Printer implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(String.format("%tT",new Date()));
                if(runFlag){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        new javax.swing.Timer(delay,new Printer()).start();*/
       class PrintTask extends TimerTask{
           @Override
           public void run() {
               System.out.println(String.format("%tT",new Date()));
           }
       }
       new Timer().schedule(new PrintTask(),2000,delay);
    }
}
