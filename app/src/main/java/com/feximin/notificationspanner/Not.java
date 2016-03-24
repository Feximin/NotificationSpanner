package com.feximin.notificationspanner;

import android.app.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Neo on 16/3/24.
 */
public abstract class Not {

    private int mNid;
    private Object mTargetId;


    private static final Map<Integer, Map<String, Integer>> sTargetNidMap = new HashMap<>();
    private static final AtomicInteger sNidSeed = new AtomicInteger(2 << 10);		//如果nid不变的话需要小于这个初始值
    private static int generateNid() {			//产生通知栏的id
        int nid = sNidSeed.getAndAdd(1);
        return nid;
    }

    public void clear(Object targetId){
        clear(fetchNid(targetId));
    }

    public void clear(int nid){

    }

    public void clear(){

    }

    public abstract Notification publish();

    //有多类Not, 每种not可发布多次，需要以type来区分
    public abstract int getType();

    //需要根据
    private int generateNid(Object targetId){
        int id = fetchNid(targetId);
        if (id <= 0) id = generateNid();
        return id;
    }

    public int getNid(){
        return mNid;
    }


    private int fetchNid(Object targetId){
        Map<String, Integer> map = sTargetNidMap.get(Integer.valueOf(getType()));
        if (map != null && map.containsKey(targetId)){
            int id = map.get(targetId);
            return id;
        }
        return -1;
    }
}
