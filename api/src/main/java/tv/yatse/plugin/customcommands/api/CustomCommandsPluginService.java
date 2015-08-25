/*
 * Copyright 2015 Tolriq / Genimee.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package tv.yatse.plugin.customcommands.api;

import android.app.IntentService;
import android.content.Intent;

/**
 * The AVReceiverPluginService service that any plugin must extend
 * <p/>
 * Unless noted in command description most commands can be called from main thread so should handled this correctly : Fast and no network / disk access.
 */
@SuppressWarnings("unused")
public abstract class CustomCommandsPluginService extends IntentService {

    private static final String TAG = "CustomCommandsPluginService";

    /**
     * String extra that will contains the associated media center unique id when Yatse connect to the service or start the settings activity.
     * This extra should always be filled, empty values should be checked and indicate a problem.
     */
    public static String EXTRA_STRING_MEDIA_CENTER_UNIQUE_ID = "tv.yatse.plugin.customcommands.EXTRA_STRING_MEDIA_CENTER_UNIQUE_ID";
    /**
     * String extra that will contains the associated media center name when Yatse connect to the service or start the settings activity.
     */
    public static String EXTRA_STRING_MEDIA_CENTER_NAME = "tv.yatse.plugin.customcommands.EXTRA_STRING_MEDIA_CENTER_NAME";
    /**
     * String extra that will contains the associated media center IP when Yatse connect to the service or start the settings activity.
     */
    public static String EXTRA_STRING_MEDIA_CENTER_IP = "tv.yatse.plugin.customcommands.EXTRA_STRING_MEDIA_CENTER_IP";
    /**
     * Parcelable extra that will contains the custom command.
     */
    public static String EXTRA_CUSTOM_COMMAND = "tv.yatse.plugin.customcommands.EXTRA_CUSTOM_COMMAND";

    public CustomCommandsPluginService(String name) {
        super(name);
    }

    public CustomCommandsPluginService() {
        super("CustomCommandsPluginService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent.hasExtra(EXTRA_CUSTOM_COMMAND)) {
            executeCustomCommand((PluginCustomCommand) intent.getParcelableExtra(EXTRA_CUSTOM_COMMAND),
                    intent.getStringExtra(EXTRA_STRING_MEDIA_CENTER_UNIQUE_ID),
                    intent.getStringExtra(EXTRA_STRING_MEDIA_CENTER_NAME),
                    intent.getStringExtra(EXTRA_STRING_MEDIA_CENTER_IP));
        } else {
            YatseLogger.getInstance(this).logError(TAG, "Plugin called without custom command to execute !");
        }
    }

    /**
     * Execute a custom command.
     * This is called from an IntentService so already on a background thread.
     *
     * @param pluginCustomCommand the plugin custom command
     * @param hostId              the host id currently connected to
     * @param hostName            the host name currently connected to
     * @param hostIP              the host iP currently connected to
     */
    protected abstract void executeCustomCommand(PluginCustomCommand pluginCustomCommand, String hostId, String hostName, String hostIP);
}
