package zielabi.icon_worldwide.com.zielabi.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.models.State;

/**
 * Created by margarita on 25/09/2017.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.DateViewHolder> {
    private ArrayList<State> dateDataList;


    private static final int VIEW_TYPE_PADDING = 1;
    private static final int VIEW_TYPE_ITEM = 2;
    private int paddingWidthDate = 0;

    private int selectedItem = -1;

    public LocationAdapter(ArrayList<State> dateData, int paddingWidthDate) {
        this.dateDataList = dateData;
        this.paddingWidthDate = paddingWidthDate;

    }


    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_state,
                    parent, false);
            return new DateViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_state,
                    parent, false);

            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            layoutParams.width = paddingWidthDate;
            view.setLayoutParams(layoutParams);
            return new DateViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(DateViewHolder holder, int position) {
        State labelerDate = dateDataList.get(position);
        if (getItemViewType(position) == VIEW_TYPE_ITEM) {
            if(labelerDate.getStateName().equals(""))
                holder.tvDate.setText(String.valueOf(""));
            holder.tvDate.setVisibility(View.VISIBLE);

            if (position == selectedItem) {
                holder.tvDate.setTextColor(Color.parseColor("#094673"));
                holder.tvDate.setTextSize(35);

            } else {
                holder.tvDate.setTextColor(Color.GRAY);
                holder.tvDate.setTextSize(35);
            }
        }
    }

    public void setSelecteditem(int selecteditem) {
        this.selectedItem = selecteditem;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dateDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        State labelerDate = dateDataList.get(position);
        if (labelerDate.getStateName().equals("Berlin")) {
            return VIEW_TYPE_PADDING;
        }
        return VIEW_TYPE_ITEM;
    }


    public class DateViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDate;
        public ImageView imgSmall;

        public DateViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.state_name);

        }
    }}