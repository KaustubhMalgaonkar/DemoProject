package demo.com.demoproject.CustomList;

import android.widget.TextView;

/**
 * Created by kaustubh on 9/4/15.
 */
public class ProfileViewHolder {

  TextView txtName;
  TextView txtEmail;
  TextView txtPhone;
  TextView txtCity;

  public ProfileViewHolder(TextView txtName, TextView txtEmail, TextView txtPhone, TextView txtCity) {
    this.txtName = txtName;
    this.txtEmail = txtEmail;
    this.txtPhone = txtPhone;
    this.txtCity = txtCity;
  }

  public TextView getTxtName() {
    return txtName;
  }

  public void setTxtName(TextView txtName) {
    this.txtName = txtName;
  }

  public TextView getTxtEmail() {
    return txtEmail;
  }

  public void setTxtEmail(TextView txtEmail) {
    this.txtEmail = txtEmail;
  }

  public TextView getTxtPhone() {
    return txtPhone;
  }

  public void setTxtPhone(TextView txtPhone) {
    this.txtPhone = txtPhone;
  }

  public TextView getTxtCity() {
    return txtCity;
  }

  public void setTxtCity(TextView txtCity) {
    this.txtCity = txtCity;
  }
}
