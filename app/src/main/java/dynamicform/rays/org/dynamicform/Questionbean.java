package dynamicform.rays.org.dynamicform;

import java.util.ArrayList;

/**
 * Created by rmodi on 8/5/2016.
 */
public class Questionbean {

    public String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Value> getmArrayValue() {
        return mArrayValue;
    }

    public void setmArrayValue(ArrayList<Value> mArrayValue) {
        this.mArrayValue = mArrayValue;
    }

    ArrayList<Value> mArrayValue = new ArrayList<Value>();

    public class Value {

        public String value1;
        public int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        //        public String value2;

        public String getValue1() {
            return value1;
        }

        public void setValue1(String value1) {
            this.value1 = value1;
        }

//        public String getValue2() {
//            return value2;
//        }
//
//        public void setValue2(String value2) {
//            this.value2 = value2;
//        }
    }


}
