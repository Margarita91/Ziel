package zielabi.icon_worldwide.com.zielabi.adapters;

/**
 * Created by margarita on 06/09/2017.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.igalata.bubblepicker.adapter.BubblePickerAdapter;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import zielabi.icon_worldwide.com.zielabi.R;

public class BubbleAdapter extends RecyclerView.Adapter<BubbleAdapter.MyViewHolder> {

    private List<String> subjectList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public BubblePicker mBubblePicker;

        public MyViewHolder(View view) {
            super(view);
            mBubblePicker = view.findViewById(R.id.picker);
            mBubblePicker.setBubbleSize(40);
           // mBubblePicker.setCenterImmediately(true);

        }
    }


    public BubbleAdapter(List<String> moviesList, Context context) {
        this.subjectList = moviesList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bubbles, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      String  title = subjectList.get(position);
        final String[] titles = mContext.getResources().getStringArray(R.array.subjects);

        holder.mBubblePicker.setAdapter(new BubblePickerAdapter() {
            @Override
            public int getTotalCount() {
                return titles.length;
            }

            @NotNull
            @Override
            public PickerItem getItem(int position) {
                PickerItem item = new PickerItem();
                item.setTitle(titles[position]);
//                item.setGradient(new BubbleGradient(colors.getColor((position * 2) % 8, 0),
//                        colors.getColor((position * 2) % 8 + 1, 0), BubbleGradient.VERTICAL));
                item.setTextColor(ContextCompat.getColor(mContext, android.R.color.white));
                item.setColor(ContextCompat.getColor(mContext, R.color.prime_orange));

                // item.setBackgroundImage(ContextCompat.getDrawable(TargetABIActivity.this, images.getResourceId(position, 0)));
                return item;
            }
        });

    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }
}