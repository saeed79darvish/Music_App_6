package com.example.saeed.music_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;

public class PaymentActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView m_response;
    PayPalConfiguration m_Configuration;

    String m_paypalClientId = "AVvy-SwqRxu9mbM1XAZaNmVapR7Ipsx7cCwbcrD3Sx6cViWucWk420x935PDLt-MitgVk5yHh4bdFEeJ";
    Intent m_service;
    int m_paypalRequestCode = 999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        toolbar = (Toolbar) findViewById(R.id.toolbar_payment);
        toolbar.setTitle(getResources().getString(R.string.app_payment));


        TextView main = (TextView) findViewById(R.id.main_activity_playlist);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistintent = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(playlistintent);
            }
        });
        TextView playlist = (TextView) findViewById(R.id.playList_payment);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playintent = new Intent(PaymentActivity.this, PlayListActivity.class);
                startActivity(playintent);
            }
        });

        TextView albums = (TextView) findViewById(R.id.albums_payment);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent albumintent = new Intent(PaymentActivity.this, AlbumsActivity.class);

                startActivity(albumintent);
            }
        });

        m_response = (TextView) findViewById(R.id.response);
        m_Configuration = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
                .clientId(m_paypalClientId);

        m_service = new Intent(this, PayPalService.class);
        m_service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_Configuration);
        startService(m_service);
    }

    public void pay(View view) {
        PayPalPayment payment = new PayPalPayment(new BigDecimal(10), "USD", "TestPayment", PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, com.paypal.android.sdk.payments.PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_Configuration);
        intent.putExtra(com.paypal.android.sdk.payments.PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent, m_paypalRequestCode);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == m_paypalRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(com.paypal.android.sdk.payments.PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    String state = confirmation.getProofOfPayment().getState();
                    if (state.equals("approved"))
                        m_response.setText("payment approved");
                    else
                        m_response.setText("error");
                } else
                    m_response.setText("Confirmation is null");
            }
        }
    }
}








