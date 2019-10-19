/**
 * California.java
 *
 * Using OpenFile, this class draws an outline of California from data
 * input from californiaborder.txt with StdDraw helping us draw the state.
 * Then takes in input from california.txt to plot out cities, and plots
 * the cities from california.txt as dots.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 9/9/2019
 */

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

public class California
{
    /** Creates a California object.
     */
    public California ( )
    { }

    /**
     *  The main method.
     */
    public static void main(String[] args)
    {
        California run = new California();
        run.setUpCanvas();
        run.drawBorder();
        run.drawCaliforniaCities();
    }

    /**
     *  Sets up the canvas, using methods from StdDraw.  This includes
     *  setting up the canvas size, the horizontal scale (Xscale), and
     *  the vertical scale (Yscale).  We will enable double buffering,
     *  in anticipation of running an animation.
     */
    public void setUpCanvas ( )               //  This method is complete.
    {
        StdDraw.setCanvasSize(620, 700);
        StdDraw.setXscale(-125.0, -114.0);    //  Related to the longitude
        StdDraw.setYscale(32.0, 42.5);        //  Related to the latitude

        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
    }

    /**
     *  Using OpenFile, this method opens the text file californiaborder.txt.
     *  Each line in the text file is an ordered pair (doubles) that represents
     *  a point on the California border.  These points are read in, using a loop,
     *  and the points are connected to form the border of California.  Don't
     *  forget to close the text file!
     */
    public void drawBorder ( )
    {
        StdDraw.setPenRadius(0.0025);
        Scanner infile = OpenFile.openToRead("californiaborder.txt");
        String temp = null;

        temp = infile.nextLine();
        int split = temp.indexOf(",");
        double long1 = Double.parseDouble(temp.substring(0, split));
        double lat1 = Double.parseDouble(temp.substring(split+2));

        while(infile.hasNext())
        {
            temp = infile.nextLine();
            split = temp.indexOf(",");
            double long2 = Double.parseDouble(temp.substring(0,split));
            double lat2 = Double.parseDouble(temp.substring(split+2, temp.length()));

            StdDraw.line(long1,lat1,long2,lat2);
            StdDraw.show();
            long1 = long2;
            lat1 = lat2;
            StdDraw.pause(50);

        }
        infile.close(); //important
    }

    /**
     *  Using OpenFile, this method opens the text file california.txt.  Each line
     *  in the text file provides information about a California city.  After the
     *  sixth comma the latitude for the city is provided (a double), and after the
     *  seventh comma the longitude for the city is provided (a double).  These
     *  values should be parsed as doubles, and the city should be represented as a
     *  dot on the map.  Don't forget to close the text file.
     *
     */
    public void drawCaliforniaCities ( )
    {
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(0.01);
        Scanner infile = OpenFile.openToRead("california.txt");
        String temp = null;
        int split = 0;
        int ind = 0;
        double x = 0.0;
        double y = 0.0;
        while(infile.hasNext()){
            temp = infile.nextLine();
            for(int i=0 ; i<6 ; i++){
                split = temp.indexOf(",");
                temp = temp.substring(split+1, temp.length());
            }
            split = temp.indexOf(",");
            x = Double.parseDouble(temp.substring(0, split));
            temp = temp.substring(split+1, temp.length());
            split = temp.indexOf(",");
            y = Double.parseDouble(temp.substring(0, split));
            StdDraw.point(y,x);
            StdDraw.show();
			StdDraw.pause(30);
        }
    }
}
