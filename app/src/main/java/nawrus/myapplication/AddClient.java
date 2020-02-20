package nawrus.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AddClient extends AppCompatActivity {
    private EditText edtNamee;
    private EditText edtPhone5;
    private EditText edtEmail2;
    private EditText edtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        edtNamee=(EditText)findViewById(R.id.edtNamee);
        edtPhone5=(EditText)findViewById(R.id.edtPhone5);
        edtEmail2=(EditText)findViewById(R.id.edtEmail2);
        edtPass=(EditText)findViewById(R.id.edtPass);

    }
}
