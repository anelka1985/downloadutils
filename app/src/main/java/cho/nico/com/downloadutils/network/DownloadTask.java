package cho.nico.com.downloadutils.network;

import cho.nico.com.downloadutils.bean.DownloadBean;
import cho.nico.com.downloadutils.callback.ConnectCallback;
import cho.nico.com.downloadutils.callback.DownloadCallback;
import cho.nico.com.downloadutils.utils.Constant;

public class DownloadTask implements DownloadCallback{

    public DownloadBean downloadBean;

    public DownloadTask(DownloadBean downloadBean) {

        this.downloadBean = downloadBean;

    }


    public void initdownloadstatus(DownloadBean downloadBean) {

    }

    public void connect() {
        downloadBean.downloadstatus = Constant.download_connect;
        DownloadManager.getThreadPool().execute(new ConnectRunnable(downloadBean, this));
    }

    public void startdownload() {
        downloadBean.downloadstatus = Constant.download_downloading;
        DownloadManager.getThreadPool().execute(new DownloadRunnable(downloadBean,this));

    }

    public void pausedownload() {
        downloadBean.downloadstatus = Constant.download_pause;
    }

    public void canceldownload() {
        downloadBean.downloadstatus = Constant.download_cancel;
    }

    public void finishdownload() {
        downloadBean.downloadstatus = Constant.download_finish;
    }

    public void waitdownload() {
    }


    @Override
    public void donwloadsuccess() {

    }

    @Override
    public void downloadprogress(int progress) {

    }

    @Override
    public void downloadfailed(int type) {

    }

    @Override
    public void connectsuccess(boolean supportranges) {

        if(supportranges)
        {
            startdownload();
        }
        else
        {
            startdownload();
        }
    }

    @Override
    public void connectfailed(int type) {

    }
}
