package manga.android.tuandang.com.manga.chapterdetail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import manga.android.tuandang.com.manga.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImagePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImagePageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String IMAGE_PARAM = "image_src";

    // TODO: Rename and change types of parameters
    private String mParam1;
    @Bind(R.id.image_page)
    ImageView ivPage;


    public ImagePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param Parameter
     * @return A new instance of fragment ImagePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImagePageFragment newInstance(String param) {
        ImagePageFragment fragment = new ImagePageFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(IMAGE_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_page, container, false);
        ButterKnife.bind(this,view);
        displayImage();
        return view;
    }

    private void displayImage() {
        Picasso.with(getContext()).load(mParam1).into(ivPage);
    }

}
