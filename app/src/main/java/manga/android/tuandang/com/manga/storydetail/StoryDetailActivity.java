package manga.android.tuandang.com.manga.storydetail;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;
import manga.android.tuandang.com.manga.base.BaseActivity;
import manga.android.tuandang.com.manga.data.model.Story;
import manga.android.tuandang.com.manga.storydetail.adapter.ViewPagerAdapter;
import manga.android.tuandang.com.manga.storydetail.fragments.ChapterListFragment;
import manga.android.tuandang.com.manga.storydetail.fragments.StoryDetailFragment;

public class StoryDetailActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;
    Story mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        ButterKnife.bind(this);
        setUpView();
    }

    private void setUpView() {
        setSupportActionBar(toolbar);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        if (getIntent() != null) {
            mStory = (Story) getIntent().getSerializableExtra(StoryDetailFragment.STORY_OBJECT_KEY);
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(StoryDetailFragment.newInstance(mStory), getString(R.string.intro));
            adapter.addFragment(ChapterListFragment.newInstance(mStory), getString(R.string.chapters));
            //adapter.addFragment(new ThreeFragment(), "THREE");
            viewPager.setAdapter(adapter);
        }
    }
}
