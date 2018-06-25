package com.john.javademo.net;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer {
    private int maxConnect=20;
    private Boolean isRunning=false;
    private ServerSocket serverSocket;
    private ExecutorService executorService;//线程池
    private final int POOL_SIZE=10;//单个CPU线程池大小
    private TcpAcceptHandler tcpAcceptHandler;
    public TcpServer(int port)throws Exception{
        this.serverSocket=new ServerSocket(port);
        executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
    }
    public TcpServer(InetAddress localAddress, int port)throws Exception{
        TcpServer(localAddress,port,this.maxConnect);
    }
    public TcpServer(InetAddress localAddress, int port, int maxConnect)throws Exception{
        TcpServer(localAddress,port,maxConnect);
    }

    /**
     * 服务端初始化
     * @param localAddress
     * @param port
     * @param maxConnect
     * @throws Exception
     */
    private void TcpServer(InetAddress localAddress,int port,int maxConnect)throws Exception{
        if(maxConnect>this.maxConnect)
            maxConnect=this.maxConnect;
        this.serverSocket=new ServerSocket(port,maxConnect,localAddress);
        executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
    }

    /**
     * 启动服务端
     */
    public void start(){
        if(serverSocket!=null){
            isRunning=true;
            tcpAcceptHandler =new TcpAcceptHandler(serverSocket);
            executorService.execute(tcpAcceptHandler);
        }
    }

    /**
     * 发送消息，单个
     * @param msg 消息内容
     * @param address IP
     * @param port 端口
     * @throws Exception
     */
    public void send(String msg,InetAddress address,int port)throws Exception{
        if(isRunning==true) {
            String key = String.format("%s:%d", address.getHostAddress(), port);
            Socket socket = tcpAcceptHandler.getClient(key);
            if (socket != null) {
                if(socket.isConnected()==true) {
                    OutputStream outputStream = socket.getOutputStream();
                    //方式1
                    /*DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
                    dataOutputStream.writeBytes(msg);
                    dataOutputStream.flush();*/
                    //方式2
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                    bufferedWriter.write(msg);
                    bufferedWriter.flush();
                    System.out.println(String.format("向%s:%d发送消息:%s", address, port, msg));
                }
                else {
                    tcpAcceptHandler.removeClient(key);
                }
            }
        }
    }

    /**
     * 群发消息
     * @param msg
     * @throws Exception
     */
    public void send(String msg)throws Exception{
        if(isRunning==true) {
            for (Map.Entry<String, TcpReadHandler> item : tcpAcceptHandler.getClients().entrySet()) {
                String[] array = item.getKey().split(":");
                InetAddress address = InetAddress.getByName(array[0]);
                this.send(msg, address, Integer.parseInt(array[1]));
            }
        }
    }

    /**
     * 停止服务端
     */
    public void stop() {
        isRunning=false;
        for (TcpReadHandler handler: tcpAcceptHandler.getClients().values()){
            handler.stop();
        }
    }
}
