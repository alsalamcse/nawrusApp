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


//1 new class                           //2 extends
public class turnAdapter extends ArrayAdapter<MyTurn> {


    //3 fix error
    public turnAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
     //4 override getview
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //4.1 bna2 item b2lb view mn3rf sfat al xml

        View vitem3 = LayoutInflater.from(getContext()).inflate(R.layout.turnitem, parent, false);
        TextView turnBegin = vitem3.findViewById(R.id.tvBegin);
        TextView turnFinish = vitem3.findViewById(R.id.tvFinish);
        TextView turnDate = vitem3.findViewById(R.id.tvDate);


        MyTurn myTurn = getItem(position);


        turnBegin.setText(myTurn.getBeginHour());
        turnFinish.setText(myTurn.getFinishHour());
        turnDate.setText(myTurn.getDate());

        return vitem3;


    }
}
