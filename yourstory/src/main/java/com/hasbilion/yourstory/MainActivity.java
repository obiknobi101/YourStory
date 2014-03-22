package com.hasbilion.yourstory;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
/*        String yourTextValue = "text";
        TextView myTextView = (TextView) findViewById(R.id.edit_message);
        myTextView.setText(yourTextValue);
        final Button button = (Button) findViewById(R.id.button1);
        final String text =myTextView.getEditableText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                System.out.println(text);
            }
        });
        try {
            //Client.startClient("192.168.2.159",55551);

        } catch (Error e) {
            e.printStackTrace();
        }*/
    }

public void sendMessage(View view){


    new Client((EditText) findViewById(R.id.edit_message)).start();
}

   public void sendMessage2(View view){
   Socket client=null;

       System.out.println("---------------------------------starting socket: ");

       System.out.println("---------------------------------starting socket: ");

       System.out.println("---------------------------------starting socket: ");
       System.out.println("---------------------------------starting socket: ");

       System.out.println("---------------------------------starting socket: ");

       System.out.println("---------------------------------starting socket: ");
       System.out.println("---------------------------------starting socket: ");
       System.out.println("---------------------------------starting socket: ");
       System.out.println("---------------------------------starting socket: ");
       System.out.println("---------------------------------starting socket: ");
       try {
           client = new Socket("EEEPC", 44441);

       } catch (IOException e) {
           e.printStackTrace();
       }
       System.out.println("socket started: ");
       try{
       PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String fromServer = in.readLine();
        out.println("JO MAN");
        System.out.println("Server: " + fromServer);
        in.close();
        out.close();
        client.close();


    } catch(UnknownHostException e) {
        System.out.println("Unknown host: www.example.com"+e);

    } catch(IOException e) {
        System.out.println("No I/O"+e);
    }
   }


    public void sendMessage1(View view){
        String hostName ="192.168.2.103";

        try {
            Socket kkSocket = new Socket(hostName, 55551);
            try {
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                try {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(kkSocket.getInputStream()));
                    try {

                        String fromServer;
                        String fromUser;

//                        while ((fromServer = in.readLine()) != null) {
                        fromServer = in.readLine();
                        System.out.println("Server: " + fromServer);
//                            if (fromServer.equals("Bye."))
//  //                              break;
//
                        EditText editText = (EditText) findViewById(R.id.edit_message);
                        String message = editText.getText().toString();
//                            fromUser = stdIn.readLine();
//                            if (fromUser != null) {
//                                System.out.println("Client: " + fromUser);
                        out.println(message);
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
            System.err.println("Don't know about host " + hostName + e.toString());
            //System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName +e.toString());
            //System.exit(1);
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
