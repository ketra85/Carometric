package com.ketra.carometric;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Maintenance {
    @SerializedName("Key")
    private String key;
    @SerializedName("Value")
    private List<Labels> values;

    public Maintenance() {
    }

    public Maintenance(String key, List<Labels> values) {
        this.key = key;
        this.values = values;
    }

    private String getKey() {
        return key;
    }

    private void setKey(String key) {
        this.key = key;
    }

    private List<Labels> getValues() {
        return values;
    }

    private void setValues(List<Labels> values) {
        this.values = values;
    }
}
