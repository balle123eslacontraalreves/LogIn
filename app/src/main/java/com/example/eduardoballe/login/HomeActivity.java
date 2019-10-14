package com.example.eduardoballe.login;

import android.content.Intent;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {


    String mail = "mario@gmail.com";
    String password = "123456";
    EditText mailField, passwordField;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        button = findViewById(R.id.button2);

        User user = getIntent().getParcelableExtra("Deta");
        TextView hello = findViewById(R.id.hello);
        if (user != null) {
            String message = user.getName () + user.getAge();
            hello.setText(message);
        }

    }


    private void showErrorMessage(String errorMessage) {
        Toast.makeText(
                this,
                errorMessage,
                Toast.LENGTH_SHORT
        ).show();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputMail = mailField.getText().toString();
                String inputPassword = passwordField.getText().toString();
            }
        });



        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            showErrorMessage(
                    "Ingrese un correo electrónico válido"
            );
            return;

            if (!mail.equals(mail)) {
                showErrorMessage(
                        "El correo es inválido"
                );
                return;
            }

            if (!password.equals(password)) {
                showErrorMessage(
                        "La contraseña en invalida"
                );
            }



            Intent intent = new Intent(getApplicationContext(),
                    HomeActivity.class);
            intent.putExtra("EXTRA", new User ("name", 20));
            startActivity(intent);
            finish();

        }

    }


}
