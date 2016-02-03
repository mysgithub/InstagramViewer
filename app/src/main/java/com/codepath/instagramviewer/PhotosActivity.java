package com.codepath.instagramviewer;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.codepath.instagramviewer.adapters.InstagramPhotosAdapter;
import com.codepath.instagramviewer.models.InstagramPhoto;
import com.codepath.instagramviewer.network.InstagramPhotosClient;

import java.util.ArrayList;

public class PhotosActivity extends AppCompatActivity {

  private ArrayList<InstagramPhoto> photos;
  private InstagramPhotosAdapter aPhotos;
  private SwipeRefreshLayout swipeContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photos);

    photos = new ArrayList<>();

    // 1. Create Adapter
    aPhotos = new InstagramPhotosAdapter(this, photos);
    // 2. Find list view from layout
    ListView lvPhotos = (ListView) findViewById(R.id.lvPhotos);
    // 3. Set Adapter
    lvPhotos.setAdapter(aPhotos);
    // 4. Set Swipe Refresh
    swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
    // Send API Request & get photos
    InstagramPhotosClient client = new InstagramPhotosClient();
    client.fetchPopularPhotos(photos, aPhotos);

    // Setup refresh listener which gets new data loading
    swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        // Send New API Request & get photos
        InstagramPhotosClient client = new InstagramPhotosClient();
        client.fetchPopularPhotos(photos, aPhotos);
        swipeContainer.setRefreshing(false);
      }
    });
  }


}
