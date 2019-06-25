package com.faranegar.fdcs.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.FileOutputStream;
import java.io.IOException;




public class ImageLogoRecyclerViewHelper {


    private final Context context;
    private final ImageView imageView;
    private final String airlineCode;
    private String airlineLogoUrl;

    public ImageLogoRecyclerViewHelper(Context context, String airlineCode, ImageView imageView, String airlineLogoUrl) {
        this.context = context;
        this.imageView = imageView;
        this.airlineCode = airlineCode;
        this.airlineLogoUrl = airlineLogoUrl;
    }

    public void bindAirlineLogo() {
        Picasso.get()
                .load(context.getFileStreamPath(airlineCode))
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Log.d(TAG, "onSuccess ");
                    }

                    @Override
                    public void onError(Exception e) {
                        getAndSaveAirlineLogo();
                    }

                });
    }


    private void getAndSaveAirlineLogo() {

        Picasso.get()
                .load(  airlineLogoUrl + airlineCode)
                .into(getTargetAndBindImage(airlineCode));
    }

    private Target getTargetAndBindImage(final String airlineCode) {

        Target target = new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap,
                                       Picasso.LoadedFrom from) {
                try {
                    FileOutputStream ostream = context
                            .openFileOutput(airlineCode,
                                    Context.MODE_PRIVATE);
                    boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG,
                            100, ostream);
                    ostream.flush();
                    ostream.close();
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Log.e("IOException", e.getLocalizedMessage());
                }

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }


            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        return target;
    }


}