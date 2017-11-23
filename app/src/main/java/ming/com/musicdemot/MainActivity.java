package ming.com.musicdemot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText_user,editText_paw;
    private CheckBox checkBox_rember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCompant();
    }
    private void initCompant(){
        editText_user=(EditText)findViewById(R.id.editText_user);
        editText_paw=(EditText)findViewById(R.id.editText_paw);
        checkBox_rember=(CheckBox)findViewById(R.id.checkBox2);

        checkBox_rember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                if(isCheck == true){
                    Toast.makeText(MainActivity.this, "a", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "b", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void ExitApp(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
    public void LoginApp(View view){
        if(editText_paw.getText().toString().isEmpty()||editText_user.getText().toString().isEmpty()){
            toast("内容不可为空");
        }else {
            if(editText_paw.getText().toString().equals("123456")){
                Intent intent=new Intent(this,SongActivity.class);
                intent.putExtra("name",editText_user.getText().toString());
                startActivity(intent);
            }else {
               toast("密码错误，请重试");
            }
        }
    }
    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
