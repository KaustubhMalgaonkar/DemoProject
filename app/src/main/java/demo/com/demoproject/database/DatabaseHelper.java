package demo.com.demoproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kaustubh on 16/3/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

  private static SQLiteDatabase db;
  // Database Version
  private static final int DATABASE_VERSION = 1;

  // Database Name
  private static final String DATABASE_NAME = "DemoProject";

  //Table Name
  public static final String TABLE_PROFILE = "profile_table";

  //Column Names
  public static final String KEY_ID = "id";
  public static final String KEY_CREATED = "created";

  public static final String KEY_NAME = "name";
  public static final String KEY_EMAIL = "email";
  public static final String KEY_NUMBER = "number";
  public static final String KEY_GENDER = "gender";
  public static final String KEY_CITY = "city";


  public DatabaseHelper(Context context){
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_DIST_DETAIL = "CREATE TABLE " + TABLE_PROFILE + "("
        + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_NAME + " TEXT,"+KEY_EMAIL+ " TEXT,"+KEY_NUMBER+ " LONG,"
        +KEY_GENDER+" TEXT,"+KEY_CITY+" TEXT,"+KEY_CREATED+" TEXT)";
    db.execSQL(CREATE_DIST_DETAIL);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
  }

  public SQLiteDatabase open(){
    db = this.getWritableDatabase();
    return db;
  }

  public void closeDatabase(){
    db.close();
  }
}
