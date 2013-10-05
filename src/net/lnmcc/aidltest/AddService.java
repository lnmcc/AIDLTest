package net.lnmcc.aidltest;

import net.lnmcc.aidltest.aidl.IAddService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AddService extends Service {

	IAddService.Stub mBinder;
	
	@Override
	public void onCreate() {
		super.onCreate();
		mBinder = new IAddService.Stub() {
			
			@Override
			public int addOne(int value) throws RemoteException {
				
				return value + 1;
			}

		};
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		return mBinder;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
