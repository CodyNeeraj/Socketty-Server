/*
 * The MIT License
 *
 * Copyright 2021 Neeraj.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package functions;

import java.awt.Desktop;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Neeraj
 */
public class Utilities
{

    public void usage_policy() //aka developer Profile
    {
        Object choice[] =
        {
            "Continue", "Cancel"
        };
        int selectedValue = JOptionPane.showOptionDialog(
                null,
                "This will take you to the Developer's site !",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                choice,
                choice[0]
        );
        if(selectedValue == JOptionPane.YES_OPTION)
        {
            String url = "";
            if(Desktop.isDesktopSupported())
            {
                Desktop desktop = Desktop.getDesktop();
                try
                {
                    desktop.browse(new URI(url));
                }
                catch(Exception e)
                {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    /**
     * Takes the user to the Specified Url as mentioned in String of url
     *
     * <br><br><b>Note:</b><br>
     *
     * Since we are overidding the showOptiondialog, The YES/NO
     * option are overrided to specified String of objects as coded
     * by programmer For example YES_OPTION = object string[0] and
     * NO_OPTION = object string[1] as specified so to check the
     * input options we need to use default variables until now as i
     * know --->
     */
    public void feedback()
    {
        Object choice[] =
        {
            "Continue", "Cancel"
        };
        int selectedValue = JOptionPane.showOptionDialog(
                null,
                "Your feedback will help me to make this software better !\nA browser windows will open to submit the feedback ",
                "Feedback",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                choice,
                choice[0]
        );
        if(selectedValue == JOptionPane.YES_OPTION)
        {
            String url = "https://www.google.com";
            if(Desktop.isDesktopSupported())
            {
                Desktop desktop = Desktop.getDesktop();
                try
                {
                    desktop.browse(new URI(url));
                }
                catch(Exception e)
                {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, e);
                }
            }

        }
        if(selectedValue == JOptionPane.NO_OPTION)
        {
        }
    }

    public void devs_site()
    {
        Object choice[] =
        {
            "Continue", "Cancel"
        };
        int selectedValue = JOptionPane.showOptionDialog(
                null,
                "This will take you to the Developer's Profile !",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                choice,
                choice[0]
        );
        if(selectedValue == JOptionPane.YES_OPTION)
        {
            String url = "https://github.com/CodyNeeraj";
            if(Desktop.isDesktopSupported())
            {
                Desktop desktop = Desktop.getDesktop();
                try
                {
                    desktop.browse(new URI(url));
                }
                catch(Exception e)
                {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

}
