package edu.illinois.cs.cs124.ay2021.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.illinois.cs.cs124.ay2021.mp.R;
import edu.illinois.cs.cs124.ay2021.mp.application.EatableApplication;
import edu.illinois.cs.cs124.ay2021.mp.databinding.ActivityRestaurantBinding;
import edu.illinois.cs.cs124.ay2021.mp.models.Restaurant;

// MP2 Part 3: New activity to display restaurant details
public class RestaurantActivity extends AppCompatActivity {
  // Binding to the layout defined in activity_main.xml
  private ActivityRestaurantBinding binding;
  private EatableApplication application;

  @Override
  protected void onCreate(@Nullable final Bundle unused) {
    super.onCreate(unused);

    // Returns the intent that started the activity which is in MainActivity
    Intent startedIntent = getIntent();
    String clicked = startedIntent.getStringExtra("id");

    application = (EatableApplication) getApplication();
    Restaurant clickedRestaurant = application.getClient().getRestaurantForID(clicked);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant);
    binding.name.setText(clickedRestaurant.getName() + ' ' + clickedRestaurant.getCuisine());
  }
}
