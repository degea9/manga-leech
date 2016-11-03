package manga.android.tuandang.com.manga.storydetail.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;

/**
 * Created by APC on 11/3/2016.
 */


public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.MyViewHolder> {

    private Map<String, String> chaptersMap;
    private List<String> chaptersName;
    private List<String> chaptersId;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvChapterName)
        public TextView tvChapterName;
        View mView;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }
    }


    public ChaptersAdapter(Map<String, String> chaptersMap) {
        this.chaptersMap = chaptersMap;
        chaptersName = new ArrayList<>(chaptersMap.values());
        chaptersId = new ArrayList<>(chaptersMap.keySet());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String chapterName = chaptersName.get(position);
        holder.tvChapterName.setText(chapterName);
        if (mListener != null) {
            //register listener
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(chaptersId.get(position));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return chaptersName.size();
    }

    public void setListener(ChapterClickListener listener) {
        mListener = listener;
    }

    public ChaptersAdapter.ChapterClickListener mListener;

    public interface ChapterClickListener {
        void onClick(String chapterId);
    }
}
