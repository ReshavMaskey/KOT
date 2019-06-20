package control;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class Hide {

    public static void SET_FEATURE_NO_TITLE(AppCompatActivity app) {
        app.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public static void HIDE_ACTIONBAR(AppCompatActivity app) {
        app.getSupportActionBar().hide();
    }


    public static void SET_FULLSCREEN(AppCompatActivity app) {
        app.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}
