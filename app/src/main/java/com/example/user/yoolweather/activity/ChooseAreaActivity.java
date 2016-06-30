package com.example.user.yoolweather.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.yoolweather.model.YoolWeatherDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/6/30.
 */
public class ChooseAreaActivity extends Activity {

    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;

    private ProgressDialog progressDialog;
    private TextView titleText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private YoolWeatherDB yoolWeatherDB;
    private List<String> dataList = new ArrayList<String>();

}
