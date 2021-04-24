/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import function.IpFetcher;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Neeraj
 */
public class serverChatConsole extends javax.swing.JFrame
{

    private static final long serialVersionUID = 1L;
    private static ServerSocket ss;
    private static Socket soc;
    private static final int MAXConnections = 10;
    private int port;
    // private static final ClientHandler threads[] = new ClientHandler[MAXConnections];
    private long start;
    private long end;
    private DateTimeFormatter pattern;
    private LocalDateTime now;
    private boolean isAlreadyEntered; //default value - for the first time
    private StringBuilder builder;
    private String selectedFilePath;
    private File selectedFile;
    //  static CopyOnWriteArrayList<ClientHandler> ar = new CopyOnWriteArrayList<>();
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private ServerMain st;

    /**
     * Creates new form serverChatConsole
     *
     * @param ss
     * @param port
     * @throws java.io.IOException
     */
    public serverChatConsole(ServerSocket ss, int port) throws IOException
    {
        this.ss = ss;
        this.port = port;

        initComponents();

//        try
//        {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        //will set the default installed l&F as windows Native
//        }
//        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
//        {
//        Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        while (true)
//        {
//            try
//            {
//                soc = ss.accept();
//                int i;
//                for (i = 0; i < MAXConnections; i++)
//                {
//                    if (threads[i] == null)
//                    {
//                        (threads[i] = new ClientHandler(soc, threads)).start();
//                        break;
//                    }
//                }
//                if (i == MAXConnections)
//                {
//                    PrintStream os = new PrintStream(soc.getOutputStream());
//                    os.println("Server too busy. Try later.");
//                    os.close();
//                    soc.close();
//                }
//            }
//            catch (IOException e)
//            {
//                System.out.println(e);
//            }
//            }
//
//    }
    }

    private void whileChatting()
    {
        String message = "";
        do
        {
            try
            {
                message = dis.readUTF();
                decodedMsgPane.append("\n" + message);
            }
            catch(IOException ex)
            {
                Object option[] =
                {
                    "Wait", "Exit"
                };
                System.out.println("Client[s] disconnected");
                int choice = JOptionPane.showOptionDialog(
                        rootPane,
                        "Everyone disconnected, What to do ?",
                        "Error",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        null,
                        option, option[0]
                );

                try
                {
                    if(choice == JOptionPane.YES_OPTION)
                    {
                        soc.close();
                    }
                    if(choice == JOptionPane.NO_OPTION)
                    {
                        System.exit(0);
                    }

                }
                catch(IOException ex1)
                {
                    Logger.getLogger(serverChatConsole.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        while(!message.equals("/quit"));
    }

    public void sendMessage(String text)
    {
        try
        {
            dos.writeUTF(text);
            // dos.flush();
        }
        catch(Exception ex)
        {
            System.out.println("No client conncted");
        }
    }

    /**
     * e
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgToSend = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        decodedMsgPane = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        encodedMsgPane = new javax.swing.JTextArea();
        msgSendBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rcvdFilePathField = new javax.swing.JTextField();
        slctFilePathBtn = new javax.swing.JButton();
        sendFileBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        filePathField = new javax.swing.JTextField();
        opnEncodedBtn = new javax.swing.JButton();
        opnDecodedBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        serverStatus = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        activeClientList = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        encAlgoType = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        dateAndTime = new javax.swing.JLabel();
        stopServerBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        public_Ip_Port = new javax.swing.JTextField();
        loc_Ip_Port = new javax.swing.JTextField();
        refreshBtn = new javax.swing.JButton();
        sessionRefreshBtn = new javax.swing.JButton();
        connectedSince = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener()
        {
            public void windowGainedFocus(java.awt.event.WindowEvent evt)
            {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt)
            {
            }
        });

        msgToSend.setColumns(20);
        msgToSend.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        msgToSend.setRows(5);
        msgToSend.setPreferredSize(jScrollPane1.getPreferredSize());
        jScrollPane1.setViewportView(msgToSend);

        decodedMsgPane.setColumns(20);
        decodedMsgPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        decodedMsgPane.setRows(5);
        jScrollPane2.setViewportView(decodedMsgPane);

        encodedMsgPane.setEditable(false);
        encodedMsgPane.setColumns(20);
        encodedMsgPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        encodedMsgPane.setRows(5);
        jScrollPane3.setViewportView(encodedMsgPane);

        msgSendBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        msgSendBtn.setText("Send");
        msgSendBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                msgSendBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("File");

        rcvdFilePathField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rcvdFilePathField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rcvdFilePathFieldActionPerformed(evt);
            }
        });

        slctFilePathBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        slctFilePathBtn.setText("Select");
        slctFilePathBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                slctFilePathBtnActionPerformed(evt);
            }
        });

        sendFileBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        sendFileBtn.setText("Send");
        sendFileBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sendFileBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Recieved File");

        filePathField.setColumns(500);
        filePathField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        filePathField.setText("No File Selected");
        filePathField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                filePathFieldActionPerformed(evt);
            }
        });

        opnEncodedBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        opnEncodedBtn.setText("View Encrypted");
        opnEncodedBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                opnEncodedBtnActionPerformed(evt);
            }
        });

        opnDecodedBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        opnDecodedBtn.setText("View Decrypted");
        opnDecodedBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                opnDecodedBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Local IP :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Public IP :");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Decrypted");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel8.setText("Recieved");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Sent");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Current Status");

        serverStatus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        serverStatus.setText("Waiting for clients");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Active Clients");

        activeClientList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        activeClientList.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                activeClientListActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Server");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Choose Encryption Type");

        encAlgoType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel11.setText("Today");

        dateAndTime.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dateAndTime.setText("Getting date");

        stopServerBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        stopServerBtn.setText("STOP");
        stopServerBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                stopServerBtnActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel13.setText("UpTime");

        public_Ip_Port.setEditable(false);
        public_Ip_Port.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        public_Ip_Port.setText("Loading....");
        public_Ip_Port.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                public_Ip_PortMouseEntered(evt);
            }
        });

        loc_Ip_Port.setEditable(false);
        loc_Ip_Port.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        loc_Ip_Port.setText("Fetching Details....");

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        refreshBtn.setToolTipText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                refreshBtnActionPerformed(evt);
            }
        });

        sessionRefreshBtn.setIcon(refreshBtn.getIcon());
        sessionRefreshBtn.addAncestorListener(new javax.swing.event.AncestorListener()
        {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt)
            {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt)
            {
                sessionRefreshBtnAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt)
            {
            }
        });
        sessionRefreshBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sessionRefreshBtnActionPerformed(evt);
            }
        });

        connectedSince.setEditable(false);
        connectedSince.setText("0  Secs");
        connectedSince.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                connectedSinceActionPerformed(evt);
            }
        });

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel1))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(public_Ip_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loc_Ip_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeClientList, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serverStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dateAndTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(45, 45, 45))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(connectedSince, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sessionRefreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(72, 72, 72)
                                            .addComponent(opnEncodedBtn)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(opnDecodedBtn))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(rcvdFilePathField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(stopServerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(filePathField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sendFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(slctFilePathBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(encAlgoType, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(msgSendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(loc_Ip_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(public_Ip_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(serverStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(activeClientList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(msgSendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(encAlgoType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(filePathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(slctFilePathBtn))
                        .addGap(7, 7, 7)
                        .addComponent(sendFileBtn)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rcvdFilePathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(opnEncodedBtn)
                            .addComponent(opnDecodedBtn)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(dateAndTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sessionRefreshBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(connectedSince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stopServerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void activeClientListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_activeClientListActionPerformed
    {//GEN-HEADEREND:event_activeClientListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activeClientListActionPerformed

    private void slctFilePathBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_slctFilePathBtnActionPerformed
    {//GEN-HEADEREND:event_slctFilePathBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //dafault user path

        /**
         * (All files) field is implicitly added at the specified position by default
         */
        fileChooser.setAcceptAllFileFilterUsed(true);

        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Audios", "ogg", "amr", "wav", "aac", "ac3", "midi", "mp2", "mp3", "3ga", "3gp", "flaq", "wma"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Videos", "mkv", "mp4", "mov", "wmv", "avi"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp", "svg"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Microsoft Office", "docx", "xlsx", "pptx", "doc", "ppt", "xls"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Others", "txt", "rdp", "html", "bin", "htm", "xml"));

        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            slctFilePathBtn.setText("Reselect");
            selectedFile = fileChooser.getSelectedFile();

            //setting the path of the selected file to the text field
            filePathField.setText(selectedFile.getAbsolutePath());

            //setting the path to the selected file to the String
            selectedFilePath = selectedFile.getAbsoluteFile().toString();
        }
        if(result == JFileChooser.CANCEL_OPTION)
        {
            //setting the path of the selected file to the text field
            filePathField.setText("No File Selected");

            //setting the path to the selected file to the String
            selectedFilePath = null;
        }
    }//GEN-LAST:event_slctFilePathBtnActionPerformed

    private void opnEncodedBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_opnEncodedBtnActionPerformed
    {//GEN-HEADEREND:event_opnEncodedBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opnEncodedBtnActionPerformed

    private void opnDecodedBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_opnDecodedBtnActionPerformed
    {//GEN-HEADEREND:event_opnDecodedBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opnDecodedBtnActionPerformed

    private void stopServerBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_stopServerBtnActionPerformed
    {//GEN-HEADEREND:event_stopServerBtnActionPerformed

    }//GEN-LAST:event_stopServerBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_refreshBtnActionPerformed
    {//GEN-HEADEREND:event_refreshBtnActionPerformed
        IpFetcher obj = new IpFetcher();
        loc_Ip_Port.setText(obj.loc_Ip() + " : " + port);
        obj.start();
        String ip = obj.pub_Ip();

        if(ip.equalsIgnoreCase("Offline"))
        {
            public_Ip_Port.setText("Offline");
        }
        else
        {
            public_Ip_Port.setText(ip + " : " + port);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void public_Ip_PortMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_public_Ip_PortMouseEntered
    {//GEN-HEADEREND:event_public_Ip_PortMouseEntered
        if(isAlreadyEntered == false)
        {
            isAlreadyEntered = Boolean.TRUE;
            /**
             * @author Codyneeraj Setting below if(2) condition to be true
             * always as above from now on (first entrance of mouse) to utilize
             * the performance improvements by avoiding continuously checking of
             * public IP from external (API of finding IPv4 Address) as
             * mentioned in utilities class, this semantic block will make sure
             * that it should not get executed again and again causing
             * performance overhead and application lagging..
             */
            IpFetcher obj = new IpFetcher();
            obj.setPriority(1);
            obj.start();
            String ip = obj.pub_Ip();
            if(ip.equalsIgnoreCase("Offline"))
            {
                public_Ip_Port.setText("Offline");
            }
            else
            {
                public_Ip_Port.setText(ip + " : " + port);
            }
        }

        if(isAlreadyEntered == true)
        {
            //do nothing if mouse entered next time again from now on 
            //(solved the problem of UI hanging if hovered again and again)
        }
    }//GEN-LAST:event_public_Ip_PortMouseEntered

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowGainedFocus
    {//GEN-HEADEREND:event_formWindowGainedFocus
        loc_Ip_Port.setText(new IpFetcher().loc_Ip() + " : " + port);
        pattern = DateTimeFormatter.ofPattern("dd-MMMM-yyyy hh:mm");
        now = LocalDateTime.now();
        dateAndTime.setText(pattern.format(now));
    }//GEN-LAST:event_formWindowGainedFocus

    private void sessionRefreshBtnAncestorAdded(javax.swing.event.AncestorEvent evt)//GEN-FIRST:event_sessionRefreshBtnAncestorAdded
    {//GEN-HEADEREND:event_sessionRefreshBtnAncestorAdded
        start = System.currentTimeMillis();
    }//GEN-LAST:event_sessionRefreshBtnAncestorAdded

    private void sessionRefreshBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sessionRefreshBtnActionPerformed
    {//GEN-HEADEREND:event_sessionRefreshBtnActionPerformed
        builder = new StringBuilder();
        end = System.currentTimeMillis();
        long elapsedtime = (end - start) / 1000;
        if(elapsedtime > 59)
        {
            double time = elapsedtime / 60f;
            double temp = (Math.floor(time * 100) / 100);
            // builder.append(String.format("%.3f", time)).append(" Mins");
            builder.append(temp).append(" Mins");
            connectedSince.setText(builder.toString());
        }
        else
        {
            builder.append(elapsedtime).append(" Secs");
            connectedSince.setText(builder.toString());
        }

        pattern = DateTimeFormatter.ofPattern("dd-MMMM-yyyy hh:mm");
        now = LocalDateTime.now();
        dateAndTime.setText(pattern.format(now));

    }//GEN-LAST:event_sessionRefreshBtnActionPerformed

    private void connectedSinceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_connectedSinceActionPerformed
    {//GEN-HEADEREND:event_connectedSinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectedSinceActionPerformed

    private void msgSendBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_msgSendBtnActionPerformed
    {//GEN-HEADEREND:event_msgSendBtnActionPerformed
        sendMessage(msgToSend.getText());
        msgToSend.setText("");
    }//GEN-LAST:event_msgSendBtnActionPerformed

    private void sendFileBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sendFileBtnActionPerformed
    {//GEN-HEADEREND:event_sendFileBtnActionPerformed
        //handling  of NullPointerException
        if(selectedFilePath == null)
        {
            JOptionPane.showMessageDialog(rootPane, "No any file selected !", "File Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Object Choice[] =
            {
                "Yes", "Cancel"
            };
            int choice = JOptionPane.showOptionDialog(
                    rootPane,
                    "Do you want to send "
                    + selectedFile.getName()
                    + "\nto the client ?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Choice, Choice[0]
            );

            if(choice == JOptionPane.YES_OPTION)
            {
                System.out.println("sent : " + selectedFilePath + " Succesfully");
            }
            else if(choice == JOptionPane.NO_OPTION)
            {
                System.out.println("Cool down nothing happened");
            }

        }

    }//GEN-LAST:event_sendFileBtnActionPerformed

    private void filePathFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_filePathFieldActionPerformed
    {//GEN-HEADEREND:event_filePathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filePathFieldActionPerformed

    private void rcvdFilePathFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rcvdFilePathFieldActionPerformed
    {//GEN-HEADEREND:event_rcvdFilePathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rcvdFilePathFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {

            try
            {
                soc = ss.accept();
                int i;
                for(i = 0; i < MAXConnections; i++)
                {
//                    if (threads[i] == null)
//                    {
//                        (threads[i] = new ClientHandler(soc, threads)).start();
//                        break;
//                    }
                }
                if(i == MAXConnections)
                {
                    PrintStream os = new PrintStream(soc.getOutputStream());
                    os.println("Server too busy. Try later.");
                    os.close();
                    soc.close();
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> activeClientList;
    private javax.swing.JTextField connectedSince;
    private javax.swing.JLabel dateAndTime;
    private javax.swing.JTextArea decodedMsgPane;
    private javax.swing.JComboBox<String> encAlgoType;
    private javax.swing.JTextArea encodedMsgPane;
    private javax.swing.JTextField filePathField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField loc_Ip_Port;
    private javax.swing.JButton msgSendBtn;
    private javax.swing.JTextArea msgToSend;
    private javax.swing.JButton opnDecodedBtn;
    private javax.swing.JButton opnEncodedBtn;
    private javax.swing.JTextField public_Ip_Port;
    private javax.swing.JTextField rcvdFilePathField;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton sendFileBtn;
    private javax.swing.JLabel serverStatus;
    private javax.swing.JButton sessionRefreshBtn;
    private javax.swing.JButton slctFilePathBtn;
    private javax.swing.JButton stopServerBtn;
    // End of variables declaration//GEN-END:variables

}
