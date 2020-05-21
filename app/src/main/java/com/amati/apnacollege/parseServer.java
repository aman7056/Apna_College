package com.amati.apnacollege;

import android.app.Application;
import com.parse.Parse;

public class parseServer extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("AF2anj0qPnliTMpSeekE4CUgadTrt38qViogoMiI")
                // if defined
                .clientKey("Q9LsXsPZhrqUJRjMZcc3R2thPBzvR2uzyYrQh2CE")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
