import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

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

        //connect using HTTPS
        try {
            URL url = new URI("https://"+hostname).toURL();
            try{
                HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
                System.out.println("\nHTTPS Connection Successful\n");

                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                System.out.println("Status Code:\n" + responseCode);


                /*try{
                    SSLContext ssl = SSLContext.getInstance("GET", "https://"+hostname);}
                catch(NoSuchProviderException e){
                    System.err.println(e.getMessage());
                }catch(NoSuchAlgorithmException e){
                    System.err.println(e.getMessage());
                }*/
                System.out.println("TLS Version:" + connection.getSSLSession().toString());
            }catch(IOException e){
                System.err.println(e.getMessage());
            }

        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
        

        //display HTTP status code
        //Display TLS version
        //Print Total response size in bytes:

    }
}
