package com.john.javademo.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TCP客户端类
 * @author jiangwei
 * @version 1.1
 */
public class TcpClient {
    private Socket client;
    private TcpReadHandler socketHandler;
    private ExecutorService executorService;
    public TcpClient(InetAddress serverAddress, Integer serverPort) throws Exception{
          this.client=new Socket(serverAddress,serverPort);
          executorService=Executors.newSingleThreadExecutor();//单线程（用于接收消息）
    }
    public TcpClient(InetAddress serverAddress, Integer serverPort,Integer localPort)throws Exception{
        InetAddress localAddress=InetAddress.getLocalHost();
        TcpClient(serverAddress,serverPort,localAddress,localPort);
    }
    public TcpClient(InetAddress serverAddress, Integer serverPort,InetAddress localAddress,Integer localPort)throws Exception{
        TcpClient(serverAddress,serverPort,localAddress,localPort);
    }

    /**
     * 初始化客户端
     * @param serverAddress
     * @param serverPort
     * @param localAddress
     * @param localPort
     * @throws Exception
     */
    private void TcpClient(InetAddress serverAddress, Integer serverPort,InetAddress localAddress,Integer localPort)throws Exception{
        this.client=new Socket(serverAddress,serverPort,localAddress,localPort);
        executorService=Executors.newCachedThreadPool();
    }

    /**
     * 启动客户端
     */
    public void start(){
        if(client!=null) {
            socketHandler=new TcpReadHandler(client);
            executorService.execute(socketHandler);
        }
    }

    /**
     * 发送消息
     * @param msg
     * @throws Exception
     */
    public void send(String msg) throws Exception {
        if(socketHandler!=null){
            Socket socket= socketHandler.getSocket();
            if(socket!=null){
                OutputStream outputStream=socket.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(msg);
                bufferedWriter.flush();
                System.out.println(String.format("向%s:%d发送消息:%s",socket.getInetAddress().getHostAddress(),socket.getPort(),msg));
            }
        }
    }

    /**
     * 停止客户端
     * @throws Exception
     */
    public void stop() throws Exception{
       if(socketHandler!=null){
           socketHandler.stop();
       }
    }
}
