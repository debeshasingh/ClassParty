package com.example.classparty;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment  implements View.OnClickListener {
    private Button btnWinCertificate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnWinCertificate = (Button)view.findViewById(R.id.btn_certificate);
        btnWinCertificate.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_certificate:
                startActivity(new Intent(getActivity(),WinCertificateActivity.class));
                break;
        }
    }
}
