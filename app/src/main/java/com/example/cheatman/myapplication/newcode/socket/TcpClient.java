package com.example.cheatman.myapplication.newcode.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Cheatman on 2018/2/1.
 */

public class TcpClient {


    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 7993);
            System.out.println("客户端打开");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));//客户端输入数据
        PrintWriter pw = null;//向服务端写入数据
        BufferedReader bi = null;
        try {
            pw = new PrintWriter(socket.getOutputStream());

            bi = new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取服务端的数据
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("客户端输入"+bu.readLine());
        while (true) {
            String lineString = null;//获取服务端的数据
            try {
                lineString = bu.readLine();

                if (!lineString.equals("bye")) {
                    //System.out.println("客户端输入"+lineString);
                    //向服务端输入数据
                    pw.println(lineString);
                    pw.flush();
                    //在获取控制台的数据System.out.println("服务端回复我........"+bi.readLine());
                } else {
                    pw.println(lineString);
                    pw.flush();
                    bu.close();
                    pw.close();
                    bi.close();
                    System.out.println("客户端断开");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}