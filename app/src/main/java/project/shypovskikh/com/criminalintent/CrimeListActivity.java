package project.shypovskikh.com.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by User7 on 06.03.2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
