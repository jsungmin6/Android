package com.example.constraint;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.startevent);


        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//        dlg.setIcon(R.drawable.kangnamstation); // 아이콘 설정
//                버튼 클릭시 동작

        dlg.setView(image);
        dlg.setPositiveButton("자세히 보기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                //토스트 메시지
                Toast.makeText(MainActivity.this,"확인을 눌르셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        dlg.show();

    }
}