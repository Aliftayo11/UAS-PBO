package id.ac.poliban.e020320046.fda_e020320046.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import id.ac.poliban.e020320046.fda_e020320046.Domain.CategoryDomain;
import id.ac.poliban.e020320046.fda_e020320046.Domain.FoodDomain;
import id.ac.poliban.e020320046.fda_e020320046.Adaptor.PopluarAdaptor;
import id.ac.poliban.e020320046.fda_e020320046.Adaptor.CatregoryAdaptor;

import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, RecyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("FDAAlif_E020320046");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        BottomNavigation();
    }

    private void BottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.home_Btn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add((new CategoryDomain("Pizza", "cat_1")));
        category.add((new CategoryDomain("Burger", "cat_2")));
        category.add((new CategoryDomain("Hotdog", "cat_3")));
        category.add((new CategoryDomain("Drink", "cat_4")));
        category.add((new CategoryDomain("Dount", "cat_5")));

        adapter = new CatregoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewPopularList = findViewById(R.id.recyclerView2);
        RecyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza", "pop_1", "slices pepperoni,mozzarella cheese,fresh oregano,ground black pepper,pizza sauce", 9.76));
        foodList.add(new FoodDomain("Cheese Burger", "pop_2", "beef, Gouda cheese, Special Sauce,Lettuce,tomato", 8.79));
        foodList.add(new FoodDomain("Vegetable pizza", "pop_3", "olive oil,Vegetable oil,pitted kalamata,cherry tomatoes,fresh oregano,basil", 8.5));

        adapter2 = new PopluarAdaptor(foodList);
        RecyclerViewPopularList.setAdapter(adapter2);


    }
}