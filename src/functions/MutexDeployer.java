package functions;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Neeraj
 */
public class MutexDeployer
{

    private static ServerSocket Mutex = null;

    public MutexDeployer()
    {
        try
        {
            UIManager.setLookAndFeel(new FlatLightLaf());
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(MutexDeployer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void MutexGenerator()
    {
        if(Mutex == null)
        {
            try
            {
                Mutex = new ServerSocket(30);
            }
            catch(Exception ex)
            {
                System.out.println("Error: Mutex Detected !\nProgram with same instance is already Running");
                JOptionPane.showMessageDialog(null, "Program is already Running !!!", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public void MutexDestroyer()
    {
        try
        {
            if(Mutex != null)
            {
                Mutex.close();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error Turning off Mutex");
            Logger.getLogger(MutexDeployer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
