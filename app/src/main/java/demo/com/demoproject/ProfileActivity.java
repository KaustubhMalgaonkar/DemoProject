package demo.com.demoproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import demo.com.demoproject.CustomList.ProfileCustomActivity;
import demo.com.demoproject.database.ProfileModel;


public class ProfileActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener, View.OnClickListener {

  EditText etName,etEmail,etNumber;
  Spinner spCity;
  RadioGroup rgGender;
  RadioButton rdMale,rdFemale;
  Button btnSubmit;
  String gender;
  String city[] = {"Mumbai","Surat","Navi Mumbai","Pune","Thane"};
  private String selectedCity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);



    etName = (EditText) findViewById(R.id.etName);
    etEmail = (EditText) findViewById(R.id.etEmail);
    etNumber = (EditText) findViewById(R.id.etNumber);

    spCity = (Spinner) findViewById(R.id.spCity);

    rgGender = (RadioGroup) findViewById(R.id.rgGender);
    rgGender.setOnCheckedChangeListener(this);

    rdMale = (RadioButton) findViewById(R.id.rdMale);
    rdFemale = (RadioButton) findViewById(R.id.rdFemale);

    btnSubmit = (Button) findViewById(R.id.btnSubmit);
    btnSubmit.setOnClickListener(this);

    ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,city);
    spCity.setAdapter(cityAdapter);
    spCity.setOnItemSelectedListener(this);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_profile, menu);
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
      Intent intent = new Intent(getApplicationContext(),ProfileCustomActivity.class);
      startActivity(intent);
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  /*@Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btnSubmit:

        break;
    }
  }*/

  @Override
  public void onCheckedChanged(RadioGroup group, int checkedId) {
     switch (checkedId){
      case R.id.rdMale:
        gender = "Male";
        break;
      case R.id.rdFemale:
        gender = "Female";
        break;
    }
  }

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    selectedCity = parent.getSelectedItem().toString();
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {

  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btnSubmit:

        ProfileModel.getInstance().addDistList(getApplicationContext(),new ProfileModel(
            etName.getText().toString(),
            etEmail.getText().toString(),
            Long.parseLong(etNumber.getText().toString()),
            gender,
            selectedCity
        ));

        Intent intent = new Intent(getApplicationContext(),ProfileDetailActivity.class);
        startActivity(intent);
        break;

      default:
        break;
    }
  }
}
