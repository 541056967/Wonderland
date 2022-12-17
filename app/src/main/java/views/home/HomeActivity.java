package views.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.wonderland.R;
import com.github.florent37.materialviewpager.MaterialViewPager;

import java.util.ArrayList;
import java.util.List;

import interfaces.IHomeContract;
import viewpager.CardFragment;
import viewpager.CardFragmentPagerAdapter;
import viewpager.CardItem;
import viewpager.CardPagerAdapter;
import viewpager.ShadowTransformer;

public class HomeActivity extends AppCompatActivity implements IHomeContract.IHomeView{

    private ViewPager mViewPager;

    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        setListener();
    }

    @Override
    public void initViews() {
        initViewPager();
    }

    @Override
    public void setListener() {

    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                dpToPixels(2, this), getCardFragments());
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mViewPager.setAdapter(mFragmentCardAdapter);
        mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        mFragmentCardShadowTransformer.enableScaling(true);
    }

    @Override
    public List<CardFragment> getCardFragments() {
        ArrayList<CardFragment> cardFragments = new ArrayList<>();
        cardFragments.add(new CardFragment(getResources().getString(R.string.title_1), getResources().getString(R.string.text_1)));
        cardFragments.add(new CardFragment(getResources().getString(R.string.title_2), getResources().getString(R.string.text_1)));
        cardFragments.add(new CardFragment(getResources().getString(R.string.title_3), getResources().getString(R.string.text_1)));
        cardFragments.add(new CardFragment(getResources().getString(R.string.title_4), getResources().getString(R.string.text_1)));
        return cardFragments;
    }
}