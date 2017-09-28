package zielabi.icon_worldwide.com.zielabi.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.wx.wheelview.adapter.SimpleWheelAdapter;
import com.wx.wheelview.common.WheelData;
import com.wx.wheelview.util.WheelUtils;
import com.wx.wheelview.widget.WheelView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import zielabi.icon_worldwide.com.zielabi.Constants;
import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.adapters.StatesAdapter;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityMainBinding;
import zielabi.icon_worldwide.com.zielabi.models.State;
import zielabi.icon_worldwide.com.zielabi.utils.ActivityAnimationUtils;

public class MainActivity extends BaseActivity {
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 2;
    private RecyclerView mStatesRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private FusedLocationProviderClient mFusedLocationClient;
    private String mUserCurrentCityName;
    private ArrayList<State> mUserStatesArrayList = new ArrayList<>();
    private ActivityMainBinding binding;
    private WheelView simpleWheelView;
    private SimpleWheelAdapter simpleWheelViewAdapter;

    private ArrayList<WheelData> createDatas() {
        ArrayList<WheelData> list = new ArrayList<WheelData>();
        WheelData item;
        for (int i = 0; i < Constants.initStatesList().size(); i++) {
            item = new WheelData();
            item.setName(Constants.initStatesList().get(i).getStateName());
            list.add(item);
        }

        return list;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dialog(this);

        simpleWheelViewAdapter =new SimpleWheelAdapter(this);
        simpleWheelView = (WheelView) findViewById(R.id.simple_wheelview);
        simpleWheelView.setWheelAdapter(simpleWheelViewAdapter);
        simpleWheelView.setWheelSize(13);
        simpleWheelView.setWheelData(createDatas());
        simpleWheelView.setSkin(WheelView.Skin.None);
        simpleWheelView.setLoop(true);
        simpleWheelView.setWheelClickable(true);

        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        style.selectedTextColor = Color.parseColor("#094779");
        style.textColor = Color.parseColor("#094779");
        style.holoBorderWidth=0;
        style.selectedTextSize = 20;
        style.backgroundColor = Color.parseColor("#f2f2f2");;
        simpleWheelView.setStyle(style);

        simpleWheelView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                simpleWheelView.setSelection(i % simpleWheelView.getWheelCount());
                WheelUtils.log("clicked:" + i % simpleWheelView.getWheelCount());
//                simpleWheelView.getAdapter().notify();
               // simpleWheelViewAdapter.notifyDataSetChanged();

            }
        });
        simpleWheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onItemClick(int position, Object o) {
                WheelUtils.log("click:" + position);


            }
        });
        simpleWheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener<WheelData>() {
            @Override
            public void onItemSelected(int position, WheelData data) {
                WheelUtils.log("selected:" + position);
            }
        });
        ///Curent location detection////
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {


            } else {


                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

            }


        } else {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                                List<Address> addresses = null;
                                try {
                                    addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                mUserCurrentCityName = addresses.get(0).getLocality();
                                if (addresses.get(0).getCountryCode().equalsIgnoreCase("DE")) {
                                    initializeCurrentCity(addresses.get(0).getLocality());
                                }

                            }
                        }
                    });
        }

        //States List///
        //   initStates();

        binding.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);
                ActivityAnimationUtils.startActivityAnimation(MainActivity.this);
            }
        });
    }

    public void getRecyclerviewDate() {
        mStatesRecyclerView = binding.recyclerStates;


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    mFusedLocationClient.getLastLocation()
                            .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                                @Override
                                public void onSuccess(Location location) {
                                    if (location != null) {
                                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                                        List<Address> addresses = null;
                                        try {
                                            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        mUserCurrentCityName = addresses.get(0).getAddressLine(0);


                                    }
                                }
                            });
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    void initializeCurrentCity(String mUserCurrentCityName) {
        for (int i = 0; i < mUserStatesArrayList.size(); i++) {

            if (mUserCurrentCityName.equalsIgnoreCase(mUserStatesArrayList.get(i).getStateName())) {


            }
        }
    }

    public void dialog(Context context) {
        float dpi = this.getResources().getDisplayMetrics().density;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.dialog_layout_ok_button, null);
        builder.setView(dialoglayout, (int) (25 * dpi), (int) (25 * dpi), (int) (25 * dpi), (int) (25 * dpi));
        final AlertDialog alert = builder.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert.show();
        ((TextView) dialoglayout.findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });
    }

}
