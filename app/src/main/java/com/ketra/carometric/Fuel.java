package com.ketra.carometric;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Fuel {

    @SerializedName("fuelTankAlerte")
    private float fuelTankAlert;
    @SerializedName("residualAutonomy")
    private float residual;
    @SerializedName("fuelLevel")
    private float fuelLevel;
    @SerializedName("fuelTankCapacity")
    private float fuelTankCapacity;
    @SerializedName("instFuelConsumption10")
    private float instFuelConsumption10;
    @SerializedName("instFuelConsumption20")
    private float instFuelConsumption20;
    @SerializedName("instFuelConsumption30")
    private float instFuelConsumption30;
    @SerializedName("instFuelConsumption40")
    private float instFuelConsumption40;
    @SerializedName("instFuelConsumption50")
    private float instFuelConsumption50;
    @SerializedName("instFuelConsumption60")
    private float instFuelConsumption60;

    @SerializedName("fuelTankAlerteLabel")
    private Labels fuelTankLabel;
    @SerializedName("residualAutonomyLabel")
    private Labels residualLabel;
    @SerializedName("fuelLevelLabel")
    private Labels fuelLevelLabel;
    @SerializedName("fuelTankCapacityLabel")
    private Labels fuelTankCapacityLabel;
    @SerializedName("instFuelConsumption10Label")
    private Labels instFuelConsumption10Label;
    @SerializedName("instFuelConsumption20Label")
    private Labels instFuelConsumption20Label;
    @SerializedName("instFuelConsumption30Label")
    private Labels instFuelConsumption30Label;
    @SerializedName("instFuelConsumption40Label")
    private Labels instFuelConsumption40Label;
    @SerializedName("instFuelConsumption50Label")
    private Labels instFuelConsumption50Label;
    @SerializedName("instFuelConsumption60Label")
    private Labels instFuelConsumption60Label;


    public Fuel() {}

    public Labels getFuelTankLabel() {
        return fuelTankLabel;
    }

    public void setFuelTankLabel(Labels labels) {
        this.fuelTankLabel = labels;
    }

    public Labels getResidualLabel() {
        return residualLabel;
    }

    public void setResidualLabel(Labels labels) {
        this.residualLabel = labels;
    }

    public Labels getFuelLevelLabel() {
        return fuelLevelLabel;
    }

    public void setFuelLevelLabel(Labels labels) {
        this.fuelLevelLabel = labels;
    }

    public Labels getFuelTankCapacityLabel() {
        return fuelTankCapacityLabel;
    }

    public void setFuelTankCapacityLabel(Labels labels) {
        this.fuelTankCapacityLabel = labels;
    }

    public Labels getInstFuelConsumption10Label() {
        return instFuelConsumption10Label;
    }

    public void setInstFuelConsumption10Label(Labels labels) {
        this.instFuelConsumption10Label = labels;
    }

    public Labels getInstFuelConsumption20Label() {
        return instFuelConsumption20Label;
    }

    public void setInstFuelConsumption20Label(Labels labels) {
        this.instFuelConsumption20Label = labels;
    }

    public Labels getInstFuelConsumption30Label() {
        return instFuelConsumption30Label;
    }

    public void setInstFuelConsumption30Label(Labels labels) {
        this.instFuelConsumption30Label = labels;
    }

    public Labels getInstFuelConsumption40Label() {
        return instFuelConsumption40Label;
    }

    public void setInstFuelConsumption40Label(Labels labels) {
        this.instFuelConsumption40Label = labels;
    }

    public Labels getInstFuelConsumption50Label() {
        return instFuelConsumption50Label;
    }

    public void setInstFuelConsumption50Label(Labels labels) {
        this.instFuelConsumption50Label = labels;
    }

    public Labels getInstFuelConsumption60Label() {
        return instFuelConsumption60Label;
    }

    public void setInstFuelConsumption60Label(Labels labels) {
        this.instFuelConsumption60Label = labels;
    }

    public float getFuelTankAlert() {
        return fuelTankAlert;
    }

    public void setFuelTankAlert(float fuelTankAlert) {
        this.fuelTankAlert = fuelTankAlert;
    }
    public float getResidual() {
        return residual;
    }

    public void setResidual(float residual) {
        this.residual = residual;
    }
    public float getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(float fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    public float getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(float fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }
    public float getInstFuelConsumption10() {
        return instFuelConsumption10;
    }

    public void setInstFuelConsumption10(float instFuelConsumption10) {
        this.instFuelConsumption10 = instFuelConsumption10;
    }
    public float instFuelConsumption20() {
        return instFuelConsumption20;
    }

    public void setInstFuelConsumption20(float instFuelConsumption20) {
        this.instFuelConsumption20 = instFuelConsumption20;
    }
    public float getInstFuelConsumption30() {
        return instFuelConsumption30;
    }

    public void setInstFuelConsumption30(float instFuelConsumption30) {
        this.instFuelConsumption30 = instFuelConsumption30;
    }
    public float getInstFuelConsumption40() {
        return instFuelConsumption40;
    }

    public void setInstFuelConsumption40(float instFuelConsumption40) {
        this.instFuelConsumption40 = instFuelConsumption40;
    }
    public float getinstFuelConsumption50() {
        return instFuelConsumption50;
    }

    public void setInstFuelConsumption50(float instFuelConsumption50) {
        this.instFuelConsumption50 = instFuelConsumption50;
    }
    public float getInstFuelConsumption600() {
        return instFuelConsumption60;
    }

    public void setInstFuelConsumption60(float instFuelConsumption60) {
        this.instFuelConsumption60 = instFuelConsumption60;
    }

}
