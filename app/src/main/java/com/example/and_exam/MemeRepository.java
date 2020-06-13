package com.example.and_exam;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MemeRepository {

    private MemeDao memeDao;
    private static MemeRepository instance;
    private Model model;

    private MemeRepository(Application application){
        MemeDatabase database = MemeDatabase.getInstance(application);
        memeDao = database.memeDao();
        model = Model.getInstance();
    }

    public static synchronized MemeRepository getInstance(Application application)
    {
        if(instance == null)
            instance = new MemeRepository(application);
        return instance;
    }

    public LiveData<List<Meme>> getAllMemes(){
        try {
            return new GetAllMemesAsync(memeDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Meme> getMayMaysFromReddit()
    {
        return model.getPostsFromReddit();
    }

    public void insert(Meme meme) {
        new AddMemeAsync(memeDao).execute(meme);
    }

    public void deleteAllNotes(Meme meme){
        new DeleteMemeAsync(memeDao).execute(meme);
    }


    private static class AddMemeAsync extends AsyncTask<Meme,Void,Void> {
        private MemeDao memeDao;

        private AddMemeAsync(MemeDao noteDao) {
            this.memeDao = noteDao;
        }

        @Override
        protected Void doInBackground(Meme... memes) {
            memeDao.addNewFavorite(memes[0]);
            Log.i("ass", memes[0].toString());
            return null;
        }
    }

    private static class DeleteMemeAsync extends AsyncTask<Meme,Void,Void> {
        private MemeDao memeDao;

        private DeleteMemeAsync(MemeDao noteDao) {
            this.memeDao = noteDao;
        }

        @Override
        protected Void doInBackground(Meme... memes) {
            memeDao.deleteFavorite(memes[0]);
            return null;
        }
    }

    private static class GetAllMemesAsync extends AsyncTask<Void,Void,LiveData<List<Meme>>> {
        private MemeDao memeDao;

        private GetAllMemesAsync(MemeDao noteDao) {
            this.memeDao = noteDao;
        }

        @Override
        protected LiveData<List<Meme>> doInBackground(Void... voids) {
            return memeDao.getAllMemes();
        }
    }

}



