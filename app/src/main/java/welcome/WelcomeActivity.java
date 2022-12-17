package welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wonderland.R;

import java.util.ArrayList;
import java.util.List;

import views.HomeActivity;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager vp;
    private Button btn_start;
    private List<Fragment> fragments;
    private ImageView iv1, iv2, iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.activity_welcome);
        initData();
        initViews();
        setListener();
    }

    public void initData() {
        fragments = new ArrayList<>();
        fragments.add(new WelcomeFragment(R.drawable.firstday));
        fragments.add(new WelcomeFragment(R.drawable.firstyear));
        fragments.add(new WelcomeFragment(R.drawable.secondyear));
    }

    public void initViews() {
        vp = findViewById(R.id.vp_welcome);
        btn_start = findViewById(R.id.btn_start);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        vp.addOnPageChangeListener(new MyPageChangeListener());
    }

    public void setListener() {
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * ViewPager适配器
     */
    private class MyPageAdapter extends FragmentPagerAdapter {


        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    /**
     * ViewPager滑动页面监听器
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * 根据页面不同动态改变红点和在最后一页显示立即体验按钮
         *
         * @param position
         */
        @Override
        public void onPageSelected(int position) {
            btn_start.setVisibility(View.GONE);
            iv1.setImageResource(R.drawable.spot2);
            iv2.setImageResource(R.drawable.spot2);
            iv3.setImageResource(R.drawable.spot2);
            if (position == 0) {
                iv1.setImageResource(R.drawable.spot1);
            } else if (position == 1) {
                iv2.setImageResource(R.drawable.spot1);
            } else {
                iv3.setImageResource(R.drawable.spot1);
                btn_start.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}