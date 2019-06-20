package control;

import android.content.Context;
import android.content.Intent;

public class IntentControl {
    Intent intent;

    public IntentControl() {
        this.intent = new Intent();
    }


    public Intent getIntent(){
        return intent;

    }

    public void START_ACTIVITY(Context context, Class<?> cls) {
        intent = new Intent(context,cls);
        context.startActivity(intent);
    }

}
