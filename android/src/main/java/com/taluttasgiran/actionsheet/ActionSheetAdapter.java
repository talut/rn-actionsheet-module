package com.taluttasgiran.actionsheet;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Callback;

import javax.annotation.Nullable;

public class ActionSheetAdapter extends RecyclerView.Adapter<ActionSheetAdapter.MyViewHolder> {
    private String[] mDataset;
    private Callback callback;
    private ActionSheet actionSheet;
    private String tintColor;
    private String backgroundColor;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearLayout;

        public MyViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
        }
    }

    public ActionSheetAdapter(String[] myDataset, @Nullable String tintColor, @Nullable String backgroundColor, Callback onClickCallback, ActionSheet actionSheetC) {
        mDataset = myDataset;
        callback = onClickCallback;
        actionSheet = actionSheetC;
        this.tintColor = tintColor;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public ActionSheetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.action_item, parent, false);
        if (backgroundColor != null) {
            linearLayout.setBackgroundColor(android.graphics.Color.parseColor(backgroundColor));
        }
        return new MyViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Button button = (Button) holder.linearLayout.findViewById(R.id.btn);
        button.setText(mDataset[position]);
        if (tintColor != null) {
            button.setTextColor(android.graphics.Color.parseColor(tintColor));
        }
        if (backgroundColor != null) {
            button.setBackgroundColor(android.graphics.Color.parseColor(backgroundColor));
        }
        button.setOnClickListener(v -> {
            callback.invoke(position);
            actionSheet.hide();
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
