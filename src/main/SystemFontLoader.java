package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neeraj
 */
public class SystemFontLoader
{
    private static Font SegoeUIFont;
    private static Font SegoeUI_SBFont;
    private static Font SegoeUI_SymbolFont;
    private static Font MicrosoftSansSerifFont;
    private Boolean isExecuted = false;
    private static String installedFonts;

    private SystemFontLoader()
    {
        checker();
    }

    private void checker()
    {
        //will load the external fonts for using later with components
        if(isExecuted == false)
        {
            Loader();
        }
        else if(isExecuted == true)
        {
            System.out.println("Class already loaded before by some variable");
        }
    }

    private void SystemFontLoader()
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fonts[] = ge.getAvailableFontFamilyNames();
        installedFonts = Arrays.toString(fonts);
    }

    private void Loader()
    {
        SystemFontLoader();
        try
        {
//            load a custom font in your project folder
//            khmerFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Font/Khmer_SBBIC_Serif.ttf"));
//            Can also be used as an alternative to the above code
//            InputStream fileStream = getClass().getResourceAsStream("/Font/Khmer_SBBIC_Serif.ttf");
//            khmerFont = Font.createFont(Font.TRUETYPE_FONT, fileStream);
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("/Font/Khmer_SBBIC_Serif.ttf")));
            SegoeUIFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/SegoeUI.ttf"));
            SegoeUI_SBFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/SegoeUI_SB.ttf"));
            SegoeUI_SymbolFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/SegoeUI_Sym.ttf"));
            MicrosoftSansSerifFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/MicrosoftSansSerif.ttf"));
            isExecuted = true;
        }
        catch(FontFormatException | IOException e)
        {
            Logger.getLogger(SystemFontLoader.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static Font getSegoe_UIFont()
    {
        if(SegoeUIFont == null)
        {
            new SystemFontLoader().checker();
        }
        if(installedFonts.contains("Segoe UI"))
        {
            return new Font("Segoe UI", 0, 0);
        }
        if(!installedFonts.contains("Segoe UI"))
        {
            return SegoeUIFont;
        }
        return null;
    }

    public static Font getSegoe_UI_SemiBoldFont()
    {
        if(SegoeUI_SBFont == null)
        {
            new SystemFontLoader().checker();
        }
        if(installedFonts.contains("Segoe UI Semibold"))
        {
            return new Font("Segoe UI Semibold", 0, 0);
        }
        if(!installedFonts.contains("Segoe UI Semibold"))
        {
            return SegoeUI_SBFont;
        }
        return null;
    }

    public static Font getSegoeUI_SymbolFont()
    {
        if(SegoeUI_SymbolFont == null)
        {
            new SystemFontLoader().checker();
        }
        if(installedFonts.contains("Segoe UI Symbol"))
        {
            return new Font("Segoe UI Symbol", 0, 0);
        }
        if(!installedFonts.contains("Segoe UI Symbol"))
        {
            return SegoeUI_SymbolFont;
        }
        return null;
    }

    public static Font getMicrosoft_SS_Font()
    {
        if(MicrosoftSansSerifFont == null)
        {
            new SystemFontLoader().checker();
        }
        if(installedFonts.contains("SansSerif"))
        {
            return new Font("SansSerif", 0, 0);
        }
        if(!installedFonts.contains("SansSerif"))
        {
            return MicrosoftSansSerifFont;
        }
        return null;
    }

    public static void main(String[] args)
    {
        new SystemFontLoader();
    }
}
