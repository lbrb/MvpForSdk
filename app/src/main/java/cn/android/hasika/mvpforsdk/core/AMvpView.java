package cn.android.hasika.mvpforsdk.core;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by hasika on 2018/1/16.
 */

public abstract class AMvpView extends Dialog {
    protected float screenWidth;
    protected float screenHeight;
    protected AMvpPresenter presenter;

    public AMvpView(Context context, AMvpPresenter presenter) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount = 0.8f;
        window.setAttributes(lp);

        this.screenWidth = 480;
        this.screenHeight = 800;

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (screenWidth * 0.9), ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;

        this.presenter = presenter;
        this.addContentView(getContentView(), layoutParams);
    }

    protected abstract View getContentView();
}
