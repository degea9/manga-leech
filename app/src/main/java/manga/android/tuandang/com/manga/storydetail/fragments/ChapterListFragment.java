package manga.android.tuandang.com.manga.storydetail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;
import manga.android.tuandang.com.manga.base.BaseFragment;
import manga.android.tuandang.com.manga.data.model.Story;
import manga.android.tuandang.com.manga.storydetail.adapter.ChaptersAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChapterListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChapterListFragment extends BaseFragment {
    public static final String STORY_OBJECT_KEY = "story_object_key";
    @Bind(R.id.rvListChapter)
    RecyclerView rvListChapter;

    // TODO: Rename and change types of parameters
    private Story mStory;


    public ChapterListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param story Parameter 1.
     * @return A new instance of fragment ChapterListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChapterListFragment newInstance(Story story) {
        ChapterListFragment fragment = new ChapterListFragment();
        Bundle args = new Bundle();
        args.putSerializable(STORY_OBJECT_KEY, story);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStory = (Story)getArguments().getSerializable(STORY_OBJECT_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_chapter_list, container, false);
        ButterKnife.bind(this,view);
        displayChapters();
        return view;
    }

    private void displayChapters() {
        ChaptersAdapter adapter = new ChaptersAdapter(mStory.getChapters());
        rvListChapter.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvListChapter.setAdapter(adapter);
    }

}
