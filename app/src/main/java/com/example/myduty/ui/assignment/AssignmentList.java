package com.example.myduty.ui.assignment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myduty.R;
import java.util.ArrayList;
import java.util.Collections;


/**
 * A fragment representing a listRecycleView of Items.
 */
public class AssignmentList extends Fragment {
    private AssignmentViewModel assignmentViewModel;
    ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_assignment_list_list, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecycleView);
//        Collections.sort(assignments);
        AssignmentAdapter adapter = new AssignmentAdapter(new AssignmentAdapter.WordDiff());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        assignmentViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()))
                .get(AssignmentViewModel.class);
        assignmentViewModel.getmAllAssignments().observe(getViewLifecycleOwner(),assignments->{
            adapter.submitList(assignments);
        } );
        return view;
    }



}