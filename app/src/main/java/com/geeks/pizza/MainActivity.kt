package com.geeks.pizza

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geeks.pizza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null


    var emailEditText: EditText? = null
    var passwordEditText: EditText? = null
    var loginButton: Button? = null
    var container: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding!!.root)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding!!.forgotPasswordBtn.setOnClickListener { View: View? ->
            if (binding!!.clue.visibility == android.view.View.VISIBLE) {
                binding!!.clue.visibility = android.view.View.GONE
            } else {
                binding!!.clue.visibility = android.view.View.VISIBLE
            }
        }


        val watcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                checkCredentials()
            }

            override fun afterTextChanged(s: Editable) {
            }
        }

        binding!!.email.addTextChangedListener(watcher)
        binding!!.password.addTextChangedListener(watcher)

        // Обработка нажатия кнопки логина
        binding!!.loginBtn.setOnClickListener { v: View? ->
            val email = binding!!.email.text.toString()
            val password = binding!!.password.text.toString()
            if (email == "azamat" && password == "admin") {
                val intent =
                    Intent(this, MenuActivity::class.java) // Переход в HomeActivity
                startActivity(intent)
                finish() // Завершение текущей активности
                Toast.makeText(this@MainActivity, "Welcome!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Wrong Email or Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun checkCredentials() {
        val email = binding!!.email.text.toString()
        val password = binding!!.password.text.toString()

        // Активировать кнопку только если оба поля заполнены
        binding!!.loginBtn.isEnabled = !email.isEmpty() && !password.isEmpty()
    }
}