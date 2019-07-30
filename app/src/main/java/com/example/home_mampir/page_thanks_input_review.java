package com.example.home_mampir;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.home_mampir.activity.MainActivity;

public class page_thanks_input_review extends Fragment {

    Button bttnThanksReview;

    public static page_thanks_input_review newInstance(){
        return new page_thanks_input_review();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page_thanks,container,false);

        bttnThanksReview = (Button)view.findViewById(R.id.bttn_thanks_review);

        bttnThanksReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = view.getContext();
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        });

        return view;

    }
}
