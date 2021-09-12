package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> implements View.OnClickListener {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        Button operate;

        public ViewHolder(View view) {
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruitname);
            operate = (Button) view.findViewById(R.id.button);
        }

    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.operate.setTag(position);
        holder.operate.setText("remove");
        holder.operate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

//                Intent intent = new Intent(MainActivity.this, Cart.class);
//                startActivity(intent);
            }
        })
        ;
//        setOnClickListener {
//            LogUtil.instance.d("点击了按钮$position")
//        }
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        public Button tvPractise;

        public ItemHolder(View itemView) {
            super(itemView);
            tvPractise = itemView.findViewById(R.id.button);

            //将创建的View注册点击事件
            //itemView.setOnClickListener(FruitAdapter.this);
            tvPractise.setOnClickListener(FruitAdapter.this);
        }
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    /** item里面有多个控件可以点击 */
//    public enum ViewName {
//        ITEM,
//        PRACTISE
//    }

    public interface OnRecyclerViewItemClickListener {
        void onClick(View view,  int position);
    }

    @Override
    public void onClick(View v) {
        //注意这里使用getTag方法获取数据
        int position = (int) v.getTag();
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onClick(v, position);
            }
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
    public void removeItem(int position){
        mFruitList.remove(position);
        notifyItemRemoved(position);
    }
}