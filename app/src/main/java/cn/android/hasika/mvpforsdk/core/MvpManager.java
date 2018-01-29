package cn.android.hasika.mvpforsdk.core;

import java.util.Stack;

/**
 * Created by hasika on 2018/1/22.
 */

public class MvpManager {
    private Stack<AMvpPresenter> stack;
    public static MvpManager instance = new MvpManager();
    public static MvpManager getInstance(){return instance;}

    public MvpManager(){
        this.stack = new Stack<>();
    }

    /**
     * 1.stack保存view
     * 2.显示view
     *
     * @param mvpPresenter
     */
    public void show(AMvpPresenter mvpPresenter){
        this.stack.push(mvpPresenter);
        mvpPresenter.getMvpView().show();
    }

    /**
     * 1.隐藏view
     * 2.从stack删除view
     * 3.回调上一个view
     * @return
     */
    public AMvpPresenter dismiss(){
        AMvpPresenter currentMvpPresenter;
        AMvpPresenter previousMvpPresenter;

        if (this.stack.size() > 1){
            currentMvpPresenter = this.stack.pop();
            previousMvpPresenter = this.stack.peek();

            //隐藏当前view
            currentMvpPresenter.getMvpView().dismiss();

            //回调前一个view结果
            previousMvpPresenter.onMvpResult(previousMvpPresenter.getRequestCode(), currentMvpPresenter.getResultCode());

        } else {
            currentMvpPresenter = this.stack.pop();
            //隐藏当前view
            currentMvpPresenter.getMvpView().dismiss();
        }

        return currentMvpPresenter;
    }
}
