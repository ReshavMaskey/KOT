package control;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class Hide {

    public static void hideActionAndNotificationBar(AppCompatActivity app) {
        app.requestWindowFeature(Window.FEATURE_NO_TITLE);
        app.getSupportActionBar().hide();
        app.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}
