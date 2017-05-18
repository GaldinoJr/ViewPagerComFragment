package cards.viewpagerteste;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.LinkedList;
import java.util.List;

import cards.viewpagerteste.Adapter.AdapterList;
import cards.viewpagerteste.Pager.BasePreviewDetailPagerAdapter;
import cards.viewpagerteste.Pager.CustomHackyViewPager;


public class MainActivity extends AppCompatActivity
{
    //private RecyclerView rvItens;
    private List<Fragment> mListFraments;
    private ViewPager mPager;
    private CirclePageIndicator mIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (ViewPager)findViewById(R.id.viewPager);
        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        //
        carregarControles();
        populateViewPager();
    }

    private void carregarControles()
    {

    }

    private void populateViewPager()
    {
        //if(mFragments != null) {
        BasePreviewDetailPagerAdapter.TYPE_FRAGMENT[] typeFragment = {
                BasePreviewDetailPagerAdapter.TYPE_FRAGMENT.TYPE2,
                BasePreviewDetailPagerAdapter.TYPE_FRAGMENT.TYPE1
        };
        BasePreviewDetailPagerAdapter adapter = new BasePreviewDetailPagerAdapter(getSupportFragmentManager(), typeFragment);
        mPager.setAdapter(adapter);

        mIndicator.setViewPager(mPager);
        mIndicator.setCurrentItem(0);
        //}
    }
}
