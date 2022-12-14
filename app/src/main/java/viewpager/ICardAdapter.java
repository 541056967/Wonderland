package viewpager;

import androidx.cardview.widget.CardView;

public interface ICardAdapter {
    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
