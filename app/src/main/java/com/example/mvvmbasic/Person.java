package com.example.mvvmbasic;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Random;

@Entity(tableName = "person")
public class Person implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;
    private int age;

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Random random = new Random();
    private static String[] names = {"YU DARVISH", "KEISUKE HONDA", "NAOMI OSAKA", "MICHAEL LEITCH", "SHOHEI OTANI"};
    public Person() {
        name = names[random.nextInt(5)];
        age = R.drawable.ic_launcher_background;
    }
}
