package nawrus.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtRewritePassword;
    private Button btnSignUp;
    private CheckBox checkManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtEmail=(EditText)findViewById(R.id.edtEmailTurn);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        edtRewritePassword=(EditText)findViewById(R.id.edtRewritePassword);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        checkManager=(CheckBox)findViewById(R.id.checkManager);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });

    }
    private void dataHandler()
    {
        boolean isOk=true;//if all fields filled well
        String email=edtEmail.getText().toString();
        String passw1=edtPassword.getText().toString();

        String passw2=edtRewritePassword.getText().toString();

        if(email.length()<4 || email.indexOf('@')<0 || email.indexOf('.')<0) {
            edtEmail.setError("wrong Email");
            isOk = false;

                edtEmail.setError("wrong Email");
                isOk=false;



        }
        if((passw1.length()<8)||passw1.equals(passw2)==false)
        {
            edtRewritePassword.setError("Have to be at least 8 char and the same password");
            edtPassword.setError("Have to be at least 8 char and the same password");
            isOk=false;
        }


        if(isOk)
        {
            createAcount(email,passw1);//createAcount(email,passw1)
        }


    }
    private void createAcount(String email, String passw1) {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(email, passw1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this, "sign up succesful", Toast.LENGTH_SHORT).show();
                    if(checkManager.isChecked())
                    {
                        Intent i=new Intent(getApplication(),AddManager.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Intent i=new Intent(getApplication(),AddClient.class);
                        startActivity(i);
                        finish();

                    }


                }
                else
                {
                    edtEmail.setError("sign n up failed");
                }
            }

        });
    }




}
