package de.enssol.lapendic.adnan.enssolchatapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 15.11.2017..
 */

public class TabPagerAdapter extends FragmentPagerAdapter{


    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        //Return clicked fragment (Tab)
        switch (position){
            case 0:
                RequestFragment requestFragment = new RequestFragment();
                return requestFragment;
            case 1:
                ChatFragment chatFragment = new ChatFragment();
                return chatFragment;
            case 2:

                FriendsFragment friendsFragment = new FriendsFragment();
                return friendsFragment;

                default:
                    return null;
        }
    }

    //Return number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {
      switch(position){
          case 0:
              return "REQUESTS";
          case 1:
              return "CHATS";
          case 2:
              return "FRIENDS";
              default:
                  return null;
      }
    }
}
