package com.example.project;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.VerticalStepView;
import com.baoyachi.stepview.bean.StepBean;
import java.util.ArrayList;
import java.util.List;

public class CheckoutStepOne extends AppCompatActivity {

    TextView add_txt;
    EditText ch_address;
    TextView tel_txt;
    EditText ch_phone;
    Button ch_btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_step_one);

        HorizontalStepView Setpview = (HorizontalStepView) findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stp1 = new StepBean("Step-1", -1);
        StepBean stp2 = new StepBean("Step-2", -1);
        StepBean stp3 = new StepBean("Step-3", -1);

        stepsBeanList.add(stp1);
        stepsBeanList.add(stp2);
        stepsBeanList.add(stp3);


        Setpview
                .setStepViewTexts(stepsBeanList)
                .setTextSize(12)
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(CheckoutStepOne.this, R.color.brown))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(CheckoutStepOne.this, R.color.brown))
                .setStepViewComplectedTextColor(ContextCompat.getColor(CheckoutStepOne.this, R.color.brown))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(CheckoutStepOne.this, R.color.brown))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(CheckoutStepOne.this, R.drawable.baseline_done_24))
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(CheckoutStepOne.this, R.drawable.baseline_panorama_fish_eye_24))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(CheckoutStepOne.this, R.drawable.baseline_error_outline_24));


        add_txt = findViewById(R.id.add_txt);
        ch_address = findViewById(R.id.ch_address);
        tel_txt = findViewById(R.id.tel_txt);
        ch_phone = findViewById(R.id.ch_phone);
        ch_btn1 = findViewById(R.id.ch_btn1);
        ch_btn1.setOnClickListener(v -> {
            // Handle button click event
            Intent i = new Intent(getApplicationContext(), CheckoutStepTwo.class);
            startActivity(i);
            // Stop Lottie animation
        });

    }

}