package com.alura.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable getDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int IdDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE, context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(IdDrawable);
        return drawableImagemPacote;
    }
}
