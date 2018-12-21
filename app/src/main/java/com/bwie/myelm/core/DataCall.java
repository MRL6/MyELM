package com.bwie.myelm.core;

import com.bwie.myelm.bean.Meau;

public interface DataCall {
    void requestSuccess(Meau meau);
    void requestFail(Meau meau);
}
