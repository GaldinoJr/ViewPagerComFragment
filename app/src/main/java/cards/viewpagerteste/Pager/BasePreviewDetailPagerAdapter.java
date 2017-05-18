package cards.viewpagerteste.Pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cards.viewpagerteste.Fragments.Fragment1;
import cards.viewpagerteste.Fragments.Fragment2;

/**
 * Created by galdino on 27/04/2017.
 */

public class BasePreviewDetailPagerAdapter extends FragmentPagerAdapter
{
    private final TYPE_FRAGMENT[] mTypeFragments;

    public enum TYPE_FRAGMENT {
        TYPE1, TYPE2
    }

    public BasePreviewDetailPagerAdapter(FragmentManager fm, TYPE_FRAGMENT[] typeFragments) {
        super(fm);
        mTypeFragments = typeFragments;
    }

    @Override
    public Fragment getItem(int position)
    {
        TYPE_FRAGMENT typeFragment = mTypeFragments[position];
        if (typeFragment == TYPE_FRAGMENT.TYPE1) {
            return new Fragment1();
        } else {
            return new Fragment2();
        }
    }

    @Override
    public int getCount() {
        return mTypeFragments.length;
    }

//    @Override
//    public Fragment getItem(int position)
//    {
//        int index = position * mNrCelulas;
//        int indexFinal = index + mNrCelulas;
//        if (indexFinal >= mFragments.size()) {
//            indexFinal = mFragments.size() - 1;
//        }
//
//        List<String> list = mFragments.subList(index, indexFinal);
//        return mFragments.get(position);
//    }
}
