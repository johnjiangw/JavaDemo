package com.john.javademo.net;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpAcceptHandler implements Runnable{
    private boolean isRunning=false;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private Map<String,TcpReadHandler> clientSockets=new HashMap<>();

    /**
     * 初始化
     * @param socket
     */
    public TcpAcceptHandler(ServerSocket socket){
        this.serverSocket=socket;
        executorService=Executors.newCachedThreadPool();
    }

    /**
     * 实现接口
     */
    @Override
    public void run() {
        if(serverSocket!=null) {
            isRunning = true;
            while (isRunning){
                try {
                    Socket socket= serverSocket.accept();
                    TcpReadHandler handler=new TcpReadHandler(socket);
                    executorService.execute(handler);
                    String key=String.format("%s:%d",socket.getInetAddress().getHostAddress(),socket.getPort());
                    if(clientSockets.containsKey(key)==false){
                        clientSockets.put(key,handler);
                    }
                    System.out.println(String.format("客户端%s连接到本服务端",key));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取所有客户端
     * @return
     */
    public Map<String,TcpReadHandler> getClients(){
        return clientSockets;
    }

    /**
     * 获取客户端
     * @param key
     * @return
     */
    public Socket getClient(String key){
        TcpReadHandler handler=clientSockets.get(key);
        if(handler!=null)
            return handler.getSocket();
        return null;
    }

    /**
     * 移除客户端
     * @param key
     */
    public void removeClient(String key){
        if(clientSockets.get(key)!=null){
            clientSockets.remove(key);
        }
    }
}
