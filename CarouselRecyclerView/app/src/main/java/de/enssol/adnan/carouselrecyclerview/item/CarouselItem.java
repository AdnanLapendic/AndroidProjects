package de.enssol.adnan.carouselrecyclerview.item;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.genius.groupie.GroupAdapter;
import com.genius.groupie.Item;

import de.enssol.adnan.carouselrecyclerview.R;
import de.enssol.adnan.carouselrecyclerview.databinding.ItemCarouselBinding;
import de.enssol.adnan.carouselrecyclerview.databinding.ItemSquareCardBinding;

/**
 * Created by user on 14.11.2017..
 */

public class CarouselItem extends Item<ItemCarouselBinding>{

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.ItemDecoration carouselDecoration;
    private LinearLayoutManager layoutManager;

    public CarouselItem(RecyclerView.ItemDecoration carouselDecoration) {
        this.carouselDecoration = carouselDecoration;
    }

    @Override
    public int getLayout() {
        return R.layout.item_carousel;
    }

    @Override
    public void bind(ItemCarouselBinding viewBinding, int position) {
        recyclerView =viewBinding.viewRecyclerView; //Find view by id
        layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.removeItemDecoration(carouselDecoration);
        recyclerView.addItemDecoration(carouselDecoration);
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public RecyclerView.ItemDecoration getCarouselDecoration() {
        return carouselDecoration;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setAdapter(GroupAdapter adapter) {
        this.adapter = adapter;
    }
}
