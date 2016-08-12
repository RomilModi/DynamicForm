package dynamicform.rays.org.dynamicform;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Questionbean> mArraylstQuestion;
    private ArrayList<Questionbean.Value> mArraylstValue;
    private LinearLayout LayoutMain;
    private Questionbean Questionbean;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<String> mArray, mArrayValue, mArrayValue2;
    private dynamicform.rays.org.dynamicform.Questionbean.Value Value;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        count = 0;
        mArray = new ArrayList<String>();
        mArrayValue = new ArrayList<String>();
        mArrayValue2 = new ArrayList<String>();


        String strJson = ReadFromfile("Json.txt", this);

        Log.e("Response", "Response is : " + strJson);

        mArraylstQuestion = new ArrayList<Questionbean>();
        mArraylstValue = new ArrayList<Questionbean.Value>();

        LayoutMain = (LinearLayout) findViewById(R.id.LayoutMain);

        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        try {
            mDatabaseHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            mDatabaseHelper.openDataBase();
        } catch (Exception e) {

        }

        Log.e("Question", "Question is : " + mDatabaseHelper.getQuestions());
        if (mDatabaseHelper.getQuestions().trim().length() == 0) {
            mDatabaseHelper.insertQuestion(strJson);
        }
        mDatabaseHelper.close();

        mArrayValue.add("Yes");
        mArrayValue.add("No");

        mArrayValue2.add("Yes");
        mArrayValue2.add("No");
        mArrayValue2.add("Not Decided");

        Questionbean q = new Questionbean();
        q.setQuestion("Do you have multiple partners?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Log.e("Q1", "Question One : " + mArrayValue.get(i));
            Questionbean.Value v = q.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }
//        v.setValue1("Yes");
//        v.setValue2("No");

        q.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q);

        mArraylstValue = new ArrayList<Questionbean.Value>();
        Questionbean q1 = new Questionbean();
        q1.setQuestion("Have you had taken blood before?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q1.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }

        q1.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q1);

        mArraylstValue = new ArrayList<Questionbean.Value>();

        Questionbean q2 = new Questionbean();
        q2.setQuestion("Do you have multiple partners?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q2.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);

        }

        q2.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q2);

        mArraylstValue = new ArrayList<Questionbean.Value>();

        Questionbean q3 = new Questionbean();
        q3.setQuestion("Have you had taken blood before?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q3.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }


        q3.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q3);

        mArraylstValue = new ArrayList<Questionbean.Value>();
        Questionbean q4 = new Questionbean();
        q4.setQuestion("Do you have multiple partners?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q4.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }

        q4.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q4);

        mArraylstValue = new ArrayList<Questionbean.Value>();

        Questionbean q5 = new Questionbean();
        q5.setQuestion("Have you had taken blood before?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q5.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }

        q5.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q5);

        mArraylstValue = new ArrayList<Questionbean.Value>();
        Questionbean q6 = new Questionbean();
        q6.setQuestion("Do you have multiple partners?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q6.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }

        q6.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q6);

        mArraylstValue = new ArrayList<Questionbean.Value>();

        Questionbean q7 = new Questionbean();
        q7.setQuestion("Have you had taken blood before?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q7.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }

        q7.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q7);

        mArraylstValue = new ArrayList<Questionbean.Value>();
        Questionbean q8 = new Questionbean();
        q8.setQuestion("Have you had taken blood before?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q8.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }

        q8.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q8);

        mArraylstValue = new ArrayList<Questionbean.Value>();
        Questionbean q9 = new Questionbean();
        q9.setQuestion("Do you have multiple partners?");

        for (int i = 0; i < mArrayValue.size(); i++) {
            Questionbean.Value v = q9.new Value();
            v.setValue1(mArrayValue.get(i));
            v.setCount(0);
            mArraylstValue.add(v);
        }

        q9.setmArrayValue(mArraylstValue);
        mArraylstQuestion.add(q9);


        for (int i = 0; i < mArraylstQuestion.size(); i++) {
            Log.e("Question", "Question is : " + mArraylstQuestion.get(i).getQuestion());
            LinearLayout layout2 = new LinearLayout(this);
            layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            layout2.setOrientation(LinearLayout.VERTICAL);
            TextView tv1 = new TextView(this);
            tv1.setText(mArraylstQuestion.get(i).getQuestion());
            tv1.setTextSize(getResources().getDimension(R.dimen.txt_size));

//            LinearLayout parent = new LinearLayout(this);
//            parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//            parent.setOrientation(LinearLayout.HORIZONTAL);
//            parent.setGravity(Gravity.LEFT);//Gravity Handles by this line
//            RadioGroup radioGroup = new RadioGroup(this);
//            radioGroup.setOrientation(LinearLayout.HORIZONTAL);
//            radioGroup.setGravity(Gravity.CENTER);
//            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            p.gravity = Gravity.CENTER;
//            p.setMargins(10, 40, 10, 40);
//            parent.addView(radioGroup, p);
//
//            for (int j = 0; j < mArraylstQuestion.get(i).getmArrayValue().size(); j++) {
//                Log.i("Question", "Question Value 1 is : " + mArraylstQuestion.get(i).getmArrayValue().get(j).getValue1());
////                Log.i("Question", "Question Value 2 is : " + mArraylstQuestion.get(i).getmArrayValue().get(j).getValue2());
//                RadioButton radioButtonView = new RadioButton(this);
//                radioButtonView.setText(mArraylstQuestion.get(i).getmArrayValue().get(j).getValue1());
//                radioButtonView.setTag(mArraylstQuestion.get(i).getmArrayValue().get(j));
//                radioButtonView.setOnClickListener(this);
//                radioGroup.addView(radioButtonView, p);
//            }

            /**********************************************/

            LinearLayout parent = new LinearLayout(this);

            parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            parent.setOrientation(LinearLayout.HORIZONTAL);
            parent.setGravity(Gravity.CENTER);
            ArrayList<Button> mArrayBtn = new ArrayList<Button>();
            for (int j = 0; j < mArraylstQuestion.get(i).getmArrayValue().size(); j++) {
                Log.i("Question", "Question Value 1 is : " + mArraylstQuestion.get(i).getmArrayValue().get(j).getValue1());
//                Log.i("Question", "Question Value 2 is : " + mArraylstQuestion.get(i).getmArrayValue().get(j).getValue2());
                android.widget.LinearLayout.LayoutParams params = new android.widget.LinearLayout.LayoutParams(
                        0, 100, 1f);
                params.setMargins(10, 10, 10, 10);
                Button iv = new Button(this);
                iv.setGravity(Gravity.CENTER);
                iv.setText(mArraylstQuestion.get(i).getmArrayValue().get(j).getValue1());
                iv.setTag(mArraylstQuestion.get(i).getmArrayValue().get(j));
                iv.setBackgroundResource(R.drawable.segment_button_left);
                mArrayBtn.add(iv);
                iv.setOnClickListener(new ImageClickLIstener(j, mArraylstQuestion.get(i).getmArrayValue(), mArrayBtn, iv));
                iv.setLayoutParams(params);
                parent.addView(iv);
            }

//            Button iv = new Button(this);
//            iv.setText(mArraylstQuestion.get(i).getmArrayValue().get(i).getValue1());
//            iv.setTag(mArraylstQuestion.get(i));
//            iv.setOnClickListener(new ImageClickLIstener());
//            StateListDrawable states = new StateListDrawable();
//            states.addState(new int[]{android.R.attr.state_pressed},
//                    getResources().getDrawable(R.mipmap.ic_launcher));
//            states.addState(new int[]{android.R.attr.state_focused},
//                    getResources().getDrawable(R.mipmap.ic_launcher));
////            states.addState(new int[] { },
////                    getResources().getDrawable(R.drawable.normal));
//
//            //imageView.setImageDrawable(states);  //YOUR IMAGE HERE
////AND FOR BUTTON
//            iv.setBackgroundDrawable(states);//FOR BUTTON
//            parent.addView(iv);
//            Button iv2 = new Button(this);
//            iv2.setText(mArraylstQuestion.get(i).getmArrayValue().get(i).getValue2());
//            parent.addView(iv2);
//            iv2.setTag(mArraylstQuestion.get(i));
//            iv2.setOnClickListener(new ImageClickLIstener());

//            RadioGroup radioGroup = new RadioGroup(this);
//            radioGroup.setOrientation(LinearLayout.HORIZONTAL);
//            radioGroup.setGravity(Gravity.CENTER);
//            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT
//            );
//            p.gravity = Gravity.CENTER;
//            p.setMargins(10, 40, 10, 40);
//            parent.addView(radioGroup, p);
//
//            RadioButton radioButtonView = new RadioButton(this);
//            radioButtonView.setText(mArraylstQuestion.get(i).getmArrayValue().get(i).getValue1());
//            radioButtonView.setTag(mArraylstQuestion.get(i));
//            radioButtonView.setOnClickListener(this);
//            radioGroup.addView(radioButtonView, p);
//
//            RadioButton radioButtonView2 = new RadioButton(this);
//            radioButtonView2.setText(mArraylstQuestion.get(i).getmArrayValue().get(i).getValue2());
//            radioButtonView2.setOnClickListener(mThisButtonListener);
//            radioGroup.addView(radioButtonView2, p);


            layout2.addView(tv1);
            layout2.addView(parent);
            LayoutMain.addView(layout2);
        }


        //********Dynamic Spinner*********//

//        for (int i = 0; i < mArraylstQuestion.size(); i++) {
//            Log.e("Question", "Question is : " + mArraylstQuestion.get(i).getQuestion());
//            Log.i("Question", "Question Value 1 is : " + mArraylstQuestion.get(i).getmArrayValue().get(i).getValue1());
//            Log.i("Question", "Question Value 2 is : " + mArraylstQuestion.get(i).getmArrayValue().get(i).getValue2());
////            for (int j = 0; j < mArraylstQuestion.get(i).getmArrayValue().size(); j++) {
////                Log.i("Question", "Question Value 1 is : " + mArraylstQuestion.get(i).getmArrayValue().get(j).getValue1());
////                Log.i("Question", "Question Value 2 is : " + mArraylstQuestion.get(i).getmArrayValue().get(j).getValue2());
////            }
//
//            LinearLayout layout2 = new LinearLayout(this);
//
//            layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//            layout2.setOrientation(LinearLayout.VERTICAL);
//            TextView tv1 = new TextView(this);
//            tv1.setText(mArraylstQuestion.get(i).getQuestion());
//            tv1.setTextSize(getResources().getDimension(R.dimen.txt_size));
//
//
//            LinearLayout parent = new LinearLayout(this);
//
//            parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//            parent.setOrientation(LinearLayout.HORIZONTAL);
//            parent.setGravity(Gravity.CENTER);
//
//            mArray.add(mArraylstQuestion.get(i).getmArrayValue().get(i).getValue1());
//            mArray.add(mArraylstQuestion.get(i).getmArrayValue().get(i).getValue2());
//
//            Spinner spinner = new Spinner(this);
//            spinner.setTag(mArraylstQuestion.get(i));
//            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.FILL_PARENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT
//            );
//            p.gravity = Gravity.CENTER;
//            p.setMargins(10, 40, 10, 40);
//            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mArray); //selected item will look like a spinner set from XML
//            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinner.setAdapter(spinnerArrayAdapter);
//            spinner.setOnItemSelectedListener(new SpinnerClickLIstener());
//            parent.addView(spinner, p);
//
//            layout2.addView(tv1);
//            layout2.addView(parent);
//            LayoutMain.addView(layout2);
//        }
    }

    @Override
    public void onClick(View v) {
        try {
//            String s = ((RadioButton) v).getText().toString();
//            Questionbean = (dynamicform.rays.org.dynamicform.Questionbean) v.getTag();
            Value = (dynamicform.rays.org.dynamicform.Questionbean.Value) v.getTag();
            Toast.makeText(MainActivity.this, "This is: " + Value.getValue1(),
                    Toast.LENGTH_LONG).show();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    class SpinnerClickLIstener implements AdapterView.OnItemSelectedListener {
        int position;

        SpinnerClickLIstener() {
            this.position = position;
        }


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Log.e("count", "count : " + count);
            if (count > 9) {
                Questionbean = (dynamicform.rays.org.dynamicform.Questionbean) view.getTag();
                Toast.makeText(MainActivity.this, Questionbean.question, Toast.LENGTH_SHORT).show();
            }
            count++;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(MainActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }
    }

    class ImageClickLIstener implements View.OnClickListener {
        int position;
        private ArrayList<dynamicform.rays.org.dynamicform.Questionbean.Value> mArray;
        private Button bn;
        private ArrayList<Button> mArraybtn;

        ImageClickLIstener(int position, ArrayList<dynamicform.rays.org.dynamicform.Questionbean.Value> mArray, ArrayList<Button> mArraybtn, Button bn) {
            this.position = position;
            this.mArray = mArray;
            this.bn = bn;
            this.mArraybtn = mArraybtn;

        }

        @Override
        public void onClick(View v) {
            //  Common.displayToast(ItemDetailsActivity.this, "" + position);
            Value = (dynamicform.rays.org.dynamicform.Questionbean.Value) v.getTag();
            for (int i = 0; i < mArray.size(); i++) {
                if (i == position) {
                    Log.e("POS", "i : " + i + " & Position : " + position);
                    mArraybtn.get(i).setBackgroundResource(R.drawable.segment_button_left_on);
                } else {
                    mArraybtn.get(i).setBackgroundResource(R.drawable.segment_button_left);
                }
            }

            Toast.makeText(MainActivity.this, Value.value1, Toast.LENGTH_SHORT).show();
        }
    }

    private View.OnClickListener mThisButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            String s = ((RadioButton) v).getText().toString();
            Toast.makeText(MainActivity.this, "Hello from 2!" + s,
                    Toast.LENGTH_LONG).show();
        }
    };

    public String ReadFromfile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }
}
