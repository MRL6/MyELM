package com.bwie.myelm.model;

import com.bwie.myelm.bean.Meau;
import com.bwie.myelm.htpp.Utils;
import com.google.gson.Gson;

public class RequestModel {
    public static Meau getData(String url){
        Utils httpUtils = Utils.getHttpUtils();
        String s = httpUtils.get(url);
        Gson gson = new Gson();
        Meau meau = gson.fromJson(s, Meau.class);
        return meau;
    }
}
