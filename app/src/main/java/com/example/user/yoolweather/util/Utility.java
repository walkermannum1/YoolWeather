package com.example.user.yoolweather.util;

import android.text.TextUtils;

import com.example.user.yoolweather.model.City;
import com.example.user.yoolweather.model.County;
import com.example.user.yoolweather.model.Province;
import com.example.user.yoolweather.model.YoolWeatherDB;

/**
 * Created by user on 2016/6/30.
 */
public class Utility {

    //Resolve and handle data back from server
    public synchronized static boolean handleProvinceResponse(YoolWeatherDB yoolWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p:allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    yoolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCitiesResponse(YoolWeatherDB yoolWeatherDB, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c:allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    yoolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCountiesResponse(YoolWeatherDB yoolWeatherDB, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c:allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    yoolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}
