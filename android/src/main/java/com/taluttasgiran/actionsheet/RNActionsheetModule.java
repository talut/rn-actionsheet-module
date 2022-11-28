package com.taluttasgiran.actionsheet;

import android.app.Activity;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;

public class RNActionsheetModule extends ReactContextBaseJavaModule {
    private ActionSheet actionSheet;

    RNActionsheetModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void show(String title, ReadableArray items, int cancelIndex, @Nullable String tintColor, @Nullable String backgroundColor, final Callback onClickCallback) {
        final String[] labels = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            labels[i] = items.getString(i);
        }
        Activity activity = getCurrentActivity();
        if (activity != null) {
            actionSheet = new ActionSheet(activity, title, labels, cancelIndex, tintColor, backgroundColor, onClickCallback);
            actionSheet.show();
        }
    }

    @ReactMethod
    public void hide() {
        actionSheet.hide();
    }

    @Override
    public String getName() {
        return "RNActionsheet";
    }
}
