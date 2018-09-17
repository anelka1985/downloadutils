package cho.nico.com.downloadutils.utils;

public class Constant {

    public final static int MAX_TASK_NUM = 3;


    /**
     * 0 排队中 ，未进入等待状态
     * 1 等待中，
     * 2 连接中
     * 3 下载中
     * 4 暂停
     * 5 异常中断
     * 6 下载完成
     * 7 等待超时
     *
     */
    public final static int download_connect = 2;

    public final static int download_downloading = 3;

    public final static int download_pause = 4;

    public final static int download_cancel = 5;

    public final static int download_finish = 6;



    public final static int connecttimeout = 15 * 1000;

    public final static int readtimeout = 15 * 1000;

    public enum DOWNLOAD_STATUS  {DOWNLOADING,WAITING,PAUSE,CONNECTING,STOP,COMPLETE};
}
