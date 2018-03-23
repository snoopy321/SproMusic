/**
 * 
 */
package com.tbw.spromusic.adapter;

import java.util.ArrayList;

import com.tbw.spromusic.R;
import com.tbw.spromusic.util.MusicListItem;
import com.tbw.spromusic.util.Type;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author tbw
 *
 */
public class MusicListItemAdapter extends BaseAdapter{
	
	private Context context;
	private ArrayList<MusicListItem> item;
	private Type type;
	/**
	 * 
	 */
	public MusicListItemAdapter(Context context,ArrayList<MusicListItem> item,Type type) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.item = item;
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View root = convertView;
		ViewHolder viewHolder = new ViewHolder();
		Log.i("tbw",""+type);
		if(root == null) {
			root = LayoutInflater.from(context).inflate(R.layout.music_list_item, null);
			viewHolder.img = root.findViewById(R.id.music_list_item_img);
			viewHolder.txt1 = root.findViewById(R.id.music_list_item_txt1);
			viewHolder.txt2 = root.findViewById(R.id.music_list_item_txt2);
			root.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) root.getTag();
		}
		
		Log.i("tbww","mm: "+item.get(position).getImg());
		//viewHolder.img.setImageResource(item.get(position).getImg());
		viewHolder.txt1.setText(item.get(position).getTxtSongName());
		viewHolder.txt2.setText(item.get(position).getTxtArtistName());
		return root;
	}
	
	class ViewHolder {
		ImageView img;
		TextView txt1;
		TextView txt2;
	}

}
