package com.example.phoebevu.crunchtime;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by phoebevu on 2/5/16.
 */
public class MyFragment1 extends Fragment {

    //Data
    HashMap<String, Double> data;

    //Variables
    String type;

    public static MyFragment1 getInstance() {
        MyFragment1 myFragment = new MyFragment1();
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Data Initialize
        data = new HashMap<String, Double>();
        data.put("Push Up", 3.5);
        data.put("Sit Up", 2.0);
        data.put("Squats", 2.25);
        data.put("Leg-lifting", 0.25);
        data.put("Plank", 0.25);
        data.put("Jumping Jack", 0.1);
        data.put("Pull Up", 0.1);
        data.put("Cycling", 0.12);
        data.put("Walking", 0.2);
        data.put("Jogging", 0.12);
        data.put("Swimming", 0.13);
        data.put("Stair-Climbing", 0.15);

        final View layout = inflater.inflate(R.layout.fragment_my, container, false);
        Button convButton = (Button) layout.findViewById(R.id.convBut);
        final Context context = container.getContext();

        convButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText) layout.findViewById(R.id.input);
                TextView output = (TextView) layout.findViewById(R.id.cal);
                String x = input.getText().toString().trim();
                double cal;
                if ((x == null) || (x.isEmpty())) {
                    cal = 0.0;
                } else {
                    cal = Double.parseDouble(x);
                }
                actDisplay(cal, layout);
            }
        });

        return layout;
    }

    public void actDisplay(Double cal, View layout) {

        TextView push = (TextView) layout.findViewById(R.id.push);
        push.setText(String.format("%.1f", (cal * data.get("Push Up"))) + " Reps");

        TextView climb = (TextView) layout.findViewById(R.id.climb);
        climb.setText(String.format("%.1f", (cal * data.get("Stair-Climbing"))) + " Mins");

        TextView cycling = (TextView) layout.findViewById(R.id.cycling);
        cycling.setText(String.format("%.1f", (cal * data.get("Cycling"))) + " Mins");

        TextView jog = (TextView) layout.findViewById(R.id.jog);
        jog.setText(String.format("%.1f", (cal * data.get("Jogging"))) + " Mins");

        TextView jump = (TextView) layout.findViewById(R.id.jump);
        jump.setText(String.format("%.1f", (cal * data.get("Jumping Jack"))) + " Mins");

        TextView lift = (TextView) layout.findViewById(R.id.lift);
        lift.setText(String.format("%.1f", (cal * data.get("Leg-lifting"))) + " Mins");

        TextView plank = (TextView) layout.findViewById(R.id.plank);
        plank.setText(String.format("%.1f", (cal * data.get("Plank"))) + " Mins");

        TextView pull = (TextView) layout.findViewById(R.id.pull);
        pull.setText(String.format("%.1f", (cal * data.get("Pull Up"))) + " Reps");

        TextView sit = (TextView) layout.findViewById(R.id.sit);
        sit.setText(String.format("%.1f", (cal * data.get("Sit Up"))) + " Reps");

        TextView squat = (TextView) layout.findViewById(R.id.squat);
        squat.setText(String.format("%.1f", (cal * data.get("Squats"))) + " Reps");

        TextView swim = (TextView) layout.findViewById(R.id.swim);
        swim.setText(String.format("%.1f", (cal * data.get("Swimming"))) + " Mins");

        TextView walk = (TextView) layout.findViewById(R.id.walk);
        walk.setText(String.format("%.1f", (cal * data.get("Walking"))) + " Mins");


    }

}
