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
    	
    	//creating CSVReader objects
    	CSVReader csvWeather = new CSVReader("de/exxcellent/challenge/weather.csv");
    	CSVReader csvFootball = new CSVReader("de/exxcellent/challenge/football.csv");
    	
    	//printing both .csvs as ArrayLists
    	System.out.println("WeatherCSV:");
    	System.out.println(csvWeather.getHeader());
    	System.out.println(csvWeather.getContent());
    	
    	System.out.println("\nFootballCSV:");
    	System.out.println(csvFootball.getHeader());
    	System.out.println(csvFootball.getContent());
    	
    	
    	
    	/*
        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    	*/
    }
}
