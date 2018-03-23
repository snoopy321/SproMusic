/**
 * 
 */
package com.tbw.spromusic.util;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.util.Log;

/**
 * @author tbw
 *
 */
public class MusicUtil {
	
	
	private static ArrayList<MusicListItem> itemList = new ArrayList<MusicListItem>();
	
	//获取song列表信息
	public static List<MusicListItem> getMusicSongData(Context context) {
		Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null,null,null, MediaStore.Audio.AudioColumns.IS_MUSIC);
		
		if(cursor != null) {
			while(cursor.moveToNext()) {
				MusicListItem item = new MusicListItem();
				Long album_id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ALBUM_ID));
				item.setImg(album_id);
				item.setTxtSongName(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DISPLAY_NAME)));
				item.setTxtArtistName(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ARTIST)));
				Log.i("tbw","aa: "+item.getImg()+"    "+item.getTxtSongName()+"   "+item.getTxtArtistName());
				itemList.add(item);
			}
		}
		cursor.close();
		
		return itemList;
		
	}
}
