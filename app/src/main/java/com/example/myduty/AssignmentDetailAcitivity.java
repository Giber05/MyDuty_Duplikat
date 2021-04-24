package com.example.myduty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AssignmentDetailAcitivity extends AppCompatActivity {

    TextView course,topic,deadline,description;
    String data1,data2,data3,data4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_detail_acitivity);


        course = findViewById(R.id.details_course);
        topic   = findViewById(R.id.details_topic);
        deadline = findViewById(R.id.details_deadline);
        description = findViewById(R.id.details_description);

        getData();
        setData();
    }

    public void getData()
    {
        data1 = getIntent().getStringExtra("data1");
        data2 = getIntent().getStringExtra("data2");
        data3 = getIntent().getStringExtra("data3");
        data4 = getIntent().getStringExtra("data4");
    }
    private void setData(){
        course.setText(data1);
        topic.setText(data2);
        deadline.setText(data3);
        description.setText(data4);
    }

}