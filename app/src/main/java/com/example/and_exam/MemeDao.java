package com.example.and_exam;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MemeDao {
    @Insert
    void addNewFavorite(Meme meme);

    @Delete
    void deleteFavorite(Meme meme);

    @Query("SELECT * FROM favorites_table")
    LiveData<List<Meme>> getAllMemes();
}
