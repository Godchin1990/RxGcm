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

/**
 * Entity received as the message on foreground notifications events.
 */
public class ForegroundMessage extends Message {
    private final boolean targetScreen;

    public ForegroundMessage(Message message, boolean targetScreen) {
        super(message.from(), message.payload(), message.target(), message.application());
        this.targetScreen = targetScreen;
    }

    /**
     * @return true if the current Activity or Fragment matches with the desired target specified in the bundle notification by the server.
     * @see GcmReceiverUIForeground
     */
    public boolean isTarget() {
        return targetScreen;
    }
}
