package manga.android.tuandang.com.manga.chapterdetail;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;
import manga.android.tuandang.com.manga.base.BaseActivity;
import manga.android.tuandang.com.manga.chapterdetail.adapter.ImagePagerAdapter;
import manga.android.tuandang.com.manga.data.model.Chapter;
import manga.android.tuandang.com.manga.storydetail.fragments.ChapterListFragment;
import manga.android.tuandang.com.manga.utils.LogUtil;

public class ChapterDetailActivity extends BaseActivity {
    private static final String TAG = ChapterDetailActivity.class.getSimpleName();
    public static final String CHAPTER_KEY = "chapter_key";
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_detail);
        ButterKnife.bind(this);
        setUpViewPager();
    }

    private void setUpViewPager() {
        if(getIntent()!=null){
            String key = getIntent().getStringExtra(CHAPTER_KEY);
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("chapters").child(key).child("chapters");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Chapter chapter = dataSnapshot.getValue(Chapter.class);
                    LogUtil.d(TAG,"onDataChange chapterUrl: "+chapter.getChapterUrl());
                    LogUtil.d(TAG,"onDataChange storyUrl: "+chapter.getStoryUrl());
                    LogUtil.d(TAG,"onDataChange key: "+dataSnapshot.getKey());
                    List<String> images = chapter.getChapters();
                    ImagePagerAdapter adapter = new ImagePagerAdapter(getSupportFragmentManager(),images);
                    viewPager.setAdapter(adapter);
//                    for(String key:images) {
//                        LogUtil.d(TAG, "onDataChange data key: " + key);
//                        //LogUtil.d(TAG, "onDataChange data value : " + images.get(key));
//                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
