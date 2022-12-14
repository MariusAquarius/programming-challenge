package de.exxcellent.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** Used to create a CSVReader object to read .csv files and create objects out of its content.
 * @author Marius Unger
 * @version 0.1
*/

public class CSVReader {
	/** attribute holding the titles for the csv content (key) 
	 * */
	private ArrayList<String> header = new ArrayList<>();
	/** attribute holding the values of the csv content (value) 
	 * */
	private ArrayList<ArrayList<String>> content = new ArrayList<>();
	
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
			String[] rowAsArray;
			//set first row as the CSVReader objects head
			if(csvScanner.hasNextLine()) {
				rowAsArray = rowToArray(csvScanner.nextLine());
				this.setHeader(new ArrayList<>(Arrays.asList(rowAsArray)));
			}
			//push a new row of content with every line of the .csv
			while(csvScanner.hasNextLine()) {
				rowAsArray = rowToArray(csvScanner.nextLine());
				this.content.add(new ArrayList<>(Arrays.asList(rowAsArray)));			
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
	/** transforms a row from the .csv file to an array
	 * @param csvRow a String which resulted from scanning the .csv file's first row
	 * @return rowAsArray a String array containing the split values
	*/
	public static String[] rowToArray(String csvRow) {
		String[] rowAsArray = csvRow.split(",");
		return rowAsArray;
	}
	
	/* getters and setters */
	/** Returns the head attribute.
	 * @return head a String array containing the title of each column.
	*/
	public List<String> getHeader() {
		return header;
	}
	/** Sets the title of the columns.
	 * @param head a String array containing the title of each column.
	*/
	public void setHeader(ArrayList<String> head) {
		this.header = head;
	}
	/** Returns the content attribute.
	 * @return content a String 2D ArrayList which contains the content of all rows and columns.
	*/
	public ArrayList<ArrayList<String>> getContent() {
		return content;
	}
	/** Sets the whole content of the object.
	 * @param content a String 2D ArrayList which contains the content of all rows and columns.
	*/
	public void setContent(ArrayList<ArrayList<String>> content) {
		this.content = content;
	}	
}