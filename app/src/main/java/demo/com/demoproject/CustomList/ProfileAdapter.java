package demo.com.demoproject.CustomList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import demo.com.demoproject.R;
import demo.com.demoproject.database.ProfileModel;

/**
 * Created by kaustubh on 9/4/15.
 */
public class ProfileAdapter extends ArrayAdapter<ProfileModel> {

  ArrayList<ProfileModel> profileModelArrayList;
  Context context;

  public ProfileAdapter(Context context, int resource, ArrayList<ProfileModel> profileModelArrayList) {
    super(context, resource, profileModelArrayList);
    this.context = context;
    this.profileModelArrayList = profileModelArrayList;
  }

  @Override
  public ProfileModel getItem(int position) {
    return profileModelArrayList.get(position);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ProfileModel profileModel = (ProfileModel) this.getItem(position);

    TextView txtName;
    TextView txtEmail;
    TextView txtPhone;
    TextView txtCity;

    if(convertView == null){
      LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = layoutInflater.inflate(R.layout.custom_profile_details,parent,false);

      txtName = (TextView) convertView.findViewById(R.id.txtName);
      txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);
      txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);
      txtCity = (TextView) convertView.findViewById(R.id.txtCity);

      convertView.setTag(new ProfileViewHolder(txtName,txtEmail,txtPhone,txtCity));
    } else {
      ProfileViewHolder profileViewHolder = (ProfileViewHolder) convertView.getTag();
      txtName = profileViewHolder.getTxtName();
      txtEmail = profileViewHolder.getTxtEmail();
      txtCity = profileViewHolder.getTxtCity();
      txtPhone = profileViewHolder.getTxtPhone();
    }

    txtName.setText(profileModel.getName());
    txtEmail.setText(profileModel.getEmail());
    txtCity.setText(profileModel.getCity());
    txtPhone.setText(Long.toString(profileModel.getNumber()));

    return convertView;
  }
}
