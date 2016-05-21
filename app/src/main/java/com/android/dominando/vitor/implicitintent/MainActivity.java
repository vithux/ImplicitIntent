package com.android.dominando.vitor.implicitintent;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    private static final String[] OPTIONS = {
            "Browser",
            "Call",
            "Maps",
            "Music",
            "SMS",
            "Share",
            "Exit"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, OPTIONS);
        setListAdapter(adpter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Uri uri = null;
        Intent intent = null;

        switch (position) {
            case 0:
                uri = Uri.parse("http://www.google.com.br");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case 1:
                uri = Uri.parse("tel:992996688");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
            case 2:
                uri = Uri.parse("geo:37.422219,-122.08364?z=14");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case 3:
                uri = Uri.parse("file:///minhamusica.mp3");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(uri, "audio/mp3");
                startActivity(intent);
                break;
            case 4:
                uri = Uri.parse("sms:19992996688");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra("sms_body", "SMS MENSAGE");
                startActivity(intent);
                break;
            case 5:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Shared");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            default:
                finish();
        }
    }
}