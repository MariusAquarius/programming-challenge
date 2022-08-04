package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 * @author Marius Unger
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String[] args) {
    	
    	String dayWithSmallestTempSpread, teamWithSmallestGoalDiff;
    	
    	//creating CSVReader objects
    	CSVReader csvWeather = new CSVReader("de/exxcellent/challenge/weather.csv");
    	CSVReader csvFootball = new CSVReader("de/exxcellent/challenge/football.csv");
    	
    	//creating maps from csv contents
    	RowsToMap weatherMap = new RowsToMap(csvWeather);
    	RowsToMap footballMap = new RowsToMap(csvFootball);
    	
    	//printing maps
    	System.out.println(weatherMap.props.keySet() + "\n" + weatherMap.props.values());
    	System.out.println("\n" + footballMap.props.keySet() + "\n" + footballMap.props.values());
    	
    	dayWithSmallestTempSpread = getDifference(weatherMap, "Day", "MxT", "MnT");
    	System.out.println("Day with smallest temperature spread: " + dayWithSmallestTempSpread);
    	teamWithSmallestGoalDiff = getDifference(footballMap, "Team", "Goals", "Goals Allowed");
    	System.out.println("\nTeam with minimum goal difference: " + teamWithSmallestGoalDiff);
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
