/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Neeraj
 */
// For every client's connection we call this class
public class ClientHandler extends Thread
{

    private String clientName;
    private DataInputStream din;
    private PrintStream pr;
    private Socket clientSocket;
    private final ClientHandler[] threads;
    private BufferedReader br;
    private int MAXConnections;
    private DataOutputStream dos;

    public ClientHandler (Socket clientSocket, ClientHandler[] threads)
    {
        this.clientSocket = clientSocket;
        this.threads = threads;
        MAXConnections = threads.length;
    }

    @Override
    public void run ()
    {
        int maxClientsCount = this.MAXConnections;
        ClientHandler[] threads = this.threads;

        try
        {
            /*
             * Create input and output streams for this client.
             */
            din = new DataInputStream(clientSocket.getInputStream());
            pr = new PrintStream(clientSocket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(din));
            String name;
            while (true)
            {
                pr.println("Enter your name please");
                name = br.readLine().trim();
                // name = din.readUTF().trim();
                if (name.indexOf('@') == -1)
                {
                    pr.println("Thank god the nam doesn't contains @ sign");
                    break;
                }
                else
                {
                    pr.println("The name should not contain '@' character.");
                }
            }

            /* Welcome the new the client. */
            pr.println("Welcome "
                    + name
                    + " to our chat room.\nTo leave enter /quit in a new line.");

            synchronized (this)
            {
                for (int i = 0; i < maxClientsCount; i++)
                {
                    if (threads[i] != null && threads[i] == this)
                    {
                        clientName = "@" + name;
                        break;
                    }
                }
                for (int i = 0; i < maxClientsCount; i++)
                {
                    if (threads[i] != null && threads[i] != this)
                    {
                        threads[i].pr.println(
                                "*** A new user "
                                + name
                                + " entered the chat room !!! ***");
                    }
                }
            }
            /* Start the conversation. */
            while (true)
            {
                String line = din.readUTF();
                if (line.startsWith("/quit"))
                {
                    break;
                }
                /* If the message is private sent it to the given client. */
                if (line.startsWith("@"))
                {
                    String[] words = line.split("\\s", 2);
                    if (words.length > 1 && words[1] != null)
                    {
                        words[1] = words[1].trim();
                        if (!words[1].isEmpty())
                        {
                            synchronized (this)
                            {
                                for (int i = 0; i < maxClientsCount; i++)
                                {
                                    if (threads[i] != null && threads[i] != this
                                            && threads[i].clientName != null
                                            && threads[i].clientName.equals(words[0]))
                                    {
                                        threads[i].pr.println("<" + name + "> " + words[1]);
                                        /*
                     * Echo this message to let the client know the private
                     * message was sent.
                                         */
                                        this.pr.println(">" + name + "> " + words[1]);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                else
                {
                    /* The message is public, broadcast it to all other clients. */
                    synchronized (this)
                    {
                        for (int i = 0; i < maxClientsCount; i++)
                        {
                            if (threads[i] != null && threads[i].clientName != null)
                            {
                                threads[i].pr.println("<" + name + "> " + line);
                            }
                        }
                    }
                }
            }
            synchronized (this)
            {
                for (int i = 0; i < maxClientsCount; i++)
                {
                    if (threads[i] != null && threads[i] != this
                            && threads[i].clientName != null)
                    {
                        threads[i].pr.println("*** The user " + name
                                + " is leaving the chat room !!! ***");
                    }
                }
            }
            pr.println("*** Bye " + name + " ***");

            /*
            * Clean up. Set the current thread variable to null so that a new client
            * could be accepted by the server.
             */
            synchronized (this)
            {
                for (int i = 0; i < maxClientsCount; i++)
                {
                    if (threads[i] == this)
                    {
                        threads[i] = null;
                    }
                }
            }
            /*
       * Close the output stream, close the input stream, close the socket.
             */
            din.close();
            pr.close();
            br.close();
            clientSocket.close();
        }
        catch (IOException e)
        {
        }
    }
}
