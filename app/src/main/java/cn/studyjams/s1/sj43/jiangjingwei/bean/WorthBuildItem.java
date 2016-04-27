package cn.studyjams.s1.sj43.jiangjingwei.bean;

/**
 * Created by David on 2016/4/26.
 */
public class WorthBuildItem {
    public int imageId;
    public String name;
    public String introduce;

    public WorthBuildItem(int imageId, String name, String introduce) {
        this.imageId = imageId;
        this.name = name;
        this.introduce = introduce;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getIntroduce() {
        return introduce;
    }
}
