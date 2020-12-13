package services.vego.network;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import services.vego.network.layer.R;

public class ViewDialog {
    public static Dialog CreateViewDialog(Context context) {
        Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_loading_layout);
        return dialog;
    }
}