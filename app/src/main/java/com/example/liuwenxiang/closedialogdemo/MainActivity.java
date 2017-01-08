package com.example.liuwenxiang.closedialogdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv__initDiglog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String btitil = MainActivity.this.getResources().getString(R.string.btitle);
                String startStr = MainActivity.this.getResources().getString(R.string.startStr);
                String content = MainActivity.this.getResources().getString(R.string.content);
                String singnature = MainActivity.this.getResources().getString(R.string.signature);
                AlertPolicyDialog(btitil,startStr,content,singnature);
            }
        });
    }


    /**
     * 关闭按钮的弹出框
     * @param btitle      大标题
     * @param startStr    银行
     * @param content     内容
     * @param signature   福利
     */
    private void AlertPolicyDialog(String btitle, String startStr, String content, String signature) {
        final PolicyDialog.Builder policyDialog = new PolicyDialog.Builder(MainActivity.this);
        policyDialog.setDialogInfo(btitle, startStr, content,
                signature, "免费领取", false, new PolicyDialog.ButtonCallBack() {
                    @Override
                    public void buttonClick() {

                        Toast.makeText(MainActivity.this,"做该做的事情吧！！！",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void cancelClick() {
                        Toast.makeText(MainActivity.this,"做该做的事情吧！！！",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void closeClick() {
                        Toast.makeText(MainActivity.this,"关闭弹框！！！",Toast.LENGTH_LONG).show();
                    }
                });
        policyDialog.create().show();
    }



}
