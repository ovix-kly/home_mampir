package com.example.home_mampir;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class page_review_user extends Fragment {

    Button bttnSubmit;

    public static page_input_review newInstance(){
        return new page_input_review();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page_feedback,container,false);

        bttnSubmit = (Button)view.findViewById(R.id.bttn_submit_review);

        bttnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page_thanks_input_review pageThanksInputReview = new page_thanks_input_review();

                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_content, pageThanksInputReview)
                        //menggant fragment
                        .addToBackStack(null)
                        //menyimpan fragment
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        //transisi fragment
                        .commit();

            }
        });

        return view;

    }
}
