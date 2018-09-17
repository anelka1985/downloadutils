package cho.nico.com.downloadutils.callback;

public interface DownloadCallback {

    public void donwloadsuccess();

    public void downloadprogress(int progress);

    public void downloadfailed(int type);

    public void connectsuccess(boolean supportranges);

    public void connectfailed(int type);
}
