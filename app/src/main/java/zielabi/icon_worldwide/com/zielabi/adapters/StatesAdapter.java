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

import java.util.List;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.models.State;

/**
 * Created by margarita on 24/08/2017.
 */

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

    private static final int VIEW_TYPE_PADDING = 1;
    private static final int VIEW_TYPE_ITEM = 2;
    private int paddingWidthDate = 0;

    private int selectedItem = -1;

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        mOnDataChangeListener = onDataChangeListener;
    }

    public interface OnDataChangeListener {
        public void onDataChanged(int size);
    }

    public StatesAdapter(Context context, List<State> data, int paddingWidthDate) {
        this.context = context;
        mData = data;
        displayMetrics = context.getResources().getDisplayMetrics();
        dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        this.paddingWidthDate = paddingWidthDate;
    }


    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }


    @Override
    public StateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_state,
                    parent, false);
            return new StateViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_padding,
                    parent, false);

            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            layoutParams.width = paddingWidthDate;
            view.setLayoutParams(layoutParams);
            return new StateViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(StateViewHolder holder, int position) {
        State item = mData.get(position);

//        if (item.isMagic()) {
//            holder.setSelected(true);
//            for (int i = 0; i < mData.size(); ++i) {
//                if (!mData.get(i).equals(item)) {
//                    mData.get(i).setMagic(false);
//                }
//            }
//        } else {
//            holder.setSelected(false);
//        }

        holder.mDurationTimeHolder.setText(item.getStateName());

        if (getItemViewType(position) == VIEW_TYPE_ITEM) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)  holder.mDurationTimeHolder.getLayoutParams();

//            if(item.dateType.equals(BirthDayActivity.DateType.C31))
//                holder.tvDate.setText(String.valueOf(labelerDate.valueDate));
//            holder.tvDate.setVisibility(View.VISIBLE);
//            holder.imgSmall.setVisibility(View.VISIBLE);

            if (position == selectedItem) {
                holder.mDurationTimeHolder.setTextColor(Color.parseColor("#094779"));
                holder.mDurationTimeHolder.setTextSize(20);
                int left = dp2px(30);
                layoutParams.width = RecyclerView.LayoutParams.MATCH_PARENT;
                layoutParams.height = ((int) displayMetrics.widthPixels) / 11;
                holder.mDurationTimeHolder.setLayoutParams(layoutParams);
                holder.mDurationTimeHolder.invalidate();
                holder.mDurationTimeHolder.setPadding(left, 0, 0, 0);

            } else {
                holder.mDurationTimeHolder.setTextColor(Color.parseColor("#094779"));
                holder.mDurationTimeHolder.setTextSize(16);
                int left = dp2px(10);
                layoutParams.width = RecyclerView.LayoutParams.MATCH_PARENT;
                layoutParams.height = ((int) displayMetrics.widthPixels) / 11;
                holder.mDurationTimeHolder.setLayoutParams(layoutParams);
                holder.mDurationTimeHolder.invalidate();
                holder.mDurationTimeHolder.setPadding(left, 0, 0, 0);
            }
        }
    }
    @Override
    public int getItemViewType(int position) {
        State item = mData.get(position);
//        if (item.getStateName().equals(" ")){
//            return VIEW_TYPE_PADDING;
//        }
        return VIEW_TYPE_ITEM;
    }

    public void setSelecteditem(int selecteditem) {
        this.selectedItem = selecteditem;
        notifyDataSetChanged();
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

                int left = dp2px(30);

                layoutParams.width = RecyclerView.LayoutParams.MATCH_PARENT;
                layoutParams.height = ((int) displayMetrics.widthPixels) / 11;
                //layoutParams.setMargins(left, 0, 0, 0);
                mItemRootView.setLayoutParams(layoutParams);
                mItemRootView.invalidate();
                mItemRootView.setPadding(left, 0, 0, 0);
                mItemRootView.requestLayout();
                mItemRootView.setBackgroundResource(R.color.colorPrimary);
                mDurationTimeHolder.setTextColor(ContextCompat.getColor(context,R.color.prime_blue));
                mDurationTimeHolder.setTextSize(TypedValue.COMPLEX_UNIT_PX, 70);
            }
            // ========== Default apearance ========== //
            else {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) mItemRootView.getLayoutParams();
                int left = dp2px(10);
                layoutParams.width = RecyclerView.LayoutParams.MATCH_PARENT;
                layoutParams.height = ((int) displayMetrics.widthPixels) / 11;
                mItemRootView.setLayoutParams(layoutParams);
                mItemRootView.setPadding(left, 0, 0, 0);
                mItemRootView.invalidate();
                mItemRootView.requestLayout();
                mItemRootView.setBackgroundResource(R.color.colorPrimary);
                mDurationTimeHolder.setTextColor(ContextCompat.getColor(context,R.color.prime_blue));
                mDurationTimeHolder.setTextSize(TypedValue.COMPLEX_UNIT_PX, 60);
            }


        }


    }

}
