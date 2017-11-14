package de.enssol.adnan.carouselrecyclerview.item;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;

import com.genius.groupie.Item;

import de.enssol.adnan.carouselrecyclerview.R;
import de.enssol.adnan.carouselrecyclerview.databinding.ItemHeaderBinding;

/**
 * Created by user on 14.11.2017..
 */

public class HeaderItem extends Item<ItemHeaderBinding> {

    @StringRes private int titleStringResId;
    @StringRes private int subtitleStringResId;
    @DrawableRes private int iconResId;

    private View.OnClickListener onClickListener;

    public HeaderItem(@StringRes int titleStringResId) {
        this.titleStringResId = titleStringResId;
    }

    public HeaderItem(@StringRes int titleStringResId, @StringRes int subtitleStringResId) {
        this(titleStringResId, subtitleStringResId, 0, null);
    }

    public HeaderItem(@StringRes int titleStringResId, @StringRes int subtitleStringResId, @DrawableRes int iconResId, View.OnClickListener onClickListener) {
    this.titleStringResId = titleStringResId;
    this.subtitleStringResId = subtitleStringResId;
    this.iconResId = iconResId;
    this.onClickListener = onClickListener;
    }



    @Override
    public int getLayout() {
        return R.layout.item_header;
    }

    @Override
    public void bind(ItemHeaderBinding viewBinding, int position) {
        viewBinding.title.setText(titleStringResId);
        if(subtitleStringResId > 0) {
            viewBinding.subtitle.setText(subtitleStringResId);
        }
        viewBinding.subtitle.setVisibility(subtitleStringResId > 0 ? View.VISIBLE : View.GONE);

        if (iconResId > 0) {
            viewBinding.icon.setImageResource(iconResId);
            viewBinding.icon.setOnClickListener(onClickListener);
        }
        viewBinding.icon.setVisibility(iconResId > 0 ? View.VISIBLE : View.GONE);
    }
}
