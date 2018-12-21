package com.bwie.myelm.presenter;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.bwie.myelm.MainActivity;
import com.bwie.myelm.bean.Meau;
import com.bwie.myelm.core.DataCall;
import com.bwie.myelm.model.RequestModel;

public class RequestPresenter {
    private DataCall dataCall;
    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            Meau meau = (Meau) msg.obj;
            if (meau.getCode() == 0){
                dataCall.requestSuccess(meau);
            }else {
                dataCall.requestFail(meau);
            }
        }
    };

    public RequestPresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    public void getRequest(final String url){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Meau data = RequestModel.getData(url);
                Message message = handler.obtainMessage();
                Log.i("aaa1",data.toString());
                message.obj = data;
                handler.sendMessage(message);
            }
        }).start();
    }
    public void unBindCall(){
        this.dataCall = null;
    }
}
