package com.example.and_exam.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MemeDao {
    @Insert
    void addNewFavorite(Meme meme);

    @Delete
    void deleteFavorite(Meme meme);

    @Query("SELECT * FROM favorites_table")
    Meme[] getAllMemes();
}
