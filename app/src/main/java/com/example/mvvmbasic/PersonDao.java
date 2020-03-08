package com.example.mvvmbasic;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface PersonDao {

    @Query("Select * from person ")
    LiveData<List<Person>> getAll();

    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);
}
