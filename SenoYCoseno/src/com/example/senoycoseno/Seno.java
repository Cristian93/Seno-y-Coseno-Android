package com.example.senoycoseno;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Seno extends View {
	
	Paint paint;
    Double ini,fin;
	public Seno (Context context,int a,int b ) {
		super(context);
		paint = new Paint ();
		ini = a*Math.PI/180;
		fin = b*Math.PI/180;
	}

	public void onDraw (Canvas canvas) {
		
		
		paint.setColor(Color.RED);
				
				canvas.drawLine(10,10,10,canvas.getHeight(),paint);
				canvas.drawLine(10,canvas.getHeight()/2,canvas.getWidth(),canvas.getHeight()/2,paint);
				paint.setColor(Color.BLUE);
				Double dx,dy;
				int ix,iy;
				
				
				for (  dx = ini; dx <= fin; dx=dx+0.01) {
					dy=Math.sin(dx)*-1;
					ix=(int)(dx*50)+10;
					iy=(int)(dy*100)+canvas.getHeight()/2;
					canvas.drawPoint(ix, iy, paint);
		  		
		  		invalidate();
		      	  
		  	}
		      
		      
	}

}
