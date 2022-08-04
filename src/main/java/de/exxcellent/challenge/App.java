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
    	
    	String dayWithSmallestTempSpread;
    	
    	//creating CSVReader objects
    	CSVReader csvWeather = new CSVReader("de/exxcellent/challenge/weather.csv");
    	CSVReader csvFootball = new CSVReader("de/exxcellent/challenge/football.csv");
    	
    	//creating maps from csv contents
    	RowsToMap weatherMap = new RowsToMap(csvWeather);
    	RowsToMap footballMap = new RowsToMap(csvFootball);
    	
    	//printing maps
    	System.out.println(weatherMap.props.keySet() + "\n" + weatherMap.props.values());
    	System.out.println("\n" + footballMap.props.keySet() + "\n" + footballMap.props.values());
    	
    	dayWithSmallestTempSpread = getDayWithSmallestTempSpread(weatherMap);
    	System.out.println("\nDay with smallest temperature spread: " + dayWithSmallestTempSpread);
    }
    
    /**
     * Function to get the smallest spread in temperature (smallest difference between max and min temperature on a day).
     * @param weatherMap a RowsToMap object featuring the weather data as a map
     * @return day a String hosting the day with the smallest temperature spread
     */
    public static String getDayWithSmallestTempSpread(RowsToMap weatherMap) {
    	String day = "0";
    	int minSpread = 0, currentSpread;
    	for(int i = 0; i < weatherMap.props.get("Day").size(); i++) {
    		currentSpread = getTempDifference(weatherMap.props.get("MxT").get(i), weatherMap.props.get("MnT").get(i));
    		if(i == 0) {
    			//in the first run the current spread is also the minimum
    			minSpread = currentSpread;
    		}
    		else {
    			if(currentSpread < minSpread) {
    				//if the current spread is less than the minimum, the current value should be assigned to the minimum
    				minSpread = currentSpread;
    				//save the day
    				day = weatherMap.props.get("Day").get(i);
    			}
    		}
    	}
    	return day;
    }
    
    /**
     * Function returning the temperature difference
     * @param mxt maximum temperature as String
     * @param mnt minimum temperature as String
     * @return diff temperature difference as integer
     */
    public static int getTempDifference(String mxt, String mnt) {
    	int max = Integer.parseInt(mxt);
    	int min = Integer.parseInt(mnt);
    	int diff = max - min;
    	return diff;
    }
}
