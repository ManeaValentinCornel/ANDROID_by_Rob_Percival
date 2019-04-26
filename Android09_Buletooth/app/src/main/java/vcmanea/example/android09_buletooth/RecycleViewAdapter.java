package vcmanea.example.android09_buletooth;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context myContext;
    List<String> list;


    public RecycleViewAdapter(Context myContext, List<String> list) {
        this.myContext = myContext;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;





        LayoutInflater layoutInflater=LayoutInflater.from(myContext);
        view=layoutInflater.inflate(R.layout.bluetooth,viewGroup,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        ((MyViewHolder) viewHolder).mTextView.setText(list.get(i));
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
         TextView mTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.txt_bluetooth);

        }
    }

}
