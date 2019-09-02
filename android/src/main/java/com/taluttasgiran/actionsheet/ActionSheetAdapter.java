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

    // Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout linearLayout;

        public MyViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ActionSheetAdapter(String[] myDataset, Callback onClickCallback, ActionSheet actionSheetC) {
        mDataset = myDataset;
        callback = onClickCallback;
        actionSheet = actionSheetC;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ActionSheetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {

        // create a new view
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
