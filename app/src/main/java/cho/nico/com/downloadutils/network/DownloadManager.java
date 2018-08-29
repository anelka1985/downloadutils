package cho.nico.com.downloadutils.network;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

import cho.nico.com.downloadutils.utils.Constant;

public class DownloadManager {

    public ArrayList<DownloadTask>  downloadTasks = new ArrayList<>();

    public LinkedBlockingDeque<DownloadTask> waitingTasks = new LinkedBlockingDeque<>();

    public synchronized  int getCurrentTask(){
        return downloadTasks.size();
    }



    public void startNewtask(DownloadTask downloadTask){
        if(getCurrentTask()< Constant.MAX_TASK_NUM)
        {
            downloadTask.startdownload();
            downloadTasks.add(downloadTask);
        }
        else
        {
            downloadTask.waitdownload();
            waitingTasks.offer(downloadTask);
        }
    }


    public void pauseTask(DownloadTask downloadTask){
        downloadTask.pausedownload();




    }
 }
