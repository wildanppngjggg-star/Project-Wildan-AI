
package com.wildan.ai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    LinearLayout chat;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 24, 24, 24);
        root.setBackgroundColor(Color.rgb(12, 18, 32));

        TextView title = new TextView(this);
        title.setText("PROJECT WILDAN AI");
        title.setTextSize(24);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        TextView welcome = new TextView(this);
        welcome.setText(
            "Halo! Saya Wildan AI. Tanyakan sesuatu!"
        );
        welcome.setTextSize(17);
        welcome.setTextColor(Color.WHITE);
        welcome.setPadding(0, 30, 0, 20);
        root.addView(welcome);

        ScrollView scroll = new ScrollView(this);
        chat = new LinearLayout(this);
        chat.setOrientation(LinearLayout.VERTICAL);
        scroll.addView(chat);

        root.addView(scroll, new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 0, 1
        ));

        EditText input = new EditText(this);
        input.setHint("Ketik pertanyaan...");
        input.setSingleLine(true);
        input.setTextColor(Color.WHITE);
        input.setHintTextColor(Color.LTGRAY);
        root.addView(input);

        Button send = new Button(this);
        send.setText("Kirim");
        root.addView(send);

        send.setOnClickListener(v -> {
            String question = input.getText().toString().trim();
            if (question.isEmpty()) return;

            addMessage("Kamu: " + question);

            addMessage(
                "Wildan AI: Ini masih versi awal. " +
                "AI online akan ditambahkan pada tahap berikutnya."
            );

            input.setText("");
        });

        setContentView(root);
    }

    void addMessage(String message) {
        TextView text = new TextView(this);
        text.setText(message);
        text.setTextColor(Color.WHITE);
        text.setTextSize(16);
        text.setPadding(0, 12, 0, 12);
        chat.addView(text);
    }
}
