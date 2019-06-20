package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kitchenorderticket.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavDrawerFragment extends Fragment {


    public NavDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_nav_drawer,container,false);
//      String text = getArguments().getString("text","");
//        TextView txt = view.findViewById(R.id.fragText);
//        txt.setText(text);
        return  view;
    }

}
