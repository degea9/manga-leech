package manga.android.tuandang.com.manga.mangalist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;
import manga.android.tuandang.com.manga.base.BaseActivity;
import manga.android.tuandang.com.manga.mangalist.adapter.StoriesAdapter;

public class MangaListActivity extends BaseActivity {
    @Bind(R.id.rvListManga)
    RecyclerView rvListManga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_list);
        ButterKnife.bind(this);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("stories");
        StoriesAdapter adapter = new StoriesAdapter(this,ref);
        rvListManga.setLayoutManager(new LinearLayoutManager(this));
        rvListManga.setAdapter(adapter);
    }
}
