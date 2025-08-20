package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;
import java.util.ArrayList;
import java.util.List;

public class CheckoutStepThree extends AppCompatActivity {

    TextView add_txt1;
    TextView add_txt2;
    TextView pay_txt1;
    TextView pay_txt2;
    Button conf_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_step_three);

        HorizontalStepView setpView =  findViewById(R.id.step_view2);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stp1 = new StepBean("Step-1", 1);
        StepBean stp2 = new StepBean("Step-2", 1);
        StepBean stp3 = new StepBean("Step-3", -1);

        stepsBeanList.add(stp1);
        stepsBeanList.add(stp2);
        stepsBeanList.add(stp3);


        setpView
                .setStepViewTexts(stepsBeanList)
                .setTextSize(12)
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(CheckoutStepThree.this, android.R.color.white))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(CheckoutStepThree.this, R.color.brown))
                .setStepViewComplectedTextColor(ContextCompat.getColor(CheckoutStepThree.this, android.R.color.white))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(CheckoutStepThree.this, R.color.white))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(CheckoutStepThree.this, R.drawable.baseline_done_24))
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(CheckoutStepThree.this, R.drawable.baseline_panorama_fish_eye_24))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(CheckoutStepThree.this, R.drawable.baseline_error_outline_24));


        add_txt1 = findViewById(R.id.add_txt1);
        add_txt2 = findViewById(R.id.add_txt2);
        pay_txt1 = findViewById(R.id.pay_txt1);
        pay_txt2 = findViewById(R.id.pay_txt2);
        conf_btn = findViewById(R.id.conf_btn);

        conf_btn.setOnClickListener(v -> {
            // Handle button click event
            Intent i = new Intent(getApplicationContext(), CheckoutStepFour.class);
            startActivity(i);

        });

    }
}