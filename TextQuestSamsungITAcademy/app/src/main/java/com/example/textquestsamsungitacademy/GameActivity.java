package com.example.textquestsamsungitacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.textquestsamsungitacademy.DATA.DATA;

public class GameActivity extends AppCompatActivity {
    Button bt_1, bt_2, bt_3;
    TextView tx;
    private int count_task_continue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bt_1 = (Button) findViewById(R.id.bt_game_1);
        bt_2 = (Button) findViewById(R.id.bt_game_2);
        bt_3 = (Button) findViewById(R.id.bt_game_3);

        bt_1.setOnClickListener(onClickListener);
        bt_2.setOnClickListener(onClickListener);
        bt_3.setOnClickListener(onClickListener);

        tx = (TextView) findViewById(R.id.tx_game);

        start_new_task(DATA.getCount_task(), 0);
    }

    private void start_new_task(int count_task, int count_task_continue){

        if (count_task == 2)
        {
            startActivity(new Intent(GameActivity.this, ResultActivity.class).putExtra("et",DATA.tasks[count_task][0].text_quest));

        } else
        {
            tx.setText(DATA.tasks[count_task][count_task_continue].text_quest);

            bt_1.setText(DATA.tasks[count_task][count_task_continue].bt_1);
            bt_2.setText(DATA.tasks[count_task][count_task_continue].bt_2);
            bt_3.setText(DATA.tasks[count_task][count_task_continue].bt_3);
        }

    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            int count_task = DATA.getCount_task();

            switch(v.getId()){
                case R.id.bt_game_1:
                   if (!(DATA.tasks[count_task][count_task_continue].done_bt_1))
                        lose(DATA.tasks[count_task][count_task_continue].reason_1);

                   break;
                case R.id.bt_game_2:
                    if (!(DATA.tasks[count_task][count_task_continue].done_bt_2))
                        lose(DATA.tasks[count_task][count_task_continue].reason_2);

                    if(count_task == 0)
                        count_task_continue = 0;

                    break;
                case R.id.bt_game_3:
                    if (!(DATA.tasks[count_task][count_task_continue].done_bt_3))
                        lose(DATA.tasks[count_task][count_task_continue].reason_2);

                    if(count_task == 1 && count_task_continue == 0)
                        DATA.setCount_task(-1);

                    if(count_task == 0)
                        count_task_continue = 1;

                    break;

            }

            DATA.setCount_task(DATA.getCount_task() + 1);
            start_new_task(DATA.getCount_task(), count_task_continue);
        }
    };

    private void lose(String eText){
        DATA.setCount_task(DATA.getCount_task() - 1);
        startActivity(new Intent(GameActivity.this, ResultActivity.class).putExtra("et", eText));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(GameActivity.this, MainActivity.class));
    }
}