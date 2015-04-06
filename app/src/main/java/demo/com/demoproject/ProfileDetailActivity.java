package demo.com.demoproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import demo.com.demoproject.database.ProfileModel;


public class ProfileDetailActivity extends ActionBarActivity {

  TextView txt;
  ArrayList<ProfileModel> profileModelArrayList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_detail);

    txt = (TextView) findViewById(R.id.txt);

    profileModelArrayList = new ArrayList<ProfileModel>();
    profileModelArrayList = ProfileModel.getInstance().getProfileList(getApplicationContext(),0);

    if(profileModelArrayList.size() != 0){
      for (ProfileModel profile : profileModelArrayList){
        Log.e("Name",profile.getName());
      }
    }

  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_profile_detail, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
