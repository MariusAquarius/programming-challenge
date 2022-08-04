package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid 
 * @author Marius Unger
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String[] args) {
    	
    	String smallestDiffResult, outputText ="";
    	int argPos = 0;
    	boolean argsGiven = false;
    	String[] mapKeys = null;
    	
    	//check arguments
    	for(int i = 0; i < args.length; i++) {
    		//ignore other args
    		if((args[i] == "weather") || (args[i] == "football")) {
    			argPos = i;
    			argsGiven = true;
    		}
    	}
    	//if no arguments are passed to main
    	if((args.length < 1) || !argsGiven) {
    		System.out.println("You have not entered one of the commands 'weather' or 'football'.");
    		return;
    	}
    	
    	//Strings for output
    	String footballText = "Team with minimum goal difference: ";
    	String weatherText = "Day with smallest temperature spread: ";
    	if(args[argPos] == "football")
    		outputText = footballText;
    	if(args[argPos] == "weather")
    		outputText = weatherText;
    	
    	//keys for football/weather
    	String[] footballKeys = {"Team", "Goals", "Goals Allowed"};
    	String[] weatherKeys = {"Day", "MxT", "MnT"};
    	if(args[argPos] == "football")
    		mapKeys = footballKeys;
    	if(args[argPos] == "weather")
    		mapKeys = weatherKeys;
    	
    	//creating CSVReader object
    	CSVReader csvWeather = new CSVReader("de/exxcellent/challenge/" + args[0] + ".csv");
    	
    	//creating map from csv content
    	RowsToMap mapFromCSV = new RowsToMap(csvWeather);
    	
    	//printing results   	
    	smallestDiffResult = getDifference(mapFromCSV, mapKeys[0], mapKeys[1], mapKeys[2]);
    	System.out.println(outputText + smallestDiffResult);
    }

    /**
     * Function returning the value with the smallest absolute difference
     * @param map contains the map on which the absolute difference will be checked
     * @param targetKey the key for the column with name/target values
     * @param maxKey the key for the column with high values
     * @param minKey the key for the column with smaller values
     * @return target the String containing the target value with the least difference
     */
    
    public static String getDifference(RowsToMap map, String targetKey, String maxKey, String minKey) {
    	String target = "";
    	float minSpread = 0, currentSpread;
    	boolean falseInput = false;
    	
    	//check if given keys are valid
    	if(!map.props.containsKey(targetKey))
    		falseInput = true;
    	if(!map.props.containsKey(maxKey))
    		falseInput = true;
    	if(!map.props.containsKey(minKey))
    		falseInput = true;
    	
    	if(falseInput)
    		return "\nERR: You may have entered false keys.";
    	
    	for(int i = 0; i < map.props.get(targetKey).size(); i++) {
    		String maxAsString = map.props.get(maxKey).get(i);
    		String minAsString = map.props.get(minKey).get(i);
    		currentSpread = Math.abs(Float.parseFloat(maxAsString) - Float.parseFloat(minAsString));
    		if(i == 0) {
    			//in the first run the current spread is also the minimum
    			minSpread = currentSpread;
    		}
    		else {
    			if(currentSpread < minSpread) {
    				//if the current spread is less than the minimum, the current value should be assigned to the minimum
    				minSpread = currentSpread;
    				//save the day
    				target = map.props.get(targetKey).get(i);
    			}
    		}
    	}
    	
    	return target;
    }
}
