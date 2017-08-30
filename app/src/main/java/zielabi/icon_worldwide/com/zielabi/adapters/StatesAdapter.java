package zielabi.icon_worldwide.com.zielabi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.models.State;

/**
 * Created by margarita on 24/08/2017.
 */

public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.ViewHolder> {
    private ArrayList<State> mDataset;
    private final OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(State item, int position);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mStateNameTextView;
        public ViewHolder(TextView v) {
            super(v);
            mStateNameTextView = v;
        }
        public void bind(final State item, final OnItemClickListener listener, final int position) {
            mStateNameTextView.setText(item.getStateName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item, position);
                }
            });
        }
    }

    public StatesAdapter(ArrayList<State> myDataset, OnItemClickListener listener) {
        mDataset = myDataset;
        this.mListener = listener;
    }


    @Override
    public StatesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_state, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(mDataset.get(position), mListener, position);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}


