package views;

import android.content.Intent;

import com.example.wonderland.R;
import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.ParallaxPage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;
import com.stephentuso.welcome.WelcomeHelper;
import com.stephentuso.welcome.WelcomeSharedPreferencesHelper;

public class MyWelcomeActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultTitleTypefacePath("Montserrat-Bold.ttf")
                .defaultHeaderTypefacePath("Montserrat-Bold.ttf")

                .page(new BasicPage(R.drawable.ic_front_desk_white,
                        "Welcome",
                        "An Android library for onboarding, instructional screens, and more")
                        .background(R.color.orange_background)
                )

                .page(new BasicPage(R.drawable.ic_thumb_up_white,
                        "Simple to use",
                        "Add a welcome screen to your app with only a few lines of code.")
                        .background(R.color.red_background)
                )

                .page(new BasicPage(R.drawable.ic_edit_white,
                        "Customizable",
                        "All elements of the welcome screen can be customized easily.")
                        .background(R.color.blue_background)
                )

                .swipeToDismiss(true)
                .exitAnimation(android.R.anim.fade_out)
                .canSkip(true)
                .build();
    }

    @Override
    protected void completeWelcomeScreen() {
        super.completeWelcomeScreen();
        Intent intent = new Intent(MyWelcomeActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void cancelWelcomeScreen() {
        super.cancelWelcomeScreen();
        Intent intent = new Intent(MyWelcomeActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public static String welcomeKey() {
        return "WelcomeScreen";
    }
}
