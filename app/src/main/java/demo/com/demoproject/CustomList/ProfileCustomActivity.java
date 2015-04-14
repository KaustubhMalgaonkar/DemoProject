package demo.com.demoproject.CustomList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import demo.com.demoproject.R;
import demo.com.demoproject.database.ProfileModel;


public class ProfileCustomActivity extends ActionBarActivity {

  ListView listView;
  ArrayList<ProfileModel> profileModelArrayList;
  ProfileAdapter profileAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_detail);

    listView = (ListView) findViewById(R.id.profileListView);

    /*get user details from database*/
    profileModelArrayList = new ArrayList<ProfileModel>();
    profileModelArrayList = ProfileModel.getInstance().getProfileList(getApplicationContext(),0);


    /*create custom adapter for profile detail view*/
    profileAdapter = new ProfileAdapter(this,R.layout.custom_profile_details,profileModelArrayList);

    listView.setAdapter(profileAdapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ProfileModel profileModel = profileAdapter.getItem(position);
        Toast.makeText(ProfileCustomActivity.this,profileModel.getName(),Toast.LENGTH_LONG).show();
      }
    });
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_profile_custom, menu);
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
