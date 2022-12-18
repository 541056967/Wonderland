package views.webconfig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wonderland.R;
import com.victor.loading.rotate.RotateLoading;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import views.home.HomeActivity;
import views.welcome.WelcomeActivity;

public class WebConfigActivity extends AppCompatActivity {

    private CardView mCvLogin, mCvConfig;
    private Button mBtnLogin, mBtnGo;
    private EditText mEtAP, mEtSSID, mEtPassword;
    private RotateLoading loading;

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
        loading = findViewById(R.id.rotateloading);
    }

    private void setListener() {

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebConfigActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                        Thread.sleep(3000);
                        e.onNext(1);
                        e.onComplete();
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                loading.start();
                            }

                            @Override
                            public void onNext(Integer value) {
                                mCvLogin.setVisibility(View.VISIBLE);
                                System.out.println(value);
                                loading.stop();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });


    }
}