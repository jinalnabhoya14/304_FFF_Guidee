package com.example.dailydiamond.ad;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.dailydiamond.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
;


public class ExitDialogNative extends BottomSheetDialogFragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.layout_exit, viewGroup, false);
        initView();
        getDialog().setOnShowListener(dialog -> {
            BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) ((BottomSheetDialog) dialog).findViewById(com.google.android.material.R.id.design_bottom_sheet));
            from.setState(BottomSheetBehavior.STATE_EXPANDED);
            from.setSkipCollapsed(true);
        });
        return this.view;
    }

    private void initView() {
        ((TextView) this.view.findViewById(R.id.tv_exit)).setOnClickListener(view -> {
            dismiss();
            getActivity().finishAffinity();
            System.exit(0);
        });
    }

    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if ((window = onCreateDialog.getWindow()) != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(GradientDrawable.RECTANGLE);
            gradientDrawable2.setColor(getResources().getColor(R.color.gnt_colorPrimary));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
            layerDrawable.setLayerInsetTop(1, displayMetrics.heightPixels);
            window.setBackgroundDrawable(layerDrawable);
        }
        return onCreateDialog;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.gnt_CustomBottomSheetDialogTheme);
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}