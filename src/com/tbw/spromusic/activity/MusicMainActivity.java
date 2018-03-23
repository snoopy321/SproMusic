
package com.tbw.spromusic.activity;

import java.util.List;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.tbw.spromusic.R;
import com.tbw.spromusic.fragment.MusicListFragment;
import com.tbw.spromusic.fragment.MusicPlayFragment;
import com.tbw.spromusic.fragment.MusicSettingFragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author tbw
 *
 */
public class MusicMainActivity extends BaseFragmentActivity {

	// @ViewInject(android.R.id.tabhost)
	private FragmentTabHost tabHost;

	private int[] tab_images = { R.drawable.music_list, R.drawable.music_play, R.drawable.music_setting };
	private String[] tab_strings = { "音乐", "播放", "设置" };
	private TextView[] textView = new TextView[4];
	private Class[] fragmentClasses = { MusicListFragment.class, MusicPlayFragment.class, MusicSettingFragment.class };

	private List<FragmentActivity> frags;

	private static boolean sPermissionReqProcessed = false;
	private static int REQUEST_EXTERNAL_STORAGE = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (getApplicationContext()
				.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
			requestMusicPermissions();
			sPermissionReqProcessed = false;
		} else {
			sPermissionReqProcessed = true;
			onCreateContinue();
		}

	}

	// 获取读取外部存储权限
	@SuppressLint("NewApi")
	private void requestMusicPermissions() {
		this.requestPermissions(new String[] { Manifest.permission.READ_EXTERNAL_STORAGE }, REQUEST_EXTERNAL_STORAGE);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
		if (requestCode == REQUEST_EXTERNAL_STORAGE) {
			// If request is cancelled, the result arrays are empty.
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				// permission was granted, yay! Do the
				// Storage-related task you need to do.
				sPermissionReqProcessed = true;
				onCreateContinue();
			} else {
				// permission denied, boo! Disable the
				// functionality that depends on this permission.
				finish();
				Toast.makeText(this, R.string.music_storage_permission_deny, Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * 
	 */
	private void onCreateContinue() {
		// TODO Auto-generated method stub
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		init();
		setTabHost();
	}

	/**
	 * 初始化组件
	 */
	private void init() {
		// TODO Auto-generated method stub
		tabHost = findViewById(android.R.id.tabhost);
		Log.i("tbw", "" + tabHost);
		tabHost.setup(this, getSupportFragmentManager(), R.id.real_content);
	}

	public void setTabHost() {
		for (int i = 0; i < tab_strings.length; i++) {
			TabSpec tabSpec = tabHost.newTabSpec(tab_strings[i]);
			tabSpec.setIndicator(getSpecContent(i, i));
			tabHost.addTab(tabSpec, fragmentClasses[i], null);
		}
	}

	/**
	 * 获取tabHost的spec
	 * 
	 * @param imgId
	 * @param txtId
	 * @return
	 */
	public View getSpecContent(int imgId, int txtId) {
		View root = LayoutInflater.from(this).inflate(R.layout.tab_host_spec, null);
		ImageView img = root.findViewById(R.id.host_spec_img);
		TextView txt = root.findViewById(R.id.host_spec_text);
		textView[txtId] = txt;
		img.setImageResource(tab_images[imgId]);
		txt.setText(tab_strings[txtId]);
		return root;
	}

}
