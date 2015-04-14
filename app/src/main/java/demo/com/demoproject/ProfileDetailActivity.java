package demo.com.demoproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import demo.com.demoproject.database.ProfileModel;


public class ProfileDetailActivity extends ActionBarActivity{


  ListView listView;
  ArrayList<ProfileModel> profileModelArrayList;
  String name [];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_detail);

    listView = (ListView) findViewById(R.id.profileListView);

    profileModelArrayList = new ArrayList<ProfileModel>();
    profileModelArrayList = ProfileModel.getInstance().getProfileList(getApplicationContext(),0);

    name = new String[profileModelArrayList.size()];
    if(profileModelArrayList.size() != 0){
      for (ProfileModel profile : profileModelArrayList){
//        Log.e("Name",profile.getName());
        name[profileModelArrayList.indexOf(profile)] = profile.getName();
      }
      /*for(int i = 0 ; i < profileModelArrayList.size() ; i++){
        name[i] = profileModelArrayList.get(i).getName();
      }*/
    }

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
    listView.setAdapter(arrayAdapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),name[position],Toast.LENGTH_LONG).show();
      }
    });
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
