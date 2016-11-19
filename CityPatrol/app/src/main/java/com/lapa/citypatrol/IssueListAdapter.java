package com.lapa.citypatrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class IssueListAdapter extends ArrayAdapter<Issue> {


    public IssueListAdapter(Context context, ArrayList<Issue> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Issue issue = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_issue, parent, false);

            viewHolder.issueDescription = (TextView) convertView.findViewById(R.id.listViewDescription);
            viewHolder.issueCategory= (TextView)convertView.findViewById(R.id.listViewCategory);
            viewHolder.issueAddress= (TextView)convertView.findViewById(R.id.listViewAddress);
//            viewHolder.issueLatitude = (TextView)convertView.findViewById(R.id.listViewDate);
            viewHolder.issueImage = (ImageView) convertView.findViewById(R.id.listViewImage);

            convertView.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) convertView.getTag();
        }

        assert issue != null;
        viewHolder.issueDescription.setText(issue.getDescription());
        viewHolder.issueCategory.setText(issue.getCategory());
//        viewHolder.articleDate.setText(issue.getDate());
//        viewHolder.articleTime.setText(issue.getTime());
        viewHolder.issueAddress.setText((issue.getAddress()));
        Picasso.with(getContext()).load(issue.getImageUrl()).into(viewHolder.issueImage);

        return convertView;
    }

    private class ViewHolder{
        TextView issueDescription;
        TextView issueCategory;
        TextView issueAddress;
        TextView articleDate;
        ImageView issueImage;
    }

}
