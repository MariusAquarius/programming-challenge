package de.exxcellent.challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Used to create an Object which hosts properties in a HashMap Object
 * @author Marius Unger
 * @version 0.1
*/

public class RowsToMap {
	
	/** attribute for RowsToMap object which holds a HashMap object, containing key/values
	 * */
	public Map<String, String> props = new HashMap<String, String>();
	
	/** creates a RowsToMap object 
	 * */
	public RowsToMap() {}
	/** creates a RowsToMap object and directly creates a key/value pair from a CSVReader object
	 *  @param csvValues a CSVReader object from which the head and content attributes are used to create a Map
	 */
	public RowsToMap(CSVReader csvValues) {
		
	}
	/** creates a RowsToMap object and directly creates a key/value pair from two ArrayLists
	 *  @param header an ArrayList which will be used for the keys
	 *  @param content an ArrayList which will be used to map values to the keys
	 */
	public RowsToMap(List<String> header, List<List<String>> content) {
		
	}
}
