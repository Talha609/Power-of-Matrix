package com.example.mohdtalha.matrixapp;

import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

        EditText tv1,tv3,tv5;
        Button butn,btn,button,clr,btnclr;
        TextView tv4,tv6;
        String r="",c="";
    int row,col,x=0,y=0;
    int ar[][],b[][],temp[][];
    String n="",s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv1=findViewById(R.id.tv1);
        butn=findViewById(R.id.butn);
        btn=findViewById(R.id.btn);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        clr=findViewById(R.id.clr);
        btnclr=findViewById(R.id.btnclr);
        button=findViewById(R.id.button);
        tv3.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        tv6.setVisibility(View.INVISIBLE);
        clr.setVisibility(View.INVISIBLE);
        btnclr.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);

        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                r=tv1.getText().toString().trim();
                if(r.isEmpty())
                    Toast.makeText(Activity2.this, "Please Enter All Details", Toast.LENGTH_SHORT).show();
                else {
                    row = Integer.parseInt(r);
                    ar = new int[row][row];
                    b=new int[row][row];
                    temp=new int[row][row];

                    /*tv3.setHint("Please Enter Number");
                    ar[x][y]=Integer.parseInt(tv3.getText().toString().trim());
                    y++;
                    tv4.setText(String.valueOf(ar[x][y]));*/

                    tv1.setVisibility(View.GONE);
                    butn.setVisibility(View.GONE);
                    tv3.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = tv3.getText().toString().trim();
                if (c.isEmpty()) {
                    Toast.makeText(Activity2.this, "Please Enter Number!!", Toast.LENGTH_SHORT).show();
                } else {
                    if (x == row - 1 && y == row) {
                        Toast.makeText(Activity2.this, "Matix Is Full!", Toast.LENGTH_SHORT).show();
                        tv3.setVisibility(View.GONE);
                        btn.setVisibility(View.GONE);
                        tv5.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                        tv5.setHint("Please Enter Power Of Matrix");
                    } else {
                        if (y == row) {
                            x++;
                            y = 0;
                            n = n + "\n\n";
                        }
                        ar[x][y] = Integer.parseInt(tv3.getText().toString().trim());
                        n = n + ar[x][y] + "      ";
                        y++;
                        tv4.setText(n);
                        tv3.getText().clear();
                        tv3.setHint("Please Enter Number");
                        //tv4.setText("\n");
                    }
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(x=0;x<=row-1;x++)
                {
                    for(y=0;y<=row-1;y++)
                    {
                        temp[x][y]=ar[x][y];
                    }
                }
                String gt=tv5.getText().toString().trim();
                int get=Integer.parseInt(gt);
                if(get==0)
                {
                    for (x = 0; x <= row - 1; x++) {
                        for (y = 0; y <= row - 1; y++) {
                            s = s + ar[x][y] + "      ";
                        }
                        s = s + "\n\n\n";
                    }
                    tv6.setText(s);
                }
                else {
                    for (int t = 1; t <= get - 1; t++) {
                        for (x = 0; x <= row - 1; x++) {
                            for (y = 0; y <= row - 1; y++) {
                                for (int z = 0; z <= row - 1; z++) {
                                    b[x][y] += temp[x][z] * ar[z][y];
                                }
                            }
                        }
                        for (x = 0; x <= row - 1; x++) {
                            for (y = 0; y <= row - 1; y++) {
                                temp[x][y] = b[x][y];

                            }
                        }

                        if (t != get - 1) {
                            for (x = 0; x <= row - 1; x++) {
                                for (y = 0; y <= row - 1; y++) {
                                    b[x][y] = 0;
                                }
                            }
                        }


                    }

                    for (x = 0; x <= row - 1; x++) {
                        for (y = 0; y <= row - 1; y++) {
                            s = s + b[x][y] + "      ";
                        }
                        s = s + "\n\n\n";
                    }
                    tv6.setText(s);
                }
                s = "";
                tv6.setVisibility(View.VISIBLE);
                clr.setVisibility(View.VISIBLE);
                btnclr.setVisibility(View.VISIBLE);
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv6.setText("");
                tv5.getText().clear();
                for(x=0;x<=row-1;x++)
                {
                    for(y=0;y<=row-1;y++)
                    {
                        b[x][y]=0;
                    }
                }
            }
        });
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv6.setText("");
                tv5.getText().clear();
                for(x=0;x<=row-1;x++)
                {
                    for(y=0;y<=row-1;y++)
                    {
                        b[x][y]=0;
                    }
                }
                for(x=0;x<=row-1;x++)
                {
                    for(y=0;y<=row-1;y++)
                    {
                        ar[x][y]=0;
                    }
                }
                Intent intent=new Intent(Activity2.this,com.example.mohdtalha.matrixapp.MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
