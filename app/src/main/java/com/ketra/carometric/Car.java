package com.ketra.carometric;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Car {
    @SerializedName("vin")
    private String vin;
    @SerializedName("lastUpdate")
    private String lastUpdate;
    @SerializedName("contract")
    private String contract;

    @SerializedName("fuel")
    private Fuel fuel;
//    @SerializedName("maintenance")
//    private List<Maintenance> maintenance;

    public Car() { }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

//    public List<Maintenance> getMaintenance() {
//        return maintenance;
//    }
//
//    public void setMaintenance(List<Maintenance> maintenance) {
//        this.maintenance = maintenance;
//    }



    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setLastUpdate(String lastUpdate){
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getContract() {
        return contract;
    }

    public String toString() { return "Vehicle with vin:" + getVin() + "\n" + "under contract:" + getContract() + "\n" + getFuel() + "\n"; }


}
