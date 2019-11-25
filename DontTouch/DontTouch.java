/**
 * DontTouch.java
 *
 * Generates circles of random x and y coordinates and maximizes the
 * radius. Then checks if the radius is large enough and officializes it
 * accordingly.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 10/25/2019
 */

import java.awt.Color;
import java.awt.Font;

public class DontTouch
{
	/**  The array for the Circles to be drawn.                         */
	private Circle[] circ;
	private double area;
	final double EPS = 1e-9;

	/**  Constructs the size (1000) for the array of Circles.           */
	public DontTouch ()
	{
		circ = new Circle[1000];
	}

	public static void main(String [] args)
	{
		DontTouch run = new DontTouch();
		run.setUpCanvas();
		run.drawCircles();
		run.drawAxes();
		run.printArea();
	}

	/**
	 *  Sets up the canvas, using methods from StdDraw.  This includes
	 *  setting up the canvas size, the horizontal scale (Xscale), and
	 *  the vertical scale (Yscale).
	 */
	public void setUpCanvas ( )
	{
		final int WIDTH = 1200;
		final int HEIGHT = 800;
		StdDraw.setCanvasSize(WIDTH, HEIGHT);
		StdDraw.setXscale(-6, 6);
		StdDraw.setYscale(-4, 4);
		StdDraw.clear(new Color(255,255,255));

		StdDraw.enableDoubleBuffering();
	}

	/**
	 *  Creates the Circles in the array of Circles.  Draws the Circles.
	 */
	public void drawCircles ( )
	{
		int itr=0, count1=0, count2=0; double radBound=1.0;
			while(count1 <= 999){
				double x = Math.random()*6*(Math.random()>=0.5 ? 1 : -1);
				double y = Math.random()*4*(Math.random()>=0.5 ? 1 : -1);
				double radius=1.0;

				for(int i=0 ; i<count1 ; i++){
					radius = Math.min(radius, Math.pow(Math.pow(circ[i].getX()-x, 2)+Math.pow(circ[i].getY()-y, 2), 0.5) - circ[i].getRadius());
				}

				if(!(x + radius + EPS > 6 || x - radius - EPS < -6 || y + radius + EPS > 4 || y - radius - EPS < -4)){
					if(radius <= 1 && radius >= radBound){
						radius-=EPS;
						circ[count1] = new Circle(x, y, radius);
						area+=circ[count1].getArea();
						count1++;
					}
					else{
						count2++;
					}
				}
				if(count2>=(int)(500*radBound) + 1500){
					if(radBound-0.001>0){
						radBound-=0.001;
					}
					count2=0;
				}
			}

			for(int i=0 ; i<1000 ; i++){
				StdDraw.setPenColor(new Color(255, (int)(Math.random()*100)+100, (int)(Math.random()*100)+100));
				StdDraw.filledCircle(circ[i].getX(), circ[i].getY(), circ[i].getRadius());
			}
			StdDraw.show();
	}



	/**
	 *  Draws a pair of axes, over the drawn Circles.  Grid lines are drawn and
	 *  the scale is shown, to help the viewer see the size of the Circles.
	 */
	public void drawAxes ( )
	{
		Font font = new Font("Arial", Font.PLAIN, 18);
		StdDraw.setFont(font);
		StdDraw.setPenColor(new Color(220,220,220));
		for(double integers = -6; integers <= 6; integers++)
		{
			StdDraw.line(integers,-4,integers,4);
			StdDraw.line(-6,integers,6,integers);
			StdDraw.setPenColor(new Color(0,0,0));
			StdDraw.text(integers,-0.4,"" + (int)integers);
			StdDraw.text(-0.3,integers-0.05,"" + (int)integers);
		}
		StdDraw.show();
	}

	/**
	 *  Adds the area of each circle to a total area.  Prints this total
	 *  area to the terminal window.
	 */
	public void printArea ( )
	{
		System.out.println("\n\n\nTotal Area: " + area + "\n\n\n");
	}
}
