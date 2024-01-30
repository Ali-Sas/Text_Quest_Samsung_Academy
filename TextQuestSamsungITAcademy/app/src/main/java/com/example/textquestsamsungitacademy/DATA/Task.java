package com.example.textquestsamsungitacademy.DATA;

public class Task {
    public int number_quest, number_quest_continue;
    public String text_quest, bt_1, bt_2, bt_3, reason_1, reason_2;
    public boolean done_bt_1, done_bt_2, done_bt_3;

    public Task(int number_quest, int number_quest_continue, String text_quest, String bt_1, String bt_2, String bt_3, boolean done_bt_1, boolean done_bt_2, boolean done_bt_3, String reason_1, String reason_2){
        this.number_quest = number_quest;
        this.text_quest = text_quest;
        this.bt_1 = bt_1;
        this.bt_2 = bt_2;
        this.bt_3 = bt_3;
        this.done_bt_1 = done_bt_1;
        this.done_bt_2 = done_bt_2;
        this.done_bt_3 = done_bt_3;
        this.reason_1 = reason_1;
        this.reason_2 = reason_2;
    }
}
