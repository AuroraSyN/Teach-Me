package de.hsworms.inf3032.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.adapters.DetailPagerAdapter;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.sqlite.FavoriteDbController;
import de.hsworms.inf3032.engine.Provider;
import de.hsworms.inf3032.engine.Speech;
import de.hsworms.inf3032.models.favorite.FavoriteModel;
import de.hsworms.inf3032.utility.ActivityUtilities;

public class DetailsActivity extends Provider {
    public static String currentItem;
    public static MenuItem startTest;
    private Activity mActivity;
    private Context mContext;
    private ArrayList<String> mItemList;
    private int mCurrentIndex;
    private ViewPager mViewPager;
    private DetailPagerAdapter mPagerAdapter = null;
    private LinearLayout mLytBottomPanel;
    private ImageButton mBtnPrev, mBtnNext;
    private TextView mTxtCounter;
    private ImageButton mBtnFavorite, mBtnShare, mBtnCopy;
    // Favourites view
    private List<FavoriteModel> mFavoriteList;
    private FavoriteDbController mFavoriteDbController;
    private boolean mIsFavorite = false;
    private Speech mSpeechEngine;
    private boolean mIsTtsPlaying = false;
    private String mTtsText;
    private MenuItem menuItemTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVar();
        initView();
        initFunctionality();
        initListener();
    }

    private void initVar() {
        mActivity = DetailsActivity.this;
        mContext = mActivity.getApplicationContext();

        mFavoriteList = new ArrayList<>();

        Intent intent = getIntent();
        if (intent != null) {
            mCurrentIndex = intent.getIntExtra(AppConstant.BUNDLE_KEY_INDEX, 0);
            mItemList = intent.getStringArrayListExtra(AppConstant.BUNDLE_KEY_ITEM);
        }
    }

    private void initView() {
        setContentView(R.layout.activity_details);

        mTxtCounter = findViewById(R.id.menus_counter);
        mBtnFavorite = findViewById(R.id.menus_fav);
        mBtnShare = findViewById(R.id.menus_share);
        mBtnCopy = findViewById(R.id.menus_copy);

        mViewPager = findViewById(R.id.pager);
        mLytBottomPanel = findViewById(R.id.bottomPanel);
        mBtnPrev = findViewById(R.id.btn_prev);
        mBtnNext = findViewById(R.id.btn_next);

        initLoader();
        initToolbar(false);
        setToolbarTitle(getString(R.string.details_text));
        enableUpButton();
    }

    private void initFunctionality() {
        showLoader();

        mPagerAdapter = new DetailPagerAdapter(mActivity, mItemList);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(mCurrentIndex);

        mTtsText = Html.fromHtml(mItemList.get(mViewPager.getCurrentItem())).toString();

        mFavoriteDbController = new FavoriteDbController(mContext);
        mFavoriteList.addAll(mFavoriteDbController.getAllData());
        isFavorite();

        mSpeechEngine = new Speech(mActivity);

        updateCounter();

        if (mItemList.size() == AppConstant.BUNDLE_KEY_FIRST_INDEX) {
            mLytBottomPanel.setVisibility(View.GONE);
        }
        hideLoader();
    }

    public void initListener() {
        mBtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIsFavorite = !mIsFavorite;
                if (mIsFavorite) {
                    mFavoriteDbController.insertData(mItemList.get(mViewPager.getCurrentItem()));
                    mFavoriteList.add(new FavoriteModel(AppConstant.BUNDLE_KEY_ZERO_INDEX, mItemList.get(mViewPager.getCurrentItem())));
                    Toast.makeText(getApplicationContext(), getString(R.string.added_to_fav), Toast.LENGTH_SHORT).show();
                } else {
                    mFavoriteDbController.deleteEachFav(mItemList.get(mViewPager.getCurrentItem()));
                    for (int i = 0; i < mFavoriteList.size(); i++) {
                        if (mFavoriteList.get(i).getDetails().equals(mItemList.get(mViewPager.getCurrentItem()))) {
                            mFavoriteList.remove(i);
                            break;
                        }
                    }
                    Toast.makeText(getApplicationContext(), getString(R.string.removed_from_fav), Toast.LENGTH_SHORT).show();
                }
                setFavorite();
            }
        });

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String appPackageName = mActivity.getPackageName();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(mItemList.get(mViewPager.getCurrentItem()))
                        + AppConstant.EMPTY_STRING
                        + mActivity.getResources().getString(R.string.share_text)
                        + " https://play.google.com/store/apps/details?id=" + appPackageName);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
            }
        });

        mBtnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Text Label", Html.fromHtml(mItemList.get(mViewPager.getCurrentItem())));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), getString(R.string.copy_to_clipboard), Toast.LENGTH_SHORT).show();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateCounter();
                mIsFavorite = false;
                isFavorite();

                mTtsText = Html.fromHtml(mItemList.get(position)).toString();
                if (mIsTtsPlaying) {
                    toggleTtsPlay(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBtnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - AppConstant.BUNDLE_KEY_FIRST_INDEX);
                updateCounter();
            }
        });
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + AppConstant.BUNDLE_KEY_FIRST_INDEX);
                updateCounter();
            }
        });
    }

    public void isFavorite() {
        for (int i = 0; i < mFavoriteList.size(); i++) {
            if (mFavoriteList.get(i).getDetails().equals(mItemList.get(mViewPager.getCurrentItem()))) {
                mIsFavorite = true;
                break;
            }
        }
        setFavorite();
    }

    public void setFavorite() {
        if (mIsFavorite) {
            mBtnFavorite.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.ic_heart_multiple_white_48dp));
        } else {
            mBtnFavorite.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.ic_heart_outline_white_48dp));
        }
    }

    public void updateCounter() {
        String counter = String.format(getString(R.string.item_counter), mViewPager.getCurrentItem() + AppConstant.BUNDLE_KEY_FIRST_INDEX, mItemList.size());
        mTxtCounter.setText(counter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menus_read_article:
                if (mItemList != null) {
                    toggleTtsPlay(false);
                }
                return true;
            case R.id.start_test:
                currentItem = mItemList.get(mViewPager.getCurrentItem());
                currentItem = currentItem.substring(0, currentItem.indexOf("</h2>"));
                currentItem = currentItem.substring(4);
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, QuestionActivity.class, true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleTtsPlay(boolean isPageScrolledWhilePlaying) {
        if (mIsTtsPlaying & !isPageScrolledWhilePlaying) {
            mSpeechEngine.releaseEngine();
            mIsTtsPlaying = false;
        } else if (mIsTtsPlaying & isPageScrolledWhilePlaying) {
            mSpeechEngine.releaseEngine();
            mSpeechEngine.startEngine(mTtsText);
            mIsTtsPlaying = true;
        } else {
            mSpeechEngine.startEngine(mTtsText);
            mIsTtsPlaying = true;
        }
        toggleTtsView();
    }

    private void toggleTtsView() {
        if (mIsTtsPlaying) {
            menuItemTTS.setTitle(R.string.site_menu_stop_reading);
        } else {
            menuItemTTS.setTitle(R.string.read_post);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSpeechEngine.releaseEngine();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSpeechEngine.releaseEngine();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_details, menu);

        menuItemTTS = menu.findItem(R.id.menus_read_article);
        startTest = menu.findItem(R.id.start_test);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
