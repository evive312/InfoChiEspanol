package edu.uic.cs478.sp2025.informationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class RestaurantsActivity extends AppCompatActivity {
    private SharedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        viewModel.getShowDetail().observe(this, showDetail -> {
            if (showDetail) {
                showTwoPaneLayout();
            } else {
                showOnePaneLayout();
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_list, ListFragment.newInstance("restaurants"))
                    .commit();
        }
    }

    private void showOnePaneLayout() {
        Fragment detailFragment = getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_detail);

        if (detailFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(detailFragment)
                    .commit();
        }
    }

    private void showTwoPaneLayout() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_detail, new DetailFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_attractions) {
            startActivity(new Intent(this, AttractionsActivity.class));
            finish();
            return true;
        } else if (itemId == R.id.menu_restaurants) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
