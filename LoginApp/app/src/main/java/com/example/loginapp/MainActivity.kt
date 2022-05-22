package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fieldsCheck()
    }

    private fun fieldsCheck(){
        val name = findViewById<EditText>(R.id.name)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)
        password.transformationMethod = PasswordTransformationMethod.getInstance()
        loginButton.setOnClickListener(){
            if(name.text.isEmpty() or password.text.isEmpty()) {
                Toast.makeText(this, "INGRESE NOMBRE Y CONTRASEÑA!!!", Toast.LENGTH_LONG)
                    .show()
            }else {
                val message = name.text.toString()
                val intent = Intent(this, NewActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }
                startActivity(intent)
            }

        }
    }

}