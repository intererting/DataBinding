package com.yly.databinding;

import android.widget.RatingBar;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

//attribute 双向绑定属性  method 双向绑定时怎么获取双向绑定属性，当ratingAttrChanged触发时，通过该方法获取值，然后修改databinding我们绑定的值
@InverseBindingMethods({
        @InverseBindingMethod(type = RatingBar.class, attribute = "android:rating", method = "getRating", event = "ratingAttrChanged"),
})
public class RatingBarBindingAdapter {

    //避免死循环
    @BindingAdapter("android:rating")
    public static void setRating(RatingBar view, float rating) {
        if (view.getRating() != rating) {
            view.setRating(rating);
        }
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