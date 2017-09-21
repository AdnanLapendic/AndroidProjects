package com.dmd.lapa.sarajevograd2.fragments;


import android.support.v4.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dmd.lapa.sarajevograd2.Article;
import com.dmd.lapa.sarajevograd2.ArticleDetailActivity;
import com.dmd.lapa.sarajevograd2.Articledb;
import com.dmd.lapa.sarajevograd2.adapter.ArticleListAdapter;
import com.dmd.lapa.sarajevograd2.MainActivity;
import com.dmd.lapa.sarajevograd2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragmentRegija extends ListFragment {

    ArrayList<Article> articles;
    ArrayAdapter<Article> articleAdapter;


    public ListFragmentRegija() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        articles = Articledb.articlesRegija;

        articleAdapter = new ArticleListAdapter(getActivity(), articles);

        setListAdapter(articleAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        launchArticleDetailActivity(position);
    }

    private void launchArticleDetailActivity(int position){
        Article article = (Article) getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
        intent.putExtra(MainActivity.ARTICLE_BODY_EXTRA, article.getBody());
        intent.putExtra(MainActivity.ARTICLE_TITLE_EXTRA, article.getTitle());
        intent.putExtra(MainActivity.ARTICLE_CATEGORY_EXTRA, article.getCategory());
        intent.putExtra(MainActivity.ARTICLE_DATE_EXTRA, article.getDate());
        intent.putExtra(MainActivity.ARTICLE_TIME_EXTRA, article.getTime());
        intent.putExtra(MainActivity.ARTICLE_ID_EXTRA, article.getId());
        intent.putExtra(MainActivity.ARTICLE_IMAGE_EXTRA, article.getImage());

        startActivity(intent);
    }


}
