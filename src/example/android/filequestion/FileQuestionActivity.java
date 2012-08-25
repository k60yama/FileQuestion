package example.android.filequestion;

import android.app.Activity;
import android.os.Bundle;

public class FileQuestionActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//Activityクラスの onCreateを実行
        super.onCreate(savedInstanceState);
        
        //レイアウト設定ファイルの指定
        setContentView(R.layout.apply_layout);
        
       
    }
}