/**
 * 
 */
package com.tbw.spromusic.util;

import android.graphics.drawable.BitmapDrawable;

/**
 * @author tbw
 *	class for MusicListItem
 */
public class MusicListItem {
	private Long img;
	private String txtSongName;
	private String txtArtistName;
	private String  txtAlbumName;
	
	public MusicListItem() {
		
	}
	
	/**
	 * @param img
	 * @param txt1
	 * @param txt2
	 */
	public MusicListItem(Long img, String txt1, String txt2,String txt3) {
		super();
		this.img = img;
		this.txtSongName = txt1;
		this.txtArtistName = txt2;
		this.txtAlbumName = txt3;
	}

	/**
	 * @return the img
	 */
	public Long getImg() {
		return img;
	}

	/**
	 * @param bitmapDrawable the img to set
	 */
	public void setImg(Long img) {
		this.img = img;
	}

	/**
	 * @return the txtSongName
	 */
	public String getTxtSongName() {
		return txtSongName;
	}

	/**
	 * @param txtSongName the txtSongName to set
	 */
	public void setTxtSongName(String txtSongName) {
		this.txtSongName = txtSongName;
	}

	/**
	 * @return the txtArtistName
	 */
	public String getTxtArtistName() {
		return txtArtistName;
	}

	/**
	 * @param txtArtistName the txtArtistName to set
	 */
	public void setTxtArtistName(String txtArtistName) {
		this.txtArtistName = txtArtistName;
	}

	/**
	 * @return the txtAlbumName
	 */
	public String getTxtAlbumName() {
		return txtAlbumName;
	}

	/**
	 * @param txtAlbumName the txtAlbumName to set
	 */
	public void setTxtAlbumName(String txtAlbumName) {
		this.txtAlbumName = txtAlbumName;
	}

	
	
}
