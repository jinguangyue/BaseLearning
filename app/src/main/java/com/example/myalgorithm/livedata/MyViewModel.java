package com.example.myalgorithm.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> data = new MutableLiveData<>();

    // 获取 LiveData 对象
    public LiveData<String> getData() {
        return data;
    }

    // 设置数据到 LiveData 对象中
    public void setData(String value) {
        data.setValue(value);
    }
}
