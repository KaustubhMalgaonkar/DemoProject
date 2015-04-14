package demo.com.demoproject.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.com.demoproject.R;

/**
 * Created by kaustubh on 14/4/15.
 */
public class FirstFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_first, container, false);
  }
}
