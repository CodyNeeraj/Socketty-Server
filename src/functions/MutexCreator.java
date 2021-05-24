package functions;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neeraj
 */
public class MutexCreator
{
    private ServerSocket Mutex = null;

    public void MutexGenerator()
    {
        if(Mutex == null)
        {
            try
            {
                Mutex = new ServerSocket(54321);
            }
            catch(IOException ex)
            {
                System.out.println("Error:Mutex Detected !\nProgram with same instance is already Running");
                System.exit(0);
            }
        }
    }

    public void MutexDestroyer()
    {
        if(Mutex != null)
        {
            try
            {
                Mutex.close();
            }
            catch(IOException ex)
            {
                Logger.getLogger(MutexCreator.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error turning of Mutex");
            }
        }
    }

}
