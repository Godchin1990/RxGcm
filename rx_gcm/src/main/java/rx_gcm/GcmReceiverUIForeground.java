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

package rx_gcm;

import rx.Observable;

/**
 * The Activity or Fragments which implement this interface will receive the push notifications when the application is onForeground state
 * just after GcmReceiverData has completed its task.
 * @see GcmReceiverData
 */
public interface GcmReceiverUIForeground {
    void onNotification(Observable<ForegroundMessage> oForegroundMessage);

    /**
     * @return The value provided in the bundle notification by the server to be used as a filter when updating data model or seeking for the activity/fragment to be notified.
     */
    String target();
}
