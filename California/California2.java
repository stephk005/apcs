
/**
 * California2.java
 *
 * Describe the program here.
 *
 * @author Your Name Here
 * @version 1.0
 * @since 9/12/2019
 */

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

public class California2
{
	/** Creates a California object.
	 */
	public California2 ( )
	{ }

	/**
	 *  The main method.
	 */
	public static void main(String[] args)
	{
		California2 run = new California2();
		run.setUpCanvas();
		run.drawBorder();
		run.legend();
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
	 *  Draws a legend in the upper right-hand corner of the output.
	 *  The legend is labeled "POPULATION" and shows the city size
	 *  for population ranges.  Cities of size greater than 400,000
	 *  are shown with a red border.  All other cites have a black
	 *  border.
	 */
	public void legend ( )					//  This method is complete.
	{
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(-116.5,40,1.4,2);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(-116.5,40,1.35,1.95);
		int population1 = 2000000, population2 = 500000;
		StdDraw.setPenColor(StdDraw.RED);
		for(int i = 0; i < 4; i++)
		{
			StdDraw.setPenRadius(Math.pow(Math.log(population1/(Math.pow(10,i))),3.5) * 0.000005);
			StdDraw.point(-117.2,41.15 - 0.8 * i);
			StdDraw.setPenRadius(Math.pow(Math.log(population2/(Math.pow(10,i))),3.5) * 0.000005);
			StdDraw.point(-117.2,40.75 - 0.8 * i);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.setPenRadius(Math.pow(Math.log(population1/(Math.pow(10,i))),3.4) * 0.000005);
			StdDraw.point(-117.2,41.15 - 0.8 * i);
			StdDraw.setPenRadius(Math.pow(Math.log(population2/(Math.pow(10,i))),3.4) * 0.000005);
			StdDraw.point(-117.2,40.75 - 0.8 * i);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.setPenRadius(Math.pow(Math.log(population1/(Math.pow(10,i))),3.3) * 0.000005);
			StdDraw.point(-117.2,41.15 - 0.8 * i);
			StdDraw.setPenRadius(Math.pow(Math.log(population2/(Math.pow(10,i))),3.3) * 0.000005);
			StdDraw.point(-117.2,40.75 - 0.8 * i);
			StdDraw.setPenColor(StdDraw.BLUE);
		}
		Font font = new Font("Arial", Font.BOLD, 18);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.textLeft(-117.5,41.6,"POPULATION");
		StdDraw.textLeft(-116.8,41.1,"2,000,000");
		StdDraw.textLeft(-116.8,40.7,"500,000");
		StdDraw.textLeft(-116.8,40.3,"200,000");
		StdDraw.textLeft(-116.8,39.9,"50,000");
		StdDraw.textLeft(-116.8,39.5,"20,000");
		StdDraw.textLeft(-116.8,39.1,"5,000");
		StdDraw.textLeft(-116.8,38.7,"2,000");
		StdDraw.textLeft(-116.8,38.3,"500");
	}

	/**
     * Read city name, population, and year of incorporation
     * for a city from californiacities.txt. Then open california.text
     * to find the city to get longitude and latitutde information.
     * The information is then plotted with a dot corresponding to its size.
     * If the population is over 400,000 a red dot is drawn.
	 */
	public void drawCaliforniaCities ( )
	{
        Scanner infile = OpenFile.openToRead("californiacities.txt");
        String temp = null;
        String temp2 = null;

        String city = null;
        double x = 0.0; //reverse!
        double y = 0.0;
        int population = 0;
        String year = null;
        while(infile.hasNext()){
            temp = infile.nextLine();
            city = temp.substring(0, temp.indexOf(","));
            Scanner infile2 = OpenFile.openToRead("california.txt");
            while(infile2.hasNext()){
                temp2 = infile2.nextLine();
                if(temp2.substring(0,temp2.indexOf(",")).equals(city)){
                    for(int i=0 ; i<6 ; i++){
                        temp2 = temp2.substring(temp2.indexOf(",")+1, temp2.length());
                    }
                    x = Double.parseDouble(temp2.substring(0, temp2.indexOf(",")));
                    temp2 = temp2.substring(temp2.indexOf(",")+1, temp2.length());
                    y = Double.parseDouble(temp2.substring(0, temp2.indexOf(",")));
                }
            }
            String[] sp = temp.split(",");
            int i=1;
            for(String a : sp){
                if(i==1) city = a;
                if(i==3) population = Integer.parseInt(a.substring(1,a.length()));
                if(i==7) year=a.substring(1,a.length());
                i++;
            }
            if(population>=400000){
                StdDraw.setPenRadius(Math.pow(Math.log(population),3.5) * 0.000005);
                StdDraw.point(y,x);
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.setPenRadius(Math.pow(Math.log(population),3.4) * 0.000005);
                StdDraw.point(y,x);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.setPenRadius(Math.pow(Math.log(population),3.3) * 0.000005);
                StdDraw.point(y,x);
                if(city.equals("Sacramento") || city.equals("Fresno") ){
                    Font font = new Font("Arial", Font.BOLD, 11);
		            StdDraw.setFont(font);
		            StdDraw.setPenColor(StdDraw.BLACK);
		            StdDraw.textLeft(y+0.30, x+0.15, city);
                }
                else{
                    Font font = new Font("Arial", Font.BOLD, 11);
		            StdDraw.setFont(font);
		            StdDraw.setPenColor(StdDraw.BLACK);
		            StdDraw.textLeft(y-1, x-0.5, city);
                }
            }
            else{
                StdDraw.setPenRadius(Math.pow(Math.log(population),3.5) * 0.000005);
                StdDraw.point(y,x);
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.setPenRadius(Math.pow(Math.log(population),3.4) * 0.000005);
                StdDraw.point(y,x);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.setPenRadius(Math.pow(Math.log(population),3.3) * 0.000005);
                StdDraw.point(y,x);
            }
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(-122.8,33.6,1.1,0.6);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(-122.8,33.6,1.05,0.55);
            Font font2 = new Font("Arial", Font.BOLD, 40);
            StdDraw.setFont(font2);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(-122.8,33.5,year);

            StdDraw.show();
            StdDraw.pause(30);
            infile2.close();
        }
        infile.close();
	}
}
