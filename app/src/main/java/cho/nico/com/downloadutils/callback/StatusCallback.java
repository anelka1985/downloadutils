package cho.nico.com.downloadutils.callback;

import cho.nico.com.downloadutils.network.DownloadTask;

/**
 * 下载任务 通知下载管理器的 回调接口
 */
public interface StatusCallback<T> {

    void connectSuccess(T t);

    void connectFailed(T t);

    void downloading(T t);

    void downloadFinish(T t);

    void downloadPause(T t);

    void downloadCancel(T t);

    void downloadFailed(T t);
}
