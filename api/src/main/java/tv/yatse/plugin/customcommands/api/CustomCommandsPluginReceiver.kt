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
package tv.yatse.plugin.customcommands.api

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * The CustomCommandsPluginService service that any plugin must extend
 *
 */
abstract class CustomCommandsPluginReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent != null) {
            if (intent.hasExtra(EXTRA_CUSTOM_COMMAND)) {
                executeCustomCommand(
                    context,
                    intent.getParcelableExtra(EXTRA_CUSTOM_COMMAND),
                    intent.getStringExtra(EXTRA_STRING_MEDIA_CENTER_UNIQUE_ID),
                    intent.getStringExtra(EXTRA_STRING_MEDIA_CENTER_NAME),
                    intent.getStringExtra(EXTRA_STRING_MEDIA_CENTER_IP)
                )
            }
        }
    }

    /**
     * Execute a custom command.
     * This is called from an BroadcastReceiver so on main thread.
     *
     * @param pluginCustomCommand the plugin custom command
     * @param hostId              the host id currently connected to
     * @param hostName            the host name currently connected to
     * @param hostIP              the host iP currently connected to
     */
    protected abstract fun executeCustomCommand(context: Context, pluginCustomCommand: PluginCustomCommand?, hostId: String?, hostName: String?, hostIP: String?)

    companion object {
        /**
         * String extra that will contains the associated media center unique id when Yatse connect to the service or start the settings activity.
         * This extra should always be filled, empty values should be checked and indicate a problem.
         */
        const val EXTRA_STRING_MEDIA_CENTER_UNIQUE_ID = "tv.yatse.plugin.customcommands.EXTRA_STRING_MEDIA_CENTER_UNIQUE_ID"

        /**
         * String extra that will contains the associated media center name when Yatse connect to the service or start the settings activity.
         */
        const val EXTRA_STRING_MEDIA_CENTER_NAME = "tv.yatse.plugin.customcommands.EXTRA_STRING_MEDIA_CENTER_NAME"

        /**
         * String extra that will contains the associated media center IP when Yatse connect to the service or start the settings activity.
         */
        const val EXTRA_STRING_MEDIA_CENTER_IP = "tv.yatse.plugin.customcommands.EXTRA_STRING_MEDIA_CENTER_IP"

        /**
         * Parcelable extra that will contains the custom command.
         */
        const val EXTRA_CUSTOM_COMMAND = "tv.yatse.plugin.customcommands.EXTRA_CUSTOM_COMMAND"
    }
}