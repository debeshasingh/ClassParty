package com.example.classparty;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class WinCertificateActivity extends AppCompatActivity implements HelperInterface, View.OnClickListener {
    private TextView txtTimer;
    private Button btnSubmit;
    private EditText edtText;
    private ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_certificate);

        imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);

        txtTimer = (TextView) findViewById(R.id.txt_timer);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        edtText = (EditText) findViewById(R.id.edt_txt);


        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                txtTimer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                txtTimer.setVisibility(View.GONE);
                btnSubmit.setVisibility(View.VISIBLE);
                edtText.setEnabled(false);

            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        onBack();
    }

    public void onBack() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBack();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public ApplicationHelper getHelper() {
        return ApplicationHelper.getInstance();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.img_back) {
            onBack();
        }
    }
}
