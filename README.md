# Yatse Custom Command plugin API

API and Sample for Yatse Custom Command plugins

Current version : **3.0** (Stable)

Version 3.0 is not compatible with previous versions, but as there was no known users of this API except Yatse itself, previous version won't be supported anymore.

[api](https://github.com/Tolriq/yatse-customcommandsplugin-api/tree/master/api) folder contains the API to include in your project.

[sample](https://github.com/Tolriq/yatse-customcommandsplugin-api/tree/master/sample) folder contains a fully working plugin that shows everything you need to write a complete plugin.

Javadoc of the API and the sample plugin should describe everything you need to get started.

## Quick start

* Clone this repository.
* Generate a new unique id for your plugin (UUID v4) (You can use for example : https://www.uuidgenerator.net/ )
* Edit [your unique id](https://github.com/Tolriq/yatse-customcommandsplugin-api/blob/master/sample/src/main/res/values/strings.xml#L23) in the Strings.xml file
* Add your custom code to [CCPluginService](https://github.com/Tolriq/yatse-customcommandsplugin-api/blob/master/sample/src/main/java/tv/yatse/plugin/customcommands/sample/CCPluginReceiver.kt)

Of course do not forget to update your plugin name, description, icons and strings.

And edit [CCPluginActivity](https://github.com/Tolriq/yatse-customcommandsplugin-api/blob/master/sample/src/main/java/tv/yatse/plugin/customcommands/sample/CCPluginActivity.kt) so they fit your plugin needs.

## Documentation

The [Wiki](https://github.com/Tolriq/yatse-customcommandsplugin-api/wiki) will contain the up to date documentation for each API versions.

If something is missing just contact me.

## Release

When your plugin works and you are ready to publish it to the world you need to ensure that the description contains the following :

> This plugin is not affiliated to Yatse or its author Tolriq / Genimee.
>
> Please request support directly from the author of this plugin : XXX (For PlayStore can be : See contact information below. or a website URL)

Adding a support button in the configuration activity so users can contact you, is a great addition too.