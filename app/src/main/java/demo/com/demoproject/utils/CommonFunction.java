package demo.com.demoproject.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kaustubh on 6/4/15.
 */
public class CommonFunction {

  public static String getCurrentTimeStamp(){
    try {

      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String currentTimeStamp = dateFormat.format(new Date()); // Find todays date

      return currentTimeStamp;
    } catch (Exception e) {
      e.printStackTrace();

      return null;
    }
  }

}
