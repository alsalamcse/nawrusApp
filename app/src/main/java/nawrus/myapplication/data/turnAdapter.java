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
        //4.2 find view by id
        TextView turnBegin = vitem3.findViewById(R.id.tvBegin);
        TextView turnFinish = vitem3.findViewById(R.id.tvFinish);
        TextView turnDate = vitem3.findViewById(R.id.tvDate);


        //4.3 get data object


        MyTurn myTurn = getItem(position);

        //4.4 set obfect data on the view


        turnBegin.setText(myTurn.getBeginHour());
        turnFinish.setText(myTurn.getFinishHour());
        turnDate.setText(myTurn.getDate());

        //4.5
        //imgCall.setOnClickListener(new View.OnClickListener(){
        //@override
        //public void onClick(view v){
        //Toast.makeText(getContext(), text"calling"+myUser.getPhone(),Toast.LENGTH_SHORT).show();
        //}



        //4.6 return view
        return vitem3;


    }
}
