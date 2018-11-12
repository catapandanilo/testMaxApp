package br.com.catapan.testemaxima.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.catapan.testemaxima.R;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client);

        Toolbar toolbar = findViewById(R.id.toolbarClient);
        toolbar.setNavigationIcon(R.drawable.ic_maxima_voltar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        updateComponents();
    }

    private void updateComponents() {
        Button btClientOpenOrderHist = findViewById(R.id.btCliOpenOrderHist);
        btClientOpenOrderHist.setTextColor(Color.rgb(149, 182, 207));
        btClientOpenOrderHist.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_maxima_historico_pedidos_inativo, 0, 0);

        Button btClientOpenLicense = findViewById(R.id.btCliOpenLicense);
        btClientOpenLicense.setTextColor(Color.rgb(149, 182, 207));
        btClientOpenLicense.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_maxima_alvara_inativo, 0, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_client, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickOrderHist(View view) {
        Intent intent = new Intent(
                ClientActivity.this, OrderHistActivity.class
        );
        startActivity(intent);
        finish();
    }

    public void onClickLicense(View view) {
        Intent intent = new Intent(
                ClientActivity.this, LicenseActivity.class
        );
        startActivity(intent);
        finish();
    }
}
