

/**
 * Utilities for opening a text file.  The text file
 * can be opened and read from, or the file can be
 * opened (created) and written to.
 * @author   Stephanie Wu
 * @version  1.0
 * @since    9/6/2019
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OpenFile
{
	/**
	 * Opens a file for reading.
	 *
	 * @param filestring   The name of the file to be opened.
	 * @return             A Scanner instance of the file to be opened.
	 */
	public static Scanner openToRead (String filestring)
	{
		Scanner fromFile = null;
		File fileName = new File(filestring);
		try{
			fromFile = new Scanner(fileName);
		}
		catch(FileNotFoundException e){
			System.err.println("Sorry, but the file " + filestring + " could not be found.");
			System.exit(1);
		}
		return fromFile;
	}

	/**
	 * Opens a file for writing.
	 *
	 * @param filestring   The name of the file to be opened (created).
	 * @return             A PrintWriter instance of the file to be opened (created).
	 */
	public static PrintWriter openToWrite (String filestring)
	{
		PrintWriter outFile = null;
		try{
			outFile = new PrintWriter(filestring);
		}
		catch(Exception e){
			System.err.println("Sorry, but the file " + filestring + " could not be created.");
			System.exit(2);
		}
		return outFile;
	}
}
