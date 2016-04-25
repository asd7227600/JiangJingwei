package cn.studyjams.s1.sj43.jiangjingwei.bean;

/**
 * Created by David on 2016/4/25.
 */
public class Group {
    private int imageId;
    private String name;
    private String aka;

    public Group(int imageId, String name, String aka) {
        this.imageId = imageId;
        this.name = name;
        this.aka = aka;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getAka() {
        return aka;
    }
}
