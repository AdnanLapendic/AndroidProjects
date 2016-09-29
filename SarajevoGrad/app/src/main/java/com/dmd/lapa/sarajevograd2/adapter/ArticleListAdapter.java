package com.dmd.lapa.sarajevograd2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmd.lapa.sarajevograd2.Article;
import com.dmd.lapa.sarajevograd2.MainActivity;
import com.dmd.lapa.sarajevograd2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lapa on 9/20/16.
 */

public class ArticleListAdapter extends ArrayAdapter<Article> {


    public ArticleListAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Article article = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_article, parent, false);

            viewHolder.articleTitle = (TextView) convertView.findViewById(R.id.listViewTitle);
            viewHolder.articleCategory= (TextView)convertView.findViewById(R.id.listViewCategory);
            viewHolder.articleTime= (TextView)convertView.findViewById(R.id.listViewTime);
            viewHolder.articleDate = (TextView)convertView.findViewById(R.id.listViewDate);
            viewHolder.articleImage = (ImageView) convertView.findViewById(R.id.listViewImage);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.articleTitle.setText(article.getTitle());
        viewHolder.articleCategory.setText(article.getCategory());
        viewHolder.articleDate.setText(article.getDate());
        viewHolder.articleTime.setText(article.getTime());
        Picasso.with(getContext()).load(article.getImage()).into(viewHolder.articleImage);

        return convertView;
    }

    private class ViewHolder{
        TextView articleTitle;
        TextView articleCategory;
        TextView articleTime;
        TextView articleDate;
        ImageView articleImage;
    }

}
