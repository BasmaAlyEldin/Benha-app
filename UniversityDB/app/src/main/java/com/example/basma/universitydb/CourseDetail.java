package com.example.basma.universitydb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseDetail extends AppCompatActivity {
    ArrayList<String> arr1;
    String type,coursename;

    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        arr1=new ArrayList<>();
        /*arr1.add("View files");
        arr1.add("View URL");
        arr1.add("View Assignment");
        arr1.add("View exams"); */


        Bundle b=getIntent().getExtras();

        if(b !=null)
        {
           coursename=b.getString("coursename");
        }
        t=(TextView)findViewById(R.id.textView);
        t.setText(coursename);


        final ListView list=(ListView)findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arr1);
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                /*
                type=list.getSelectedItem().toString();
                Intent i=new Intent(CourseDetail.this,CourseUpdate.class);
                i.putExtra("type",type);
                startActivity(i); */
            }
        });
    }
}
