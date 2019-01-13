package com.example.student1.hackaton;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    ImageView ship;
    float step = 10;
    static float shipY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (detectOrientation()) {
            ship = findViewById(R.id.ship);
            shipY = ship.getY();
        }
    }

    public boolean detectOrientation(){
        Context appContext = getApplicationContext();
        Configuration configuration = getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(appContext, getString(R.string.error_portrait_orientation), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void clickBtnMoveTop(View v) {
        shipY-=step;
        ship.setY(shipY);
    }

    public void clickBtnMoveDown(View v) {
        shipY+=step;
        ship.setY(shipY);
    }


}
