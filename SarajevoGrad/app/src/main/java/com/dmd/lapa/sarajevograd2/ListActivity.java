package com.dmd.lapa.sarajevograd2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import com.dmd.lapa.sarajevograd2.fragments.ListFragmentBih;
import com.dmd.lapa.sarajevograd2.fragments.ListFragmentRegija;
import com.dmd.lapa.sarajevograd2.fragments.ListFragmentScitech;
import com.dmd.lapa.sarajevograd2.fragments.ListFragmentSport;
import com.dmd.lapa.sarajevograd2.fragments.ListFragmentSvijet;
import com.dmd.lapa.sarajevograd2.fragments.ListFragmentVijesti;
import com.dmd.lapa.sarajevograd2.fragments.ListFragmentZanimljivosti;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    private void createAndAddFragment(ListFragment articles){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.activity_list, articles, "ARTICLE_VIEW_FRAGMENT");
        fragmentTransaction.commit();
    }
}
