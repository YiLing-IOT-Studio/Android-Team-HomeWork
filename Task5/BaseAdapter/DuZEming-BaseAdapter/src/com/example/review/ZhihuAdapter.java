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
		mList.add(new Zhihu("鲨鱼捕食与生活","12223576 次浏览 6986 次添加",R.drawable.a));
		mList.add(new Zhihu("埃菲尔的空白","6010001 次浏览 9576 次添加",R.drawable.b));
		mList.add(new Zhihu("黑暗中的等待","8145450 次浏览 13252 次添加",R.drawable.c));
		mList.add(new Zhihu("电梯安全与艺术","2198429 次浏览 1987 次添加",R.drawable.d));
		mList.add(new Zhihu("黄昏的水彩","1879636 次浏览 9547 次添加",R.drawable.e));
		mList.add(new Zhihu("天空的空隙","20395405 次浏览 34928 次添加",R.drawable.f));
		mList.add(new Zhihu("工艺艺术与传承","11591668 次浏览 11190 次添加",R.drawable.g));
		mList.add(new Zhihu("食品安全与艺术","14028517 次浏览 40908 次添加",R.drawable.hg));

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
