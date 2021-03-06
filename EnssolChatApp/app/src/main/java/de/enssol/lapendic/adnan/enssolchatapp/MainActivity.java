package de.enssol.lapendic.adnan.enssolchatapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabPagerAdapter mTabPagerAdapter;
    private TabLayout mTabLayout;

    private DatabaseReference mUserRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase
        mAuth = FirebaseAuth.getInstance();
        //Initialize toolbar
        mToolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Enssol Chat");

        if (mAuth.getCurrentUser() != null) {

            mUserRef = FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.getCurrentUser().getUid());

        }

        //Tabs
        mViewPager = findViewById(R.id.main_tab_pager);
        mTabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mTabPagerAdapter);

        mTabLayout = findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null) {
        sendToStartActivity();

        } else {

            mUserRef.child("online").setValue("true");
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {

            mUserRef.child("online").setValue(ServerValue.TIMESTAMP);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);

         //Signing out from the app (ending session) and redirecting to start screen
         if(item.getItemId() == R.id.main_logout_btn) {
             FirebaseAuth.getInstance().signOut();
             sendToStartActivity();
         }

         //Open settings screen when user select Account Settings from menu
         if (item.getItemId() == R.id.main_account_settings){

             Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
             startActivity(intent);
         }

         //Open list of all users of this app
         if(item.getItemId() == R.id.main_all_users){
             Intent intent = new Intent(MainActivity.this, UsersActivity.class);
             startActivity(intent);
         }
         return true;
    }

    /**
     * Start StartActivity
     */
    private void sendToStartActivity(){
        Intent intent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(intent);
        finish();
    }
}
