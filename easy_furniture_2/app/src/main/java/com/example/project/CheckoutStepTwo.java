package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

public class CheckoutStepTwo extends AppCompatActivity {

    LottieAnimationView lottie;
    Button btn_con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_step_two);

        HorizontalStepView Setpview = (HorizontalStepView) findViewById(R.id.step_view1);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stp1 = new StepBean("Step-1", 1);
        StepBean stp2 = new StepBean("Step-2", -1);
        StepBean stp3 = new StepBean("Step-3", -1);

        stepsBeanList.add(stp1);
        stepsBeanList.add(stp2);
        stepsBeanList.add(stp3);

        Setpview
                .setStepViewTexts(stepsBeanList)
                .setTextSize(12)
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(CheckoutStepTwo.this, android.R.color.white))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(CheckoutStepTwo.this, R.color.brown))
                .setStepViewComplectedTextColor(ContextCompat.getColor(CheckoutStepTwo.this, android.R.color.white))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(CheckoutStepTwo.this, R.color.white))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(CheckoutStepTwo.this, R.drawable.baseline_done_24))
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(CheckoutStepTwo.this, R.drawable.baseline_panorama_fish_eye_24))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(CheckoutStepTwo.this, R.drawable.baseline_error_outline_24));

        lottie = findViewById(R.id.lottie);
        btn_con = findViewById(R.id.btn_con);

        lottie.animate().translationX(0).setDuration(2000).setStartDelay(2900);

        btn_con.setOnClickListener(v -> {
            // Handle button click event
            Intent i = new Intent(getApplicationContext(), CheckoutStepThree.class);
            startActivity(i);
            // Stop Lottie animation
            lottie.cancelAnimation();
        });



    }
}