package com.example.androiappm.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.androiappm.Adapter.CategoryAdapter;
import com.example.androiappm.Adapter.RecommendedAdapter;
import com.example.androiappm.Domain.CategoryDomain;
import com.example.androiappm.Domain.MakeupDomain;
import com.example.androiappm.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();


    }


    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<MakeupDomain> makeuplist = new ArrayList<>();
        makeuplist.add(new MakeupDomain("lipstick", "pic_1", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 130, 5, 20, 20));
        makeuplist.add(new MakeupDomain("eyeliner", "pic_2", "beef, Gouda Cheese, Special sauce, Lettuce, tomato ", 150, 4, 18, 15));
        makeuplist.add(new MakeupDomain("foundation", "pic_3", " olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 110, 3, 16, 8));
        makeuplist.add(new MakeupDomain("gliter eyeliner","gliter1","excellent",250,5,20,17));
        makeuplist.add(new MakeupDomain("mascara","mascara1","excellent",225,4,20,31));
        makeuplist.add(new MakeupDomain("eyebrow pencil","eyepencil","excellent",200,5,20,22));
//        makeuplist.add(new MakeupDomain("concealer","image_9","excellent",300,5,20,12));
//        makeuplist.add(new MakeupDomain("eye shadow","image_13","excellent",220,5,20,11));
//        makeuplist.add(new MakeupDomain("eyelashes","image_27","excellent",50,4,20,24));
//        makeuplist.add(new MakeupDomain("Makeup Brush","image_29","excellent",50,4,20,9));
//        makeuplist.add(new MakeupDomain("Nailpolish","image_28","excellent",40,5,20,15));
//        makeuplist.add(new MakeupDomain("Powder","image_30","excellent",100,5,20,10));

        adapter2 = new RecommendedAdapter(makeuplist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList = findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("lipstick","pic_1"));
        categoryList.add(new CategoryDomain("eyeliner","pic_2"));
        categoryList.add(new CategoryDomain("foundation","pic_3"));
        categoryList.add(new CategoryDomain("mascara","pic_4"));
        categoryList.add(new CategoryDomain("eyebrow pencil","pic_5"));
        categoryList.add(new CategoryDomain("glitter eyeliner","gliter1"));
        categoryList.add(new CategoryDomain("eye shadow","image_13"));
        categoryList.add(new CategoryDomain("Nailpolish","image_19"));
        categoryList.add(new CategoryDomain("Makeup Brush","image_10"));
        categoryList.add(new CategoryDomain("powder","image_24"));
        categoryList.add(new CategoryDomain("Face serum","image_25"));
        categoryList.add(new CategoryDomain("Eyelashes","image_26"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);

    }
}