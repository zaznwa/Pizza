package com.geeks.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.geeks.pizza.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    EditText emailEditText, passwordEditText;
    Button loginButton;
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.forgotPasswordBtn.setOnClickListener(View -> {
            if (binding.clue.getVisibility() == android.view.View.VISIBLE) {
                binding.clue.setVisibility(android.view.View.GONE);
            } else {
                binding.clue.setVisibility(android.view.View.VISIBLE);
            }
        });




        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkCredentials();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        binding.email.addTextChangedListener(watcher);
        binding.password.addTextChangedListener(watcher);

        // Обработка нажатия кнопки логина
        binding.loginBtn.setOnClickListener(v -> {
            String email = binding.email.getText().toString();
            String password = binding.password.getText().toString();

            if (email.equals("azamat") && password.equals("admin")) {
                Intent intent = new Intent(this, MenuActivity.class); // Переход в HomeActivity
                startActivity(intent);
                finish(); // Завершение текущей активности
                Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkCredentials() {
        String email = binding.email.getText().toString();
        String password = binding.password.getText().toString();

        // Активировать кнопку только если оба поля заполнены
        binding.loginBtn.setEnabled(!email.isEmpty() && !password.isEmpty());
    }

}