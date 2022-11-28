package com.taluttasgiran.actionsheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.react.bridge.Callback;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import javax.annotation.Nullable;

public class ActionSheet extends BottomSheetDialog {
    BottomSheetDialog mBottomSheetDialog;

    ActionSheet(@NonNull Context context, String title, String[] options, final int cancelIndex, @Nullable String tintColor, @Nullable String backgroundColor, final Callback onClickCallback) {
        super(context);
        View sheetView = this.getLayoutInflater().inflate(R.layout.action_sheet, null);

        if (backgroundColor != null) {
            sheetView.setBackgroundColor(android.graphics.Color.parseColor(backgroundColor));
        }

        RecyclerView mRecyclerView = sheetView.findViewById(R.id.list);

        if (backgroundColor != null) {
            mRecyclerView.setBackgroundColor(android.graphics.Color.parseColor(backgroundColor));
        }

        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mBottomSheetDialog = new BottomSheetDialog(context);
        RecyclerView.Adapter<ActionSheetAdapter.MyViewHolder> mAdapter = new ActionSheetAdapter(options, tintColor, backgroundColor, onClickCallback, this);
        mRecyclerView.setAdapter(mAdapter);
        if (sheetView.getParent() != null) {
            ((ViewGroup) sheetView.getParent()).removeView(sheetView);
        }

        mBottomSheetDialog.setOnCancelListener(dialog -> onClickCallback.invoke(cancelIndex));

        TextView tvTitle = (TextView) sheetView.findViewById(R.id.title);
        tvTitle.setText(title);
        if (tintColor != null) {
            tvTitle.setTextColor(android.graphics.Color.parseColor(tintColor));
        }
        mBottomSheetDialog.setContentView(sheetView);
    }

    public void show() {
        mBottomSheetDialog.show();
    }

    public void hide() {
        mBottomSheetDialog.dismiss();
    }
}
