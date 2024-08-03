package com.example.readpdf;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) PDFView pdfView = findViewById(R.id.pdfView);

        String pdfFileName = getIntent().getStringExtra("pdfFileName");

        pdfView.fromAsset(pdfFileName).load();
    }
}
