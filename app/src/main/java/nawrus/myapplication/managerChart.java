package nawrus.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import nawrus.myapplication.data.MyManager;

public class managerChart extends Fragment {
    private TasksAdapter tasksAdapter;
    private ListView lvTasks;


    public managerChart(){

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasksAdapter=new TasksAdapter(getContext(),R.layout.taskitem);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_manajor_chart, container, false);
        lvTasks=view.findViewById(R.id.lvTasks);
        lvTasks.setAdapter(tasksAdapter);
        return view;
    }
    public void onResume() {
        super.onResume();
        readTasksFromFirebase();
    }
    public void readTasksFromFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();//to connect to database
        FirebaseAuth auth = FirebaseAuth.getInstance();//to get current UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        reference.child("task").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tasksAdapter.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    MyManager t = d.getValue(MyManager.class);
                    Log.d("MYTASK", t.toString());
                    tasksAdapter.add(t);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }

    }

