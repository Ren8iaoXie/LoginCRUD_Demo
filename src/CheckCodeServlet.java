import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author xieren8iao
 * @create 2019/3/19 - 16:25
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int higth=50;
        String str="ABCDRFGHIJKLMNOPQRSTUVWXYZabcdrfghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();

        BufferedImage bufferedImage=new BufferedImage(width,higth,BufferedImage.TYPE_INT_RGB);
        Graphics g=bufferedImage.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,width,higth);
        g.setColor(Color.red);
        g.drawRect(0,0,width-1,higth-1);

        g.setColor(Color.red);
        for (int i = 1; i <=4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(ch+"",width/5*i,higth/i);

        }
        g.setColor(Color.green);

        for (int i = 1; i <6 ; i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);
            int y1=random.nextInt(higth);
            int y2=random.nextInt(higth);
            g.drawLine(x1,y1,x2,y2);

        }
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }
}
