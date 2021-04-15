package main;

//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
//import sun.tools.asm.CatchData;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;

class Transaction extends Thread implements SocketConnection
{

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Socket socket;
    private SynchList outputs;
    private int n;
    private Message message;
    protected ArrayList<String> online_users;

    public Transaction (int n, SynchList outputs, ArrayList<String> online_users, Socket socket) throws Exception
    {
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());//starting new outputstream
        this.inputStream = new ObjectInputStream(socket.getInputStream()); //starting new inputstream
        this.socket = socket;
        this.outputs = outputs;//Synchlist
        this.online_users = online_users;//Old Arraylist referencing
        this.n = n; //Synchlist size
        this.outputs.add(outputStream); //after assigning the referrnce, adding outsteam objects into Synchlists
    }

    @Override
    public void run ()
    {
        this.communicate();
    }

    @Override
    public void communicate ()
    {
        try
        {
            while (true)
            {
                // deserializing the object, reading the content from the
                // clients
                message = (Message) inputStream.readObject();

                if (message.getName().equals("@join"))
                {
                    String newUser = message.getMessage();
                    online_users.add(newUser);
                    message.setOnlineUsers(online_users);
                    message.setMessage(newUser + " has joined the conversation!");
                    message.addOnlineUser(newUser);
                    message.setName("Server");
                }

                for (int j = 0; j < outputs.size(); j++)
                {
                    // serialise the object
                    outputs.get(j).writeObject(message);
                    outputs.get(j).flush();
                }
                System.out.println(message.toString());
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            this.outputs.remove(outputStream);
        }

        clientLeft(message);

    }

    public void clientLeft (Message m)
    {
        online_users.remove(m.getName());
        m.setMessage(m.getName() + " has left the conversation!");
        m.setToWho("Update");
        m.setName("Server");
        message = m;
        System.out.println(message + " has left the conversation!");

        try
        {
            for (int j = 0; j < outputs.size(); j++)
            {
                // serialise the object
                outputs.get(j).writeObject(message);
                outputs.get(j).flush();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error " + e);
            this.outputs.remove(outputStream);
        }

    }

    //override close method
    @Override
    public void closeConnections ()
    {
        try
        {
            inputStream.close();
            outputStream.close();
            socket.close();
        }
        catch (IOException i)
        {
            System.out.println(i);
        }
    }

}
