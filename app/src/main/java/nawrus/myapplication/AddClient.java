package nawrus.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nawrus.myapplication.data.MyClient;

public class AddClient extends AppCompatActivity {
    private EditText edtNamee;
    private EditText edtPhone5;
    private EditText edtEmail2;
    private EditText edtPass;
    private Button btnSaveClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        edtNamee=(EditText)findViewById(R.id.edtNamee);
        edtPhone5=(EditText)findViewById(R.id.edtPhone5);
        edtEmail2=(EditText)findViewById(R.id.edtEmail2);
        edtPass=(EditText)findViewById(R.id.edtPass);
        btnSaveClient=(Button)findViewById(R.id.btnSaveClient);

        btnSaveClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });

    }


    private void dataHandler() {
        String name1 = edtNamee.getText().toString();
        String phone1 = edtPhone5.getText().toString();
        String email1 = edtEmail2.getText().toString();
        String password1 = edtPass.getText().toString();
        boolean isOk = true;
        if (name1.length() < 1) {
            edtNamee.setError("title length error");
            isOk = false;

        }
        if (phone1.length() < 10) {
            edtPhone5.setError(" subject length error ");
            isOk = false;
        }
        if (isOk) {
            MyClient d = new MyClient();
            d.setName1(name1);
            createMyTask(d);

        }
    }

    private void createMyTask(MyClient d) {
        //.1
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //.2
        DatabaseReference reference = database.getReference();
        FirebaseAuth auth = FirebaseAuth.getInstance();//to get the user uid(or other details like email)
        String uid = auth.getCurrentUser().getUid();
        String key = reference.child("task").push().getKey();
        d.setKey(key);
        reference.child(key).setValue(d).addOnCompleteListener(AddClient.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AddClient.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddClient.this, "add failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }

            }


        });
    }
}




