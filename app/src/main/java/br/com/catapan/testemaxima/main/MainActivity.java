package br.com.catapan.testemaxima.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import br.com.catapan.testemaxima.util.InternetTask;
import br.com.catapan.testemaxima.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        AppCompatImageView ivConnection = findViewById(R.id.ivConnection);

        InternetTask task = new InternetTask(getApplicationContext(), ivConnection);
        task.execute(10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClickClient(View view) {
        Intent intent = new Intent(
                MainActivity.this, ClientActivity.class
        );
        startActivity(intent);
    }
}
