package id.sch.smktelkom_mlg.tugas01.xirpl6028.pendaftran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama, etNT;
    RadioGroup rgHL, rgJK;
    Spinner spTY, spJJ;
    CheckBox cb1, cb2, cb3, cb4;
    Button bDaftar;
    TextView tvHasil, tvHasil2;
    int nPosisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNT = (EditText) findViewById(R.id.editTextNT);
        rgHL = (RadioGroup) findViewById(R.id.radioGroupHL);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        spTY = (Spinner) findViewById(R.id.spinnerTY);
        spJJ = (Spinner) findViewById(R.id.spinnerJJ);

        cb1 = (CheckBox) findViewById(R.id.Asana);
        cb2 = (CheckBox) findViewById(R.id.Matsyasana);
        cb3 = (CheckBox) findViewById(R.id.Padmasana);
        cb4 = (CheckBox) findViewById(R.id.Hatha);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);

        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        tvHasil = (TextView) findViewById(R.id.Hasil);
        tvHasil2 = (TextView) findViewById(R.id.Hasil2);

        bDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String NT = etNT.getText().toString();
        String hasil = null;
        String hasill = null;
        String JJ = spJJ.getSelectedItem().toString();
        String TY = spTY.getSelectedItem().toString();
        String Hasil2 = "\nJenis Yoga             : ";

        int startlen = Hasil2.length();
        if (cb1.isChecked()) Hasil2 += cb1.getText() + ",";
        if (cb2.isChecked()) Hasil2 += cb2.getText() + ",";
        if (cb3.isChecked()) Hasil2 += cb3.getText() + ",";
        if (cb4.isChecked()) Hasil2 += cb4.getText();

        if (Hasil2.length() == startlen) Hasil2 += "Tidak ada pada pilihan";

        if (rgHL.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgHL.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasill = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
        } else {
            etNama.setError(null);
        }

        if (NT.isEmpty()) {
            etNT.setError("Belum Diisi");
        } else if (NT.length() < 9) {
            etNT.setError("Format Salah");
        } else {
            etNT.setError(null);
        }

        tvHasil.setText("              PENDAFTARAN ANDA BERHASIL              " + "\nNama                      : " + nama + "\nNo. Telepon           : " + NT
                + "\nHari Latihan           : " + hasil + "\nTingakatan Yoga   : " + TY + "\nJenjang                  :" + JJ + "\nJenis Kelamin       :" + hasill + Hasil2);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nPosisi += 1;
        else nPosisi -= 1;
        tvHasil2.setText("Jenis Yoga (" + nPosisi + " terpilih)");
    }
}