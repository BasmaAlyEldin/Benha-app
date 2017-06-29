package com.example.basma.universitydb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CourseUpdate extends AppCompatActivity {
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_update);

        Bundle b=getIntent().getExtras();

        if(b !=null)
        {
            type=b.getString("type");

        }
    }
}
