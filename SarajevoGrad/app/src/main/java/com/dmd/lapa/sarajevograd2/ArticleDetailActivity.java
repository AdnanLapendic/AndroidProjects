package com.dmd.lapa.sarajevograd2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dmd.lapa.sarajevograd2.fragments.ArticleViewFragment;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        createAndAddFragment();
    }


    private void createAndAddFragment(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ArticleViewFragment articleViewFragment = new ArticleViewFragment();
        setTitle(R.string.viewFragmentTitle);
        fragmentTransaction.add(R.id.article_detail_container, articleViewFragment, "ARTICLE_VIEW_FRAGMENT");

        fragmentTransaction.commit();
    }

}
