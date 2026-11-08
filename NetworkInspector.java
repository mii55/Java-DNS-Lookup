import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkInspector {
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

        
    }
}
