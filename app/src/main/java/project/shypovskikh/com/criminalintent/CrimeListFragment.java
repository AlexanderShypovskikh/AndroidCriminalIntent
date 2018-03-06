package project.shypovskikh.com.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import model.Crime;
import model.CrimeLab;

import static android.content.ContentValues.TAG;

/**
 * Created by User7 on 06.03.2018.
 */

public class CrimeListFragment extends ListFragment {
    private List<Crime> mCrimes;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.getCrime(getActivity()).getmCrimes();

     //   ArrayAdapter<Crime> adapter =
      //          new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,
        //                                mCrimes);
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
        Log.d(TAG, c.getmTitle() + "was clicked");
    }

    private class CrimeAdapter extends ArrayAdapter<Crime>{

        public CrimeAdapter(List<Crime> crimes){
            super(getActivity(),0,crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_crime, null);

            }
            Crime c = getItem(position);
            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.crime_title_listView);
            titleTextView.setText(c.getmTitle());
            TextView dateTextView =
                    (TextView)convertView.findViewById(R.id.crime_title_datelistView);
            dateTextView.setText(c.getmDate().toString());
            CheckBox solvedCheckBox =
                    (CheckBox)convertView.findViewById(R.id.crime_list_item_solved_checkBox);
            solvedCheckBox.setChecked(c.ismSolved());
            return convertView;
        }

    }
}





















