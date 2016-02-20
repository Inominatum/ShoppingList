package bullet.shoppinglist;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	public int editTexts = 7;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("myapp", "on create before numberoftext");
		setFocusOnEditText();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void setFocusOnEditText(){
		LinearLayout layout = (LinearLayout) findViewById(R.id.PriceLayout);
		this.editTexts = layout.getChildCount();
		for(int i=0; i<editTexts;i++){
			try{
				if(layout.getChildAt(i) instanceof EditText){
					EditText b = (EditText) layout.getChildAt(i);
					b.setOnFocusChangeListener(new OnFocusChangeListener() {
						@Override
						public void onFocusChange(View v, boolean hasFocus) {
							if(!hasFocus){
								getNumberOfText();
							}
						}
					});
				}
			}
			catch(Exception e){
				Log.d("myapp",e.getMessage());
			}
		}
	}
	
	public void getNumberOfText(){
		Log.d("myapp","enter in number of text");
		LinearLayout layout = (LinearLayout) findViewById(R.id.PriceLayout);
		this.editTexts = layout.getChildCount();
		String value;
		Double sum;
		Double total=0.0;
		for(int i=0; i<editTexts;i++){
			try{
				if(layout.getChildAt(i) instanceof EditText){
					EditText b = (EditText) layout.getChildAt(i);
					value = b.getText().toString();
					sum = Double.parseDouble(value);
					total+=sum;
				}
			}
			catch(Exception e){
				Log.d("myapp",e.getMessage());
			}
		}
		TextView tot = (TextView)findViewById(R.id.textView1);
		tot.setText(total.toString());
	}
}
