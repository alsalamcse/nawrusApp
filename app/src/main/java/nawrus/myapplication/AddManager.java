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

import nawrus.myapplication.data.MyManager;

public class AddManager extends AppCompatActivity {
    private EditText edtName4;
    private EditText edtSubject;
    private EditText edtPhone4;
    private Button btnSave;
    private EditText edtDate;
    private EditText edtHour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        edtName4=(EditText)findViewById(R.id.edtName4);
        edtSubject=(EditText)findViewById(R.id.edtSubject);
        edtPhone4=(EditText)findViewById(R.id.edtPhone4);
        btnSave=(Button)findViewById(R.id.btnSave);
        edtDate=(EditText)findViewById(R.id.edtDate);
        edtHour=(EditText)findViewById(R.id.edtHour);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });


    }

    private void dataHandler()
    {
        String phone=edtPhone4.getText().toString();
        String date=edtDate.getText().toString();
        String hour=edtHour.getText().toString();
        String name=edtName4.getText().toString();
        String subject=edtSubject.getText().toString();
        boolean isOk=true;
        if(name.length()<1)
        {
            edtName4.setError("title length error");
            isOk=false;

        }
        if(subject.length()<1)
        {
            edtSubject.setError(" subject length error ");
            isOk=false;
        }
        if(isOk)
        {
            MyManager t=new MyManager();
            t.setName(name);
            createMyManager(t);

        }

    }

    private void createMyManager(MyManager t) {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //.2
        DatabaseReference reference = database.getReference();
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get the user uid(or other details like email)
        String uid= auth.getCurrentUser().getUid();
        String key = reference.child("task").push().getKey();
        t.setKey(key);
        reference.child(key).setValue(t).addOnCompleteListener(AddManager.this, new OnCompleteListener<Void>()
        {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AddManager.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddManager.this, "add failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }
            }

            });

        }
    }