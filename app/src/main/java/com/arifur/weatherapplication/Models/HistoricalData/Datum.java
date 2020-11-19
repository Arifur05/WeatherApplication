
package com.arifur.weatherapplication.Models.HistoricalData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("rh")
    @Expose
    private Double rh;
    @SerializedName("max_wind_spd_ts")
    @Expose
    private Integer maxWindSpdTs;
    @SerializedName("t_ghi")
    @Expose
    private Double tGhi;
    @SerializedName("max_wind_spd")
    @Expose
    private Integer maxWindSpd;
    @SerializedName("solar_rad")
    @Expose
    private Double solarRad;
    @SerializedName("wind_gust_spd")
    @Expose
    private Integer windGustSpd;
    @SerializedName("max_temp_ts")
    @Expose
    private Integer maxTempTs;
    @SerializedName("min_temp_ts")
    @Expose
    private Integer minTempTs;
    @SerializedName("clouds")
    @Expose
    private Integer clouds;
    @SerializedName("max_dni")
    @Expose
    private Double maxDni;
    @SerializedName("precip_gpm")
    @Expose
    private Integer precipGpm;
    @SerializedName("wind_spd")
    @Expose
    private Double windSpd;
    @SerializedName("slp")
    @Expose
    private Double slp;
    @SerializedName("ts")
    @Expose
    private Integer ts;
    @SerializedName("max_ghi")
    @Expose
    private Integer maxGhi;
    @SerializedName("temp")
    @Expose
    private Double temp;
    @SerializedName("pres")
    @Expose
    private Double pres;
    @SerializedName("dni")
    @Expose
    private Double dni;
    @SerializedName("dewpt")
    @Expose
    private Double dewpt;
    @SerializedName("snow")
    @Expose
    private Integer snow;
    @SerializedName("dhi")
    @Expose
    private Double dhi;
    @SerializedName("precip")
    @Expose
    private Integer precip;
    @SerializedName("wind_dir")
    @Expose
    private Integer windDir;
    @SerializedName("max_dhi")
    @Expose
    private Double maxDhi;
    @SerializedName("ghi")
    @Expose
    private Double ghi;
    @SerializedName("max_temp")
    @Expose
    private Double maxTemp;
    @SerializedName("t_dni")
    @Expose
    private Double tDni;
    @SerializedName("max_uv")
    @Expose
    private Integer maxUv;
    @SerializedName("t_dhi")
    @Expose
    private Double tDhi;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("t_solar_rad")
    @Expose
    private Double tSolarRad;
    @SerializedName("min_temp")
    @Expose
    private Integer minTemp;
    @SerializedName("max_wind_dir")
    @Expose
    private Integer maxWindDir;
    @SerializedName("snow_depth")
    @Expose
    private Object snowDepth;

    public Double getRh() {
        return rh;
    }

    public void setRh(Double rh) {
        this.rh = rh;
    }

    public Integer getMaxWindSpdTs() {
        return maxWindSpdTs;
    }

    public void setMaxWindSpdTs(Integer maxWindSpdTs) {
        this.maxWindSpdTs = maxWindSpdTs;
    }

    public Double getTGhi() {
        return tGhi;
    }

    public void setTGhi(Double tGhi) {
        this.tGhi = tGhi;
    }

    public Integer getMaxWindSpd() {
        return maxWindSpd;
    }

    public void setMaxWindSpd(Integer maxWindSpd) {
        this.maxWindSpd = maxWindSpd;
    }

    public Double getSolarRad() {
        return solarRad;
    }

    public void setSolarRad(Double solarRad) {
        this.solarRad = solarRad;
    }

    public Integer getWindGustSpd() {
        return windGustSpd;
    }

    public void setWindGustSpd(Integer windGustSpd) {
        this.windGustSpd = windGustSpd;
    }

    public Integer getMaxTempTs() {
        return maxTempTs;
    }

    public void setMaxTempTs(Integer maxTempTs) {
        this.maxTempTs = maxTempTs;
    }

    public Integer getMinTempTs() {
        return minTempTs;
    }

    public void setMinTempTs(Integer minTempTs) {
        this.minTempTs = minTempTs;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Double getMaxDni() {
        return maxDni;
    }

    public void setMaxDni(Double maxDni) {
        this.maxDni = maxDni;
    }

    public Integer getPrecipGpm() {
        return precipGpm;
    }

    public void setPrecipGpm(Integer precipGpm) {
        this.precipGpm = precipGpm;
    }

    public Double getWindSpd() {
        return windSpd;
    }

    public void setWindSpd(Double windSpd) {
        this.windSpd = windSpd;
    }

    public Double getSlp() {
        return slp;
    }

    public void setSlp(Double slp) {
        this.slp = slp;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public Integer getMaxGhi() {
        return maxGhi;
    }

    public void setMaxGhi(Integer maxGhi) {
        this.maxGhi = maxGhi;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getPres() {
        return pres;
    }

    public void setPres(Double pres) {
        this.pres = pres;
    }

    public Double getDni() {
        return dni;
    }

    public void setDni(Double dni) {
        this.dni = dni;
    }

    public Double getDewpt() {
        return dewpt;
    }

    public void setDewpt(Double dewpt) {
        this.dewpt = dewpt;
    }

    public Integer getSnow() {
        return snow;
    }

    public void setSnow(Integer snow) {
        this.snow = snow;
    }

    public Double getDhi() {
        return dhi;
    }

    public void setDhi(Double dhi) {
        this.dhi = dhi;
    }

    public Integer getPrecip() {
        return precip;
    }

    public void setPrecip(Integer precip) {
        this.precip = precip;
    }

    public Integer getWindDir() {
        return windDir;
    }

    public void setWindDir(Integer windDir) {
        this.windDir = windDir;
    }

    public Double getMaxDhi() {
        return maxDhi;
    }

    public void setMaxDhi(Double maxDhi) {
        this.maxDhi = maxDhi;
    }

    public Double getGhi() {
        return ghi;
    }

    public void setGhi(Double ghi) {
        this.ghi = ghi;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getTDni() {
        return tDni;
    }

    public void setTDni(Double tDni) {
        this.tDni = tDni;
    }

    public Integer getMaxUv() {
        return maxUv;
    }

    public void setMaxUv(Integer maxUv) {
        this.maxUv = maxUv;
    }

    public Double getTDhi() {
        return tDhi;
    }

    public void setTDhi(Double tDhi) {
        this.tDhi = tDhi;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Double getTSolarRad() {
        return tSolarRad;
    }

    public void setTSolarRad(Double tSolarRad) {
        this.tSolarRad = tSolarRad;
    }

    public Integer getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Integer minTemp) {
        this.minTemp = minTemp;
    }

    public Integer getMaxWindDir() {
        return maxWindDir;
    }

    public void setMaxWindDir(Integer maxWindDir) {
        this.maxWindDir = maxWindDir;
    }

    public Object getSnowDepth() {
        return snowDepth;
    }

    public void setSnowDepth(Object snowDepth) {
        this.snowDepth = snowDepth;
    }

}
