package com.example.day18rikao03.di;

import java.lang.ref.WeakReference;

/**
 * Created by lenovo on 2018/8/24.
 */

public class presenterimp implements  icontract.ipresenter<icontract.iview> {

    private WeakReference<icontract.iview> iviewWeakReference;
    private  icontract.iview iview;
    private WeakReference<icontract.imoudle> weakReference;
    private moudleimp moudleimp;


    @Override
    public void attachview(icontract.iview iview) {
        this.iview =iview;
        moudleimp = new moudleimp();
        //解决内存泄漏
        iviewWeakReference = new WeakReference<icontract.iview>(iview);
        weakReference = new WeakReference<icontract.imoudle>(moudleimp);
    }

    @Override
    public void detachview(icontract.iview iview) {
        //解绑
        iviewWeakReference.clear();
        weakReference.clear();
    }

    @Override
    public void requestinfo() {
          moudleimp.requestdata(new icontract.imoudle.calllisten() {
              @Override
              public void responsemsg(String s) {
                  iview.showtinfo(s);
              }
          });
    }
}
