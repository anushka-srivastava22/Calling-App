package com.devdroid.callingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import gcloud.uikit.prebuilt.call.invite.ZegoUiKitPrebuiltCallInvitationConfig;

import .zego.zegoexpress.constants.ZegoUIKitPrebuiltCallInvitationConfig;
import .zego.zegoexpress.constants.ZegoUIKitPrebuiltCallInvitationService;

public class MainActivity<ZegoUIKitPrebuiltCallInvitationConfig> extends AppCompatActivity {

    EditText userIdEditText;
    Button startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userIdEditText = findViewById(R.id.user_id_edit_text);
        startBtn = findViewById(R.id.start_btn);

        startBtn.setOnClickListener((v)-> {
            String userID = userIdEditText.getText().toString().trim();

            if(userID.isEmpty()) {
                return;
            }
        });
    }

    void startService(String userID) {
        Application application = getApplication(); // Android's application context
        long appID = 2053271253;   // yourAppID
        String appSign = "02541365cfb80a0cb994e38c1df0f98e1b5f74f9fd84858c2c832c900ee1eb9c";  // yourAppSign

        String userName = userID;   // yourUserName

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        callInvitationConfig.notifyWhenAppRunningInBackgroundorQuit = true;
        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound = "zego_uikit_sound_call";
        notificationConfig.channelID = "CallInvitation";
        notificationConfig.channelName = "CallInvitation";
        ZegoUIKitPrebuiltCallInviationService.init(getApplication(), appID, appSign, userID, userName, callInvitationConfig);
    }
}