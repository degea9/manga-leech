package manga.android.tuandang.com.manga.storydetail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;
import manga.android.tuandang.com.manga.base.BaseFragment;
import manga.android.tuandang.com.manga.data.model.Story;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryDetailFragment extends BaseFragment {
    public static final String STORY_OBJECT_KEY = "story_object_key";
    //view
    @Bind(R.id.ivThumbnail)
    ImageView ivThumbnail;
    @Bind(R.id.tvTittle)
    TextView tvTittle;
    @Bind(R.id.tvAuthor)
    TextView tvAuthor;
    @Bind(R.id.tvStatus)
    TextView tvStatus;
    @Bind(R.id.tvViewCount)
    TextView tvViewCount;
    @Bind(R.id.tvGenre)
    TextView tvGenre;
    @Bind(R.id.tvDescription)
    TextView tvDescription;


    public StoryDetailFragment() {
        // Required empty public constructor
    }

    public static StoryDetailFragment newInstance(Story story){
        StoryDetailFragment fragment = new StoryDetailFragment();
        Bundle arg = new Bundle();
        arg.putSerializable(STORY_OBJECT_KEY,story);
        fragment.setArguments(arg);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_story_detail, container, false);
        ButterKnife.bind(this,view);
        displayInfo();
        return view;
    }

    private void displayInfo() {
        if(getArguments()!=null) {
            Story story = (Story) getArguments().getSerializable(STORY_OBJECT_KEY);
            Picasso.with(getContext()).load(story.getThumbnail()).resize(80, 80).centerInside().into(ivThumbnail);
            tvTittle.setText(story.getTitle());
            tvAuthor.setText(story.getAuthor());
            tvStatus.setText(story.getStatus());
            tvViewCount.setText(""+story.getViewcount());
            tvGenre.setText(story.getGenre());
            tvDescription.setText(story.getDescription());
        }
    }

}
