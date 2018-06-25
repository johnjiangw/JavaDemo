package com.john.javademo.net;

import java.io.*;
import java.net.Socket;

/**
 * Socket接收消息，适用于客户端和服务端
 */
public class TcpReadHandler implements Runnable {
    private Socket socket;
    private Boolean isRuning=false;
    public TcpReadHandler(Socket socket){
        this.socket=socket;
    }
    public Socket getSocket(){
        return socket;
    }
    @Override
    public void run() {
        if(socket!=null) {
            isRuning=true;
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String info = null;
                while(isRuning==true&&(info=br.readLine())!=null){
                    System.out.println(String.format("接收到%s:%d的消息:%s", socket.getInetAddress().getHostAddress(),socket.getPort(), info));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 停止接收消息
     */
    public void stop()
    {
        isRuning=false;
    }
}
