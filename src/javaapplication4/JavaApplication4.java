
package javaapplication4;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author moazr
 */
public class JavaApplication4 extends JFrame {
    int r1,r2;
    int xc=0,yc=0;
    
Graphics g;
 public static  int x11,x21,x31,y11,y21,y31,pox,poy;
   public JavaApplication4(){
    setTitle("java Graphics");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       setSize(600,600);
      setLocation(200, 150);

       setVisible(true);
    }
   
   
    public void paint ( Graphics g1){
      int y;
    y = 0;
      g=g1;
 curv2(x11,y11,x21,y21,x31,y31);         

    g.setColor(Color.red);
  
      squr(pox, poy);
           

curv(x11,y11,x21,y21,x31,y31);         
 
  
  }
  
    
    
           public void rect (int x,int y){

 for (int i = 1; i < y; i++)
                        {
 for (int j = 1; j < y; j++){
                           setpixl(j, i);
                          setpixl(j, y);
                          setpixl(j, i);
                          setpixl(i, j);
}

                        }
    }

    
    
   
    
    
     
   
   
      
   void curv(int x0, int y0, int x1, int y1, int x2, int y2)
{        
  
    
  int sx = x2-x1, sy = y2-y1;
  long xx = x0-x1, yy = y0-y1, xy;         /* relative values for checks */
  double dx, dy, err, cur = xx*sy-yy*sx;                    /* curvature */

  assert(xx*sx <= 0 && yy*sy <= 0);  /* sign of gradient must not change */

  if (sx*(long)sx+sy*(long)sy > xx*xx+yy*yy) { /* begin with longer part */ 
    x2 = x0; x0 = sx+x1; y2 = y0; y0 = sy+y1; cur = -cur;  /* swap P0 P2 */
  }  
  if (cur != 0) {                                    /* no straight line */
    xx += sx; xx *= sx = x0 < x2 ? 1 : -1;           /* x step direction */
    yy += sy; yy *= sy = y0 < y2 ? 1 : -1;           /* y step direction */
    xy = 2*xx*yy; xx *= xx; yy *= yy;          /* differences 2nd degree */
    if (cur*sx*sy < 0) {                           /* negated curvature? */
      xx = -xx; yy = -yy; xy = -xy; cur = -cur;
    }
    dx = 4.0*sy*cur*(x1-x0)+xx-xy;             /* differences 1st degree */
    dy = 4.0*sx*cur*(y0-y1)+yy-xy;
    xx += xx; yy += yy; err = dx+dy+xy;                /* error 1st step */    
    do {
        
        
           //   g.fillRect(100, 200, 10, 20);

        if((x0==pox&&y0==poy)||(x0==x31&&y0==poy+1)||
                (x0==pox&&y0==poy+2)||
                (x0==pox&&y0==poy+3)||
                (x0==pox&&y0==poy+4)||
                (x0==pox&&y0==poy+5)
                ||
                (x0==pox&&y0==poy-1)
                ||
                (x0==pox&&y0==poy-2)
                ||
                (x0==pox&&y0==poy-3)
                ||
                (x0==pox&&y0==poy-4)
                ||
                (x0==pox&&y0==poy-5)  
                
              
                ){
            
           // g.drawString("---1", 300, 50);
                 JOptionPane.showMessageDialog(null, "1", "1" , JOptionPane.INFORMATION_MESSAGE);
  
        break;
        }
        if((x0==x31&&y0==y31)||(x0==x31&&y0==y31+1)){
                   // g.drawString("0", 300, 50);

                JOptionPane.showMessageDialog(null, "0", "0" , JOptionPane.INFORMATION_MESSAGE);

        }
          //  g.setColor(Color.BLACK);
   g.setColor(Color.BLACK);

       // opject(x0,y0);
        //opject(x0, y0);
              squr(x0, y0);

//g.fill3DRect(x0, y0, 30, 40,false);
        setpixl(x0+10,y0+10);
  
        
        
         try {
                  Thread.sleep(100);
              } catch (InterruptedException ex) {
              }    
              
   g.setColor(Color.WHITE);
   
     squr(x0, y0);

      
xc=x0;
yc=y0;
                                   
      if (x0 == x2 && y0 == y2) return;  /* last pixel -> curve finished */
                        /* save value for test of y step */
      if (2*err > dy) { x0 += sx; dx -= xy; err += dy += yy; } /* x step */
      if (    err*2 < dx  ) { y0 += sy; dy -= xy; err += dx += xx; } /* y step */
    } while (dy < dx );           /* gradient negates -> algorithm fails */
  }
  //g.drawLine(x0,y0, x2,y2);                  /* plot remaining part to end */
}   
   
       
       
    void curv2(int x0, int y0, int x1, int y1, int x2, int y2)
{        
  
    
  int sx = x2-x1, sy = y2-y1;
  long xx = x0-x1, yy = y0-y1, xy;         /* relative values for checks */
  double dx, dy, err, cur = xx*sy-yy*sx;                    /* curvature */

  assert(xx*sx <= 0 && yy*sy <= 0);  /* sign of gradient must not change */

  if (sx*(long)sx+sy*(long)sy > xx*xx+yy*yy) { /* begin with longer part */ 
    x2 = x0; x0 = sx+x1; y2 = y0; y0 = sy+y1; cur = -cur;  /* swap P0 P2 */
  }  
  if (cur != 0) {                                    /* no straight line */
    xx += sx; xx *= sx = x0 < x2 ? 1 : -1;           /* x step direction */
    yy += sy; yy *= sy = y0 < y2 ? 1 : -1;           /* y step direction */
    xy = 2*xx*yy; xx *= xx; yy *= yy;          /* differences 2nd degree */
    if (cur*sx*sy < 0) {                           /* negated curvature? */
      xx = -xx; yy = -yy; xy = -xy; cur = -cur;
    }
    dx = 4.0*sy*cur*(x1-x0)+xx-xy;             /* differences 1st degree */
    dy = 4.0*sx*cur*(y0-y1)+yy-xy;
    xx += xx; yy += yy; err = dx+dy+xy;                /* error 1st step */    
    do {
        
        
  
        
           
              
   g.setColor(Color.BLACK);
           setpixl(x0,y0);


                             
      if (x0 == x2 && y0 == y2) return;  /* last pixel -> curve finished */
                        /* save value for test of y step */
      if (2*err > dy) { x0 += sx; dx -= xy; err += dy += yy; } /* x step */
      if (    err*2 < dx  ) { y0 += sy; dy -= xy; err += dx += xx; } /* y step */
    } while (dy < dx );           /* gradient negates -> algorithm fails */
  }
  //g.drawLine(x0,y0, x2,y2);                  /* plot remaining part to end */
}       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
   
       
    
    
    public static void main(String[] args) {
 
 JFrame f = new JFrame("The Twilight Zone");
   f.setSize(600, 300);
   f.setLocation(100, 150);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //f.setDefaultLookAndFeelDecorated(true);
   JButton b = new JButton("star");
b.setBounds(150, 150, 100, 30);

   JLabel p1 = new JLabel("px1");
   p1.setBounds(120, 50, 200, 30);
    JLabel p1y = new JLabel("py1");
   p1y.setBounds(120, 100, 200, 30);
    JLabel p2y = new JLabel("py2");
   p2y.setBounds(280, 100, 200, 30);
    JLabel p3y = new JLabel("py3");
   p3y.setBounds(380, 100, 200, 30);
  
      JLabel popject = new JLabel("place object");
   popject.setBounds(300, 200, 200, 30);
  f.add(popject);   
  JLabel xxxo = new JLabel("x");
   xxxo.setBounds(450, 170, 200, 30);
  f.add(xxxo);   
  JLabel yyo = new JLabel("y");
   yyo.setBounds(450, 200, 200, 30);
  f.add(yyo);
  
   JTextField xop = new JTextField();
   xop.setBounds(400, 170, 50, 30);
   xop.setText("100");
   
   JTextField yop = new JTextField();
   yop.setBounds(400, 200, 50, 30);
   yop.setText("200");
   f.add(yop);
     f.add(xop);
     
    JLabel p2 = new JLabel("px2 ");
   p2.setBounds(280,50, 200, 30);
    JLabel p3 = new JLabel("px3 ");
   p3.setBounds(380, 50, 200, 30);
   
   JTextField x1 = new JTextField();
   x1.setBounds(150, 50, 50, 30);
   x1.setText("500");
   
   
   JTextField x2 = new JTextField();
   x2.setBounds(150, 100, 50, 30);
   x2.setText("300");
   
 
   JTextField y1 = new JTextField();
   y1.setBounds(300, 50, 50, 30);
   y1.setText("500");
   
   
   JTextField y2 = new JTextField();
   y2.setBounds(300, 100, 50, 30);
   y2.setText("200");
   
   
   JTextField x3 = new JTextField();
   x3.setBounds(400,50, 50, 30);
   x3.setText("50");
   
 
   JTextField y3 = new JTextField();
   y3.setBounds(400, 100, 50, 30);
   y3.setText("200");
   
   
   
   
   
   
   
   f.setLayout(null);
   f.setVisible(true);
    f.add(x1);
  f.add(x2);
    
   f.add(p3y);
   f.add(p2y);
   f.add(p1y);
   
f.add(p1);
f.add(p2);
f.add(p3);
 f.add(y1);
  f.add(y2);
   f.add(y3);
   f.add(x3);
   
f.add(b);

                


//////////////////////////حدث زر ابدا
   b.addActionListener( new ActionListener() 
              
    {
      
        
        public void actionPerformed(ActionEvent e)
            {          
 x11=Integer.parseInt(x1.getText());
 x21=Integer.parseInt(x2.getText());
 x31=Integer.parseInt(x3.getText());
 y11=Integer.parseInt(y1.getText());
 y21=Integer.parseInt(y2.getText());
 y31=Integer.parseInt(y3.getText());
 pox=Integer.parseInt(xop.getText());
 poy=Integer.parseInt(yop.getText());

//plotQuadBezierSeg(500,500,300,200,50,200);         

JavaApplication4 i=new JavaApplication4();
  //if(motto1.getText()==null){motto1.setText("1");}

 
                         f.setVisible(false);

            
                

            }
        
        
    });
   
   
            }

    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void squr (int x,int y){

               g.fillRect(x, y, 20, 20);

    }

    
    public void setpixl (int x,int y){

g.drawLine(x,y, x, y);

    }  
    
}

  

    

    
    
    
    
    
    
    
    
      
    
    
    

