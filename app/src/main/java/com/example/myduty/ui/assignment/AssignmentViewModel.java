package com.example.myduty.ui.assignment;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AssignmentViewModel extends AndroidViewModel {

    private AssignmentRepository mRepository;

    private final LiveData<List<Assignment>> mAllAssignments;
    public AssignmentViewModel (Application application){
        super(application);
        mRepository = new AssignmentRepository(application);
        mAllAssignments = mRepository.getAllAssignments();
    }

    public LiveData<List<Assignment>> getmAllAssignments(){return mAllAssignments;}

    public void insert(Assignment assignment) {mRepository.insert(assignment);}
    public void delete(int idTugas){mRepository.delete(idTugas);}
}
