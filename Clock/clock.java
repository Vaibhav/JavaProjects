import java.awt.*;
import java.util.Date;
import java.applet.Applet;

public class clock extends Applet implements Runnable
{
    Font f = new Font("TimesRoman", Font.BOLD,24);
    Date d = new Date();
    Thread runner;

    public void start()
    {
        if(runner == null)
        {
            runner = new Thread(this);
            runner.start();
        }
    } 

    public void run()
    {
        while(true)
        {
            d= new Date();
            repaint();
            try {runner.sleep(1000);}
            catch (InterruptedException e) { }
        }
    }

    public void paint(Graphics g)
    {
        g.setFont(f);
        g.drawString(d.toString(), 10, 50);
    }
}