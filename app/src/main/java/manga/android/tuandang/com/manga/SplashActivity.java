package manga.android.tuandang.com.manga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import manga.android.tuandang.com.manga.base.BaseActivity;
import manga.android.tuandang.com.manga.mangalist.MangaListActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        navigateTo(MangaListActivity.class);
    }
}
