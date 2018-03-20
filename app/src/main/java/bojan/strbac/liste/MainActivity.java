package bojan.strbac.liste;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener{
    private static final String TAG = "MainActivity";
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private Button button;
    private EditText mText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.list_id);
        button = findViewById(R.id.button_id);
        mText = findViewById(R.id.edit_id);

        button.setOnClickListener(this);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = mAdapter.getItem(i);
                Log.d(TAG,"On item click"+ i);
                //OVDE KUCAMO AKO HOCEMO DA PRELAZIMO NA NEKE AKTIVITIJE
                mAdapter.remove(item); //Brisanje iz liste
            }
        });
    }

    @Override
    public void onClick(View view) {
        String text = mText.getText().toString();
        mAdapter.add(text);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
