package com.example.myduty.ui.assignment;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface AssignmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Assignment assignment);

    @Query("DELETE FROM assign_table")
    void deleteAll();

    @Query("SELECT * FROM assign_table ORDER BY priority DESC")
    LiveData<List<Assignment>> getAlphabetizedWords();

    @Query("DELETE FROM assign_table WHERE idTugas = :idTugas")
    void delete(int idTugas);
}
