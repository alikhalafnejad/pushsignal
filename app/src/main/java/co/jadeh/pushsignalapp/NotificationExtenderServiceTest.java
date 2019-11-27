package co.jadeh.pushsignalapp;


import java.math.BigInteger;

import androidx.core.app.NotificationCompat;
import co.jadeh.pushsignal.NotificationExtenderService;
import co.jadeh.pushsignal.OSNotificationPayload;
import co.jadeh.pushsignal.OSNotificationReceivedResult;

public class NotificationExtenderServiceTest extends NotificationExtenderService {

   @Override
   protected boolean onNotificationProcessing(OSNotificationReceivedResult notification) {
      DebuggingHelper.printObject(notification);
      if (notification.payload.actionButtons != null) {
         for(OSNotificationPayload.ActionButton button : notification.payload.actionButtons) {
           // System.out.println("button:");
            DebuggingHelper.printObject(button);
         }
      }

      OverrideSettings overrideSettings = new OverrideSettings();

      overrideSettings.extender = new NotificationCompat.Extender() {
         @Override
         public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
            return builder.setColor(new BigInteger("FF00FF00", 16).intValue());
         }
      };

      displayNotification(overrideSettings);

      return true;
   }
}
