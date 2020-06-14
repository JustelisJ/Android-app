package com.example.and_exam.Model;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Model{

    private Gson gson;
    private static Model instance;

    private Model()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();
    }

    public static Model getInstance()
    {
        if(instance == null)
            instance = new Model();

        return instance;
    }

    public ArrayList<Meme> getPostsFromReddit()
    {
        String myUrl = "https://www.reddit.com/r/dankmemes/top.json?count=25";
        String result = null;
        ArrayList<Meme> memes = new ArrayList<Meme>();

        HttpGetRequest getRequest = new HttpGetRequest();
        try {
            result = getRequest.execute(myUrl).get();
        } catch (ExecutionException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            result = new JSONObject(result).getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONObject(result).getJSONArray("children");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jsonArray.length() > 0) {
            //memes = (ArrayList<Meme>) Arrays.asList(gson.fromJson(jsonArray.toString(), Meme[].class));
            for(int i = 0; i < jsonArray.length(); i++)
            {

                try {
                    String json = new JSONObject(jsonArray.getString(i)).getString("data");
                    String title = new JSONObject(json).getString("title");
                    String url = new JSONObject(json).getString("url");
                    memes.add(new Meme(title, url));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        return memes;
    }

    public class HttpGetRequest extends AsyncTask<String, Void, String> {
        //Code borrowed from - https://medium.com/@JasonCromer/android-asynctask-http-request-tutorial-6b429d833
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        @Override
        protected String doInBackground(String... params){
            String stringUrl = params[0];
            String result;
            String inputLine;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(stringUrl);
                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();
                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                //Connect to our url
                connection.connect();
                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();
                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();
            }
            catch(IOException e){
                e.printStackTrace();
                result = null;
            }
            return result;
        }
        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }
    }
}