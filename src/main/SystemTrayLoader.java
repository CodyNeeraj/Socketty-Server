package main;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Neeraj
 */
public class SystemTrayLoader
{
    JFrame frame;

    public SystemTrayLoader(JFrame obj)
    {
        this.frame = obj;
        try
        {
            UIManager.setLookAndFeel(new FlatLightLaf());
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(SystemTrayLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(SystemTray.isSupported())
        {
            DisplayTraypanel();
        }
        else
        {
            System.out.println("System Tray isn't Supported");
        }
    }

    private void DisplayTraypanel()
    {
//        final PopupMenu popup = new PopupMenu();
//        final TrayIcon trayIcon = new TrayIcon(createImage("images/bulb.gif", "tray icon"));
//        final SystemTray systemtray = SystemTray.getSystemTray();
//        CheckboxMenuItem cb1 = new CheckboxMenuItem("Set auto size");
//        CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
//        Menu displayMenu = new Menu("Display");
//        MenuItem errorItem = new MenuItem("Error");
//        MenuItem warningItem = new MenuItem("Warning");
//        MenuItem infoItem = new MenuItem("Info");
//        MenuItem noneItem = new MenuItem("None");
//        MenuItem exitItem = new MenuItem("Exit");
//        MenuItem aboutItem = new MenuItem("About");
//
//        //Add components to popup menu
//        popup.add(aboutItem);
//        popup.addSeparator();
//        popup.add(cb1);
//        popup.add(cb2);
//        popup.addSeparator();
//        popup.add(displayMenu);
//        displayMenu.add(errorItem);
//        displayMenu.add(warningItem);
//        displayMenu.add(infoItem);
//        displayMenu.add(noneItem);
//        popup.add(exitItem);
//
//        trayIcon.setPopupMenu(popup);

        SystemTray systemTray = SystemTray.getSystemTray();
        PopupMenu trayPopupMenu = new PopupMenu();
        MenuItem Show = new MenuItem("Display frame");
        MenuItem Exit = new MenuItem("Exit");
        Image ico = Toolkit.getDefaultToolkit().getImage("/icons/refresh.png");

        Show.addActionListener((ActionEvent e) ->
        {
            frame.setVisible(true);
            //frame.revalidate();
        });
        trayPopupMenu.add(Show);

        Exit.addActionListener((ActionEvent e) ->
        {

            System.out.println("Exiting now");
            System.exit(0);
        });
        trayPopupMenu.add(Exit);

        TrayIcon trayIcon = new TrayIcon(ico, "SystemTray Demo", trayPopupMenu);

        //adjust to default size as per system recommendation
        trayIcon.setImageAutoSize(true);
        try
        {
            systemTray.add(trayIcon);
        }
        catch(AWTException e)
        {
            System.out.println("TrayIcon could not be added.");
        }
    }
}
