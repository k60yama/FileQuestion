package example.android.filequestion;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FileQuestionFile extends Activity {
	
	private static final String FILE_NAME="FILE_QUESTION"; 
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		//ActivityクラスのonCreateを実行
		super.onCreate(savedInstanceState);
		
		//レイアウト設定ファイルの指定
		setContentView(R.layout.result_layout);
		
		//インテント生成
		Intent intent = getIntent();
		
		//付加情報取得
		Bundle data = intent.getExtras();
		ArrayList<String> data_array = data.getStringArrayList("DATA_ARRAY");
		
		//ファイルにデータ保存
		try{
			
			//保存するファイル名指定
			FileOutputStream stream = openFileOutput(FILE_NAME,MODE_APPEND);
			
			//書き出しバッファ領域確保
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(stream));
			
			//書き出し処理
			for(int i = 0; i < data_array.size(); i++){
				out.write(data_array.get(i));
				out.newLine();
			}
			
			//書き出しバッファ領域解放
			out.close();
			
			//メッセージ出力
			Toast.makeText(this, "ファイルを保存しました。", Toast.LENGTH_SHORT).show();
			
		}catch(Exception e){
			
			//メッセージ出力
			Toast.makeText(this, "ファイルの保存に失敗しました。", Toast.LENGTH_SHORT).show();
		}
	}

}
