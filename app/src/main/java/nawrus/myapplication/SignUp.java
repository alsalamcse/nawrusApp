package nawrus.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    private EditText edtfname;
    private EditText edtlname;
    private EditText edtPhone;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtRewritePassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtfname=(EditText)findViewById(R.id.edtfname);
        edtlname=(EditText)findViewById(R.id.edtlname);
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        edtRewritePassword=(EditText)findViewById(R.id.edtRewritePassword);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
    }
}
