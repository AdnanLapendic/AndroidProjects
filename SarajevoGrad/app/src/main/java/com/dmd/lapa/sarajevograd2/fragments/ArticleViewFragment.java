package com.dmd.lapa.sarajevograd2.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmd.lapa.sarajevograd2.Article;
import com.dmd.lapa.sarajevograd2.ArticleDetailActivity;
import com.dmd.lapa.sarajevograd2.MainActivity;
import com.dmd.lapa.sarajevograd2.R;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleViewFragment extends Fragment {


    public ArticleViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_article_view, container, false);

        TextView title = (TextView)view.findViewById(R.id.articleDetailViewTitle);
        TextView category = (TextView)view.findViewById(R.id.articleDetailViewCategory);
        TextView body = (TextView)view.findViewById(R.id.articleDetailViewBody);
        TextView date = (TextView)view.findViewById(R.id.articleDetailViewDate);
        TextView time = (TextView)view.findViewById(R.id.articleDetailViewTime);
        ImageView image = (ImageView)view.findViewById(R.id.articleDetailViewImage);

        Intent intent = getActivity().getIntent();

            title.setText(intent.getExtras().getString(MainActivity.ARTICLE_TITLE_EXTRA));
            category.setText(intent.getExtras().getString(MainActivity.ARTICLE_CATEGORY_EXTRA));
            body.setText(intent.getExtras().getString(MainActivity.ARTICLE_BODY_EXTRA));
            date.setText(intent.getExtras().getString(MainActivity.ARTICLE_DATE_EXTRA));
            time.setText(intent.getExtras().getString(MainActivity.ARTICLE_TIME_EXTRA));
            Picasso.with(getContext()).load(intent.getExtras().getString(MainActivity.ARTICLE_IMAGE_EXTRA)).into(image);

        // Inflate the layout for this fragment
        return view;
    }

}
