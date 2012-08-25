package example.android.filequestion;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;

public class FileQuestionIntent extends Activity implements OnClickListener{
	
	//付加情報リスト
	static ArrayList<String> data_array2 = new ArrayList<String>();
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		//ActivityクラスのonCreateを実行
		super.onCreate(savedInstanceState);
		
		//レイアウト設定ファイルの指定
		setContentView(R.layout.confirm_layout);
		
		//インテント取得
		Intent intent = getIntent();
		
		//インテントの付加情報取得
		Bundle input_array = intent.getExtras();
		ArrayList<String> data_array = input_array.getStringArrayList("DATA_ARRAY");
		
		//名前オブジェクト設定(表示用)
		TextView name_view = (TextView)findViewById(R.id.name);
		String name = "未入力";
		if(!(data_array.get(0).equals(""))){
			name = data_array.get(0);
		}
		name_view.setText(name);
		data_array2.add("お名前：" + name);
		
		//住所オブジェクト設定(表示用)
		TextView address_view = (TextView)findViewById(R.id.address);
		String address = "未入力";
		if(!(data_array.get(1).equals(""))){
			address = data_array.get(1);
		}
		address_view.setText(address);
		data_array2.add("住所：" + address);
		
		//月オブジェクト(表示用)
		TextView month_view = (TextView)findViewById(R.id.month);
		month_view.setText(data_array.get(2));
		
		//日オブジェクト(表示用)
		TextView day_view = (TextView)findViewById(R.id.day);
		day_view.setText(data_array.get(3));
		data_array2.add("生年月日：" + data_array.get(2) + "月" + data_array.get(3) + "日");
		
		//性別オブジェクト(表示用)
		TextView sex_view = (TextView)findViewById(R.id.sex);
		String sex = "未選択";
		if(!(data_array.get(4).equals(""))){
			sex = data_array.get(4);
		}
		sex_view.setText(sex);
		data_array2.add("性別：" + sex);
		
		//りんごオブジェクト(表示用)
		TextView apple_view = (TextView)findViewById(R.id.apple_num);
		String apple_num = "0";
		if(!(data_array.get(5).equals(""))){
			apple_num = data_array.get(5);
		}
		apple_view.setText(apple_num);
		data_array2.add("りんご：" + apple_num + "個");
		
		//みかんオブジェクト(表示用)
		TextView orange_view = (TextView)findViewById(R.id.orange_num);
		String orange_num = "0";
		if(!(data_array.get(6).equals(""))){
			orange_num = data_array.get(6);
		}
		orange_view.setText(orange_num);
		data_array2.add("みかん：" + orange_num + "個");
		
		//ももオブジェクト(表示用)
		TextView peach_view = (TextView)findViewById(R.id.peach_num);
		String peach_num = "0";
		if(!(data_array.get(7).equals(""))){
			peach_num = data_array.get(7);
		}
		peach_view.setText(peach_num);
		data_array2.add("もも：" + peach_num + "個");
		
		//Buttonオブジェクト取得
		Button confirm = (Button)findViewById(R.id.confirm);
		Button back = (Button)findViewById(R.id.back);
		
		//Buttonオブジェクトにクリックリスナー設定
		confirm.setOnClickListener(this);
		back.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view){
		
		//押下されたボタン判別
		switch(view.getId()){
		case R.id.confirm:
			
			//インテント生成
			Intent intent = new Intent(this,FileQuestionFile.class);
			
			//付加情報設定
			intent.putExtra("DATA_ARRAY", data_array2);
			
			//アクティビティ実行
			startActivity(intent);
			
			break;
		case R.id.back:
			
			//アクティビティ終了
			finish();
			break;
		}
	}
}
