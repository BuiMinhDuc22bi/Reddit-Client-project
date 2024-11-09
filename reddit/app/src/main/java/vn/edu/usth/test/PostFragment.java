package vn.edu.usth.test;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PostFragment extends Fragment {
    private static final String ARG_POST_ID = "postId";
    private static final String ARG_POST_IMAGE = "postImage";
    private static final String ARG_POST_TEXT = "postText";

    private int postId;
    private int postImage;
    private String postText;

    public static PostFragment newInstance(int postId, int postImage, String postText) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POST_ID, postId);
        args.putInt(ARG_POST_IMAGE, postImage);
        args.putString(ARG_POST_TEXT, postText);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            postId = getArguments().getInt(ARG_POST_ID);
            postImage = getArguments().getInt(ARG_POST_IMAGE);
            postText = getArguments().getString(ARG_POST_TEXT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        ImageView postImageView = view.findViewById(R.id.post_image);
        TextView postDetails = view.findViewById(R.id.post_details);

        // Set the image and text based on the provided arguments
        postImageView.setImageResource(postImage);
        postDetails.setText(postText);

        return view;
    }
}