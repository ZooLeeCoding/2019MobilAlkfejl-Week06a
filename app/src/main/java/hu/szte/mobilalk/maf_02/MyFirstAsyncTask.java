package hu.szte.mobilalk.maf_02;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MyFirstAsyncTask extends AsyncTask<Void, Void, String> {

    private WeakReference<TextView> textViewWeakReference;

    public MyFirstAsyncTask(TextView tv) {
        textViewWeakReference = new WeakReference<TextView>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
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

    @Override
    protected void onPostExecute(String result) {
        textViewWeakReference.get().setText(result);
    }
}
