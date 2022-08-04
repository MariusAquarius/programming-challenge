package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/** Used to create an Object which hosts properties in a HashMap Object
 * @author Marius Unger
 * @version 0.1
*/

public class RowsToMap {
	
	/** attribute for RowsToMap object which holds a HashMap object, containing key/values
	 * */
	public Map<String, ArrayList<String>> props = new LinkedHashMap<String, ArrayList<String>>();
	
	/** creates a RowsToMap object and directly creates a key/value pair from a CSVReader object
	 *  @param csvValues a CSVReader object from which the head and content attributes are used to create a Map
	 */
	public RowsToMap(CSVReader csvValues) {
		ArrayList<ArrayList<String>> transposedContent = transpose(csvValues.getContent());
		for(int i = 0; i < csvValues.getHeader().size(); i++) {
			this.props.put(csvValues.getHeader().get(i), transposedContent.get(i));
		}
	}
	/** creates a RowsToMap object and directly creates a key/value pair from two ArrayLists
	 *  @param header an ArrayList which will be used for the keys
	 *  @param content an ArrayList which will be used to map values to the keys
	 */
	public RowsToMap(ArrayList<String> header, ArrayList<ArrayList<String>> content) {
		ArrayList<ArrayList<String>> transposedContent = transpose(content);
		for(int i = 0; i < header.size(); i++) {
			this.props.put(header.get(i), transposedContent.get(i));
		}
	}
	
	/** transposes ArrayList (switching x and y axis)
	 *  @param list ArrayList to transpose
	 *  @return transpoList transposed ArrayList
	 */
	public static ArrayList<ArrayList<String>> transpose(ArrayList<ArrayList<String>> list) {
        ArrayList<ArrayList<String>> transpoList = new ArrayList<ArrayList<String>>();
        final int y = list.get(0).size();
        for (int i = 0; i < y; i++) {
            ArrayList<String> col = new ArrayList<String>();
            for (ArrayList<String> row : list) {
                col.add(row.get(i));
            }
            transpoList.add(col);
        }
        return transpoList;
    }
}
