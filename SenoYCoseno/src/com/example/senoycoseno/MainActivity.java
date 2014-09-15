package com.example.senoycoseno;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	ListView lvfunciones;
	ArrayList <String> listfunciones;
	ArrayAdapter <String> adapterfunciones;
	
	String sseno, scoseno;
	
	RadioButton rb0pi, rbrango;
	EditText etinicio,etfin;
	Button btgraficar;
	
	int pos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

        lvfunciones=(ListView) findViewById(R.id.listViewfunciones);
		listfunciones = new ArrayList <String> ();
		adapterfunciones= new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1,listfunciones);
		//mirar para que sirve esta linea--------------
		adapterfunciones.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
		//permite que el dato sea agregado a a la lista
		lvfunciones.setAdapter(adapterfunciones);
		
		
		adapterfunciones.add("Seno");
		//permite que el dato sea agregado a la lista
		adapterfunciones.notifyDataSetChanged();
		//lvciudades.setAdapter(adapterciudades);
		adapterfunciones.add("Coseno");
		//permite que el dato sea agregado a la lista
		adapterfunciones.notifyDataSetChanged();
		
		
		rb0pi= (RadioButton) findViewById (R.id.radio0_2pi);
		rbrango= (RadioButton) findViewById (R.id.radiorango);
        
      
        etinicio=(EditText) findViewById(R.id.editTextinicio);
        etfin=(EditText) findViewById(R.id.editTextfin);
		
		btgraficar= (Button) findViewById(R.id.buttongraficar);
		
		btgraficar.setOnClickListener(this);
	
	
		lvfunciones.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				 Toast.makeText(getBaseContext(), "Ha seleccionado la funcion: " + listfunciones.get(position) , Toast.LENGTH_SHORT).show();
				 pos=position;
				
				
			}
		 });


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.item1) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		lvfunciones.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				 Toast.makeText(getBaseContext(), "Ha seleccionado la funcion: " + listfunciones.get(position) , Toast.LENGTH_SHORT).show();
				 pos=position;
				
				
			}
		 });
		
		
		if (v.getId()==R.id.buttongraficar && rb0pi.isChecked()==true && pos==0 ){
			
			Toast.makeText(getBaseContext(), "Graficando " + listfunciones.get(pos) , Toast.LENGTH_SHORT).show();
			setContentView(new Seno (this,0,360));

		
		}
		
        if (v.getId()==R.id.buttongraficar && rbrango.isChecked()==true && pos==0  ){
        	Toast.makeText(getBaseContext(), "Graficando " + listfunciones.get(pos) , Toast.LENGTH_SHORT).show();
        	setContentView(new Seno (this,Integer.parseInt(etinicio.getText().toString()),Integer.parseInt(etfin.getText().toString())));
			
		}
          if (v.getId()==R.id.buttongraficar && rb0pi.isChecked()==true && pos==1 ){
        	  Toast.makeText(getBaseContext(), "Graficando " + listfunciones.get(pos) , Toast.LENGTH_SHORT).show();
        	  setContentView(new Coseno (this,0,360));
			
		}
		
        if (v.getId()==R.id.buttongraficar && rbrango.isChecked()==true && pos==1  ){
        	Toast.makeText(getBaseContext(), "Graficando " + listfunciones.get(pos) , Toast.LENGTH_SHORT).show();
		
        	setContentView(new Coseno (this,Integer.parseInt(etinicio.getText().toString()),Integer.parseInt(etfin.getText().toString())));
		
	}
		
	}
}
