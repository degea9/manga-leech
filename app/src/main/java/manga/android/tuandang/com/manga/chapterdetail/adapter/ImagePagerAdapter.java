package manga.android.tuandang.com.manga.chapterdetail.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import manga.android.tuandang.com.manga.chapterdetail.ImagePageFragment;

/**
 * Created by APC on 11/4/2016.
 */

public class ImagePagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mImagePaths;
    public ImagePagerAdapter(FragmentManager fm,List<String> imagePaths) {
        super(fm);
        this.mImagePaths = imagePaths;
    }


    @Override
    public Fragment getItem(int position) {
        return ImagePageFragment.newInstance(mImagePaths.get(position));
    }

    @Override
    public int getCount() {
        return mImagePaths.size();
    }
}