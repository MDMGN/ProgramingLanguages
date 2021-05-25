package com.example.programinglanguages;

import android.content.res.TypedArray;

import java.io.Serializable;

public class ProgramingLanguages implements Serializable {
    private  String imageResource;
    private int title;
    public ProgramingLanguages(int title,String imageResource){
        this.title=title;
        this.imageResource=imageResource;
    }

    public int getTitle() {
        return title;
    }

    public String getImageResource() {
        return imageResource;
    }
}
