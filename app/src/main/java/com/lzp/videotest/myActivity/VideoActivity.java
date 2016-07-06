package com.lzp.videotest.myActivity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsoluteLayout;

import com.lzp.videotest.R;
import com.lzp.videotest.myVideoview.VideoPlayer;

public class VideoActivity extends AppCompatActivity {

    private AbsoluteLayout main;
    private String Path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        main = (AbsoluteLayout) findViewById(R.id.main_layout);
        Path = Environment.getExternalStorageDirectory().getPath();
        Log.i("activity","path:"+Path);
        Path = Path + "/playlist/1466749643309.flv";
        Log.i("activity","filepath:"+Path);

        init();
    }

    private void init() {

        AbsoluteLayout a = new AbsoluteLayout(this);
        a.setLayoutParams(new AbsoluteLayout.LayoutParams(800,600,0,0));

        main.addView(a);

        AbsoluteLayout b = new AbsoluteLayout(this);
        b.setLayoutParams(new AbsoluteLayout.LayoutParams(800,600,0,620));
        main.addView(b);

        AbsoluteLayout c = new AbsoluteLayout(this);
        c.setLayoutParams(new AbsoluteLayout.LayoutParams(800,600,0,1240));
        main.addView(c);


        //创建播放器
        VideoPlayer vp1 = new VideoPlayer(VideoActivity.this,a);
        vp1.setMyLayout(0,0,800,600);

        VideoPlayer vp2 = new VideoPlayer(VideoActivity.this,b);
        vp2.setMyLayout(0,620,800,660);

        VideoPlayer vp3 = new VideoPlayer(VideoActivity.this,c);
        vp3.setMyLayout(0,1240,800,600);

        vp1.loadRouce(Path);
        vp2.loadRouce(Path);
        vp3.loadRouce(Path);

        vp1.start();
        vp2.start();
        vp3.start();
    }


}
