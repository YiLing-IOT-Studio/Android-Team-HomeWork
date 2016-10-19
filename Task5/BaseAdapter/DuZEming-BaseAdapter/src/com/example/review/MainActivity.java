package com.example.review;


import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ZhihuAdapter myAdapter = new ZhihuAdapter(this);

        ListView listView = (ListView) findViewById(R.id.lv_zhihu);

        listView.setAdapter(myAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
				Zhihu zhihu=((List<Zhihu>) ZhihuAdapter.mList).get(i);
				Toast.makeText(MainActivity.this,zhihu.getTitle(), Toast.LENGTH_SHORT).show();

			}
        });


    }

	
}
 