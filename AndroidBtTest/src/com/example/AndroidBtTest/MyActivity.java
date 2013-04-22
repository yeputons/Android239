package com.example.AndroidBtTest;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Set;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                    Set<BluetoothDevice> devs = adapter.getBondedDevices();
                    BluetoothDevice connectTo;
                    connectTo = null;

                    for (BluetoothDevice dev : devs) {
                        if (dev.getName().equals("s239_48")) {
                            connectTo = dev;
                        }
                    }

                    NxtBluetoothController controller = new NxtBluetoothController(connectTo);
                    controller.connect();
                    byte[] cmd = {
                            (byte)0x80,
                            (byte)0x03,
                            (byte)0xB8,
                            (byte)0x01,
                            (byte)0xF4,
                            (byte)0x01
                    };
                    controller.sendDirectCommand(cmd);
                    controller.disconnect();
                } catch (Exception e) {
                    new AlertDialog.Builder(view.getContext()
                    )
                            .setMessage(e.toString())
                            .create().show();
                }
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
