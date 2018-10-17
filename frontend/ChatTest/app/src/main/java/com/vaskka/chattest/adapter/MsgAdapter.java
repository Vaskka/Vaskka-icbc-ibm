package com.vaskka.chattest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vaskka.chattest.R;
import com.vaskka.chattest.entity.Msg;

import java.util.List;

public class MsgAdapter extends  RecyclerView.Adapter<MsgAdapter.ViewHolder>{
    private List<Msg> mMsgList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Msg msg  = mMsgList.get(i);

        // 判断消息类型
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            // 收到的消息，显示在左边，右边的消息隐藏
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);

            viewHolder.leftMsg.setText(msg.getContent());
        }
        else if (msg.getType() == Msg.TYPE_SENT) {
            // 发送的消息，显示在右边，左边的消息隐藏
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);

            viewHolder.rightMsg.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    /**
     * ViewHolder
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;

        LinearLayout rightLayout;

        TextView leftMsg;

        TextView rightMsg;

        ImageView leftHeadImage;

        ImageView rightHeadImage;

        public ViewHolder(View view) {
            super(view);
            leftLayout  = (LinearLayout) view.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            leftMsg     = (TextView) view.findViewById(R.id.left_msg);
            rightMsg    = (TextView) view.findViewById(R.id.right_msg);
            leftHeadImage = (ImageView) view.findViewById(R.id.left_head_image);
            rightHeadImage = (ImageView) view.findViewById(R.id.right_head_image);

        }

    }


    public MsgAdapter(List<Msg> msgList) {
        mMsgList = msgList;
    }


}
