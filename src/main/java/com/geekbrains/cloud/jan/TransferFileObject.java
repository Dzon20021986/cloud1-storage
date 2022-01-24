package com.geekbrains.cloud.jan;

import java.io.Serializable;

public class TransferFileObject implements Serializable {
    private String tag;
    private String file;



    public TransferFileObject(String tag, String file) {
        this.tag = tag;
        this.file = file;

    }

    public String getTag() {
        return tag;
    }

    public String getFile() {
        return file;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setFile(String file) {
        this.file = file;
    }


    @Override
    public String toString() {
        return "TransferFileObject{" +
                "tag='" + tag + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
