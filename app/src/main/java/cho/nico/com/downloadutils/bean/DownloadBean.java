package cho.nico.com.downloadutils.bean;

public class DownloadBean {

    /**
     * 下载请求地址
     */
    public String downloadurl;


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
    public int downloadstatus;
    /**
     * 本地存放地址
     */
    public String savepath;
    /**
     * 文件名
     */
    public String filename;


    public long filesize;


    public long downloadsize;


}
