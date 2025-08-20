package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

public class CheckoutStepFour extends AppCompatActivity {

    LottieAnimationView lottie1;
    TextView confirm_txt1;
    TextView confirm_txt2;
    Button done_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_step_four);

        HorizontalStepView Setpview = (HorizontalStepView) findViewById(R.id.step_view3);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stp1 = new StepBean("Step-1",1 );
        StepBean stp2 = new StepBean("Step-2", 1);
        StepBean stp3 = new StepBean("Step-3", 1);

        stepsBeanList.add(stp1);
        stepsBeanList.add(stp2);
        stepsBeanList.add(stp3);


        Setpview
                .setStepViewTexts(stepsBeanList)
                .setTextSize(12)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(CheckoutStepFour.this, android.R.color.white))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(CheckoutStepFour.this, R.color.brown))
                .setStepViewComplectedTextColor(ContextCompat.getColor(CheckoutStepFour.this, android.R.color.white))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(CheckoutStepFour.this, R.color.white))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(CheckoutStepFour.this, R.drawable.baseline_done_24))
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(CheckoutStepFour.this, R.drawable.baseline_panorama_fish_eye_24))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(CheckoutStepFour.this, R.drawable.baseline_error_outline_24));


        lottie1 = findViewById(R.id.lottie1);
        confirm_txt1 = findViewById(R.id.confirm_txt1);
        confirm_txt2 = findViewById(R.id.confirm_txt2);
        done_btn = findViewById(R.id.done_btn);

        lottie1.animate().translationX(0).setDuration(2000).setStartDelay(2900);

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

                lottie1.cancelAnimation();

            }
        });


    }
}