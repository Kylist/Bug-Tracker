package common.Ultilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Contains all static helper methods
 * @author Trung Nguyen
 *
 */
public class Utilities {
	static Calendar cal = new GregorianCalendar();
	static DateFormat dfm = new SimpleDateFormat("MM-dd-yyyy");
	
	public static Date getDate(int year, int month, int date) {
		cal.set(year, month, date);
		return cal.getTime();
	}
	
	public static Date stringToDate(String string) throws ParseException {
		return dfm.parse(string);
	}
	
	public static String getDateString(Date date) {
		return  dfm.format(date);
	}
	
	public static JSONArray readFile(String s) throws Exception {
		JSONParser jsonParser = new JSONParser();
		JSONArray arr = null;
        try {
        	Class cls = Class.forName("common.Task.TaskHold");
        	// returns the ClassLoader object assosiated with this Class
        	ClassLoader cLoader = cls.getClassLoader();
        	InputStream inputStream = cLoader.getResourceAsStream("resources/database.json");
        	if (inputStream != null ) {
        		BufferedReader streamReader = new BufferedReader (
        				new InputStreamReader(inputStream,"UTF-8"));
        		StringBuilder responseStrBuilder = new StringBuilder();
        		
        		String inputStr;
        		while ((inputStr = streamReader.readLine()) != null) {
        		responseStrBuilder.append(inputStr);	
        		
        	}
        	

            //Read JSON file
            //JSONObject obj = (JSONObject) jsonParser.parse(responseStrBuilder.toString());
          

    	   // JSONArray alerts = Utilities.readFile("alert");
        		JSONObject obj = (JSONObject) jsonParser.parse(responseStrBuilder.toString());
        	
/////////////////////////////////////////////////////////
           /* FileReader reader = new FileReader("src/resources/database.json");
            JSONObject obj = (JSONObject) jsonParser.parse(reader);*/
        		arr = (JSONArray) obj.get(s);
            
        } return arr;
        	} catch (Exception e) {
        	
        	throw e;
        }
		
	}
	
	public static int[] makeSequence(int begin, int end) {
		return java.util.stream.IntStream.rangeClosed(begin, end).toArray();
	}
	
	public static int compareWithTodayDate(Date d) {
		if(d==null) return 1;
		return d.toInstant().atZone(ZoneId.systemDefault())
			      .toLocalDate().compareTo(java.time.LocalDate.now());
	}
	
	public static Date getCurrentDate() {
		return Date.from(java.time.LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}