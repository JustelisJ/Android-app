package com.example.and_exam;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.and_exam.Model.Meme;
import com.example.and_exam.Model.MemeDao;
import com.example.and_exam.Model.MemeDatabase;
import com.example.and_exam.Model.Model;

import java.util.ArrayList;
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

    public ArrayList<Meme> getAllMemes(){
        try {
            Meme[] list = new GetAllMemesAsync(memeDao).execute().get();
            ArrayList<Meme> memes = new ArrayList<>();
            for(int i = 0; i < list.length; i++)
            {
                if(list[i] != null)
                    memes.add(list[i]);
            }
            return memes;
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

    private static class GetAllMemesAsync extends AsyncTask<Void,Void, Meme[]> {
        private MemeDao memeDao;

        private GetAllMemesAsync(MemeDao noteDao) {
            this.memeDao = noteDao;
        }

        @Override
        protected Meme[] doInBackground(Void... voids) {
            return memeDao.getAllMemes();
        }
    }

}



