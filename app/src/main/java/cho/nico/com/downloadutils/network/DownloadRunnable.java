package cho.nico.com.downloadutils.network;

import android.net.Uri;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import cho.nico.com.downloadutils.bean.DownloadBean;
import cho.nico.com.downloadutils.callback.DownloadCallback;
import cho.nico.com.downloadutils.utils.Constant;

public class DownloadRunnable implements Runnable {


    DownloadBean downloadBean;
    DownloadCallback downloadCallback;
    public HttpURLConnection urlConnection;


    public DownloadRunnable(DownloadBean downloadBean, DownloadCallback downloadCallback) {
        this.downloadBean = downloadBean;
        this.downloadCallback = downloadCallback;
    }




    @Override
    public void run() {

        try {
            URL url = new URL(downloadBean.downloadurl);
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(Constant.connecttimeout);
                urlConnection.setReadTimeout(Constant.readtimeout);

                urlConnection.setRequestMethod("GET");




            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
        }
    }
}
