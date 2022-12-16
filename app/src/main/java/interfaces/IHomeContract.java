package interfaces;

import java.util.List;

import viewpager.CardFragment;

public interface IHomeContract extends IBaseContract {

    interface IHomeView extends IBaseContract.IBaseView{

        /**
         * 初始化viewPager
         * */
        void initViewPager();

        List<CardFragment> getCardFragments();
    }

    interface IHomePresenter extends IBaseContract.IBasePresenter {

    }
}
