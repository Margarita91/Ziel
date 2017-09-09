package zielabi.icon_worldwide.com.zielabi.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import zielabi.icon_worldwide.com.zielabi.Constants;
import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.ZielAbiApplication;
import zielabi.icon_worldwide.com.zielabi.adapters.StatesAdapter;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityMainBinding;
import zielabi.icon_worldwide.com.zielabi.models.State;
import zielabi.icon_worldwide.com.zielabi.utils.ActivityAnimationUtils;
import zielabi.icon_worldwide.com.zielabi.utils.RecyclerTouchListener;
import zielabi.icon_worldwide.com.zielabi.utils.ZoomCenterItemLayoutManager;

import static java.security.AccessController.getContext;

public class MainActivity extends BaseActivity {
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 2;
    private RecyclerView mStatesRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private FusedLocationProviderClient mFusedLocationClient;
    private String mUserCurrentCityName;
    private ArrayList<State> mUserStatesArrayList = new ArrayList<>();
    private ActivityMainBinding binding;
    public List<State> items = new ArrayList<>();
    private static int START_POSITION = 0;
    private int mLastSelectedPos = 0;
    private StatesAdapter mStatesAdapter;
    private int mItemActualWidth;
    private int offsetX = 0;


    ;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dialog(this);

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
                                if(addresses.get(0).getCountryCode().equalsIgnoreCase("DE")){
                                    initializeCurrentCity( addresses.get(0).getLocality());
                                }

                            }
                        }
                    });
        }

        //States List///
        mStatesRecyclerView= binding.recyclerStates;
        mStatesRecyclerView.setHasFixedSize(true);
        initStates();
        // use a custom zooming layout manager

        binding.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);
                ActivityAnimationUtils.startActivityAnimation(MainActivity.this);
            }
        });
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
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
    private void initStates() {
        // ========== TEST DURATION ========== //
//        min = 50;
//        max = 950;


        int itemsCount = Constants.initStatesList().size();
        int interval = 1;

        // ========== very bad solution, will be replaced in future ========== //
        // copy 1000 times
        for (int j = 0; j < 400; j++) {
//             init objects with correct values
            for (int i = 0; i < itemsCount - 1; i++) {
                items.add(new State(Constants.initStatesList().get(i).getStateName()));
                interval = interval + 1; // eg 30, 60, 90 ...

            }
            interval = 1;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        int itemWidth = dp2px(((int) displayMetrics.widthPixels) / 5);
        int itemMarginLeft = dp2px(1);
        int itemMarginRight = dp2px(1);

        mItemActualWidth = itemWidth + itemMarginLeft + itemMarginRight;

        mStatesAdapter = new StatesAdapter(this, items);
        mStatesRecyclerView = binding.recyclerStates;
        mStatesRecyclerView.setAdapter(mStatesAdapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mStatesRecyclerView.setLayoutManager(layoutManager);

        START_POSITION = (items.size() / 2) - 2;
        items.get(START_POSITION + 2).setMagic(true);
        if (START_POSITION > 0) {

            mStatesRecyclerView.scrollToPosition(START_POSITION);

            int someItemsX = START_POSITION * mItemActualWidth;
            int correctX = someItemsX + mItemActualWidth / 2;
            offsetX = correctX;
        } else {
            offsetX = mItemActualWidth / 2;
        }

        mStatesAdapter.setOnDataChangeListener(new StatesAdapter.OnDataChangeListener() {

            @Override
            public void onDataChanged(int position) {
                {
                    if (position != -1) {


                    }
                }
            }
        });

        mStatesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    layoutManager.scrollToPositionWithOffset(mLastSelectedPos - 2, 5); // 8 is experimental value


                }
            }
        });
        mStatesRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mStatesRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                mStatesRecyclerView.smoothScrollToPosition(position);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        mStatesRecyclerView.addOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        offsetX = offsetX + dx;
                        int pos = (offsetX / mItemActualWidth) + 2;
                        if (mLastSelectedPos != pos) {
//                    if(items.size()<8) {
//                        return;
//                    }
                            items.get(pos).setMagic(true);
                            items.get(mLastSelectedPos).setMagic(false); // this is last position
                            if (!mStatesRecyclerView.isComputingLayout()) {
                                mStatesAdapter.notifyDataSetChanged();

                            }


                            mLastSelectedPos = pos;

                        }

                        //System.out.println("current = " + mLastSelectedPos);
                        //System.out.println("******pos = " + pos);

                    }
                }

        );

        // ========== END OF TESTING ========== //
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
