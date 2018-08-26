package com.example.android.usingvollytoloadimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUrl;
    private Button buttonLoad;
    private NetworkImageView imageView;
    private ImageLoader imageLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        editTextUrl = findViewById( R.id.editTextUrl );
        buttonLoad = findViewById( R.id.buttonLoad );
        imageView = findViewById( R.id.image1 );

        buttonLoad.setOnClickListener( this );


    }

    private void loadImage() {
        String url = editTextUrl.getText().toString().trim();
        if (url.equals( "" )) {
            Toast.makeText( this, "Please enter a URL", Toast.LENGTH_LONG ).show();
            return;
        }
        imageLoader = CustomVolleyRequest.getInstance( this.getApplicationContext() )
                .getImageLoader();
        imageLoader.get( url, ImageLoader.getImageListener( imageView,
                android.R.drawable.alert_light_frame, android.R.drawable
                        .ic_dialog_alert ) );
        imageView.setImageUrl( url, imageLoader );
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLoad) {
            loadImage();
        }
    }


}