package com.codepath.instagramviewer.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.instagramviewer.R;
import com.codepath.instagramviewer.models.InstagramPhoto;
import com.makeramen.roundedimageview.RoundedImageView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

/**
 * Created by Shyam Rokde on 1/30/16.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
  public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
    super(context, android.R.layout.simple_list_item_1, objects);
  }

  static class ViewHolderItem {
    ImageView ivProfile;
    ImageView ivPhoto;
    TextView tvCaption;
    TextView tvUsername;
    TextView tvTime;
    TextView tvLikes;
    TextView tvComment;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolderItem viewHolder;
    // Get data
    InstagramPhoto photo = getItem(position);
    // Is Recycle
    if (convertView == null) {
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
      // Set up view holder
      viewHolder = new ViewHolderItem();
      viewHolder.ivProfile = (RoundedImageView) convertView.findViewById(R.id.ivProfile);
      viewHolder.tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
      viewHolder.ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
      viewHolder.tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
      viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
      viewHolder.tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
      viewHolder.tvComment = (TextView) convertView.findViewById(R.id.tvComment);
      // Store view holder with the view
      convertView.setTag(viewHolder);
    }else {
      viewHolder = (ViewHolderItem) convertView.getTag();
    }

    // Profile Picture
    Transformation transformation = new RoundedTransformationBuilder().cornerRadiusDp(25)
        .oval(false)
        .build();
    Picasso.with(getContext()).load(photo.getProfilePicture()).fit().transform(transformation)
        .into(viewHolder.ivProfile);
    // Username
    viewHolder.tvUsername.setText(photo.getUsername());
    // Caption
    viewHolder.tvCaption.setText(photo.getCaption());
    // Image
    viewHolder.ivPhoto.setImageResource(0);

    Picasso.with(getContext())
        .load(photo.getImageUrl())
        .placeholder(R.drawable.ic_picture_240)
        .into(viewHolder.ivPhoto);
    // Relative Time
    viewHolder.tvTime.setText(photo.getCreatedTime());
    // Likes
    viewHolder.tvLikes.setText(String.format("%,d likes", photo.getLikeCount()));
    viewHolder.tvComment.setText(Html.fromHtml(photo.getLatestComment()));
    // Insert Model
    // Return
    return convertView;
  }
}
