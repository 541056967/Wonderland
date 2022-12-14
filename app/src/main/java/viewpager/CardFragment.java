package viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.wonderland.MainActivity;
import com.example.wonderland.R;

import views.memo.MemoActivity;
import views.photoupload.PhotoUploadActivity;

public class CardFragment extends Fragment {

    private CardView mCardView;
    private String title, text;
    private TextView mTitle, mText;
    public Button mBtn;

    public CardFragment() {
        super();
    }

    public CardFragment(String title, String text) {
        super();
        this.title = title;
        this.text = text;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mCardView = (CardView) view.findViewById(R.id.cardView);
        mText = mCardView.findViewById(R.id.card_text);
        mTitle = mCardView.findViewById(R.id.card_title);
        mBtn = mCardView.findViewById(R.id.card_btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (title) {
                    case "天气":
                        intent = new Intent(getActivity(), MainActivity.class);
                        break;
                    case "相册":
                         intent = new Intent(getActivity(), PhotoUploadActivity.class);
                         break;
                    case "纪念日":
                        intent = new Intent(getActivity(), MainActivity.class);
                        break;
                    case "备忘":
                        intent = new Intent(getActivity(), MemoActivity.class);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + title);
                }
                startActivity(intent);
            }
        });
        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * ICardAdapter.MAX_ELEVATION_FACTOR);
        mText.setText(text);
        mTitle.setText(title);
        return view;
    }

    public CardView getCardView() {
        return mCardView;
    }

}
