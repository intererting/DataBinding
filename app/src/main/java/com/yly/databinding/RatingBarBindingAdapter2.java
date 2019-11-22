package com.yly.databinding;

import android.widget.RatingBar;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

import java.security.PublicKey;


//双向绑定InverseBindingAdapter版本
//- @InverseBindingMethod与@InverseBindingMethods + @BindingAdapter可以实现双向绑定
//- @InverseBindingAdapter + @BindingAdapter也可以实现双向绑定
public class RatingBarBindingAdapter2 {

    //避免死循环
    @BindingAdapter("android:rating")
    public static void setRating(RatingBar view, float rating) {
        if (view.getRating() != rating) {
            view.setRating(rating);
        }
    }

    @InverseBindingAdapter(attribute = "android:rating", event = "ratingAttrChanged")
    public static float getRating(RatingBar view) {
        return view.getRating();
    }

    @BindingAdapter(value = {"onRatingChanged", "ratingAttrChanged"},
            requireAll = false)
    public static void setListeners(RatingBar view, final RatingBar.OnRatingBarChangeListener listener,
                                    final InverseBindingListener ratingChange) {
        if (ratingChange == null) {
            view.setOnRatingBarChangeListener(listener);
        } else {
            view.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if (listener != null) {
                        listener.onRatingChanged(ratingBar, rating, fromUser);
                    }
                    ratingChange.onChange();
                }
            });
        }
    }
}