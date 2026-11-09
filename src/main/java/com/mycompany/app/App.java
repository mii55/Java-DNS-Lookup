package com.mycompany.app;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args){
        
        if (args.length != 1){
            System.err.println("Usage: java NetworkInspector <host-name>");
            System.exit(1);
        }
        String hostname =args[1];

        //perform DNS look up
        // display hostname & ALL resolved addresses
        //InetAddress.getAllByName(
        try{
            InetAddress[] hostAddresses = InetAddress.getAllByName(hostname);
            for (InetAddress inetAddress : hostAddresses) {
                System.err.println(inetAddress);
            }
        }catch(UnknownHostException e){
            System.out.println(e.getMessage());
        }

        //connect using HTTPS

        //display HTTP status code
        //Display TLS version
        //Print Total response size in bytes:

    }
}
