package nawrus.myapplication.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import nawrus.myapplication.R;

public class ManagerAdapter extends ArrayAdapter<MyManager> {

    public ManagerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View vitem2= LayoutInflater.from(getContext()).inflate(R.layout.manageritem,parent,false);
        TextView managerName=vitem2.findViewById(R.id.tvManagerName);
        TextView managerPhone=vitem2.findViewById((R.id.tvManagerPhone));
        TextView managerDate=vitem2.findViewById(R.id.tvManagerDate);
        TextView managerSubject=vitem2.findViewById(R.id.tvManagerSubject);
        TextView managerHour=vitem2.findViewById(R.id.tvManagerHour);

        MyManager myManager=getItem(position);

        managerName.setText(myManager.getName());
        managerPhone.setText(myManager.getPhone());
        managerDate.setText(myManager.getDate());
        managerSubject.setText(myManager.getSubject());
        managerHour.setText(myManager.getHour());





        return vitem2;
    }
}
