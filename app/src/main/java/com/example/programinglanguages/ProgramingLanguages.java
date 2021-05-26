package com.example.programinglanguages;

import android.content.res.TypedArray;

import java.io.Serializable;

public class ProgramingLanguages implements Serializable {
    private  String imageResource;
    private int title;
    private int info;
    public ProgramingLanguages(int title,int info,String imageResource){
        this.title=title;
        this.info=info;
        this.imageResource=imageResource;
    }

    public int getTitle() {
        return title;
    }

    public int getInfo() {
        return info;
    }

    public String getImageResource() {
        return imageResource;
    }
}
