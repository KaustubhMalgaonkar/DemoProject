package demo.com.demoproject.database;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import demo.com.demoproject.utils.CommonFunction;

/**
 * Created by kaustubh on 6/4/15.
 */
public class ProfileModel {

  private static ProfileModel mInstance;
  private ContentValues contentValues;
  private SQLiteDatabase db;

  private long id;
  private String name;
  private String email;
  private long number;
  private String gender;
  private String city;
  private String created;

  public static ProfileModel getInstance(){
    if(mInstance == null)
    {
      mInstance = new ProfileModel();
    }
    return mInstance;
  }

  public ProfileModel(){}

  public ProfileModel(String name, String email, long number, String gender, String city) {
    this.name = name;
    this.email = email;
    this.number = number;
    this.gender = gender;
    this.city = city;
  }

  public ProfileModel(long id, String name, String email, long number, String gender, String city, String created) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.number = number;
    this.gender = gender;
    this.city = city;
    this.created = created;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public long addProfile(Context context, ProfileModel profileModel){
    DatabaseHelper databaseHelper = new DatabaseHelper(context);
    db = databaseHelper.open();

    contentValues = new ContentValues();
    contentValues.put(databaseHelper.KEY_NAME,profileModel.getName());
    contentValues.put(databaseHelper.KEY_EMAIL,profileModel.getEmail());
    contentValues.put(databaseHelper.KEY_NUMBER,profileModel.getNumber());
    contentValues.put(databaseHelper.KEY_GENDER,profileModel.getGender());
    contentValues.put(databaseHelper.KEY_CITY,profileModel.getCity());
    contentValues.put(databaseHelper.KEY_CREATED, CommonFunction.getCurrentTimeStamp());

    long lastId = db.insert(databaseHelper.TABLE_PROFILE,null,contentValues);
    databaseHelper.closeDatabase();

    Log.i("Database", "Inserted Profile Info");
    return lastId;
  }

  public ArrayList<ProfileModel> getProfileList(Context context,long profileId){
    ArrayList<ProfileModel> profileList = new ArrayList<ProfileModel>();
    DatabaseHelper databaseHelper = new DatabaseHelper(context);
    db = databaseHelper.open();
    Cursor cursor;
    if(profileId == 0) {
      cursor = db.rawQuery("select * from " + databaseHelper.TABLE_PROFILE + " ORDER BY " + databaseHelper.KEY_CREATED + " DESC", null);
    } else {
      cursor = db.query(databaseHelper.TABLE_PROFILE, new String[]{databaseHelper.KEY_ID,databaseHelper.KEY_NAME,
              databaseHelper.KEY_EMAIL, databaseHelper.KEY_NUMBER, databaseHelper.KEY_GENDER, databaseHelper.KEY_CITY,
              databaseHelper.KEY_CREATED}, databaseHelper.KEY_ID + "=?",
          new String[]{String.valueOf(profileId)}, null, null, null, null);
    }

    int idIndex = cursor.getColumnIndex(databaseHelper.KEY_ID);
    int nameIndex = cursor.getColumnIndex(databaseHelper.KEY_NAME);
    int emailIndex = cursor.getColumnIndex(databaseHelper.KEY_EMAIL);
    int numberIndex = cursor.getColumnIndex(databaseHelper.KEY_NUMBER);
    int genderIndex = cursor.getColumnIndex(databaseHelper.KEY_GENDER);
    int cityIndex = cursor.getColumnIndex(databaseHelper.KEY_CITY);
    int createdIndex = cursor.getColumnIndex(databaseHelper.KEY_CREATED);
    if (cursor.moveToFirst()) {
      while (cursor.isAfterLast() == false) {
        long id = cursor.getLong(idIndex);
        String name = cursor.getString(nameIndex);
        String email = cursor.getString(emailIndex);
        long number = cursor.getLong(numberIndex);
        String gender = cursor.getString(genderIndex);
        String city = cursor.getString(cityIndex);
        String createdBy = cursor.getString(createdIndex);

        profileList.add(new ProfileModel(id,name,email,number,gender,city,createdBy));
        cursor.moveToNext();
      }
    }

    cursor.close();
    databaseHelper.close();

    return profileList;
  }
}
