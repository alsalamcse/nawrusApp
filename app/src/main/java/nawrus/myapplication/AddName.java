package nawrus.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddName extends AppCompatActivity {
    private EditText edtName4;
    private EditText edtSubject;
    private EditText edtPhone4;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        edtName4=(EditText)findViewById(R.id.edtName4);
        edtSubject=(EditText)findViewById(R.id.edtSubject);
        edtPhone4=(EditText)findViewById(R.id.edtPhone4);
        btnSave=(Button)findViewById(R.id.btnSave);
    }
}
