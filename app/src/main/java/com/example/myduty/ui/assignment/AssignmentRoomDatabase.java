package com.example.myduty.ui.assignment;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Assignment.class},version = 1,exportSchema = false)
public abstract class AssignmentRoomDatabase extends RoomDatabase {

    public abstract AssignmentDao assignmentDao();
    private static volatile AssignmentRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AssignmentRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AssignmentRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AssignmentRoomDatabase.class, "assignment_database").addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                AssignmentDao dao = INSTANCE.assignmentDao();
                dao.deleteAll();

                Assignment assignment = new Assignment("Matematika","Integral","02-April-2021",4,"Cepat bereskan");
                dao.insert(assignment);
                assignment =new Assignment("IPA","Adaptasi","22-April-2021",5,"Yu bisa");
                dao.insert(assignment);
                assignment =new Assignment("IPS","Sistem Kasta","22-April-2021",3,"Pengumpulan via Google Classroom");
                dao.insert(assignment);
                assignment =new Assignment("B.Indonesia","Struktur Kalimat","22-April-2021",1,"Yu bisa");
                dao.insert(assignment);
                assignment =new Assignment("PLH","Kebersihan lingkungan","22-April-2021",2,"Yu bisa");
                dao.insert(assignment);
                assignment =new Assignment("PLH","Kebersihan Sekolah","23-April-2021",1,"Yu bisa");
                dao.insert(assignment);
                assignment =new Assignment("Penjas","PencakSilat","25-April-2021",5,"Yu bisa");
                dao.insert(assignment);
                assignment =new Assignment("B.Inggris","Tenses","25-April-2021",4,"Yu bisa");
                dao.insert(assignment);
                assignment =new Assignment("B.Inggris","Tenses","25-April-2021",4,"Yu bisa");
                dao.insert(assignment);
            });
        }
    };
}
