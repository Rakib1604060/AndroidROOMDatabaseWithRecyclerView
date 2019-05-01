package com.ourcuet.myapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class NoteRepository {
    private  NoteDao noteDao;
    private android.arch.lifecycle.LiveData<List<Note>>allNotes;

    public  NoteRepository(Application application){
        NoteDataBase dataBase =NoteDataBase.getInstance(application);
        noteDao =dataBase.noteDao();
        allNotes=noteDao.getAllNode();
    }

    public  void insert(Note note){
        new insertTaskAysunctusk( noteDao).execute(note);
    }
    public void update(Note note){
        new updateTaskAysunctusk( noteDao).execute(note);
    }
    public  void delete(Note note){
        new deletetTaskAysunctusk( noteDao).execute(note);
    }
    public  void deleteAll(){
        new deleteAllTaskAysunctusk(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public  static  class  insertTaskAysunctusk extends AsyncTask<Note,Void,Void>{
         private  NoteDao noteDao;
         private  insertTaskAysunctusk ( NoteDao noteDao){
          this.noteDao=noteDao;
         }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.insert(notes[0]);
            return null;
        }
    }


    public  static  class  updateTaskAysunctusk extends AsyncTask<Note,Void,Void>{
        private  NoteDao noteDao;
        private  updateTaskAysunctusk ( NoteDao noteDao){
            this.noteDao=noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.update(notes[0]);
            return null;
        }
    }

    public  static  class  deletetTaskAysunctusk extends AsyncTask<Note,Void,Void>{
        private  NoteDao noteDao;
        private  deletetTaskAysunctusk ( NoteDao noteDao){
            this.noteDao=noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.delete(notes[0]);
            return null;
        }
    }

    public  static  class  deleteAllTaskAysunctusk extends AsyncTask<Void,Void,Void>{
        private  NoteDao noteDao;
        private  deleteAllTaskAysunctusk ( NoteDao noteDao){
            this.noteDao=noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            noteDao.delete_all();
            return null;
        }
    }
}
