package com.wst.util;

import android.content.Context;

import com.mingle.widget.ShapeLoadingDialog;

/**
 * Created by: BruceChang
 * Date on : 2016/11/22.
 * Time on: 13:55
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:
 */

public class LoadingUtils {
    Context mContext;
    private ShapeLoadingDialog shapeLoadingDialog;

    public LoadingUtils(Context context) {
        mContext = context;
        shapeLoadingDialog = new ShapeLoadingDialog(context);
        shapeLoadingDialog.setCanceledOnTouchOutside(false);
        shapeLoadingDialog.setLoadingText("加载中...");
    }

    public void show() {
        shapeLoadingDialog.show();
    }

    public void dismiss() {
        shapeLoadingDialog.dismiss();
    }

}
