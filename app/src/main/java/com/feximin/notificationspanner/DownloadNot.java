package com.feximin.notificationspanner;

import android.content.Context;

/**
 * Created by Neo on 16/3/24.
 */
public class DownloadNot extends Not {


    public DownloadNot(Context context, String url){
        super(context);
        this.mTargetId = url;
        this.mNid = generateNid();
    }

    @Override
    public NotMeta generateNotMeta() {
        NotMeta meta = new NotMeta()
                .content("《太极张三丰》下载完成")
                .title("下载完了")
                .ticker("下载完成，快去看看吧")
                .target(ActivityDownload.class)
                .context(mContext);
        return meta;
    }

    @Override
    public int getType() {
        return 0;
    }

}
