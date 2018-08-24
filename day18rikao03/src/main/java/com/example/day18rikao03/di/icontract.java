package com.example.day18rikao03.di;

/**
 * Created by lenovo on 2018/8/24.
 */

public interface icontract {
    /**
     *  iview层
     */
    public  interface  iview{
        //显示方法
        void  showtinfo(String s);
    }
    /**
     * ipresenter层
     */
    public  interface  ipresenter<iview>{
        //关联
        void  attachview(iview iview);
        //解绑
        void  detachview(iview iview);
        //逻辑方法
        void  requestinfo();
    }
    /**
     * imoudle层
     */
    public  interface  imoudle{
        //回调
        interface calllisten{
            void  responsemsg(String s);
        }
        void  requestdata(calllisten calllisten);
    }
}
