package com.example.bluetoothtest;

import android.os.Handler;
import android.widget.TextView;

/**
 * Handler — это механизм, который позволяет работать с очередью сообщений. Он привязан к
 * конкретному потоку (thread) и работает с его очередью. Handler умеет помещать сообщения в
 * очередь.
 * При этом он ставит самого себя в качестве получателя этого сообщения. И когда приходит время,
 * система достает сообщение из очереди и отправляет его адресату (т.е. в Handler) на обработку.
 */
public class MyHandler extends Handler {

    private final int ARDUINO_DATA = 1;
    private TextView mytext;

    public MyHandler(TextView mytext) {
        this.mytext = mytext;
    }

    /**
     * Обрабатывает сообщения handleMessage. Мы извлекаем из сообщения атрибут what, obj и аргументы
     * типа int. Преобразуем полученное сообщение в строку и выводим его в текстовое поле главного
     * activity: mytext.setText(«Данные от Arduino: » + strIncom)
     */
    public void handleMessage(android.os.Message msg) {
        switch (msg.what) {
            case ARDUINO_DATA:
                byte[] readBuf = (byte[]) msg.obj;
                String strIncom = new String(readBuf, 0, msg.arg1);
                mytext.setText("Данные от Arduino: " + strIncom);
                break;
        }
    }

    public int getARDUINO_DATA() {
        return ARDUINO_DATA;
    }
}
