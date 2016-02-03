package com.codepath.instagramviewer.adapters;

import android.content.Context;
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

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // Get data
    InstagramPhoto photo = getItem(position);
    // Is Recycle
    if (convertView == null) {
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
    }
    // UI elements
    ImageView ivProfile = (RoundedImageView) convertView.findViewById(R.id.ivProfile);
    TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
    ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
    TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
    TextView tvTime = (TextView) convertView.findViewById(R.id.tvTime);
    TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
    // Profile Picture
    Transformation transformation = new RoundedTransformationBuilder()
        .cornerRadiusDp(25)
        .oval(false)
        .build();
    Picasso.with(getContext())
        .load(photo.getProfilePicture())
        .fit()
        .transform(transformation)
        .into(ivProfile);
    // Username
    tvUsername.setText(photo.getUsername());
    // Caption
    tvCaption.setText(photo.getCaption());
    // Image
    ivPhoto.setImageResource(0);

    Picasso.with(getContext())
        .load(photo.getImageUrl())
        .into(ivPhoto);
    // Relative Time
    tvTime.setText(photo.getCreatedTime());
    // Likes
    tvLikes.setText(String.format("%d likes", photo.getLikeCount()));

    // Insert Model
    // Return
    return convertView;
  }
}
