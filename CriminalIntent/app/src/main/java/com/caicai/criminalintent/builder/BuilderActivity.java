package com.caicai.criminalintent.builder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.caicai.criminalintent.R;

/**
 * Author : caicai
 * Time : 2016/4/18 10:32
 * Description:构造器模式
 * 定义:将一个复杂对象的构建与他的表示分离,使得同样的构建过程可以创建不同的表示 即对象的属性是通过一个构造器来设置的,最后返回一个不同属性的对象
 */
public class BuilderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
        Builder worker = new Worker();
        Designer designer = new Designer();
        designer.order(worker);
        Room room = worker.getRoom();

        TextView showTv = (TextView) findViewById(R.id.builder_tv);

        showTv.setText("window:" + room.window + "----floor:" + room.floor);
        showTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(BuilderActivity.this).setTitle("title").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BuilderActivity.this, "ok", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BuilderActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        final Button showDialog = (Button) findViewById(R.id.builder_dialog);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BuilderActivity.this,AlertDialog.THEME_HOLO_LIGHT);

                View view = View.inflate(getApplicationContext(), R.layout.dialog_builder, null);
                Button ok = (Button) view.findViewById(R.id.btn_ok);
                Button cancel = (Button) view.findViewById(R.id.btn_cancel);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BuilderActivity.this, "ok", Toast.LENGTH_SHORT).show();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BuilderActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });


                AlertDialog dialog = builder.create();
                dialog.setTitle("title");
                TextView subTitle = new TextView(BuilderActivity.this);
//                dialog.setCustomTitle(subTitle);
                dialog.setMessage("message");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setView(view);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

            }
        });

    }

}
