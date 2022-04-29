package edu.illinois.cs.cs124.ay2021.mp.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// MP2 Part 4: Identify relationships between restaurants
public class RelatedRestaurants {
  private Map<String, Map<String, Integer>> restaurantRelationships = new HashMap<>();

  public RelatedRestaurants(
      final List<Restaurant> restaurants, final List<Preference> preferences) {
    // populate the restaurantRelationships map
    for (Restaurant r : restaurants) {
      Map<String, Integer> addToMap = new HashMap<>();
      for (Restaurant j : restaurants) {
        if (j.equals(r)) {
          continue;
        }
        int strength = 0;
        for (Preference p : preferences) {
          if (p.getRestaurantIDs().contains(r.getId()) && p.getRestaurantIDs().contains(j.getId())) {
            strength++;
          }
        }
        if (strength == 0) {
          addToMap.put(j.getId(), null);
        } else {
          addToMap.put(j.getId(), strength);
        }
      }
      restaurantRelationships.put(r.getId(), addToMap);
    }
  }

  public Map<String, Integer> getRelated(final String restaurantID) {
    Map<String, Integer> returnMap = restaurantRelationships.get(restaurantID);
    if (returnMap != null) {
      return returnMap;
    } else {
      return new HashMap<>();
    }
  }
}
