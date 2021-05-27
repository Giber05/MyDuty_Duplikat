package com.example.myduty.ui.assignment;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class AssignmentRepository {
     private AssignmentDao mAssignmentDao;
     private LiveData<List<Assignment>> mAllAssignments;

     AssignmentRepository(Application application) {
         AssignmentRoomDatabase db = AssignmentRoomDatabase.getDatabase(application);
         mAssignmentDao = db.assignmentDao();
         mAllAssignments = mAssignmentDao.getAlphabetizedWords();
     }

     // Room executes all queries on a separate thread.
     // Observed LiveData will notify the observer when the data has changed.
     LiveData<List<Assignment>> getAllAssignments() {
         return mAllAssignments;
     }

     // You must call this on a non-UI thread or your app will throw an exception. Room ensures
     // that you're not doing any long running operations on the main thread, blocking the UI.
     void insert(Assignment assignment) {
         AssignmentRoomDatabase.databaseWriteExecutor.execute(() -> {
             mAssignmentDao.insert(assignment);
         });
     }

     void delete(int idTugas)
     {
         AssignmentRoomDatabase.databaseWriteExecutor.execute(()->{
             mAssignmentDao.delete(idTugas);
         });
     }
}
