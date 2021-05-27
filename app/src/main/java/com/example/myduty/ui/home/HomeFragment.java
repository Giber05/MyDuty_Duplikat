package com.example.myduty.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myduty.AssignmentDetailAcitivity;
import com.example.myduty.R;
import com.example.myduty.ui.assignment.Assignment;
import com.example.myduty.ui.assignment.AssignmentViewModel;

public class HomeFragment extends Fragment {

    private AssignmentViewModel assignmentViewModel;
    private HomeViewModel homeViewModel;
    private TextView home_deadline;
    private TextView home_course;
    private TextView home_topic;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        home_course =  root.findViewById(R.id.home_course);
        home_deadline= root.findViewById(R.id.home_deadline);
        home_topic= root.findViewById(R.id.home_topic);

        assignmentViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()))
                .get(AssignmentViewModel.class);
        assignmentViewModel.getmAllAssignments().observe(getViewLifecycleOwner(),assignments->{
            Assignment oAssignment = assignments.get(0);
            home_deadline.setText(oAssignment.getDeadline());
            home_course.setText(oAssignment.getCourse());
            home_topic.setText(oAssignment.getTopic());

            LinearLayout home_detail = root.findViewById(R.id.home_detail);
            home_detail.setOnClickListener(View->{
                Intent intent = new Intent(root.getContext(), AssignmentDetailAcitivity.class);
                intent.putExtra("data1",oAssignment.getCourse());
                intent.putExtra("data2",oAssignment.getTopic());
                intent.putExtra("data3",oAssignment.getDeadline());
                intent.putExtra("data4",oAssignment.getDescription());
                intent.putExtra("idTugas",oAssignment.getIdTugas());
                root.getContext().startActivity(intent);
            });
        } );
        return root;
    }
}