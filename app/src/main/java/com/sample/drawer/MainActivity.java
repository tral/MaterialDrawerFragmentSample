package com.sample.drawer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.sample.drawer.utils.Utils;

public class MainActivity extends ActionBarActivity {

    private Drawer.Result drawerResult = null;
    private AccountHeader.Result headerResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Для Activity с боковым меню ставьте эту тему,
        // для Activity без бокового меню ставьте тему AppThemeNonDrawer (она прописана по умолчанию в манифесте кстати)
        // иначе будет "сползать" ActionBar
        // Темы находятся в styles.xml
        setTheme(R.style.AppThemeDrawer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init Drawer & Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        headerResult = Utils.getAccountHeader(MainActivity.this, savedInstanceState);
        drawerResult = Utils.createCommonDrawer(MainActivity.this, toolbar, headerResult);
        drawerResult.setSelectionByIdentifier(1, false); // Set proper selection

        // Покажем drawer автоматически при запуске
        drawerResult.openDrawer();

    }

    @Override
    public void onBackPressed() {
        if (drawerResult.isDrawerOpen()) {
            // Закрываем меню, если оно показано и при этом нажата системная кнопка "Назад"
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


}
