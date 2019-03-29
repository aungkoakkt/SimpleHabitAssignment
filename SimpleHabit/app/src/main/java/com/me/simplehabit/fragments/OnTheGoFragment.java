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
public class OnTheGoFragment extends Fragment {


    private static OnTheGoFragment objectInstance=null;

    public OnTheGoFragment() {
        // Required empty public constructor
    }

    public static OnTheGoFragment getInstance(){
        return (objectInstance==null)? objectInstance=new OnTheGoFragment():objectInstance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_the_go, container, false);
    }

}
