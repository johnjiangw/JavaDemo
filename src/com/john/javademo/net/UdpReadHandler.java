package com.john.javademo.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReadHandler implements Runnable {
    private DatagramSocket socket;
    private Boolean isRuning=false;
    private static final int BUFFER_SIZE = 1024;

    /**
     * 初始化
     * @param socket
     */
    public UdpReadHandler(DatagramSocket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        if(socket!=null){
            isRuning=true;
            while (isRuning) {
                try {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    DatagramPacket datagramPacket = new DatagramPacket(buffer, BUFFER_SIZE);
                    socket.receive(datagramPacket);
                    String msg = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                    if (msg.length() > 0) {
                       System.out.println(String.format("接收到%s:%d的消息:%s", datagramPacket.getAddress().getHostAddress(), datagramPacket.getPort(), msg));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void stop(){
        isRuning=false;
    }
}
