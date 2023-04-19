package org.techtown.doitmission_9;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cusInfoFragment extends Fragment {
private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_cus_info, container, false);
        context = container.getContext();
        EditText editName = rootView.findViewById(R.id.editTextName);
        EditText editAge = rootView.findViewById(R.id.editTextAge);
        Button buttonBirth = rootView.findViewById(R.id.buttonBirth);
        Button buttonSave = rootView.findViewById(R.id.buttonSave);

        Timestamp ts  = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        buttonBirth.setText(sdf.format(ts));
        final EditText dateEdit = new EditText(getContext());
        dateEdit.setFilters(new InputFilter[] { new InputFilter.LengthFilter(6) });

        buttonBirth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                dlg.setTitle("생년월일");
                dlg.setMessage("생년월일 6자리를 입력하세요");
                dlg.setView(dateEdit);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String Birth = dateEdit.getText().toString();
                        buttonBirth.setText(Birth);
                    }
                });
                dlg.show();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            public  void onClick(View v) {
                String Birth = buttonBirth.getText().toString();
                String name = editName.getText().toString();
                String Age = editAge.getText().toString();
                Toast.makeText(context, "이름 : "+name+" , 나이 : "+Age+" , 생년월일 : " +Birth,Toast.LENGTH_LONG ).show();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }


}