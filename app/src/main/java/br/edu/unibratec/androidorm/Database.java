package br.edu.unibratec.androidorm;

import android.content.Context;

import ollie.Ollie;

/**
 * Created by felipe on 08/10/16.
 */

public class Database {
    private String DB_NAME = "bajsahdfsjkse";
    private int DB_VERSION = 1;

    public Database(Context context)  {
        Ollie.with(context)
                .setName(DB_NAME)
                .setVersion(DB_VERSION)
                .setLogLevel(Ollie.LogLevel.FULL)
                .setCacheSize(Ollie.DEFAULT_CACHE_SIZE)
                .init();
    }


}
