package manga.android.tuandang.com.manga.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by APC on 11/1/2016.
 */

public class BaseActivity extends AppCompatActivity {
    public void navigateTo(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        finish();
    }
}
