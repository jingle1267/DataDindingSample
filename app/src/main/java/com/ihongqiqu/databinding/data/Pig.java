package com.ihongqiqu.databinding.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.ihongqiqu.databinding.BR;

/**
 * 猪，有标签和重量两个属性
 * <p/>
 * Created by zhenguo on 3/13/16.
 */
public class Pig extends BaseObservable {

    private String label;
    private String weight;

    @Bindable
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        notifyPropertyChanged(BR.label);
    }

    @Bindable
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }
}
