package tools.txapasta.toolsforproyects.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tools.txapasta.toolsforproyects.R;

/**
 * Created by txapasta on 22/01/2017.
 */

/*
* Show Comic Details in a Fragment.
* */
public class ComicDetailsFragment extends Fragment {
    private static final String ARGUMENT_IMAGE_RES_ID = "imageResId";
    private static final String ARGUMENT_NAME = "name";
    private static final String ARGUMENT_DESCRIPTION = "description";
    private static final String ARGUMENT_URL = "url";

    public ComicDetailsFragment(){}


    public static ComicDetailsFragment newInstance(int imageResId, String name,
                                                       String description, String url) {
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_IMAGE_RES_ID, imageResId);
        args.putString(ARGUMENT_NAME, name);
        args.putString(ARGUMENT_DESCRIPTION, description);
        args.putString(ARGUMENT_URL, url);
        final ComicDetailsFragment fragment = new ComicDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_details,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_comic_cover);
        TextView nameTextView = (TextView) view.findViewById(R.id.tv_comic_title);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.tv_comic_description);

        Bundle args = getArguments();
        imageView.setImageResource(args.getInt(ARGUMENT_IMAGE_RES_ID));
        nameTextView.setText(args.getString(ARGUMENT_NAME));
        final String text = String.format(getString(R.string.description_format), args.getString
                (ARGUMENT_DESCRIPTION), args.getString(ARGUMENT_URL));
        descriptionTextView.setText(text);
        return view;
    }
}
