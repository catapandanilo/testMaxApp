package br.com.catapan.testemaxima.main;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import br.com.catapan.testemaxima.adapter.CustomAdapter;
import br.com.catapan.testemaxima.R;

public class OrderHistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderhist);

        Toolbar toolbar = findViewById(R.id.toolbarOrderHist);
        toolbar.setNavigationIcon(R.drawable.ic_maxima_voltar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        updateComponents();
    }

    private void updateComponents() {
        Button btHistOpenClient = findViewById(R.id.btHistOpenClient);
        btHistOpenClient.setTextColor(Color.rgb(149, 182, 207));
        btHistOpenClient.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_maxima_pessoa_inativo, 0, 0);

        Button btHistOpenLicense = findViewById(R.id.btHistOpenLicense);
        btHistOpenLicense.setTextColor(Color.rgb(149, 182, 207));
        btHistOpenLicense.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_maxima_alvara_inativo, 0, 0);
    }

    private void openOldLegends() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.row_item, null);
        ListView ll = row.findViewById(R.id.listviewLegenda);
        ll.setAdapter(new CustomAdapter(this));

        builder.setView(row);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openNewLegends() {
        Intent intent = new Intent(
                OrderHistActivity.this, LegendsActivity.class
        );
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_orderhist, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_legends:
                openNewLegends();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickClient(View view) {
        Intent intent = new Intent(
                OrderHistActivity.this, ClientActivity.class
        );
        startActivity(intent);
        finish();
    }

    public void onClickLicense(View view) {
        Intent intent = new Intent(
                OrderHistActivity.this, LicenseActivity.class
        );
        startActivity(intent);
        finish();
    }
}
