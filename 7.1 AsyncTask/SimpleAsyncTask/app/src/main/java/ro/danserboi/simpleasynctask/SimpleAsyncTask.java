package ro.danserboi.simpleasynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {
    private WeakReference<TextView> mTextView;
    private WeakReference<TextView> mResultTextView;
    private WeakReference<ProgressBar> mProgressBar;
    private static final int CHUNK_SIZE = 10;
    private Integer totalTime = null;

    SimpleAsyncTask (TextView tv, TextView result, ProgressBar bar){
        mTextView = new WeakReference<>(tv);
        mResultTextView = new WeakReference<>(result);
        mProgressBar = new WeakReference<>(bar);
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 2000;
        publishProgress(s);
        // Sleep time corresponding to a chunk
        int chunkSize = s / CHUNK_SIZE;
        // Sleep for the random amount of time in chunks
        for (int i = 0; i < CHUNK_SIZE; i++){
            try {
                Thread.sleep(chunkSize);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(((i + 1) * 100) / CHUNK_SIZE);
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }
    protected void onProgressUpdate(Integer... values) {
        if(totalTime == null) {
            mResultTextView.get().setText("Current sleep time: " + values[0] + " ms");
            totalTime = values[0];
        } else {
            mProgressBar.get().setProgress(values[0]);
        }
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}