package com.example.ahmedshalyel;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class Notfcation {

        private Context ctx;
        private Class classAct;

        public Notfcation(Context mCtx, Class classAct){
            this.ctx = mCtx;
            this.classAct  = classAct;
        }

        public void notificar(String bannerTxt, String titulo, String txt, int icon){

            NotificationManager notificationManager =
                    (NotificationManager) this.ctx
                            .getSystemService(this.ctx.NOTIFICATION_SERVICE);

            PendingIntent pendingIntent =
                    PendingIntent.getActivity
                            (
                                    ctx.getApplicationContext(),
                                    0,
                                    new Intent
                                            (
                                                    ctx.getApplicationContext(),
                                                    this.classAct
                                            ),
                                    0
                            );

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this.ctx.getApplicationContext());

            builder.setSmallIcon(icon);
            builder.setTicker(bannerTxt);
            builder.setContentTitle(titulo);
            builder.setVibrate(new long[]{100, 100, 100, 100});
            builder.setContentIntent(pendingIntent);
            builder.setContentText(txt);

            Notification notification = builder.build();

            // O icone diferencia uma notificacao da outra.
            notificationManager.notify(icon, notification);

        }


}
