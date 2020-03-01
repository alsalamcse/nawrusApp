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

        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.clientitem,parent,false);
        TextView managerName=vitem.findViewById(R.id.tvManagerName);
        TextView managerPhone=vitem.findViewById((R.id.tvManagerPhone));
        TextView managerDate=vitem.findViewById(R.id.tvManagerDate);
        TextView managerSubject=vitem.findViewById(R.id.tvManagerSubject);
        TextView managerHour=vitem.findViewById(R.id.tvManagerHour);

        MyManager myManager=getItem(position);

        managerName.setText(myManager.getName());
        managerPhone.setText(myManager.getPhone());
        managerDate.setText(myManager.getDate());
        managerSubject.setText(myManager.getSubject());
        managerHour.setText(myManager.getHour());





        return vitem;
    }
}
