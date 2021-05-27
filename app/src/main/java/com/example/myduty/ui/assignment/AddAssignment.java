package com.example.myduty.ui.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import android.widget.SeekBar;

import com.example.myduty.R;

public class AddAssignment extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    EditText course;
    EditText topic;
    EditText deadline;
    EditText description;
    SeekBar priority;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);
        course = findViewById(R.id.form_course);
        topic = findViewById(R.id.form_topic);
        deadline = findViewById(R.id.form_deadline);
        description = findViewById(R.id.form_description);
        priority = findViewById(R.id.form_priority);
        save = findViewById(R.id.form_btn_save);

        save.setOnClickListener(view ->{
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(course.getText().toString())){
                setResult(RESULT_CANCELED,replyIntent);
            }
            else
            {
                String aCourse = course.getText().toString();
                String aTopic = topic.getText().toString();
                String aDeadline = deadline.getText().toString();
                String aDescription = description.getText().toString();
                int aPriority = priority.getProgress();
                replyIntent.putExtra(EXTRA_REPLY,aCourse);
                replyIntent.putExtra("aTopic",aTopic);
                replyIntent.putExtra("aDeadline",aDeadline);
                replyIntent.putExtra("aPriority",aPriority);
                replyIntent.putExtra("aDescription",aDescription);


                setResult(RESULT_OK,replyIntent);
                Log.d("Debag", "message");
            }
            finish();
        });
    }
}