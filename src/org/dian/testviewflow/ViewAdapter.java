package org.dian.testviewflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ViewAdapter extends BaseAdapter {

	/**xml view�����*/
	private LayoutInflater mInflater;
	/**Ҫ�õ���ͼƬid����*/
	private Integer[] coverIds;
	
	public ViewAdapter(Context context, Integer[] drawableId) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		coverIds = drawableId;
	}
	
	@Override
	public int getCount() {
		return coverIds.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.view_item, null);
		}
		ImageView iv = (ImageView) convertView.findViewById(R.id.imageview);
		iv.setImageResource(coverIds[position]);
		return convertView;
	}
}
