package example.android.filequestion;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class FileQuestionActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	//各オブジェクト初期化
	private String name_txt = "";
	private String address_txt = "";
	private String sex_txt = "";
	private String apple_txt = "";
	private String orange_txt = "";
	private String peach_txt = "";

	//インテント引き渡し用
	//public ArrayList<String> input_array;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//Activityクラスの onCreateを実行
        super.onCreate(savedInstanceState);
        
        //レイアウト設定ファイルの指定
        setContentView(R.layout.apply_layout);
        
        //Buttonオブジェクト取得
        Button send = (Button)findViewById(R.id.send);
        
        //Buttonオブジェクトにクリックリスナーを設定
        send.setOnClickListener(this);
    }
    
    //送信ボタン押下
    @Override
    public void onClick(View view){
    	
    	//インテント設定
    	Intent intent = new Intent(this,FileQuestionIntent.class);
    	
    	//インテント引き渡し用
    	ArrayList<String> input_array = new ArrayList<String>();
    	
    	//名前オブジェクト取得
    	EditText name = (EditText)findViewById(R.id.name);
    	if (!(name.getText().toString().equals(""))){
    		name_txt = name.getText().toString();
    	}
    	input_array.add(name_txt);
    	
    	//住所オブジェクト取得
    	EditText address = (EditText)findViewById(R.id.address);
    	if(!(address.getText().toString().equals(""))){
    		address_txt = address.getText().toString();
    	}
    	input_array.add(address_txt);
    	
    	//月オブジェクト
    	Spinner month = (Spinner)findViewById(R.id.month);
    	input_array.add(month.getSelectedItem().toString());
    	
    	//日オブジェクト
    	Spinner day = (Spinner)findViewById(R.id.day);
    	intent.putExtra("DAY", day.getSelectedItem().toString());
    	input_array.add(day.getSelectedItem().toString());
    	
    	//性別オブジェクト
    	RadioGroup sex_group = (RadioGroup)findViewById(R.id.sexgroup);
    	if(sex_group.getCheckedRadioButtonId() != -1){
    		RadioButton sex = (RadioButton)findViewById(sex_group.getCheckedRadioButtonId());
    		sex_txt = sex.getText().toString();
    	}
    	input_array.add(sex_txt);
    	
    	//りんごオブジェクト
    	CheckBox apple_chk = (CheckBox)findViewById(R.id.apple_chk);
    	if(apple_chk.isChecked()){
    		EditText apple_num = (EditText)findViewById(R.id.apple_num);
    		apple_txt = apple_num.getText().toString();
    	}
    	input_array.add(apple_txt);
    	
    	//みかんオブジェクト
    	CheckBox orange_chk = (CheckBox)findViewById(R.id.orange_chk);
    	if(orange_chk.isChecked()){
    		EditText orange_num = (EditText)findViewById(R.id.orange_num);
    		orange_txt = orange_num.getText().toString();
    	}
    	input_array.add(orange_txt);
    	
    	//ももオブジェクト
    	CheckBox peach_chk = (CheckBox)findViewById(R.id.peach_chk);
    	if(peach_chk.isChecked()){
    		EditText peach_num = (EditText)findViewById(R.id.peach_num);
    		peach_txt = peach_num.getText().toString();
    	}
    	input_array.add(peach_txt);
    	
    	//インテント付加情報設定
    	intent.putExtra("DATA_ARRAY", input_array);
    	
    	//アクティビティ起動
    	startActivity(intent);
    }
}