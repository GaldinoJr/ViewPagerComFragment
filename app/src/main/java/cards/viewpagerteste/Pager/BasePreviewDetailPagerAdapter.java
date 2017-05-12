package cards.viewpagerteste.Pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cards.viewpagerteste.FragmentPager;

/**
 * Created by galdino on 27/04/2017.
 */

public class BasePreviewDetailPagerAdapter extends FragmentPagerAdapter {

    private final int mNrCelulas;
    private List<String> mTexts;

    public BasePreviewDetailPagerAdapter(FragmentManager fm, List<String> mText, int nrCelulas) {
        super(fm);
        mTexts = mText;
        mNrCelulas = nrCelulas;
    }

//    @Override
//    public Fragment getItem(int position) {
//        return mTexts.get(position);
//    }

    @Override
    public int getCount() {
        double count = (double) mTexts.size() / (double)mNrCelulas;
        return (int) Math.ceil(count);
    }

    @Override
    public Fragment getItem(int position)
    {
        int index = position * mNrCelulas;
        int indexFinal = index + mNrCelulas;
        if (indexFinal >= mTexts.size()) {
            indexFinal = mTexts.size() - 1;
        }

        List<String> list = mTexts.subList(index, indexFinal);
        return FragmentPager.newInstance(list);
    }
}
