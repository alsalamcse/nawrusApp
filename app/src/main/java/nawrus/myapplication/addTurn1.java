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
import nawrus.myapplication.data.MyTurn;

public class addTurn1 extends AppCompatActivity {
    private EditText edtNameTurn;
    private EditText edtPhoneTurn;
    private EditText edtEmailTurn;
    private EditText edtBeginHour;
    private EditText edtDateTurn;
    private Button btnSaveTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_turn1);
        edtNameTurn = (EditText) findViewById(R.id.edtNameTurn);
        edtPhoneTurn = (EditText) findViewById(R.id.edtPhoneTurn);
        edtEmailTurn = (EditText) findViewById(R.id.edtEmailTurn);
        edtBeginHour = (EditText) findViewById(R.id.edtBeginHour);
        edtDateTurn = (EditText) findViewById(R.id.edtDateTurn);
        btnSaveTurn = (Button) findViewById(R.id.btnSaveTurn);

        btnSaveTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }

    private void dataHandler() {
        String nameTurn = edtNameTurn.getText().toString();
        String phoneTurn = edtPhoneTurn.getText().toString();
        String emailTurn = edtEmailTurn.getText().toString();
        String beginHour = edtBeginHour.getText().toString();
        String dateTurn = edtDateTurn.getText().toString();
        boolean isOk = true;
        if (nameTurn.length() < 1) {
            edtNameTurn.setError("title length error");
            isOk = false;

        }
        if (phoneTurn.length() < 10) {
            edtPhoneTurn.setError(" subject length error ");
            isOk = false;
        }

        if (isOk) {
            MyTurn d = new MyTurn();
            d.setName2(nameTurn);
            d.setEmail2(emailTurn);
            d.setPhone2(phoneTurn);
            d.setDate(dateTurn);
            d.setBeginHour(beginHour);
            createMyTask(d);

        }
    }

    private void createMyTask(MyTurn d) {
        //.1
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //.2
        DatabaseReference reference = database.getReference();
        FirebaseAuth auth = FirebaseAuth.getInstance();//to get the user uid(or other details like email)
        String uid = auth.getCurrentUser().getUid();
        String key = reference.child("turns").push().getKey();
        d.setKey(key);
        reference.child("turns").child(key).setValue(d).addOnCompleteListener(addTurn1.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(addTurn1.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(addTurn1.this, "add failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }

            }


        });
    }

}
