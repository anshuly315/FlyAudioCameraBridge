# FlyAudio Camera Bridge

This project sends the following explicit intent to the FlyAudio camera service:

Component:
com.flyaudio.carvideo/.external.ExternalService

Extras:
key_video_cmd = cmd_show_video
key_video_way = back

## Build
Open the project in Android Studio and choose Build > Build APK(s).

The resulting APK should be under:
app/build/outputs/apk/debug/

## Important
This does NOT modify the FlyAudio camera APK, MCU, CAN configuration, or vehicle firmware.

If the head unit rejects the call with a permission error involving flyaudio.permission.AVM, the bridge cannot bypass that protection. That result would tell us that a privileged/system caller is required.
