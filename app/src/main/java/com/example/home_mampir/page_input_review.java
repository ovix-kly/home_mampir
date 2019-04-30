package com.example.home_mampir;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class page_input_review extends BottomSheetDialogFragment {

    Button bttnSubmit;

    public static page_input_review newInstance(){
        return new page_input_review();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.container_review,container,false);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        page_review_user pageReviewUser = new page_review_user();
        fragmentTransaction.add(R.id.frame_content, pageReviewUser).commit();


        return view;

    }
}
