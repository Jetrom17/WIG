package com.wig;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String url_input = "";
	private String language = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private Button button1;
	private CardView cardview1;
	private EditText edittext1;
	
	private Intent url_git = new Intent();
	private AlertDialog.Builder dialog_warn;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		button1 = findViewById(R.id.button1);
		cardview1 = findViewById(R.id.cardview1);
		edittext1 = findViewById(R.id.edittext1);
		dialog_warn = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Github_io();
			}
		});
	}
	
	private void initializeLogic() {
		Locale current = getResources().getConfiguration().locale;
		String language = current.getLanguage();
		AlertDialog.Builder dialog_warn = new AlertDialog.Builder(MainActivity.this);
		
		if (language.equals("pt")) {
			    dialog_warn.setTitle("⚠️ Atenção");
			    dialog_warn.setMessage("Olá. Esse aplicativo contém versão 1.0.0.\n\nVocê insere url com subdomínio \"github.io\" e terás acesso ao repositório.");
		} else if (language.equals("en")) {
			    dialog_warn.setTitle("⚠️ Attention");
			    dialog_warn.setMessage("Hello. This application contains version 1.0.0.\n\nYou enter the URL with the subdomain \"github.io\" to access the repository.");
		} else if (language.equals("fa")) {
			    dialog_warn.setTitle("⚠️ توجه");
			    dialog_warn.setMessage("سلام. این برنامه شامل نسخه 1.0.0 است.\n\nشما URL را با زیر دامنه \"github.io\" وارد می کنید و به مخزن دسترسی پیدا می کنید.");
		} else if (language.equals("ar")) {
			    dialog_warn.setTitle("⚠️ انتباه");
			    dialog_warn.setMessage("مرحبًا. يحتوي هذا التطبيق على الإصدار 1.0.0.\n\nأدخل عنوان URL مع النطاق الفرعي \"github.io\" للوصول إلى المستودع.");
		} else if (language.equals("hi")) {
			    dialog_warn.setTitle("⚠️ ध्यान दें");
			    dialog_warn.setMessage("नमस्ते। यह एप्लिकेशन संस्करण 1.0.0 है।\n\nआप \"github.io\" उपडोमेन के साथ URL दर्ज करते हैं और आप भंडार तक पहुँच प्राप्त करते हैं।");
		}
		
		dialog_warn.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			    @Override
			    public void onClick(DialogInterface _dialog, int _which) {
				        
				    }
		});
		
		AlertDialog dialog = dialog_warn.create();
		dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
		dialog.show();
		// button1
		
		android.graphics.drawable.GradientDrawable JEEJFCC = new android.graphics.drawable.GradientDrawable();JEEJFCC.setColor(Color.argb(255,255,255,255));
		JEEJFCC.setCornerRadius(35);
		android.graphics.drawable.RippleDrawable JEEJFCC_RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.argb(25,0,0,0)}), JEEJFCC, null);
		button1.setBackground(JEEJFCC_RE);
		if(Build.VERSION.SDK_INT >= 21) { button1.setElevation(5f); }
	}
	
	public void _Github_io() {
		String url_input = edittext1.getText().toString();
		
		if (url_input.contains("github.io")) {
			    String[] parts = url_input.replace("https://", "").split(".github.io/");
			
			    if (parts.length == 2) {
				        String username = parts[0];
				        String repository = parts[1];
				        String github_url = "https://github.com/" + username + "/" + repository;
				
				        Intent url_git = new Intent(Intent.ACTION_VIEW);
				        url_git.setData(Uri.parse(github_url));
				        startActivity(url_git);
				    } else {
				        SketchwareUtil.showMessage(getApplicationContext(), "Invalid URL format");
				    }
		} else {
			    SketchwareUtil.showMessage(getApplicationContext(), "Invalid");
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}