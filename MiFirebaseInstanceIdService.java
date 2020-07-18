package com.example.contractplayfinal;
        import android.util.Log;
        import com.google.firebase.iid.FirebaseInstanceId;
        import com.google.firebase.iid.FirebaseInstanceIdService;
// desarrollado por Ronald Machaca .
public class MiFirebaseInstanceIdService extends FirebaseInstanceIdService {
    String TAG ="NOTICIAS";
    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"RefreshedToken:"+refreshedToken);

    }
}
