/*
 * Copyright 2016 Victor Albertos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rx_gcm.internal;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx_gcm.GcmReceiverData;
import rx_gcm.Message;

public class GcmReceiverDataMock implements GcmReceiverData {
    private static List<Message> messages;
    private static long onNotificationFinishTimeStamp;

    public static void initSubscriber() {
        messages = new ArrayList<>();
    }

    @Override public Observable<Message> onNotification(Observable<Message> oMessage) {
        return oMessage.doOnNext(new Action1<Message>() {
            @Override public void call(Message foregroundMessage) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                messages.add(foregroundMessage);
                onNotificationFinishTimeStamp = System.currentTimeMillis();

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}
            }
        });
    }

    public static List<Message> getMessages() {
        return messages;
    }

    public static long getOnNotificationFinishTimeStamp() {
        return onNotificationFinishTimeStamp;
    }
}
