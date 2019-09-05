package com.comapi.internal.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import com.comapi.R;
import com.comapi.internal.log.Logger;
import com.comapi.internal.network.InternalService;

import java.lang.ref.WeakReference;

/**
 * @author Marcin Swierczek
 * @since 1.4.0
 */
public class LocalNotificationsManager {

    private WeakReference<Context> context;
    private WeakReference<InternalService> service;

    private ChannelData channelData;
    private PushUIConfig uiConfig;
    private Logger log;

    LocalNotificationsManager(Context context, Logger log) {
        this.context = new WeakReference<>(context);
        channelData = new ChannelData(context.getString(R.string.comapi_default_channel_id),
                context.getString(R.string.comapi_default_channel_name),
                context.getString(R.string.comapi_default_channel_description));
        uiConfig = new PushUIConfig(context);
        this.log = log;
    }

    public void handleNotification(PushBuilder builder) {

        InternalService service = this.service.get();
        if (service != null) {
            log.d("TODO: send `delivered`");
            //TODO send `delivered` for messageId
        }

        Context context = this.context.get();
        if (context != null) {
            int id = builder.getMessageId().hashCode();
            Notification n = builder.buildNotification(context, channelData, uiConfig);
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.notify(id, n);
            } else {
                log.e("NotificationManager unavailable in LocalNotificationsManager.handleNotification");
            }
        } else {
            log.e("Missing week context reference in LocalNotificationsManager.handleNotification");
        }
    }

    public void handleNotificationClick(String messageId, String id, String link) {
        InternalService service = this.service.get();
        if (service != null) {
            log.d("TODO: send `read messageId="+messageId);
            //TODO send `read` for messageId
            if (link != null) {
                log.d("TODO: send `click` messageId="+messageId+" id="+id+" link="+link);
                //TODO send `click` for link+id
            }
        }
    }

    public void setService(InternalService service) {
        this.service = new WeakReference<>(service);
    }
}
