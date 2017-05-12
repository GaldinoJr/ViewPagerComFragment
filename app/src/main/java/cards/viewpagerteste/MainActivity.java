package cards.viewpagerteste;

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
    private List<String> mListItens;
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
        mListItens = new LinkedList<>();
        String mItem = "Linha ";
        for (int i = 0; i < 10; i++)
        {
            mItem = "Linha " + Integer.toString(i);
            mListItens.add(mItem);
        }
    }

    private void populateViewPager()
    {
        //if(mFragments != null) {
            BasePreviewDetailPagerAdapter adapter = new BasePreviewDetailPagerAdapter(getSupportFragmentManager(), mListItens, 4);
            mPager.setAdapter(adapter);
            mPager.setOffscreenPageLimit(2); // TODO Carregar paginas a mais

            mIndicator.setViewPager(mPager);
            mIndicator.setCurrentItem(0);
        //}
    }
}
