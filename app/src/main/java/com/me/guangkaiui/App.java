package com.me.guangkaiui;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by tao.liu on 2017/8/25.
 */

public class App extends Application {
        public static ImageLoader instance = ImageLoader.getInstance();
        @Override
        public void onCreate() {
                super.onCreate();
                initImageLoader();


        }

        private void initImageLoader() {
                //初始化universal image loader
                DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder() //
                        //.showImageForEmptyUri(R.drawable.sales_banner01) //
                       // .showImageOnFail(R.drawable.sales_banner01) //
                        .cacheInMemory(true) //
                        .cacheOnDisk(true) //
                        .build();//
                ImageLoaderConfiguration config = new ImageLoaderConfiguration//
                        .Builder(getApplicationContext())//
                        .defaultDisplayImageOptions(defaultOptions)//
                        .writeDebugLogs()//
                        .build();//
                instance.init(config);
        }
}
