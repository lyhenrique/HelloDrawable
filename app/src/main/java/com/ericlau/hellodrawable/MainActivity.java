package com.ericlau.hellodrawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));

    }

    private class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            int width = getWidth();
            int height = getHeight();
            ShapeDrawable rect
                    = new ShapeDrawable(new RectShape());
            rect.setBounds(width / 6, height/10, width * 5 / 6, height*2/10);
            rect.getPaint().setColor(Color.GRAY);
            rect.draw(canvas);
            GradientDrawable circle = (GradientDrawable) getResources().getDrawable(R.drawable.circle);
            circle.setBounds(width / 4, height / 4, width * 3 / 4, height * 3 / 4);
            circle.draw(canvas);
//            BitmapDrawable bmp = (BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher);
//            int bmpWidth = bmp.getIntrinsicWidth();
//            int bmpHeight = bmp.getIntrinsicHeight();
//            bmp.setBounds((width - bmpWidth) / 2, 20, (width + bmpWidth) / 2, 20 + bmpHeight);
//            bmp.draw(canvas);

            BitmapDrawable bmi = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_128);
            bmi.setBounds((getWidth()-300)/2, (getHeight()-300)/2,(getWidth()+300)/2,(getHeight()+300)/2);
            bmi.draw(canvas);

//            Paint linePaint = new Paint();
//            linePaint.setColor(Color.argb(1000, 111, 111, 111));
//            canvas.drawRect(width / 2, width / 2, height / 2, height / 2,linePaint);

            Paint textPaint = new Paint();
            textPaint.setColor(Color.RED);
            textPaint.setTextSize(60);
            textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("BMI", width/2, height / 6, textPaint);
        }
    }
}
