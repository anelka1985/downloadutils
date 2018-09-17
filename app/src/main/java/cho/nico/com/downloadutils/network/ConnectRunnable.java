package cho.nico.com.downloadutils.network;

import android.text.TextUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import cho.nico.com.downloadutils.bean.DownloadBean;
import cho.nico.com.downloadutils.callback.DownloadCallback;
import cho.nico.com.downloadutils.utils.Constant;

public class ConnectRunnable implements Runnable {


    DownloadBean downloadBean;
    DownloadCallback connectCallback;
    public HttpURLConnection urlConnection;

    boolean isConnect;


    public ConnectRunnable(DownloadBean downloadBean, DownloadCallback connectCallback) {
        this.downloadBean = downloadBean;
        this.connectCallback = connectCallback;
    }

    @Override
    public void run() {
        try {
            isConnect = true;
            URL u = new URL(downloadBean.downloadurl);
            urlConnection =
                    (HttpURLConnection) u.openConnection();
            urlConnection.setConnectTimeout(Constant.connecttimeout);
            urlConnection.setReadTimeout(Constant.readtimeout);

            urlConnection.setRequestMethod("GET");

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String ranges = urlConnection.getHeaderField("Accept-Ranges");
                if (TextUtils.equals(ranges, "bytes")) {
                    connectCallback.connectsuccess(true);
                } else {
                    connectCallback.connectsuccess(false);
                }
            } else {
                connectCallback.connectfailed(0);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            connectCallback.connectfailed(1);
        } catch (IOException e) {
            e.printStackTrace();
            connectCallback.connectfailed(1);
        } finally {
            isConnect = false;
            urlConnection.disconnect();
        }

    }


    public boolean isConnect() {
        return isConnect;
    }

    public void cancel() {
        Thread.currentThread().interrupt();
    }
}
