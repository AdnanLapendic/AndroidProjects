package de.enssol.adnan.carouselrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;

import com.genius.groupie.GroupAdapter;
import com.genius.groupie.Section;

import de.enssol.adnan.carouselrecyclerview.databinding.ActivityMainBinding;
import de.enssol.adnan.carouselrecyclerview.decoration.CarouselItemDecoration;
import de.enssol.adnan.carouselrecyclerview.decoration.HeaderItemDecoration;
import de.enssol.adnan.carouselrecyclerview.item.CarouselCardItem;
import de.enssol.adnan.carouselrecyclerview.item.CarouselItem;
import de.enssol.adnan.carouselrecyclerview.item.HeaderItem;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private GroupAdapter mGroupAdapter;
    private GridLayoutManager mLayoutManager;

    private int[] mRainbow;

    int mGray;
    int mBetweenPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mGray = ContextCompat.getColor(this, R.color.cardview_dark_background);
        mBetweenPadding = getResources().getDimensionPixelOffset(R.dimen.padding_small);
        mRainbow = getResources().getIntArray(R.array.rainbow);

        mGroupAdapter = new GroupAdapter();
        mGroupAdapter.setSpanCount(12);
        populateAdapter();
        mLayoutManager = new GridLayoutManager(this, mGroupAdapter.getSpanCount());
        mLayoutManager.setSpanSizeLookup(mGroupAdapter.getSpanSizeLookup());

        final RecyclerView recyclerView = mBinding.recyclerView;
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mGroupAdapter);

    }

    private void populateAdapter() {
        //Horizontal carousel
        Section carouselSection = new Section(new HeaderItem(R.string.carousel, R.string.carousel_subtitle));
        CarouselItem carouselItem = makeCarouselItem();
        carouselSection.add(carouselItem);
        mGroupAdapter.add(carouselItem);
        mGroupAdapter.add(carouselItem);
        mGroupAdapter.add(carouselItem);
    }

    private CarouselItem makeCarouselItem() {
        CarouselItemDecoration carouselItemDecoration = new CarouselItemDecoration(mGray, mBetweenPadding);
        GroupAdapter carouselAdapter = new GroupAdapter();
        for (int i = 0; i < 30; i++) {
            carouselAdapter.add(new CarouselCardItem());
        }
        CarouselItem carouselItem = new CarouselItem(carouselItemDecoration);
        carouselItem.setAdapter(carouselAdapter);
        return carouselItem;
    }
}
