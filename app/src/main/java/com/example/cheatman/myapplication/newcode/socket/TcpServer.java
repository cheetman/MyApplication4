package com.example.cheatman.myapplication.newcode.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Cheatman on 2018/2/1.
 */

public class TcpServer {

    private ServerSocket server1;
    private Socket socket1;
    private BufferedReader reader;

    public void getServer(){
        try{
            server1=new ServerSocket(7993);
            System.out.println("服务器套接字已经创建成功");
            while(true){
                System.out.println("等待客户机链接");
                socket1=server1.accept();
                reader=new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                getClientMessage(socket1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }











    public static void main(String[] args){
        TcpServer tcp=new TcpServer();
        tcp.getServer();
    }





    private void getClientMessage(Socket socket){
        try{
            while(true){
                System.out.println("来自客户机的信息："+reader.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if(reader!=null){
                reader.close();
                System.out.println("readerclose");
            }
            if(socket!=null){
                socket.close();
                System.out.println("socketclose");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
