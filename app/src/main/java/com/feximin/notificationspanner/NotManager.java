package com.feximin.notificationspanner;

import android.app.NotificationManager;
import android.content.Context;

/**
 * Created by Neo on 16/3/24.
 */
public class NotManager {

    private NotificationManager mNotificationManager;

    private NotManager(){ }

    private static final NotManager INSTANCE = new NotManager();

    public static NotManager getInstance(Context context){
        if (INSTANCE.mNotificationManager == null){
            INSTANCE.mNotificationManager = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return INSTANCE;
    }

    public void publish(Not not){
        mNotificationManager.notify(not.getNid(), not.generateNotMeta().build());
    }

    public void cancel(Not noti){

    }
}
