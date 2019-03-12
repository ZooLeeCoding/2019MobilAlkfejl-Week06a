package hu.szte.mobilalk.maf_02;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.Random;

public class SleepLoader extends AsyncTaskLoader<String> {

    public SleepLoader(Context context) {
        super(context);
    }

    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        Random r = new Random();

        int n = r.nextInt(5);
        int seconds = n * 1000;
        try {
            Thread.sleep(seconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return "I slept for " + n + " seconds";
    }
}
