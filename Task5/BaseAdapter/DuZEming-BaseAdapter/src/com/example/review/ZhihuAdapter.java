package com.example.review;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class Zhihu {
	 String title;
	 String look;
	 int imageId;
    public  String getTitle() {
		return title;
	}
	public Zhihu(String title, String look, int imageId) {
		this.title = title;
		this.look = look;
		this.imageId = imageId;
	}



}
public class ZhihuAdapter extends BaseAdapter {
	
     static List<Zhihu> mList = new ArrayList<Zhihu>();

	{
		mList.add(new Zhihu("���㲶ʳ������","12223576 ����� 6986 �����",R.drawable.a));
		mList.add(new Zhihu("���ƶ��Ŀհ�","6010001 ����� 9576 �����",R.drawable.b));
		mList.add(new Zhihu("�ڰ��еĵȴ�","8145450 ����� 13252 �����",R.drawable.c));
		mList.add(new Zhihu("���ݰ�ȫ������","2198429 ����� 1987 �����",R.drawable.d));
		mList.add(new Zhihu("�ƻ��ˮ��","1879636 ����� 9547 �����",R.drawable.e));
		mList.add(new Zhihu("��յĿ�϶","20395405 ����� 34928 �����",R.drawable.f));
		mList.add(new Zhihu("���������봫��","11591668 ����� 11190 �����",R.drawable.g));
		mList.add(new Zhihu("ʳƷ��ȫ������","14028517 ����� 40908 �����",R.drawable.hg));

	}

	private Context mContext;

	public ZhihuAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int i) {
		return mList.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}
 
	@SuppressLint("ViewHolder")
	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {

		LayoutInflater inflater = LayoutInflater.from(mContext);
		View inflate;
		Zhihu zhihu=mList.get(i);
		ViewHolder viewHolder;
		if(view==null){
			inflate = inflater.inflate(R.layout.zhihu_item, null);
			viewHolder=new ViewHolder();
			viewHolder.zhihuImage=(ImageView) inflate.findViewById(R.id.iv_zhihu);
			viewHolder.title=(TextView) inflate.findViewById(R.id.tv_zhihu_1);
			viewHolder.look=(TextView) inflate.findViewById(R.id.tv_zhihu_2);
			inflate.setTag(viewHolder);
		}
		else{
			inflate=view;
			viewHolder=(ViewHolder) inflate.getTag();
		}
		viewHolder.title.setText(zhihu.title);
		viewHolder.look.setText(zhihu.look);
		viewHolder.zhihuImage.setImageResource(zhihu.imageId);
 		return inflate;
		
		}
	class ViewHolder{
		ImageView zhihuImage;
		TextView title;
		TextView look;
	}
}
