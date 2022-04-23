package kelas.b.activity8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import kelas.b.activity8.database.DBController;

public class editTeman extends AppCompatActivity {
    TextInputEditText Nama, Telpon;
    Button Save;
    String nm,tlp,id;
    DBController controller = new DBController(this);

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_edit_teman);

        Nama = findViewById(R.id.edNama);
        Telpon = findViewById(R.id.edTelp);
        Save = findViewById(R.id.simpanBtn);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telpon");

        setTitle("Edit Data");
        Nama.setText(nm);
        Telpon.setText(tlp);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Nama.getText().toString().equals("") || Telpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Mohon isi data terlebih dahulu...", Toast.LENGTH_LONG).show();
                } else {
                    nm = Nama.getText().toString();
                    tlp = Telpon.getText().toString();
                    HashMap<String,String> values = new HashMap<>();
                    values.put("id", id);
                    values.put("nama", nm);
                    values.put("telpon", tlp);
                    controller.UpdateData(values);
                    callHome();
                }
            }
        });
    }
    private void callHome(){
        Intent i= new Intent(editTeman.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
