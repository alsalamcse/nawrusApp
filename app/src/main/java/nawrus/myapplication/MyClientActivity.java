package nawrus.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import nawrus.myapplication.data.ClintAdapter;
import nawrus.myapplication.data.MyClient;

//5 new activity
//5.1 add Listview to the xml
public class MyClientActivity extends AppCompatActivity {


//5.2
    private ListView listView;
    private ClintAdapter clintAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_client);
        //5.3
        listView=findViewById(R.id.lstvClient);
        clintAdapter=new ClintAdapter(getBaseContext(),R.layout.clientitem);
        //5.4
        listView.setAdapter((clintAdapter));
    }
    // astd3a2 aldale
    protected void onResume(){
        super.onResume();
        readFromFirebase();
    }


    //nnzl m3lomat mn al firebase n3tehn adapter who l7alo bbne al listview (b7t alka2nat b2lbo)
    //5.5 downloadm data from firebase
    public void readFromFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();//to connect to database
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get current user UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();//a5d mo2shr qa3dt byanat database


        //5.6 add listener to udate us about any change
        // change group name
        reference.child("clients").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //5.7
                clintAdapter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren()) {
                    MyClient t=d.getValue(MyClient.class);
                    Log.d("MYTASK",t.toString());
                    clintAdapter.add(t);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
