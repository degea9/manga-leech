package manga.android.tuandang.com.manga.storylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;
import manga.android.tuandang.com.manga.base.BaseActivity;
import manga.android.tuandang.com.manga.data.model.Story;
import manga.android.tuandang.com.manga.storylist.adapter.StoriesAdapter;
import manga.android.tuandang.com.manga.storydetail.StoryDetailActivity;
import manga.android.tuandang.com.manga.storydetail.fragments.StoryDetailFragment;

public class StoryListActivity extends BaseActivity {
    @Bind(R.id.rvListManga)
    RecyclerView rvListManga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        ButterKnife.bind(this);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        showProgressDialog(getString(R.string.loading));
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("stories");
        final StoriesAdapter adapter = new StoriesAdapter(this,ref.orderByChild("viewCount").limitToLast(100));
        rvListManga.setLayoutManager(new LinearLayoutManager(this));
        adapter.setListener(mListener);
        rvListManga.setAdapter(adapter);
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                dissmissProgressDialog();
                adapter.unregisterAdapterDataObserver(this);
            }
        });
    }

    private StoriesAdapter.StoryClickListener mListener = new StoriesAdapter.StoryClickListener() {
        @Override
        public void onClick(Story story) {
            Intent intent = new Intent(StoryListActivity.this, StoryDetailActivity.class);
            intent.putExtra(StoryDetailFragment.STORY_OBJECT_KEY,story);
            startActivity(intent);
        }
    };
}
