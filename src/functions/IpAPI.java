package functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 *
 * @author Neeraj
 */
public class IpAPI extends Thread
{

    private InetAddress localhost;
    private String public_ip;

    public String loc_Ip()
    {
        try
        {
            localhost = InetAddress.getLocalHost();
        }
        catch(UnknownHostException ex)
        {
            return "Error";
        }
        return localhost.getHostAddress();
    }

    public String pub_Ip()
    {
        try
        {
            //External IP tools API to get Http response in the form of text
            // URL publicIP = new URL("https://api.my-ip.io/ip");
            URL publicIP = new URL("https://api.my-ip.io/ip");
            BufferedReader url = new BufferedReader(new InputStreamReader(publicIP.openStream()));
            public_ip = url.readLine();
        }
        catch(IOException e)
        {
            return "Offline";
        }
        return public_ip;
    }

    @Override
    public void run()
    {
        pub_Ip();
    }
}
