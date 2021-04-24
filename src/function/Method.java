package function;

import java.util.ArrayList;
import javax.swing.JTextArea;

public class Method
{

    private static int clientID = 0;
    private static int fileID;
    private static ArrayList<Client> clients;
    private static JTextArea CurrStatus;
    private static final ArrayList<String> usernames = new ArrayList<>();

    public static int getFileID()
    {
        return fileID;
    }

    public static int getUserNum()
    {
        return usernames.size();
    }

    public static ArrayList<String> getUserList()
    {
        return usernames;
    }

    @SuppressWarnings("unchecked")
    public static void modifyUserList(String ls)
    {
        usernames.add(ls);
        System.out.println("Connected users are: " + usernames);
//        ServerMain.activeUsers.revalidate();
//        ServerMain.activeUsers.repaint();
    }

    public static void userRemover(String uname)
    {
        System.out.println("THe request came to reove user named: " + uname);
        usernames.remove(uname);
        System.out.println("Array after removing the above said user is " + usernames);
    }

    public static void setFileID(int aFileID)
    {
        fileID = aFileID;
    }

    public static JTextArea getTxt()
    {
        return CurrStatus;
    }

    public static void setTxt(JTextArea aTxt)
    {
        CurrStatus = aTxt;
    }

    public static int getClientID()
    {
        return clientID;
    }

    public static void setClientID(int aClientID)
    {
        clientID = aClientID;
    }

    public static ArrayList<Client> getClients()
    {
        return clients;
    }

    public static void setClients(ArrayList<Client> aClients)
    {
        clients = aClients;
        clientID = 1;
        fileID = 1;
    }

    public static int addClient(Client client)
    {
        clients.add(client);
        return clientID++;
    }
}
