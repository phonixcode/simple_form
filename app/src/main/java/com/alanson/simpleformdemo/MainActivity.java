package com.alanson.simpleformdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.alanson.simpleformdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                activityMainBinding.img1.setImageResource(hasLength(charSequence) ? R.drawable.checked : R.drawable.unchecked);

                activityMainBinding.img2.setImageResource(hasUppercase(charSequence) ? R.drawable.checked : R.drawable.unchecked);

                activityMainBinding.img3.setImageResource(hasDigit(charSequence) ? R.drawable.checked : R.drawable.unchecked);

                activityMainBinding.img4.setImageResource(hasSymbol(charSequence) ? R.drawable.checked : R.drawable.unchecked);

                if (hasLength(charSequence) && hasUppercase(charSequence) && hasDigit(charSequence) && hasSymbol(charSequence)) {
                    activityMainBinding.btnRegister.setVisibility(View.VISIBLE);
                } else {
                    activityMainBinding.btnRegister.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public boolean hasLength(CharSequence value) {
        return String.valueOf(value).length() >= 8;
    }

    public boolean hasDigit(CharSequence value) {
        return String.valueOf(value).matches("(.*\\d.*)");
    }

    public boolean hasUppercase(CharSequence value) {
        String s = String.valueOf(value);
        return !s.equals(s.toLowerCase());
    }

    public boolean hasSymbol(CharSequence value) {
        String s = String.valueOf(value);
        return !s.matches("[A-Za-z0-9 ]*");
    }
}