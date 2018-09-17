package cho.nico.com.downloadutils.callback;

public interface ConnectCallback {

    public void connectsuccess(boolean supportranges);

    public void connectfailed(int type);
}
