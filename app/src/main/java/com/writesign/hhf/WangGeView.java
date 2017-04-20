package com.writesign.hhf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class WangGeView extends View {

	private int wSpace = 0;
	private int hSpace = 0;
	private Paint paint;
	private int width,height;

	public WangGeView(Context context) {
		super(context);
		// TODO Auto-generatedwSpace constructor stub
	}

	public WangGeView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public WangGeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		width = MeasureSpec.getSize(widthMeasureSpec);
		height = MeasureSpec.getSize(heightMeasureSpec);
		wSpace = width / 30;
		hSpace = height / 10;
		paint = new Paint();
		paint.setColor(Color.YELLOW);
		paint.setAntiAlias(true);
		paint.setStrokeWidth(3);
		paint.setStyle(Paint.Style.STROKE);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		int vertz = 0;
		int hortz = 0;
		for (int i = 0; i < 300; i++) {
			canvas.drawLine(0, vertz, width, vertz, paint);
			canvas.drawLine(hortz, 0, hortz, height, paint);
			vertz += wSpace;
			hortz += hSpace;
		}
	}

}
