package com.mycompany.app;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Hello world!
 */
public class NetworkInspector {
    public static void main(String[] args){
        
        for(int i = args.length;i<args.length;i++){
            System.out.println(args[i]);
        }
        if (args.length != 1){
            System.err.println("Usage: java NetworkInspector <host-name>");
            System.exit(1);
        }
        String hostname =args[0];

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
