package com.me.simplehabit.data.vos;

import com.google.gson.annotations.SerializedName;

public class TopicVO {

    @SerializedName("topic-name")
    private String topicName;

    @SerializedName("topic-desc")
    private String topicDesc;

    @SerializedName("icon")
    private String icon;

    @SerializedName("background")
    private String background;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

}
