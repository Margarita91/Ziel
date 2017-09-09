package zielabi.icon_worldwide.com.zielabi.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.models.State;

/**
 * Created by margarita on 24/08/2017.
 */


import java.util.List;

/**
 * Created by sergeychilingaryan on 12/5/15.
 */
public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.StateViewHolder> {

    Context context;
    List<State> mData;
    OnDataChangeListener mOnDataChangeListener;
    private DisplayMetrics displayMetrics;
    private float dpHeight;
    private float dpWidth;


    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        mOnDataChangeListener = onDataChangeListener;
    }

    public interface OnDataChangeListener {
        public void onDataChanged(int size);
    }

    public StatesAdapter(Context context, List<State> data) {
        this.context = context;
        mData = data;
        displayMetrics = context.getResources().getDisplayMetrics();
        dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        dpWidth = displayMetrics.widthPixels / displayMetrics.density;
    }


    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }


    @Override
    public StateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_state, parent, false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateViewHolder holder, int position) {
        State item = mData.get(position);

        if (item.isMagic()) {
            holder.setSelected(true);
            for (int i = 0; i < mData.size(); ++i) {
                if (!mData.get(i).equals(item)) {
                    mData.get(i).setMagic(false);
                }
            }
        } else {
            holder.setSelected(false);
        }

        holder.mDurationTimeHolder.setText(item.getStateName());


    }


    @Override
    public int getItemCount() {

        return mData.size();
    }

    //========================================================
    //           VIEW HOLDER
    //========================================================
    public class StateViewHolder extends RecyclerView.ViewHolder {
        TextView mDurationTimeHolder;
        View mItemRootView;

        public StateViewHolder(View itemView) {
            super(itemView);
            mItemRootView = itemView;
            mDurationTimeHolder = (TextView) itemView.findViewById(R.id.state_name);
            itemView.setOnClickListener
                    (new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             for (int i = 0; i < mData.size(); ++i) {
                                 mData.get(i).setMagic(false);
                             }
                             if (mOnDataChangeListener != null) {
                                 mOnDataChangeListener.onDataChanged(getAdapterPosition());
                             }
                             if (mData.size() > getAdapterPosition() && getAdapterPosition() != -1) {
                                 mData.get(getAdapterPosition()).setMagic(true);
                                 notifyItemChanged(getAdapterPosition());
                                 notifyDataSetChanged();
                             }
                         }
                     }
                    );


        }


        void setSelected(boolean selected) {
            if (selected) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) mItemRootView.getLayoutParams();

                int left = dp2px(20);

                layoutParams.width = RecyclerView.LayoutParams.MATCH_PARENT;
                layoutParams.height = ((int) displayMetrics.widthPixels) / 5;
                //layoutParams.setMargins(left, 0, 0, 0);
                mItemRootView.setLayoutParams(layoutParams);
                mItemRootView.invalidate();
                mItemRootView.setPadding(left, 0, 0, 0);
                mItemRootView.requestLayout();
                mItemRootView.setBackgroundResource(R.color.colorPrimary);
                mDurationTimeHolder.setTextColor(ContextCompat.getColor(context,R.color.prime_blue));
                mDurationTimeHolder.setTextSize(TypedValue.COMPLEX_UNIT_PX, 80);
            }
            // ========== Default apearance ========== //
            else {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) mItemRootView.getLayoutParams();
                int left = dp2px(10);
                layoutParams.width = RecyclerView.LayoutParams.MATCH_PARENT;
                layoutParams.height = ((int) displayMetrics.widthPixels) / 5;

                mItemRootView.setLayoutParams(layoutParams);
                mItemRootView.setPadding(left, 0, 0, 0);
                mItemRootView.invalidate();
                mItemRootView.requestLayout();
                mItemRootView.setBackgroundResource(R.color.colorPrimary);
                mDurationTimeHolder.setTextColor(ContextCompat.getColor(context,R.color.prime_blue));
                mDurationTimeHolder.setTextSize(TypedValue.COMPLEX_UNIT_PX, 65);
            }


        }


    }

}
