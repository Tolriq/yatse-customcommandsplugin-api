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

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import tv.yatse.plugin.customcommands.api.CustomCommandsActivity;

public class CCPluginActivity extends CustomCommandsActivity {

    TextView mViewTitle;
    TextView mViewParam1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_commands);

        mViewTitle = findViewById(R.id.custom_command_title);
        mViewParam1 = findViewById(R.id.custom_command_param1);

        if (isEditing()) {
            mViewTitle.setText(pluginCustomCommand.title());
            mViewParam1.setText(pluginCustomCommand.param1());
        }

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAndFinish();
            }
        });

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Custom command source field must always equals to plugin uniqueId !!
                pluginCustomCommand.source(getString(R.string.plugin_unique_id));
                pluginCustomCommand.title(String.valueOf(mViewTitle.getText()));
                pluginCustomCommand.param1(String.valueOf(mViewParam1.getText()));
                saveAndFinish();
            }
        });

    }
}
