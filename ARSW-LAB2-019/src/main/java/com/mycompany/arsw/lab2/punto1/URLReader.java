/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arsw.lab2.punto1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author 2108263
 */
public class URLReader {
    
    public static void main(String[] args) throws Exception {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        FileWriter  resultado = new FileWriter("C:\\Users\\w guzman\\Desktop\\ARSW-LAB2-019\\ARSW-LAB2-019/resultado.html");
        
        try 
        {
            URL google = new URL(a);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println(inputLine);
                    PrintWriter pw = new PrintWriter(resultado);
                    pw.println(inputLine);
            }
                 resultado.close();
    
            } catch (IOException x) {
             System.err.println(x);
    
           }
            System.out.println("Protocolo " + google.getProtocol());
            System.out.println("Autoridad " + google.getAuthority());
            System.out.println("Host " + google.getHost());
            System.out.println("Port " + google.getPort());
            System.out.println("Path " + google.getPath());
            System.out.println("Query " + google.getQuery());
            System.out.println("File " + google.getFile());
            System.out.println("Ref " + google.getRef());




        }catch (MalformedURLException e)
        {
         e.printStackTrace();
        }
    }
}
