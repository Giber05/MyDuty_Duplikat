package com.example.myduty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.myduty.ui.assignment.AssignmentViewModel;

public class AssignmentDetailAcitivity extends AppCompatActivity {
    AssignmentViewModel assignmentViewModel;
    TextView course,topic,deadline,description;
    int idTugas;
    Button done;
    String data1,data2,data3,data4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_detail_acitivity);

        course = findViewById(R.id.details_course);
        topic   = findViewById(R.id.details_topic);
        deadline = findViewById(R.id.details_deadline);
        description = findViewById(R.id.details_description);
        done = findViewById(R.id.details_button);

        getData();
        setData();
        assignmentViewModel = new ViewModelProvider(this).get(AssignmentViewModel.class);

        done.setOnClickListener(View->{

            assignmentViewModel.delete(idTugas); //id tugas null
            Log.d("Debag", String.valueOf(idTugas));
            finish();
        });
    }

    public void getData()
    {
        data1 = getIntent().getStringExtra("data1");
        data2 = getIntent().getStringExtra("data2");
        data3 = getIntent().getStringExtra("data3");
        data4 = getIntent().getStringExtra("data4");
        idTugas = getIntent().getIntExtra("idTugas",1);
    }
    private void setData(){
        course.setText(data1);
        topic.setText(data2);
        deadline.setText(data3);
        description.setText(data4);
    }

}