/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/sijiewang/Documents/workspace/AIDLTest/src/net/lnmcc/aidltest/aidl/IAddService.aidl
 */
package net.lnmcc.aidltest.aidl;
public interface IAddService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements net.lnmcc.aidltest.aidl.IAddService
{
private static final java.lang.String DESCRIPTOR = "net.lnmcc.aidltest.aidl.IAddService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an net.lnmcc.aidltest.aidl.IAddService interface,
 * generating a proxy if needed.
 */
public static net.lnmcc.aidltest.aidl.IAddService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof net.lnmcc.aidltest.aidl.IAddService))) {
return ((net.lnmcc.aidltest.aidl.IAddService)iin);
}
return new net.lnmcc.aidltest.aidl.IAddService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_addOne:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.addOne(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements net.lnmcc.aidltest.aidl.IAddService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public int addOne(int value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(value);
mRemote.transact(Stub.TRANSACTION_addOne, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_addOne = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public int addOne(int value) throws android.os.RemoteException;
}
