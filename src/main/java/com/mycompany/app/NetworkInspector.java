package com.mycompany.app;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NetworkInspector {
    public static void main(String[] args){
        
        if (args.length != 1){
            System.err.println("Usage: java NetworkInspector <host-name>");
            System.exit(1);
        }
        String hostname = args[0];

        //perform DNS look up
        //Display Hostname
        System.out.println("Hostname: "+ hostname+"\n");
        try{
            InetAddress[] hostAddresses = Inet4Address.getAllByName(hostname);
            System.out.println("Resolved addresses:");

            //display resolved addresses
            for (InetAddress inetAddress : hostAddresses) {
                System.out.println(inetAddress.getHostAddress());
            }
        }catch(UnknownHostException e){
            System.out.println(e.getMessage());
        }

        //connect using HTTP
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://"+hostname))
            .GET()
            .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println("\nHTTPS Connection Successful\n");
                
                System.out.println("Status Code:\n" + response.statusCode()+"\n");

                System.out.println("TLS Version:\n" + response.sslSession().get().getProtocol()+"\n");

                System.out.println("Response size: "+ response.body().getBytes().length+" bytes \n");
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
