package vcmanea.example.android09_buletooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    BluetoothAdapter BA;
    Button mButtonTurnOn;
    Button mButtonTurnOff;
    Button mButtonFindDiscoverable;
    Button mButtonPairedDevices;
    ArrayList<String> pairedDevicesArray;
    RecyclerView recyclerView;
    RecycleViewAdapter recycleViewAdapter;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pairedDevicesArray=new ArrayList<>();





        BA=BluetoothAdapter.getDefaultAdapter();
        mButtonTurnOn=findViewById(R.id.btn_On);
        mButtonTurnOff=findViewById(R.id.btn_turnOff);
        mButtonFindDiscoverable=findViewById(R.id.btn_discoverable_devices);
        mButtonPairedDevices=findViewById(R.id.btn_paired_devices);





        recyclerView=findViewById(R.id.recycler_view);
        recycleViewAdapter=new RecycleViewAdapter(this,pairedDevicesArray);

        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


     ///////////////////////////////////////////////////////////////////////////////////////////////
        mButtonTurnOn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(BA.isEnabled()){
                    Toast.makeText(MainActivity.this, "Your bluetooth is already on", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(i);
                    Toast.makeText(MainActivity.this,"Your bluetooth is turnet on",Toast.LENGTH_LONG).show();
                }

            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        mButtonTurnOff.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                if(BA.isEnabled()){
                    Toast.makeText(MainActivity.this, "Bluetooth could not be disabled", Toast.LENGTH_SHORT).show();
                    BA.disable();
                }
                else{
                    Toast.makeText(MainActivity.this, "Buuetooth turned off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ///////////////////////////////////////////




        mButtonFindDiscoverable.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view){



                Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivity(i);



            }



        });

        mButtonPairedDevices.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Set<BluetoothDevice> pairedDevices=BA.getBondedDevices();

                for(BluetoothDevice bluetoothDevice:pairedDevices){
                    pairedDevicesArray.add(bluetoothDevice.getName());


                }
                pairedDevicesArray.add("shit");


                recycleViewAdapter.notifyDataSetChanged();

                Log.d(TAG, "onClick: "+pairedDevicesArray.toString());



            }




        });











    }






















}
