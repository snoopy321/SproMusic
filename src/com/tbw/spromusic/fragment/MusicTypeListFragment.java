/**
 * 
 */
package com.tbw.spromusic.fragment;

import java.util.ArrayList;

import com.tbw.spromusic.R;
import com.tbw.spromusic.adapter.MusicListItemAdapter;
import com.tbw.spromusic.util.MusicListItem;
import com.tbw.spromusic.util.MusicUtil;
import com.tbw.spromusic.util.SwipeRefreshLayout;
import com.tbw.spromusic.util.Type;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author tbw
 *
 *	音乐分类Fragment
 */
public class MusicTypeListFragment extends Fragment{
	private Type musicType;
	private ListView listView;
	private SwipeRefreshLayout refresh;
	private View root;
	private ArrayList<MusicListItem> item;
	/**
	 * 
	 */
	public MusicTypeListFragment(Type type) {
		// TODO Auto-generated constructor stub
		this.musicType = type;
		
	}
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(root == null) {
			root= inflater.inflate(R.layout.news_navgation_type, null);
		}
		if(getUserVisibleHint()) {
			initViews();
		}
		
		return root;
	}

	/**
	 * 
	 */
	private void initViews() {
		// TODO Auto-generated method stub
		refresh = root.findViewById(R.id.music_list_container);
		listView = root.findViewById(R.id.music_listview);
		item = new ArrayList<MusicListItem>();
		/*
		for(int i= 0;i<20;i++) {
			item.add(new MusicListItem(R.drawable.ic_launcher, "aa: "+i, "bb: "+i,"cc: "+i));
		}*/
		
		item = (ArrayList<MusicListItem>) MusicUtil.getMusicSongData(getContext());
		
		listView.setAdapter(new MusicListItemAdapter(getContext(),item,musicType));
	}

}
