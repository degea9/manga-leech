package manga.android.tuandang.com.manga.mangalist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;
import manga.android.tuandang.com.manga.data.model.Story;
import manga.android.tuandang.com.manga.utils.LogUtil;

/**
 * Created by APC on 11/1/2016.
 */




public class StoriesAdapter extends FirebaseRecyclerAdapter<Story, StoriesAdapter.StoriesViewHolder> {

    private static final String TAG = StoriesAdapter.class.getSimpleName();
    private Context mContext;

    public StoriesAdapter(Context context, DatabaseReference ref) {
        super(Story.class, R.layout.item_story, StoriesAdapter.StoriesViewHolder.class, ref);
        LogUtil.d(TAG, "ContactsAdapter() ");
        mContext = context;
    }

    public StoriesAdapter(Context context, Query query) {
        super(Story.class, R.layout.item_story, StoriesAdapter.StoriesViewHolder.class, query);
        LogUtil.d(TAG, "ContactsAdapter() ");
        mContext = context;
    }

    @Override
    protected void populateViewHolder(StoriesViewHolder viewHolder, Story story, final int position) {
        //LogUtil.d(TAG, "model.getAvatar " + model.getAvatar());
        //LogUtil.d(TAG, "model.getUsername " + model.getUsername());
        story.printChapterList();
        viewHolder.tvTittle.setText(story.getTitle());
        viewHolder.tvGenre.setText(story.getGenre());
        viewHolder.tvAuthor.setText(story.getAuthor());
        if (story.getThumbnail() != null)
            Picasso.with(mContext).load(story.getThumbnail()).resize(80, 80).centerInside().into(viewHolder.ivThumbnail);

    }

    static class StoriesViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvTittle)
        TextView tvTittle;
        @Bind(R.id.tvGenre)
        TextView tvGenre;
        @Bind(R.id.tvAuthor)
        TextView tvAuthor;
        @Bind(R.id.ivThumbnail)
        ImageView ivThumbnail;

        public StoriesViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}