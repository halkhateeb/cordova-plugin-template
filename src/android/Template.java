package cordova.plugin;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.provider.Settings.Secure;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class Template extends CordovaPlugin {

    private AudioManager myAudioManager;
    private TelephonyManager myTelephonyManager;


    @Override
    public boolean execute(String action, JSONArray data, final CallbackContext callbackContext) throws JSONException {
        int mod = myAudioManager.getRingerMode();
        if (action.equals("echo")) {
            // callbackContext.success("Echo: " + data.getString(0));
            callbackContext.success(mod);
            return true;
        } else if(action.equals("tm")){
            int tmInt = myTelephonyManager.getCallState();
            callbackContext.success(tmInt);
            return true;
        } 
        
        else {
            return false;
        }
    }

    @Override
	protected void pluginInitialize() {
		myAudioManager = (AudioManager)cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
        myTelephonyManager = (TelephonyManager) cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
	}
}
