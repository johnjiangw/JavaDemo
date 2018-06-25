package com.john.javademo.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UdpClient {
    private DatagramSocket socket;
    private UdpReadHandler udpReadHandler;
    private ExecutorService executorService;

    public UdpClient(InetAddress localAddress,int localPort)throws Exception{
        socket=new DatagramSocket(localPort,localAddress);
        executorService=Executors.newSingleThreadExecutor();//单线程（用于接收消息）
    }
    public void start(){
        if(socket!=null){
            udpReadHandler=new UdpReadHandler(socket);
            executorService.execute(udpReadHandler);
        }
    }

    public void send(String msg,InetAddress targetAddress,int targetPort)throws Exception{
            if(socket!=null){
                byte[] buffer = msg.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length,targetAddress, targetPort);
                // 发送数据
                socket.send(datagramPacket);
                System.out.println(String.format("向%s:%d发送消息:%s",targetAddress.getHostAddress(),targetPort,msg));
            }
    }
    public void stop(){
        if(udpReadHandler!=null){
            udpReadHandler.stop();
        }
    }
}
