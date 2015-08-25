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

package tv.yatse.plugin.customcommands.sample;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import tv.yatse.plugin.customcommands.api.CustomCommandsPluginService;
import tv.yatse.plugin.customcommands.api.PluginCustomCommand;
import tv.yatse.plugin.customcommands.api.YatseLogger;

/**
 * Sample CustomCommandsPluginService that implement all functions with dummy code that displays Toast and logs to main Yatse log system.
 * <p/>
 * See {@link CustomCommandsPluginService} for documentation on all functions
 */
public class CCPluginService extends CustomCommandsPluginService {
    private Handler handler = new Handler(Looper.getMainLooper());
    private static final String TAG = "AVPluginService";

    public CCPluginService() {
        super();
    }

    @Override
    protected void executeCustomCommand(PluginCustomCommand pluginCustomCommand, String hostId, String hostName, String hostIP) {
        displayToast(pluginCustomCommand.param1());
        YatseLogger.getInstance(this).logVerbose(TAG, "Starting customCommand : %s", pluginCustomCommand.title());
    }

    private void displayToast(final String message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
