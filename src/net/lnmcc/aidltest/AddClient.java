package net.lnmcc.aidltest;

import net.lnmcc.aidltest.R;
import net.lnmcc.aidltest.aidl.IAddService;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddClient extends Activity {

	IAddService service;
	myServiceConnection connection;

	class myServiceConnection implements ServiceConnection {
		@Override
		public void onServiceConnected(ComponentName name, IBinder boundservice) {
			service = IAddService.Stub.asInterface(boundservice);
			Toast.makeText(AddClient.this, "Service connected",
					Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			service = null;
			Toast.makeText(AddClient.this, "Service disconnected",
					Toast.LENGTH_SHORT).show();
		}
	}

	private void initService() {
		connection = new myServiceConnection();
		Intent i = new Intent();
		i.setClassName("net.lnmcc.aidltest",
				net.lnmcc.aidltest.AddService.class.getName());
		if (!bindService(i, connection, Context.BIND_AUTO_CREATE)) {
			Toast.makeText(AddClient.this, "Bind Service Failed",
					Toast.LENGTH_SHORT).show();
		}
	}

	private void releaseService() {
		unbindService(connection);
		connection = null;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initService();

		Button buttonCalc = (Button) findViewById(R.id.addone);
		buttonCalc.setOnClickListener(new View.OnClickListener() {
			TextView result = (TextView) findViewById(R.id.result);
			EditText value1 = (EditText) findViewById(R.id.value);

			@Override
			public void onClick(View v) {
				int v1, res = 0;
				try {
					v1 = Integer.parseInt(value1.getText().toString());
					res = service.addOne(v1);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				result.setText(Integer.valueOf(res).toString());
			}
		});
	}

	@Override
	protected void onDestroy() {
		releaseService();
		super.onDestroy();
	}
}
