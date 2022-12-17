package views.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.wonderland.R;

public class WelcomeFragment extends Fragment {

    private ImageView imageView;
    private int drawableResId;

    public WelcomeFragment(int drawableResId) {
        this.drawableResId = drawableResId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome_view, container, false);
        imageView = view.findViewById(R.id.iv_background);
        Glide.with(view).load(drawableResId).into(imageView);
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        return view;
    }

}
