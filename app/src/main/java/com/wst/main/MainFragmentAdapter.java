package com.wst.main;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.RelativeLayout;

import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.lhh.apst.library.Margins;
import com.wst.R;

/**
 * Created by: BruceChang
 * Date on : 2016/11/17.
 * Time on: 14:14
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:MainActivity的Adapter
 */

public class MainFragmentAdapter extends FragmentStatePagerAdapter implements AdvancedPagerSlidingTabStrip.IconTabProvider, AdvancedPagerSlidingTabStrip.LayoutProvider, AdvancedPagerSlidingTabStrip.TipsProvider {

    public static final int VIEW_FIRST = 0;
    public static final int VIEW_SECOND = 1;
    public static final int VIEW_THIRD = 2;
    public static final int VIEW_FOURTH = 3;
    private FirstFragment mFirstFragment = null;
    private SecondFragment mSecondFragment = null;
    private ThirdFragment mThirdFragment = null;
    private FourthFragment mFourthFragment = null;

    public static final int VIEW_SIZE = 4;

    private int mSize = 0;

    private Context context;

    public MainFragmentAdapter(Context context, FragmentManager fm, int mSize) {
        super(fm);
        this.mSize = mSize;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= 0 && position < VIEW_SIZE) {
            switch (position) {
                case VIEW_FIRST:
                    if (null == mFirstFragment)
                        mFirstFragment = FirstFragment.newInstance("", "");
                    return mFirstFragment;

                case VIEW_SECOND:
                    if (null == mSecondFragment)
                        mSecondFragment = SecondFragment.newInstance("", "");
                    return mSecondFragment;

                case VIEW_THIRD:
                    if (null == mThirdFragment)
                        mThirdFragment = ThirdFragment.newInstance("", "");
                    return mThirdFragment;

                case VIEW_FOURTH:
                    if (null == mFourthFragment)
                        mFourthFragment = FourthFragment.newInstance("", "");
                    return mFourthFragment;
                default:
                    break;
            }
        }
        return null;
    }


    @Override
    public int getCount() {
        return VIEW_SIZE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position >= 0 && position < VIEW_SIZE){
            switch (position){
                case  VIEW_FIRST:
                    return  "导游";
                case  VIEW_SECOND:
                    return  "动态";
                case  VIEW_THIRD:
                    return  "体验";
                case  VIEW_FOURTH:
                    return  "我的";
                default:
                    break;
            }
        }
        return null;
    }

    //AdvancedPagerSlidingTabStrip.IconTabProvider,getPageIcon（展示未选中的图片）
    @Override
    public Integer getPageIcon(int index) {
        if(index >= 0 && index < VIEW_SIZE){
            switch (index){
                case  VIEW_FIRST:
                    return  R.drawable.ic_home_gray;
                case VIEW_SECOND:
                    return  R.drawable.ic_supervisor_account_gray;
                case VIEW_THIRD:
                    return  R.drawable.ic_search_gray;
                case VIEW_FOURTH:
                    return  R.drawable.ic_person_gray;
                default:
                    break;
            }
        }
        return 0;
    }

    //AdvancedPagerSlidingTabStrip.IconTabProvider,getPageSelectIcon（展示选中的图片）
    @Override
    public Integer getPageSelectIcon(int position) {
        if(position >= 0 && position < VIEW_SIZE){
            switch (position){
                case  VIEW_FIRST:
                    return  R.drawable.ic_home_red;
                case VIEW_SECOND:
                    return  R.drawable.ic_supervisor_account_red;
                case VIEW_THIRD:
                    return  R.drawable.ic_search_red;
                case VIEW_FOURTH:
                    return  R.drawable.ic_person_red;
                default:
                    break;
            }
        }
        return 0;
    }
    //AdvancedPagerSlidingTabStrip.IconTabProvider,
    @Override
    public Rect getPageIconBounds(int position) {
        return new Rect(0, 0, mSize, mSize);
    }
//, AdvancedPagerSlidingTabStrip.LayoutProvider
    @Override
    public float getPageWeight(int position) {
        if(position >= 0 && position < VIEW_SIZE){
            switch (position){
                case  VIEW_FIRST:
                    return  0.92f;
                case  VIEW_SECOND:
                    return  1.0f;
                case  VIEW_THIRD:
                    return  1.0f;
                case  VIEW_FOURTH:
                    return  0.92f;
                default:
                    break;
            }
        }
        return 1.0f;
    }
//, AdvancedPagerSlidingTabStrip.LayoutProvider
    @Override
    public int[] getPageRule(int position) {
        if(position >= 0 && position < VIEW_SIZE){
            switch (position){
                case  VIEW_FIRST:
                    return  new int[]{
                            RelativeLayout.ALIGN_PARENT_LEFT};
                case  VIEW_SECOND:
                    return  new int[]{
                            RelativeLayout.ALIGN_PARENT_LEFT};
                case  VIEW_THIRD:
                    return  new int[]{
                            RelativeLayout.ALIGN_PARENT_RIGHT};
                case  VIEW_FOURTH:
                    return  new int[]{
                            RelativeLayout.ALIGN_PARENT_RIGHT};
                default:
                    break;
            }
        }
        return new int[0];
    }
//, AdvancedPagerSlidingTabStrip.LayoutProvider
    @Override
    public Margins getPageMargins(int position) {
        if(position >= 0 && position < VIEW_SIZE){
            switch (position){
                case  VIEW_FIRST:
                    return  new Margins(context.getResources().getDimensionPixelSize(R.dimen.home_bar_icon_margins),0,0,0);
                case VIEW_SECOND:
                    return  null;
                case VIEW_THIRD:
                    return  null;
                case VIEW_FOURTH:
                    return  new Margins(0,0,context.getResources().getDimensionPixelSize(R.dimen.home_bar_icon_margins),0);
                default:
                    break;
            }
        }
        return null;
    }
//, AdvancedPagerSlidingTabStrip.TipsProvider
    @Override
    public int[] getTipsRule(int position) {
        if(position >= 0 && position < VIEW_SIZE){
            switch (position){
                case  VIEW_FIRST:
                    return  new int[]{
                            RelativeLayout.ALIGN_PARENT_LEFT};
                case  VIEW_SECOND:
                    return  new int[]{
                            RelativeLayout.ALIGN_PARENT_LEFT};
                case  VIEW_THIRD:
                    return  new int[]{
                            RelativeLayout.ALIGN_PARENT_RIGHT};
                case  VIEW_FOURTH:
                    return  new int[]{
                            RelativeLayout.ALIGN_PARENT_RIGHT};
                default:
                    break;
            }
        }
        return new int[0];
    }
//, AdvancedPagerSlidingTabStrip.TipsProvider
    @Override
    public Margins getTipsMargins(int position) {
        if(position >= 0 && position < VIEW_SIZE){
            switch (position){
                case VIEW_FIRST:
                    return new Margins(4 *context.getResources().getDimensionPixelSize(R.dimen.psts_dot_m_right), 0, 0, 0);
                default:
                    break;
            }
        }
        return null;
    }
//, AdvancedPagerSlidingTabStrip.TipsProvider
    @Override
    public Drawable getTipsDrawable(int position) {
        return null;
    }
}
