package de.enssol.adnan.carouselrecyclerview.item;

import android.support.annotation.ColorInt;

import com.genius.groupie.Item;

import de.enssol.adnan.carouselrecyclerview.R;
import de.enssol.adnan.carouselrecyclerview.databinding.ItemSquareCardBinding;

/**
 * Created by user on 14.11.2017..
 */

public class CarouselCardItem extends Item<ItemSquareCardBinding> {


   @ColorInt
   private int colorRes;

    @Override
    public int getLayout() {
        return R.layout.item_square_card;
    }

    @Override
    public void bind(ItemSquareCardBinding viewBinding, int position) {
        viewBinding.getRoot().setBackgroundColor(colorRes);
    }
}
