package com.example.myapplication;

//import com.example.listviewwithadapter.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//public class MainActivity extends Activity {
//    // 声明变量
//    ListView listView;
//    ArrayAdapter<String> adapter;
//    // 声明数据源
//    private String[] itemData = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        // TODO Auto-generated method stub
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        listView = (ListView) findViewById(R.id.listview);
//
//        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
//                itemData);
//        listView.setAdapter(adapter);
//
//    }
//
//}
public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    private  FruitAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new FruitAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //在此处理点击事件即可，viewName可以区分是item还是内部控件
                adapter.removeItem(position);
            }
        });
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Start Cart activity
//        final ImageButton cart_button = (ImageButton) findViewById(R.id.cart_button);
//        cart_button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Cart.class);
//                startActivity(intent);
//            }
//        });
//    }
@Override
public boolean onCreateOptionsMenu(Menu menu)
{
    menu.add(1,1,1,"添加");
    menu.add(1,2,2,"删除");
    return super.onCreateOptionsMenu(menu);
}

//    @Override
//    public boolean onOptionsItemSelected(Button item)
//    {
//
//        adapter.removeItem(1);
//        return true;
//    }


    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.apple_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.apple_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.apple_pic);
            fruitList.add(watermelon);
//            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
//            fruitList.add(pear);
//            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
//            fruitList.add(grape);
//            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
//            fruitList.add(pineapple);
//            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
//            fruitList.add(strawberry);
//            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
//            fruitList.add(cherry);
//            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
//            fruitList.add(mango);

        }
    }
}


