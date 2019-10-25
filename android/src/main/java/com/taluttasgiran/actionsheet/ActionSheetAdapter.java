package com.taluttasgiran.actionsheet;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Callback;

public class ActionSheetAdapter extends RecyclerView.Adapter<ActionSheetAdapter.MyViewHolder> {
    private String[] mDataset;
    private Callback callback;
    private ActionSheet actionSheet;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearLayout;
        public MyViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
        }
    }

    public ActionSheetAdapter(String[] myDataset, Callback onClickCallback, ActionSheet actionSheetC) {
        mDataset = myDataset;
        callback = onClickCallback;
        actionSheet = actionSheetC;
    }

    @Override
    public ActionSheetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.action_item, parent, false);
        MyViewHolder vh = new MyViewHolder(linearLayout);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Button button = (Button) holder.linearLayout.findViewById(R.id.btn);
        button.setText(mDataset[position]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.invoke(position);
                actionSheet.hide();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
