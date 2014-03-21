package com.hasbilion.yourstory;

/**
 * Created by obiknobi on 27.02.14.
 */
/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.*;
import java.net.*;

public class Client extends Activity {
    public String test ="test";


    TelephonyManager telephonyManager  =  ( TelephonyManager
            )getSystemService( Context.TELEPHONY_SERVICE );


    private String getIMEI(){


        String androidId2 = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        String androidIMEI = telephonyManager.getSubscriberId();
        return androidId2;
    }


    public static void startClient(String hostName,int portNumber) throws IOException {

        try {
            Socket kkSocket = new Socket(hostName, portNumber);
            try {
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                try {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(kkSocket.getInputStream()));
                    try {
                        BufferedReader stdIn =
                                new BufferedReader(new InputStreamReader(System.in));
                        String fromServer;
                        String fromUser;

//                        while ((fromServer = in.readLine()) != null) {
                        fromServer = in.readLine();
                            System.out.println("Server: " + fromServer);
//                            if (fromServer.equals("Bye."))
//  //                              break;
//
//                            fromUser = stdIn.readLine();
//                            if (fromUser != null) {
//                                System.out.println("Client: " + fromUser);
//                                out.println(fromUser);
//                            }
//                        }
                    } finally {
                        in.close();
                    }
                } finally {
                    out.close();
                }
            } finally {
                kkSocket.close();
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}