package com.taluttasgiran.actionsheet;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;

public class RNActionsheetModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private ActionSheet actionSheet;

    RNActionsheetModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @ReactMethod
    public void show(String title, ReadableArray items, final Callback onClickCallback, int cancelIndex) {
        final String[] labels = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            labels[i] = items.getString(i);
        }
        actionSheet = new ActionSheet(getCurrentActivity(), title, labels, onClickCallback, cancelIndex);
        actionSheet.show();
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