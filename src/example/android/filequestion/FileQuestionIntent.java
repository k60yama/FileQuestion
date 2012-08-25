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
	
	//�t����񃊃X�g
	static ArrayList<String> data_array2 = new ArrayList<String>();
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		//Activity�N���X��onCreate�����s
		super.onCreate(savedInstanceState);
		
		//���C�A�E�g�ݒ�t�@�C���̎w��
		setContentView(R.layout.confirm_layout);
		
		//�C���e���g�擾
		Intent intent = getIntent();
		
		//�C���e���g�̕t�����擾
		Bundle input_array = intent.getExtras();
		ArrayList<String> data_array = input_array.getStringArrayList("DATA_ARRAY");
		
		//���O�I�u�W�F�N�g�ݒ�(�\���p)
		TextView name_view = (TextView)findViewById(R.id.name);
		String name = "������";
		if(!(data_array.get(0).equals(""))){
			name = data_array.get(0);
		}
		name_view.setText(name);
		data_array2.add("�����O�F" + name);
		
		//�Z���I�u�W�F�N�g�ݒ�(�\���p)
		TextView address_view = (TextView)findViewById(R.id.address);
		String address = "������";
		if(!(data_array.get(1).equals(""))){
			address = data_array.get(1);
		}
		address_view.setText(address);
		data_array2.add("�Z���F" + address);
		
		//���I�u�W�F�N�g(�\���p)
		TextView month_view = (TextView)findViewById(R.id.month);
		month_view.setText(data_array.get(2));
		
		//���I�u�W�F�N�g(�\���p)
		TextView day_view = (TextView)findViewById(R.id.day);
		day_view.setText(data_array.get(3));
		data_array2.add("���N�����F" + data_array.get(2) + "��" + data_array.get(3) + "��");
		
		//���ʃI�u�W�F�N�g(�\���p)
		TextView sex_view = (TextView)findViewById(R.id.sex);
		String sex = "���I��";
		if(!(data_array.get(4).equals(""))){
			sex = data_array.get(4);
		}
		sex_view.setText(sex);
		data_array2.add("���ʁF" + sex);
		
		//��񂲃I�u�W�F�N�g(�\���p)
		TextView apple_view = (TextView)findViewById(R.id.apple_num);
		String apple_num = "0";
		if(!(data_array.get(5).equals(""))){
			apple_num = data_array.get(5);
		}
		apple_view.setText(apple_num);
		data_array2.add("��񂲁F" + apple_num + "��");
		
		//�݂���I�u�W�F�N�g(�\���p)
		TextView orange_view = (TextView)findViewById(R.id.orange_num);
		String orange_num = "0";
		if(!(data_array.get(6).equals(""))){
			orange_num = data_array.get(6);
		}
		orange_view.setText(orange_num);
		data_array2.add("�݂���F" + orange_num + "��");
		
		//�����I�u�W�F�N�g(�\���p)
		TextView peach_view = (TextView)findViewById(R.id.peach_num);
		String peach_num = "0";
		if(!(data_array.get(7).equals(""))){
			peach_num = data_array.get(7);
		}
		peach_view.setText(peach_num);
		data_array2.add("�����F" + peach_num + "��");
		
		//Button�I�u�W�F�N�g�擾
		Button confirm = (Button)findViewById(R.id.confirm);
		Button back = (Button)findViewById(R.id.back);
		
		//Button�I�u�W�F�N�g�ɃN���b�N���X�i�[�ݒ�
		confirm.setOnClickListener(this);
		back.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view){
		
		//�������ꂽ�{�^������
		switch(view.getId()){
		case R.id.confirm:
			
			//�C���e���g����
			Intent intent = new Intent(this,FileQuestionFile.class);
			
			//�t�����ݒ�
			intent.putExtra("DATA_ARRAY", data_array2);
			
			//�A�N�e�B�r�e�B���s
			startActivity(intent);
			
			break;
		case R.id.back:
			
			//�A�N�e�B�r�e�B�I��
			finish();
			break;
		}
	}
}
