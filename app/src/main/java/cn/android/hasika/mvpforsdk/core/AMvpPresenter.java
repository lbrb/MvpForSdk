package cn.android.hasika.mvpforsdk.core;

import android.content.Context;

/**
 * Created by hasika on 2018/1/22.
 */

public abstract class AMvpPresenter {
    protected Context mContext;
    protected AMvpView mMvpView;

    private int mRequestCode;
    private int mResultCode;

    public AMvpPresenter(Context context){
        this.mContext = context;
        mMvpView = createMvpView();
    }

    /*****************界面展示相关*********************/
    public void showView(AMvpPresenter presenter){
        showViewForResult(presenter, -1);
    }

    public void showViewForResult(AMvpPresenter presenter, int requestCode){
        this.mRequestCode = requestCode;
        MvpManager.getInstance().show(presenter);
    }

    public void dismiss(){
        MvpManager.getInstance().dismiss();
    }

    public AMvpView getMvpView(){
        return mMvpView;
    }

    /*****************回调相关******************/
    public int getRequestCode(){
        return this.mRequestCode;
    }

    public void setResultCode(int resultCode){
        this.mResultCode = resultCode;
    }

    public int getResultCode(){
        return this.mResultCode;
    }

    /**
     * 回调函数，用于相邻两个view间通信
     * @param requestCode
     * @param resultCode
     */
    protected void onMvpResult(int requestCode, int resultCode){

    }
    /*****************抽象方法********************/
    protected abstract AMvpView createMvpView();
}
