package com.example.mvvmbasic;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DatabaseRepository {

    private AppDatabase appDatabase;

    DatabaseRepository(Application application) {
        this.appDatabase = AppDatabase.getInstance(application);
    }

    public void insertPerson(Person person) {
        Observable.just(getColorsList()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<String> strings) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private List<String> getColorsList() {

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add("" + i);
        }
        return strings;
    }
}
