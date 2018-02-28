package cn.jarlen.shortcut;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.shortCutOne).setOnClickListener(this);
        findViewById(R.id.shortCutTwo).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shortCutOne:
                createShortCut(this, ShortCutOne.class, "ShortCut One", R.drawable.ic_launcher);
                break;
            case R.id.shortCutTwo:
                createShortCut(this, ShortCutTwo.class, "ShortCut Two", R.drawable.ic_launcher_round);

                break;

            default:

                break;
        }
    }

    private void createShortCut(Context context, Class<?> cls, String shortCutName, int shortCutRes) {

        Intent shortCutIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");

        shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortCutName);

        shortCutIntent.putExtra("duplicate", false);

        Intent targetIntent = new Intent(context, cls);
//        targetIntent.setAction(Intent.ACTION_MAIN);
//        targetIntent.addCategory(Intent.CATEGORY_DEFAULT);
        shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, targetIntent);

        Intent.ShortcutIconResource shortcutIconResource = Intent.ShortcutIconResource.fromContext(context, shortCutRes);
        shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, shortcutIconResource);

        context.sendBroadcast(shortCutIntent);

    }


}
