package function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;
import message.Message;

public class Client extends Thread
{

    private Socket socket;
    private String userName;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private ImageIcon profile;
    private int ID;
    private String time;
    private final DateTimeFormatter forLog = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Client(Socket socket)
    {
        this.socket = socket;
        execute();
    }

    private void execute()
    {
        this.start();
    }

    @Override
    public void run()
    {
        try
        {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            ID = Method.addClient(this);
            //  loop starting get message from client
            while(true)
            {
                Message ms = (Message) in.readObject();
                String status = ms.getStatus();
                if(status.equals("New"))
                {
                    userName = ms.getName().split("!")[0];
                    time = ms.getName().split("!")[1];
                    profile = ms.getImage();
                    Method.modifyUserList(userName);
                    Method.getTxt().append("\n[" + forLog.format(LocalDateTime.now()) + "]  New User : [" + userName + "] has connected ...");
                    Method.getTxt().append("\n[" + forLog.format(LocalDateTime.now()) + "]  Total connections till now: " + Method.getUserNum());
                    //for displaying number of users connected by fetching details from Arraylist in Method class

//                    activeUsers.removeAllItems();
//                    for (String value : Method.getUserList())
//                    {
//                        activeUsers.addItem(value);
//                    }
                    Method.comboAdder(userName);

                    //  list all friend send to new client login
                    for(Client client : Method.getClients())
                    {
                        ms = new Message();
                        ms.setStatus("New");
                        ms.setID(client.getID());
                        ms.setName(client.getUserName() + "!" + client.getTime());
                        ms.setImage(client.getProfile());
                        out.writeObject(ms);
                        out.flush();
                    }
                    //  send new client to old client
                    for(Client client : Method.getClients())
                    {
                        if(client != this)
                        {
                            ms = new Message();
                            ms.setStatus("New");
                            ms.setName(userName + "!" + time);
                            ms.setID(ID);
                            ms.setImage(profile);
                            client.getOut().writeObject(ms);
                            client.getOut().flush();
                        }
                    }
                }
                else if(status.equals("File"))
                {
                    int fileID = Method.getFileID();
                    //file number, by default the file id variable in method class is kept static
                    String fileN = ms.getName();
                    String fileName = null;
                    try
                    {
                        fileName = fileID + " [" + userName + "] "
                                + DateTimeFormatter.ofPattern("HH-mm-ss a").format(LocalDateTime.now())
                                + "!" + ms.getName().split("!")[0];
                        try(FileOutputStream output = new FileOutputStream(new File("data" + File.separator + fileName)))
                        {
                            output.write(ms.getData());
                        }
                    }
                    catch(Exception ex)
                    {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Method.getTxt().append("\n[" + forLog.format(LocalDateTime.now()) + "]  " + userName + " sent " + fileName);
                    Method.setFileID(fileID + 1);
                    ms = new Message();
                    ms.setStatus("File");
                    ms.setName(fileID + "!" + fileN);
                    ms.setImage((ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(new File("data/" + fileName)));
                    ms.setID(ID);
                    for(Client client : Method.getClients())
                    {
                        client.getOut().writeObject(ms);
                        client.getOut().flush();
                    }
                }
                else if(status.equals("download"))
                {
                    sendFile(ms);
                }
                else
                {
                    for(Client client : Method.getClients())
                    {
                        client.getOut().writeObject(ms);
                        client.getOut().flush();
                    }
                }
            }

        }
        catch(IOException | ClassNotFoundException e)
        {
            try
            {
                Method.getClients().remove(this);
                Method.userRemover(this.userName);
                Method.comboRemover(userName);
                Method.getTxt().append("\n[" + forLog.format(LocalDateTime.now()) + "]  User : " + userName + " has been logged out ...");
                Method.getTxt().append("\n[" + forLog.format(LocalDateTime.now()) + "]  Total left users : " + Method.getUserNum());

//                activeUsers.removeAllItems();
//                for (String value : Method.getUserList())
//                {
//                    activeUsers.addItem(value);
//                }
                for(Client s : Method.getClients())
                {
                    Message ms = new Message();
                    ms.setStatus("Error");
                    ms.setID(ID);
                    ms.setName(userName);
                    s.getOut().writeObject(ms);
                    s.getOut().flush();
                }
            }
            catch(IOException e1)
            {
                Method.getTxt().append("\n[" + forLog.format(LocalDateTime.now()) + "]  Error : " + e1);
            }
        }
    }

    private void sendFile(Message ms)
    {
        new Thread(() ->
        {
            String fID = ms.getMessage();
            File file = new File("data");
            for(File f : file.listFiles())
            {
                if(f.getName().startsWith(fID))
                {
                    try
                    {
                        FileInputStream ins = new FileInputStream(f);
                        byte data[] = new byte[ins.available()];
                        ins.read(data);
                        ins.close();
                        ms.setData(data);
                        ms.setStatus("GetFile");
                        out.writeObject(ms);
                        out.flush();
                        break;
                    }
                    catch(Exception e)
                    {
                        //  send to client error
                    }
                }
            }
        }).start();
    }

    public Socket getSocket()
    {
        return socket;
    }

    public void setSocket(Socket socket)
    {
        this.socket = socket;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public ObjectInputStream getIn()
    {
        return in;
    }

    public void setIn(ObjectInputStream in)
    {
        this.in = in;
    }

    public ObjectOutputStream getOut()
    {
        return out;
    }

    public void setOut(ObjectOutputStream out)
    {
        this.out = out;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public ImageIcon getProfile()
    {
        return profile;
    }

    public void setProfile(ImageIcon profile)
    {
        this.profile = profile;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

}
