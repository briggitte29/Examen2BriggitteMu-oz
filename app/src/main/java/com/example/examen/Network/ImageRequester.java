package com.example.examen.Network;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.LruCache;

import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.examen.Application.ProductoContext;

public class ImageRequester {

    private static ImageRequester instance=null;
    private final Context context;
    private final RequestQueue requestQueue;
    private final ImageLoader imageLoader;
    private final int maxByteSize;

    private ImageRequester(){
        context= ProductoContext.getAppContext();
        this.requestQueue= Volley.newRequestQueue(context);
        this.requestQueue.start();
        this.maxByteSize=calculateMaxByteSize();
        this.imageLoader=new ImageLoader(
                requestQueue,
                new ImageLoader.ImageCache() {

                    private final LruCache<String, Bitmap> lruCache=new LruCache<String,Bitmap>(maxByteSize){
                        @Override
                        protected int sizeOf(String url, Bitmap bitmap) {
                            return bitmap.getByteCount();
                        }
                    };

                    @Nullable
                    @Override
                    public synchronized Bitmap getBitmap(String url) {
                        return lruCache.get(url);
                    }

                    @Override
                    public synchronized void putBitmap(String url, Bitmap bitmap) {
                        lruCache.put(url,bitmap);
                    }
                });
    }

    public static ImageRequester getInstance(){
        if(instance==null){
            instance=new ImageRequester();
        }
        return instance;
    }

    public void setImageFormUrl(NetworkImageView networkImageView, String url){
        networkImageView.setImageUrl(url,imageLoader);
    }

    private int calculateMaxByteSize(){
        DisplayMetrics displayMetrics=context.getResources().getDisplayMetrics();
        final int screenBytes=displayMetrics.widthPixels*displayMetrics.heightPixels*4;
        return screenBytes*3;
    }

}
