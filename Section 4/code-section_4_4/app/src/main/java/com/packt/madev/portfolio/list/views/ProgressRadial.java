package com.packt.madev.portfolio.list.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.packt.madev.R;


public class ProgressRadial extends View {

    private Paint arcPaint;
    private Paint circlePaint;
    private RectF rectF;
    private float bottomOfDrawing;
    private float leftOfDrawing;
    private float topOfDrawing;
    private float rightOfCircle;
    private float progress;
    private int progressColor;

    public ProgressRadial(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context.obtainStyledAttributes(attrs, R.styleable.ProgressRadial));
        setupPaints();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float startAngle = 180.0f;
        float maxAngleLength = 360.0f;

        canvas.drawOval(rectF, circlePaint);
        float angleLength = maxAngleLength * progress;

        canvas.drawArc(rectF, startAngle, angleLength, true, arcPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        setupBounds();
        invalidate();
    }

    private void setupBounds() {
        bottomOfDrawing = getHeight();
        leftOfDrawing = getPaddingLeft() + 5;
        topOfDrawing = getPaddingTop() + 5;
        rightOfCircle = bottomOfDrawing;


        rectF = new RectF(leftOfDrawing, topOfDrawing, rightOfCircle, bottomOfDrawing);
    }

    private void setupPaints() {

        circlePaint = new Paint();
        circlePaint.setColor(Color.WHITE);
        circlePaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        arcPaint = new Paint();
        arcPaint.setColor(progressColor);
        arcPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    private void parseAttributes(TypedArray a) {
        float progressFloat = a.getFloat(R.styleable.ProgressRadial_progress, 0.4f);
        progressColor = a.getColor(R.styleable.ProgressRadial_progressColor, Color.RED);
        setProgress(progressFloat);

        a.recycle();
    }

    public void setProgress(float progress) {
        this.progress = progress;

        invalidate();
    }

}
