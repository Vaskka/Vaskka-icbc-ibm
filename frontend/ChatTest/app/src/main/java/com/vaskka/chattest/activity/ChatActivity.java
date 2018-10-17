package com.vaskka.chattest.activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.vaskka.chattest.R;
import com.vaskka.chattest.adapter.MsgAdapter;
import com.vaskka.chattest.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    // 消息实体List
    private List<Msg> msgList = new ArrayList<>();

    // 布局控件
    private EditText inputText;

    private Button send;

    private RecyclerView msgRecyclerView;


    // 适配器
    private MsgAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // 初始化消息 +
        initMsg();
        // 初始化消息 -

        // 初始化控件
        inputText       = findViewById(R.id.input_text);
        send            = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);

        // 绑定适配器
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);

        // 初始化消息监听
        initEventListener();

    }

    /**
     * 初始化消息监听
     */
    private void initEventListener() {
        // 绑定滑动监听
        msgRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 拖动隐藏输入法
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    hideKeyboard(ChatActivity.this);
                }
            }


        });

        // 绑定发送按钮点击监听
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();


                if (!content.equals("")) {
                    // 信息有效，构造信息实体
                    Msg msg = new Msg(content, Msg.TYPE_SENT);

                    msgList.add(msg);

                    // 刷新显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    // 定位到最后
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);

                    // 清空输入框
                    inputText.setText("");
                }
            }
        });

    }


    /**
     * 隐藏软键盘
     */
    public static void hideKeyboard(Activity c) {
        try {
            InputMethodManager imm = (InputMethodManager) c.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(c.getCurrentFocus().getWindowToken(), 0);
        } catch (NullPointerException e) {
            Log.e("hideKeyboard", e.toString());
        }
    }

    /**
     * 初始化消息数据
     */
    private void initMsg() {
        Msg msg1 = new Msg("233", Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("receive", Msg.TYPE_RECEIVED);
        Msg msg3 = new Msg("send", Msg.TYPE_SENT);

        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);

    }
}
