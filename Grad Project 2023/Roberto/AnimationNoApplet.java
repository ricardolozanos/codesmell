package noapplet.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import noapplet.NoApplet;

public class AnimationNoApplet extends NoApplet {

  protected Timer timer; 
  protected int delay = 10;
  protected int size = 40;
  protected int position = 100;
  protected boolean switcher = true;

  public void init() {
	  timer = new Timer(delay, e -> repaint());
  }

  public void start() {
	  timer.start();
  }

  public void stop() {
    timer.stop();
  }
  
  public class Balloon{
	  public void paintComponent(Graphics g) {
		  Dimension d = getSize();
		  g.setColor(Color.WHITE);
		  g.fillOval(position, position, size, size);
		  g.setColor(Color.BLACK);
	      size = size + 1;
	      if(position + size == d.width || position + size == d.height) {
	    	switcher = false;
	      }
	      else {
	    	g.fillOval(100, 100, size, size);
	      }
	  }
  }
  
  public class Balloon2 extends Balloon{
	  public void paintComponenttwo(Graphics g) {
		  g.setColor(Color.WHITE);
		  g.fillOval(position, position, size, size);
		  g.setColor(Color.BLACK);
	      size = size - 1;
	      if(size == 0 || size == 0) {
	      	switcher = true;
	      }
	      else {
	      	g.fillOval(position, position, size, size);
	      }
	  }
  }
  
  public void paintComponent(Graphics g){    // <paint the current frame>
	  Dimension d = getSize();
	  System.out.print(d.height);
	  g.setColor(Color.WHITE);
      g.fillRect(0, 0, d.width, d.height);
      
      Balloon2 a = (Balloon2) new Balloon();
      
	  if(switcher == true) {
		a.paintComponent(g);
	  }
	  else {
		a.paintComponenttwo(g);
	  }
      
  }
  // <other fields and methods>
  
  public static void main(String[] args) {
  	//new HelloWorld().run();
  	// or specify optional parameters such as the window size
      new AnimationNoApplet().run();
  }
}
