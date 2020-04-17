package com.example.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class DiceView extends View {

    private int mEdgeWidth;
    public int points =1; //滑鼠點擊次數

    //----------從這邊開始讓layout的DiceView變成正方形分隔線--------------
    //用這個的話，只要再layout那邊設定好寬度，不管把高度改成怎樣他都會維持正方形喔
    public DiceView(Context context) {
        super(context);
         }
    public DiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public DiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        //重写此方法后默认调用父类的onMeasure方法,分别将宽度测量空间与高度测量空间传入
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //上面這個會讓圖行占滿整個畫面
    }
    //----------到這邊是讓layout的DiceView變成正方形結束的分隔線--------------

    public void next(){
        points = points%6 +1;   //點一下會進來+1，然後讓他可以按照順序看去哪個這樣
        invalidate();           //內建，觸發onDraw()，用來更新畫面
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {    //設定(改變後的寬度，改變後的高度，改變前的寬度，改變前的高度)的變數，這些值都系統會去計算的喔
        //super.onSizeChanged(w, h, oldw, oldh);//可省略
        mEdgeWidth = w ;
    }

    @Override
    protected void onDraw(Canvas canvas) {  //來畫圖喔
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        //paint.setAntiAlias(true);
        //paint.setStyle(Paint.Style.STROKE);     //只有他的話就是只有框框
        //paint.setStyle(Paint.Style.FILL);       //再加上他就會填滿顏色
        //paint.setStrokeWidth(10f);              //線寬

        switch (points){
            case 1:
                canvas.drawRect(mEdgeWidth/3, mEdgeWidth/3, mEdgeWidth*2/3, mEdgeWidth*2/3, paint);
                break;
            case 2:
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth/12, mEdgeWidth/4, mEdgeWidth/4, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth*3/4, mEdgeWidth*11/12, mEdgeWidth*11/12, paint);
                break;
            case 3:
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth/12, mEdgeWidth/4, mEdgeWidth/4, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth*3/4, mEdgeWidth*11/12, mEdgeWidth*11/12, paint);
                canvas.drawRect(mEdgeWidth*5/12, mEdgeWidth*5/12, mEdgeWidth*7/12, mEdgeWidth*7/12, paint);
                break;
            case 4:
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth/12, mEdgeWidth/4, mEdgeWidth/4, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth*3/4, mEdgeWidth*11/12, mEdgeWidth*11/12, paint);
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth*3/4, mEdgeWidth/4, mEdgeWidth*11/12, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth/12, mEdgeWidth*11/12, mEdgeWidth/4, paint);
                break;
            case 5:
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth/12, mEdgeWidth/4, mEdgeWidth/4, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth*3/4, mEdgeWidth*11/12, mEdgeWidth*11/12, paint);
                canvas.drawRect(mEdgeWidth*5/12, mEdgeWidth*5/12, mEdgeWidth*7/12, mEdgeWidth*7/12, paint);
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth*3/4, mEdgeWidth/4, mEdgeWidth*11/12, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth/12, mEdgeWidth*11/12, mEdgeWidth/4, paint);
                break;
            case 6:
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth/12, mEdgeWidth/4, mEdgeWidth/4, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth*3/4, mEdgeWidth*11/12, mEdgeWidth*11/12, paint);
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth*3/4, mEdgeWidth/4, mEdgeWidth*11/12, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth/12, mEdgeWidth*11/12, mEdgeWidth/4, paint);
                canvas.drawRect(mEdgeWidth/12, mEdgeWidth*5/12, mEdgeWidth/4, mEdgeWidth*7/12, paint);
                canvas.drawRect(mEdgeWidth*3/4, mEdgeWidth*5/12, mEdgeWidth*11/12, mEdgeWidth*7/12, paint);
                break;
        }
    }
}
