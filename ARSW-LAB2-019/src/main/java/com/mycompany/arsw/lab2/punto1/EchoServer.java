/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arsw.lab2.punto1;

/**
 *
 * @author 2108263
 */
import java.net.*;
 import java.io.*;
 public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
         serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
         System.err.println("Could not listen on port: 35000.");
         System.exit(1);
        }
        Socket clientSocket = null;
        try {
         clientSocket = serverSocket.accept();
        } catch (IOException e) {
         System.err.println("Accept failed.");
         System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine, rest;
//        String tipo="cos";
        while ((inputLine = in .readLine()) != null) {
            System.out.println(inputLine);
            
//           
//            if(inputLine.contains("fun:")){
//                if(inputLine.contains("sin")){
//                    tipo="sin";
//                    rest="cambio a seno";
//                }else if(inputLine.contains("tan")){
//                    tipo="tan";
//                    rest="cambio a tangente";
//                }else{
//                    tipo="cos";
//                    rest="cambio a coseno";
//                }
//            }
//            else{
//                if(tipo=="sin"){
//                rest = Double.toString(Math.sin(Integer.parseInt(inputLine)));
//                
//                }else if(tipo=="tan"){
//                    rest = Double.toString(Math.tan(Integer.parseInt(inputLine)));
//                }
//                else{
//                    rest = Double.toString(Math.cos(Integer.parseInt(inputLine)));
//                }
//            }
//            
//            
            double cuadrado = Math.pow(Double.parseDouble(inputLine), 2);
            rest = Double.toString(cuadrado);
            outputLine = "Respuesta " + rest ;
            System.out.println("Mensaje: " + inputLine);
//            Double.toString(cuadrado)
            out.println(outputLine);
            if (outputLine.equals("Respuestas: Bye.")) break;
        }
        out.close(); in .close();
        clientSocket.close();
        serverSocket.close();
    }
}
