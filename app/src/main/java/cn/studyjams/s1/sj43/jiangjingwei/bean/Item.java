package cn.studyjams.s1.sj43.jiangjingwei.bean;

/**
 * Created by David on 2016/4/25.
 */
public class Item {
    private int iconId;
    private String advantage;
    private String disadvantage;
    private String evaluate;
    private String remark;

    public Item(int iconId, String advantage, String disadvantage, String evaluate, String remark) {
        this.iconId = iconId;
        this.advantage = advantage;
        this.disadvantage = disadvantage;
        this.evaluate = evaluate;
        this.remark = remark;
    }

    public int getIconId() {
        return iconId;
    }

    public String getAdvantage() {
        return advantage;
    }

    public String getDisadvantage() {
        return disadvantage;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public String getRemark() {
        return remark;
    }
}
