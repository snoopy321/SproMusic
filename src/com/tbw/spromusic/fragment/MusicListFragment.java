/**
 * 
 */
package com.tbw.spromusic.fragment;

import com.tbw.spromusic.R;
import com.tbw.spromusic.util.Type;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

/**
 * @author tbw
 *
 */
public class MusicListFragment extends Fragment {

	private FrameLayout musicSearch;
	private ViewPager vp;
	private HorizontalScrollView hsv;
	private TextView[] musicTypes = new TextView[4];

	private String[] type = { "艺人", "专辑", "歌曲", "喜爱" };

	private float marginToLeft = 0;
	private int oldPageId = 0;

	private Fragment[] musicTypeFrag = { new MusicTypeListFragment(Type.艺人), new MusicTypeListFragment(Type.专辑),
			new MusicTypeListFragment(Type.歌曲), new MusicTypeListFragment(Type.喜爱) };

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.music_list, null);
		initView(view);
		// 给ViewPager设置适配器
		vp.setAdapter(new MusicListAdapter(getChildFragmentManager()));
		addListener();
		
		//避免View重复加载出错
		ViewGroup vg = (ViewGroup) view.getParent();
		if(vg != null) {
			vg.removeView(view);
		}
		return view;
	}

	/**
	 * 给ViewPager添加滑动监听器
	 */
	private void addListener() {
		// TODO Auto-generated method stub
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < musicTypeFrag.length; i++) {
					musicTypes[i].setTextColor(Color.parseColor("#6BB1F8"));
				}
				musicTypes[arg0].setTextColor(Color.WHITE);

				marginToLeft = musicTypes[0].length();

				if (oldPageId < arg0) {
					hsv.smoothScrollTo((int) (hsv.getScrollX() + marginToLeft), 0);
				} else {
					hsv.smoothScrollTo(hsv.getScrollX() - musicTypes[3].length(), 0);
				}
				oldPageId = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		for (int i = 0; i < musicTypes.length; i++) {
			musicTypes[i].setOnClickListener(new NavScrollClick());
		}
	}

	/**
	 * @param view
	 */
	private void initView(View root) {
		// TODO Auto-generated method stub
		musicSearch = root.findViewById(R.id.music_nav_search);
		vp = root.findViewById(R.id.music_vp);
		hsv = root.findViewById(R.id.music_nav_scorll);
		musicTypes[0] = root.findViewById(R.id.music_artist);
		musicTypes[1] = root.findViewById(R.id.music_album);
		musicTypes[2] = root.findViewById(R.id.music_song);
		musicTypes[3] = root.findViewById(R.id.music_fav);
	}

	class MusicListAdapter extends FragmentPagerAdapter {

		/**
		 * @param fm
		 */
		public MusicListAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
		 */
		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return musicTypeFrag[arg0];
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.support.v4.view.PagerAdapter#getCount()
		 */
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return musicTypeFrag.length;
		}

	}

	/*
	 * 音乐列表界面，点击分类标题，跳转至相应界面
	 */
	class NavScrollClick implements OnClickListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int tag = Integer.parseInt(v.getTag().toString());
			switch (tag) {
			case 0:
				vp.setCurrentItem(0);
				break;

			case 1:
				vp.setCurrentItem(1);
				break;
			case 2:
				vp.setCurrentItem(2);
				break;

			case 3:
				vp.setCurrentItem(3);
				break;
			}
		}

	}
}
