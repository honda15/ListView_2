package com.example.listview_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] idData, lineData, nameData;
    private List<Map<String, Object>> listData;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idData = getResources().getStringArray(R.array.id);
        nameData = getResources().getStringArray(R.array.name);
        lineData = getResources().getStringArray(R.array.line);

        listData = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < idData.length; i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", idData[i]);
            data.put("name", nameData[i]);
            data.put("line", lineData[i]);
            listData.add(data);
        }

        ListView listViewLine = findViewById(R.id.listView_data);
        adapter = new SimpleAdapter(
                this,
                listData,
                R.layout.item_layout,
                new String[]{"id", "name", "line"},
                new int[]{R.id.textView_id, R.id.textview_name, R.id.textView_line}
        );

//        ListView listView = findViewById(R.id.listView); // Make sure to use the correct ID for your ListView
        listViewLine.setAdapter(adapter);
        listViewLine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
                String idNumber = item.get("id").toString();
                String name = item.get("name").toString();
                String line = item.get("line").toString();
                Toast.makeText(MainActivity.this,
                        "Select : " + idNumber + "," + name + "," + line
                        , Toast.LENGTH_SHORT).show();


            }
        });
    }
}
