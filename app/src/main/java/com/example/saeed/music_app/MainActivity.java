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
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
    TextView m_response;
    Toolbar toolbar;

    PayPalConfiguration m_configuration;
    String m_paypalClientId="AYs4QO-hT-vBb0aD445j6Z2YJzBTFzfm-VSXeAx-DzV0YJK3oMEO3rZv1h6W5vqktF2Ub6rN8-Yui5VW";
    Intent m_service;
    int m_paypalRequstCode=999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        m_response= (TextView) findViewById(R.id.response);

        m_configuration =new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
                .clientId(m_paypalClientId);

        m_service =new Intent(this, PayPalService.class);
        m_service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,m_configuration);
        startService(m_service);



        final TextView playlist = (TextView) findViewById(R.id.PlayList);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistintent = new Intent(MainActivity.this, PlayListActivity.class);
                startActivity(playlistintent);
            }
        });


        TextView albums = (TextView) findViewById(R.id.Albums);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumsintent = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(albumsintent);
            }
        });

    }
    public void payment(View view){
        PayPalPayment payment=new PayPalPayment(new BigDecimal(10),"USD","Payment for Add new songs",
                PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent=new Intent(MainActivity.this,PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,m_configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payment);
        startActivityForResult(intent,m_paypalRequstCode);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==m_paypalRequstCode){
            if (requestCode== Activity.RESULT_OK){
                PaymentConfirmation confirm= data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirm!= null){
                        String state=confirm.getProofOfPayment().getState();
                         if (state.equals("approved"))
                             m_response.setText("payment approved");
                          else
                              m_response.setText("error in the payment");
                }else{
                       m_response.setText("cofirmation in null");
                }
            }
        }
    }
}
