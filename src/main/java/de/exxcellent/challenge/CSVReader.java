package de.exxcellent.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Used to create a CSVReader object to read .csv files and create objects out of its content.
 * @author Marius Unger
 * @version 0.1
*/

//object of class CSVReader will be created to read .csv files and create objects from the .csv's content
public class CSVReader {
	
	private String[] head;
	private String[][] content;
	
	/** Creates a CSVReader object. */
	public CSVReader() {}
	/** Creates a CSVReader object which directly invokes the read() method.
	 * @param filePath a String containing the file path.
	*/
	public CSVReader(String filePath) {
		this.read(filePath);
	}
	
	/** Method to read a .csv file after creating a CSVReader object.
	 * @param filePath a String containing the file path.
	*/
	public void read(String filePath) {
		//use ClassLoader to get file path of files in resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			//create File object and corresponding Scanner
			File csvFile = new File(classLoader.getResource(filePath).getFile());
			Scanner csvScanner = new Scanner(csvFile);
			while(csvScanner.hasNext()) {
				System.out.println(csvScanner.next());
			}
			csvScanner.close();
			
		} catch (FileNotFoundException e) {
			//file could not be found
			System.out.println("ERR: The file may be corrupted or does not exist under the given path.");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("ERR: The file path must not start with '/' if the first element in the filepath is a folder.");
			e.printStackTrace();
		}
	}
	
	/* getters and setters */
	/** Returns the head attribute.
	 * @return head a String array containing the title of each column.
	*/
	public String[] getHead() {
		return head;
	}
	/** Sets the title of the columns.
	 * @param head a String array containing the title of each column.
	*/
	public void setHead(String[] head) {
		this.head = head;
	}
	/** Returns the content attribute.
	 * @return content a String 2D array which contains the content of all rows and columns.
	*/
	public String[][] getContent() {
		return content;
	}
	/** Sets the whole content of the object.
	 * @param content a String 2D array which contains the content of all rows and columns.
	*/
	public void setContent(String[][] content) {
		this.content = content;
	}	
}