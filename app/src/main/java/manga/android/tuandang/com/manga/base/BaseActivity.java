package manga.android.tuandang.com.manga.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

import manga.android.tuandang.com.manga.R;

/**
 * Created by APC on 11/1/2016.
 */

public class BaseActivity extends AppCompatActivity {
    private MaterialDialog mProgressDialog;
    public void showProgressDialog(String message){
        mProgressDialog =new MaterialDialog.Builder(this)
                .content(message)
                .widgetColorRes(R.color.pink)
                .theme(Theme.LIGHT)
                .progress(true, 0)
                .cancelable(false)
                .show();
        mProgressDialog.show();
    }

    public void dissmissProgressDialog(){
        if(mProgressDialog!=null)mProgressDialog.dismiss();
    }
    public void navigateTo(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        finish();
    }
}
