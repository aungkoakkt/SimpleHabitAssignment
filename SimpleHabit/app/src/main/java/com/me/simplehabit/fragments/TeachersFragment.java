package com.me.simplehabit.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.simplehabit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeachersFragment extends Fragment {


    private static TeachersFragment objectInstance=null;

    public TeachersFragment() {
        // Required empty public constructor
    }

    public static TeachersFragment getInstance(){
        return (objectInstance==null)? objectInstance=new TeachersFragment():objectInstance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teachers, container, false);
    }

}
