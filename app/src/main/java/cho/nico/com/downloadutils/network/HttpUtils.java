package cho.nico.com.downloadutils.network;

import java.net.HttpURLConnection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpUtils {


    private static HttpUtils httpUtils;


    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }

        return httpUtils;
    }





    HttpURLConnection connection;

    ExecutorService executorService = Executors.newFixedThreadPool(5);


}
