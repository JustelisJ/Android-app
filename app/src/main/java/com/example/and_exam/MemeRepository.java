package com.example.and_exam;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MemeRepository {

    private MemeDao memeDao;
    private static MemeRepository instance;
    private LiveData<List<Meme>> allMemes;

    private MemeRepository(Application application){
        MemeDatabase database = MemeDatabase.getInstance(application);
        memeDao = database.memeDao();
        allMemes = memeDao.getAllMemes();
    }

    public static synchronized MemeRepository getInstance(Application application)
    {
        if(instance == null)
            instance = new MemeRepository(application);
        return instance;
    }

    public LiveData<List<Meme>> getAllMemes(){
        return allMemes;
    }

    public void insert(Meme meme) {
        memeDao.addNewFavorite(meme);
    }

    public void deleteAllNotes(Meme meme){
        memeDao.deleteFavorite(meme);
    }


    private static class InsertNoteAsync extends AsyncTask<Meme,Void,Void> {
        private MemeDao noteDao;

        private InsertNoteAsync(MemeDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Meme... notes) {
            noteDao.addNewFavorite(notes[0]);
            return null;
        }
    }

}



