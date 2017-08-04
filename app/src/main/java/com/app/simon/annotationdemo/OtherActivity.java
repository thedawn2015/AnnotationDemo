package com.app.simon.annotationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.app.simon.annotationdemo.model.AnTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class OtherActivity extends AppCompatActivity {
    /** TAG */
    public static final String TAG = OtherActivity.class.getSimpleName();
    private android.widget.Button btnactivity;
    private Button btnmethod;
    private Button btnfields;
    private Button btnreset;
    private AnTest anTest;


    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, OtherActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initData();
        assignViews();
    }

    private void initData() {
        anTest = new AnTest();
        anTest.setId(120);
        anTest.setName("大家");
        anTest.setPhone(String.valueOf(135666));
    }

    private void assignViews() {
        this.btnactivity = (Button) findViewById(R.id.btn_new);
        this.btnreset = (Button) findViewById(R.id.btn_set_value);
        this.btnfields = (Button) findViewById(R.id.btn_fields);
        this.btnmethod = (Button) findViewById(R.id.btn_method);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_set_value:
                        setValues();
                        break;
                    case R.id.btn_fields:
                        getDeclareFields();
                        break;
                    case R.id.btn_method:
                        getDeclareMethods();
                        break;
                    case R.id.btn_new:
                        newObject();
                        break;
                }
            }
        };
        btnactivity.setOnClickListener(onClickListener);
        btnreset.setOnClickListener(onClickListener);
        btnfields.setOnClickListener(onClickListener);
        btnmethod.setOnClickListener(onClickListener);
    }

    /** --------------------------反射-------------------------- */

    /**
     * 设置参数值
     */
    private void setValues() {
        try {
            Class<? extends AnTest> aClass = anTest.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                //设置这些值是可以访问的
                field.setAccessible(true);
                if (field.getName().equals("name")) {
                    //设置系新的name
                    field.set(anTest, "新名字");
                }
            }

            for (Field field : fields) {
                Object o = field.get(anTest);
                Log.i(TAG, "setValues: " + field.getName() + ":" + o);
            }

            //直接通过参数名称取值
            Field idField = aClass.getDeclaredField("id");
            Object o = idField.get(anTest);
            Log.i(TAG, "setValues: " + idField.getName() + ":" + o);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 获取参数
     */
    private void getDeclareFields() {
        try {
            Class<? extends AnTest> aClass = anTest.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                //设置这些值是可以访问的
                field.setAccessible(true);
                Object o = field.get(anTest);
                Log.i(TAG, "getDeclareFields: " + field.getName() + "：" + o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取方法
     */
    private void getDeclareMethods() {
        try {
            Method[] declaredMethods = MainActivity.class.getDeclaredMethods();
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                String name = method.getName();
                Log.i(TAG, "getDeclareMethods: " + name);
            }

            Class<? extends AnTest> aClass = anTest.getClass();

            //1个参数
            Method addString = aClass.getDeclaredMethod("addString", String.class);
            addString.setAccessible(true);
            Object retString = addString.invoke(anTest, "新的参数");
            Log.i(TAG, "getDeclareMethods: retString2=" + retString);

            //两个参数
            Method addString2 = aClass.getDeclaredMethod("addString2", String.class, String.class);
            addString2.setAccessible(true);
            Object retString2 = addString2.invoke(anTest, "新的参数1", "新的参数2");
            Log.i(TAG, "getDeclareMethods: retString2=" + retString2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建新的对象
     */
    private void newObject() {
        try {
            //无参
            Class<? extends AnTest> aClass = (Class<? extends AnTest>) Class.forName("com.app.simon.annotationdemo.model.AnTest");
            Constructor constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            AnTest anTest = (AnTest) constructor.newInstance();
            anTest.setId(101);
            anTest.setName("无私");
            anTest.setPhone(String.valueOf(15145444));
            Log.i(TAG, "newObject1: " + anTest.toString());

            //有参
            Constructor constructor2 = aClass.getDeclaredConstructor(int.class);
            constructor2.setAccessible(true);
            AnTest anTest2 = (AnTest) constructor2.newInstance(222);
            anTest2.setName("大");
            anTest2.setPhone(String.valueOf(1333333));
            Log.i(TAG, "newObject2: " + anTest2.toString());

            //双参
            Constructor constructor3 = aClass.getDeclaredConstructor(new Class[]{int.class, String.class});
            constructor3.setAccessible(true);
            AnTest anTest3 = (AnTest) constructor3.newInstance(555, "联防");
            anTest3.setPhone(String.valueOf(814211));
            Log.i(TAG, "newObject3: " + anTest3.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
