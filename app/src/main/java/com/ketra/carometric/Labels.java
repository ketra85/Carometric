package com.ketra.carometric;

import com.google.gson.annotations.SerializedName;

public class Labels {
    @SerializedName("label")
    private String label;
    @SerializedName("groupLabel")
    private String groupLabel;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getGroupLabel() {
        return groupLabel;
    }

    public void setGroupLabel(String groupLabel) {
        this.groupLabel = groupLabel;
    }

}
