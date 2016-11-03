package manga.android.tuandang.com.manga;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import manga.android.tuandang.com.manga.base.BaseActivity;
import manga.android.tuandang.com.manga.storylist.StoryListActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        enableOffline();
        navigateTo(StoryListActivity.class);
    }

    private void enableOffline() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference scoresRef = FirebaseDatabase.getInstance().getReference("stories");
        scoresRef.keepSynced(true);
    }
}
