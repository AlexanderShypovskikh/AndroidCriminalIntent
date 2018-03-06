package model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by User7 on 04.03.2018.
 */

public class CrimeLab {
   private ArrayList<Crime> mCrimes;
   private Context myAppContext;
   private static CrimeLab crimeLab;

    private CrimeLab(Context appContext){
        this.myAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for(int i = 0; i < 100; i++){
            Crime c = new Crime();
            c.setmTitle("Crime # "+i);
            c.setmSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab getCrime(Context c){
        if(crimeLab == null){
            crimeLab = new CrimeLab(c.getApplicationContext());
            return crimeLab;
        } else
            return crimeLab;
    }

    public ArrayList<Crime> getmCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime c : mCrimes){
            if(c.getmId().equals(id))
                return c;
        }
        return null;
    }


}
