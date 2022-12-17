package views.webconfig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wonderland.R;

import views.home.HomeActivity;
import views.welcome.WelcomeActivity;

public class WebConfigActivity extends AppCompatActivity {

    private CardView mCvLogin, mCvConfig;
    private Button mBtnLogin, mBtnGo;
    private EditText mEtAP, mEtSSID, mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_config);
        assignViews();
        setListener();
    }

    public void assignViews() {
        mCvLogin = findViewById(R.id.cv_login);
        mCvConfig = findViewById(R.id.cv_config);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnGo = findViewById(R.id.btn_go);
        mEtAP = findViewById(R.id.et_ap_wifi);
        mEtSSID = findViewById(R.id.et_wifi_ssid);
        mEtPassword = findViewById(R.id.et_wifi_password);
    }

    private void setListener() {

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCvConfig.setVisibility(View.VISIBLE);
            }
        });

        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebConfigActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


    }
}