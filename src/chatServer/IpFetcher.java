package chatServer;

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
public class IpFetcher
{

    public String loc_Ip ()
    {
        InetAddress localhost;
        try
        {
            localhost = InetAddress.getLocalHost();
        }
        catch (UnknownHostException ex)
        {
            return "Error";
        }
        return localhost.getHostAddress();
    }

    public String pub_Ip ()
    {
        String public_ip;

        try
        {
            //External IP tools API to get Http response in the form of text
            URL url_name = new URL("https://api.ipify.org");
            BufferedReader url = new BufferedReader(new InputStreamReader(url_name.openStream()));
            public_ip = url.readLine();
        }
        catch (IOException e)
        {
            return "Offline";
        }
        return public_ip;
    }

}
