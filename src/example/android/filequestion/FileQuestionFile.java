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
		
		//Activity�N���X��onCreate�����s
		super.onCreate(savedInstanceState);
		
		//���C�A�E�g�ݒ�t�@�C���̎w��
		setContentView(R.layout.result_layout);
		
		//�C���e���g����
		Intent intent = getIntent();
		
		//�t�����擾
		Bundle data = intent.getExtras();
		ArrayList<String> data_array = data.getStringArrayList("DATA_ARRAY");
		
		//�t�@�C���Ƀf�[�^�ۑ�
		try{
			
			//�ۑ�����t�@�C�����w��
			FileOutputStream stream = openFileOutput(FILE_NAME,MODE_APPEND);
			
			//�����o���o�b�t�@�̈�m��
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(stream));
			
			//�����o������
			for(int i = 0; i < data_array.size(); i++){
				out.write(data_array.get(i));
				out.newLine();
			}
			
			//�����o���o�b�t�@�̈���
			out.close();
			
			//���b�Z�[�W�o��
			Toast.makeText(this, "�t�@�C����ۑ����܂����B", Toast.LENGTH_SHORT).show();
			
		}catch(Exception e){
			
			//���b�Z�[�W�o��
			Toast.makeText(this, "�t�@�C���̕ۑ��Ɏ��s���܂����B", Toast.LENGTH_SHORT).show();
		}
	}

}
