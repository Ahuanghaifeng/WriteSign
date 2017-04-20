package com.writesign.hhf;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SignView mView;
    private TextView commit,clear;
    private Bitmap mSignBitmap;
    private String signPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        mView = (SignView) findViewById(R.id.signView);
        commit = (TextView) findViewById(R.id.tv_commit);
        clear = (TextView) findViewById(R.id.tv_clear);
        commit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                saveSign(mView.getCachebBitmap());
            }
        });
        clear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                mView.clear();
            }
        });
    }

    /**
     * signPath是图片保存路径
     * @param bit
     */
    public void saveSign(Bitmap bit) {
        mSignBitmap = bit;
        signPath = createFile();
    }

    /**
     * @return
     */
    private String createFile() {
        ByteArrayOutputStream baos = null;
        String _path = null;
        try {
            String sign_dir = Environment.getExternalStorageDirectory()
                    .getPath() + "/";
            _path = sign_dir + "sign.jpg";
            baos = new ByteArrayOutputStream();
            mSignBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] photoBytes = baos.toByteArray();
            if (photoBytes != null) {
                new FileOutputStream(new File(_path)).write(photoBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return _path;
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (mSignBitmap != null) {
            mSignBitmap.recycle();
        }
    }
}
