package com.example.testprojectgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testprojectgithub.model.User;
import com.example.testprojectgithub.remote.ApiUtils;
import com.example.testprojectgithub.remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LoginActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;

    UserService userService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        userService = ApiUtils.getUserService();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(validateLogin(username, password))
                {
                    doLogin(username, password);
                }
            }
        });
    }
    private boolean validateLogin(String username, String password)
    {
        if(username == null || username.trim().length() == 0)
        {
            displayToast("Username is required");
            return false;
        }
        if (password == null || password.trim().length() == 0)
        {
            displayToast("Password is required");
            return false;
        }
        return true;
    }

    private void doLogin(String username, String password)
    {
        Call call = userService.login(username, password);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful())
                {
                    User user = (user)
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        })
    }
}