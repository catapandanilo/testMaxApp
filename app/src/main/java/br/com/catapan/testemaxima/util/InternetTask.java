package br.com.catapan.testemaxima.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.widget.AppCompatImageView;

import br.com.catapan.testemaxima.R;

public class InternetTask extends AsyncTask<Integer, Integer, Void> {

    private Context context;
    private AppCompatImageView imageView;

    public InternetTask(Context context, AppCompatImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }

    private static boolean isConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert manager != null;
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];

        for (int i = 0; i <= max; i++) {
            SystemClock.sleep(3000);
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        imageView.setImageResource(isConnected(this.context) ? R.drawable.ic_maxima_nuvem_conectado : R.drawable.ic_maxima_nuvem_desconectado);
    }
}
