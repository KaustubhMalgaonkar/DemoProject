package demo.com.demoproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kaustubh on 11/3/15.
 */
public class TestActivity extends Activity implements View.OnClickListener {

  TextView txtName;
  EditText editName;
  Button btnShow;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_activity);

    txtName = (TextView) findViewById(R.id.textName);
    editName = (EditText) findViewById(R.id.editName);
    btnShow = (Button) findViewById(R.id.btnShow);
    btnShow.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btnShow:
        String name = editName.getText().toString();
        editName.setText("");
        txtName.setText(name);
        break;
    }
  }
}
