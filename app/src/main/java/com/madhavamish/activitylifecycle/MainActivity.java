package com.madhavamish.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Counter counter;
    TextView c_onCreate, c_onStart, c_onResume, c_onPause, c_onStop, c_onRestart, c_onDestroy;
    TextView t_onCreate, t_onStart, t_onResume, t_onPause, t_onStop, t_onRestart, t_onDestroy;
    Button reset;
    
//    int[] current = new int[] {0, 0, 0, 0, 0, 0, 0};
//    int[] totals = new int[] {0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = preferences.edit();
        counter = new Counter();
        reset = findViewById(R.id.button);
        
        c_onCreate = findViewById(R.id.onCreate);
        c_onStart = findViewById(R.id.onStart);
        c_onResume = findViewById(R.id.onResume);
        c_onPause = findViewById(R.id.onPause);
        c_onStop = findViewById(R.id.onStop);
        c_onRestart = findViewById(R.id.onRestart);
        c_onDestroy = findViewById(R.id.onDestroy);
        
        t_onCreate = findViewById(R.id.t_onCreate);
        t_onStart = findViewById(R.id.t_onStart);
        t_onResume = findViewById(R.id.t_onResume);
        t_onPause = findViewById(R.id.t_onPause);
        t_onStop = findViewById(R.id.t_onStop);
        t_onRestart = findViewById(R.id.t_onRestart);
        t_onDestroy = findViewById(R.id.t_onDestroy);

        counter.setCreate(counter.getCreate()+1);
        Log.i("debug", "onCreate");
        c_onCreate.setText("onCreate(): " + counter.getCreate());
        c_onStart.setText("onStart(): " + counter.getStart());
        c_onResume.setText("onResume(): " + counter.getResume());
        c_onPause.setText("onPause(): " + counter.getPause());
        c_onStop.setText("onStop(): " + counter.getStop());
        c_onRestart.setText("onRestart(): " + counter.getRestart());
        c_onDestroy.setText("onDestroy(): " + counter.getDestroy());

        counter.shared_preferences("create");
        t_onCreate.setText("onCreate(): " + preferences.getInt("create", 0));
        t_onStart.setText("onStart(): " + preferences.getInt("start", 0));
        t_onResume.setText("onResume(): " + preferences.getInt("resume", 0));
        t_onPause.setText("onPause(): " + preferences.getInt("pause", 0));
        t_onStop.setText("onStop(): " + preferences.getInt("stop", 0));
        t_onRestart.setText("onRestart(): " + preferences.getInt("restart", 0));
        t_onDestroy.setText("onDestroy(): " + preferences.getInt("destroy", 0));

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.reset();

                c_onCreate.setText("onCreate(): " + counter.getCreate());
                c_onStart.setText("onStart(): " + counter.getStart());
                c_onResume.setText("onResume(): " + counter.getResume());
                c_onPause.setText("onPause(): " + counter.getPause());
                c_onStop.setText("onStop(): " + counter.getStop());
                c_onRestart.setText("onRestart(): " + counter.getRestart());
                c_onDestroy.setText("onDestroy(): " + counter.getDestroy());

                t_onCreate.setText("onCreate(): " + preferences.getInt("create", 0));
                t_onStart.setText("onStart(): " + preferences.getInt("start", 0));
                t_onResume.setText("onResume(): " + preferences.getInt("resume", 0));
                t_onPause.setText("onPause(): " + preferences.getInt("pause", 0));
                t_onStop.setText("onStop(): " + preferences.getInt("stop", 0));
                t_onRestart.setText("onRestart(): " + preferences.getInt("restart", 0));
                t_onDestroy.setText("onDestroy(): " + preferences.getInt("destroy", 0));
            }
        });
    }

    @Override
    public void onStart(){
        Log.i("debug", "onStart");
        counter.setStart(counter.getStart()+1);
        counter.shared_preferences("start");
        c_onStart.setText("onStart(): " + counter.getStart());
        t_onStart.setText("onStart(): " + preferences.getInt("start", 0));
        super.onStart();
    }

    @Override
    public void onResume(){
        Log.i("debug", "onResume");
        counter.setResume(counter.getResume()+1);
        counter.shared_preferences("resume");
        c_onResume.setText("onResume(): " + counter.getResume());
        t_onResume.setText("onResume(): " + preferences.getInt("resume", 0));
        super.onResume();
    }

    @Override
    public void onPause(){
        Log.i("debug", "onPause");
        counter.setPause(counter.getPause()+1);
        counter.shared_preferences("pause");
        c_onPause.setText("onPause(): " + counter.getPause());
        t_onPause.setText("onPause(): " + preferences.getInt("pause", 0));
        super.onPause();
    }

    @Override
    public void onStop(){
        Log.i("debug", "onStop");
        counter.setStop(counter.getStop()+1);
        counter.shared_preferences("stop");
        c_onStop.setText("onStop(): " + counter.getStop());
        t_onStop.setText("onStop(): " + preferences.getInt("stop", 0));
        super.onStop();
    }

    @Override
    public void onRestart() {
        Log.i("debug", "onRestart");
        counter.setRestart(counter.getRestart()+1);
        counter.shared_preferences("restart");
        c_onRestart.setText("onRestart(): " + counter.getRestart());
        t_onRestart.setText("onRestart(): " + preferences.getInt("restart", 0));
        super.onRestart();
    }

    @Override
    public void onDestroy() {
        Log.i("debug", "onDestroy");
        counter.setDestroy(counter.getDestroy()+1);
        counter.setResume(0);
        counter.shared_preferences("destroy");
        c_onDestroy.setText("onDestroy(): " + counter.getStart());
        t_onDestroy.setText("onDestroy(): " + preferences.getInt("destroy", 0));
        super.onDestroy();
    }

    private class Counter{
        int create, start, resume, pause, stop, restart, destroy;
        public Counter(){
            create = 0;
            start = 0;
            resume = 0;
            pause = 0;
            stop = 0;
            restart = 0;
            destroy = 0;
        }

        public void shared_preferences(String key){
            editor.putInt(key, preferences.getInt(key, 0)+1);
            editor.apply();
        }

        public void reset(){
            editor.putInt("create", 0);
            editor.putInt("start", 0);
            editor.putInt("resume", 0);
            editor.putInt("pause", 0);
            editor.putInt("stop", 0);
            editor.putInt("restart", 0);
            editor.putInt("destroy", 0);

            editor.apply();

            setCreate(0);
            setStart(0);
            setResume(0);
            setPause(0);
            setStop(0);
            setRestart(0);
            setDestroy(0);
        }

        public int getCreate() {
            return create;
        }

        public int getStart() {
            return start;
        }

        public int getResume() {
            return resume;
        }

        public int getPause() {
            return pause;
        }

        public int getStop() {
            return stop;
        }

        public int getRestart() {
            return restart;
        }

        public int getDestroy() {
            return destroy;
        }

        public void setCreate(int create) {
            this.create = create;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setResume(int resume) {
            this.resume = resume;
        }

        public void setPause(int pause) {
            this.pause = pause;
        }

        public void setStop(int stop) {
            this.stop = stop;
        }

        public void setRestart(int restart) {
            this.restart = restart;
        }

        public void setDestroy(int destroy) {
            this.destroy = destroy;
        }
    }
}
