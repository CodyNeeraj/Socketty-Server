package function;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Method
{

    public static int num = 0;
    private static int clientID = 0;
    private static int fileID;
    private static ArrayList<Client> clients;
    private static JTextArea CurrStatus;
    private static JComboBox<String> activeUsers;
    private static List<String> usernames = new ArrayList<String>();

    public static int getFileID ()
    {
        return fileID;
    }

    public static void activeUsersSetter ()
    {
    }

    public static void setFileID (int aFileID)
    {
        fileID = aFileID;
    }

    public static JTextArea getTxt ()
    {
        return CurrStatus;
    }

    public static void setTxt (JTextArea aTxt)
    {
        CurrStatus = aTxt;
    }

    public static int getClientID ()
    {
        return clientID;
    }

    public static void setClientID (int aClientID)
    {
        clientID = aClientID;
    }

    public static ArrayList<Client> getClients ()
    {
        return clients;
    }

    public static void setClients (ArrayList<Client> aClients)
    {
        clients = aClients;
        clientID = 1;
        fileID = 1;
    }

    public static int addClient (Client client)
    {
        clients.add(client);
        num = clientID++;
        return num;
    }

    public static void reduceClient ()
    {
        num = num - 1;
        System.out.println("Users left are: " + num);
    }
}
