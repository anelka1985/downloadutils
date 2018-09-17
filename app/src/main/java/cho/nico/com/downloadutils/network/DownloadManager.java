package cho.nico.com.downloadutils.network;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cho.nico.com.downloadutils.callback.StatusCallback;
import cho.nico.com.downloadutils.utils.Constant;

public class DownloadManager implements StatusCallback<DownloadTask> {

    public ArrayList<DownloadTask> downloadTasks = new ArrayList<>();

    public LinkedBlockingDeque<DownloadTask> waitingTasks = new LinkedBlockingDeque<>();

    public synchronized int getCurrentTask() {
        return downloadTasks.size();
    }

    private static ThreadPoolExecutor threadPoolExecutor;


    public static ThreadPoolExecutor getThreadPool() {
        if (threadPoolExecutor == null) {
            threadPoolExecutor = new ThreadPoolExecutor(5, 5, 60 * 1000, TimeUnit.NANOSECONDS, new LinkedBlockingDeque<>(5));
        }

        return threadPoolExecutor;
    }

    /**
     * 开始下载
     *
     * @param downloadTask
     */
    public void startNewtask(DownloadTask downloadTask) {



        if (getCurrentTask() < Constant.MAX_TASK_NUM) {
            if (!isExistinqueen(downloadTask)) {
                downloadTask.startdownload();

            } else {
//提示队列已有该任务
            }
        } else {
            downloadTask.waitdownload();
            waitingTasks.offer(downloadTask);
        }
    }

    /**
     * 正在下载队列是否有这个任务
     *
     * @param downloadTask
     * @return
     */
    private boolean isExistinqueen(DownloadTask downloadTask) {
        for (DownloadTask task : downloadTasks) {
            if (TextUtils.equals(task.downloadBean.downloadurl, downloadTask.downloadBean.downloadurl)) {
                return true;
            }
        }

        return false;
    }


    /**
     * 暂停任务
     *
     * @param downloadTask
     */
    public void pauseTask(DownloadTask downloadTask) {
        downloadTask.pausedownload();

    }


    /**
     * 取消任务
     *
     * @param downloadTask
     */
    public void cancelTask(DownloadTask downloadTask) {
        downloadTask.canceldownload();
    }


    /**
     * 暂停全部任务
     */
    public void pauseAlltask() {
    }


    /**
     * 取消全部任务
     */
    public void cancelAlltask() {
    }

    @Override
    public void connectSuccess(DownloadTask downloadTask) {
        downloadTasks.add(downloadTask);
    }

    @Override
    public void connectFailed(DownloadTask downloadTask) {

    }

    @Override
    public void downloading(DownloadTask downloadTask) {

    }

    @Override
    public void downloadFinish(DownloadTask downloadTask) {

    }

    @Override
    public void downloadPause(DownloadTask downloadTask) {

    }

    @Override
    public void downloadCancel(DownloadTask downloadTask) {

    }

    @Override
    public void downloadFailed(DownloadTask downloadTask) {

    }
}
