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

public class ClintAdapter extends ArrayAdapter<MyClient>
{


    public ClintAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.clientitem,parent,false);
        TextView clientName=vitem.findViewById(R.id.tnClientItemName);
        TextView clientPhone=vitem.findViewById(R.id.tvClientPhone);
        TextView clientItemEmail=vitem.findViewById(R.id.tvClientItemEmail);

        MyClient myClient=getItem(position);


        clientName.setText(myClient.getName1());
        clientPhone.setText(myClient.getPhone1());
        clientItemEmail.setText(myClient.getEmail1());





        
        
        
        return vitem;
    }
}
