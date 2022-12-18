package views.photoupload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wonderland.R;
import com.tangxiaolv.telegramgallery.GalleryActivity;
import com.tangxiaolv.telegramgallery.GalleryConfig;

import java.util.List;

public class PhotoUploadActivity extends AppCompatActivity {

    private TextView mTvUpload;
    private ImageView mIvPre;
    private Button mBtnUploadPhoto;
    private GalleryConfig config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_upload);
        assignViews();
        setListeners();
        config = new GalleryConfig.Build()
                .limitPickPhoto(1)
                .singlePhoto(false)
                .hintOfPick("this is pick hint")
                .filterMimeTypes(new String[]{"image/jpeg"})
                .build();
    }

    private void assignViews() {
        mTvUpload = findViewById(R.id.tv_upload);
        mIvPre = findViewById(R.id.iv_pre);
        mBtnUploadPhoto = findViewById(R.id.btn_upload_photo);
    }

    private void setListeners() {
        mTvUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryActivity.openActivity(PhotoUploadActivity.this, 12, config);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<String> photos = (List<String>) data.getSerializableExtra(GalleryActivity.PHOTOS);
        if (photos != null) {
            Glide.with(this).load(photos.get(0)).into(mIvPre);
        }
    }
}