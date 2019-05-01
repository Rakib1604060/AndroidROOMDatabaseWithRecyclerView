package com.ourcuet.myapplication;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Note.class},version = 1)
public abstract class NoteDataBase extends RoomDatabase {

    public  static  NoteDataBase instance;
    public abstract  NoteDao noteDao();

    public  static synchronized NoteDataBase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),NoteDataBase.class,
                    "note_databse").fallbackToDestructiveMigration()
                    .addCallback(roomcallBack)
                    .build();

        }
        return instance;
    }

    private  static  RoomDatabase.Callback roomcallBack=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAysunckTask(instance).execute();
        }
    };

    private static class PopulateDbAysunckTask extends AsyncTask<Void,Void,Void>{
           NoteDao noteDao;
        private  PopulateDbAysunckTask(NoteDataBase noteDataBase){
            this.noteDao=noteDataBase.noteDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {

            noteDao.insert(new Note("Rakib","heasdfloo ",1));
            noteDao.insert(new Note("sakib","heloasdf o ",2));
            noteDao.insert(new Note("Rakib","helasdfoo ",5));
            noteDao.insert(new Note("Rakib","heloo ",2));
            noteDao.insert(new Note("akib","heleqewoo ",3));

            return null;
        }
    }

}
