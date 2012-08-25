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
	
	//�e�I�u�W�F�N�g������
	private String name_txt = "";
	private String address_txt = "";
	private String sex_txt = "";
	private String apple_txt = "";
	private String orange_txt = "";
	private String peach_txt = "";

	//�C���e���g�����n���p
	//public ArrayList<String> input_array;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//Activity�N���X�� onCreate�����s
        super.onCreate(savedInstanceState);
        
        //���C�A�E�g�ݒ�t�@�C���̎w��
        setContentView(R.layout.apply_layout);
        
        //Button�I�u�W�F�N�g�擾
        Button send = (Button)findViewById(R.id.send);
        
        //Button�I�u�W�F�N�g�ɃN���b�N���X�i�[��ݒ�
        send.setOnClickListener(this);
    }
    
    //���M�{�^������
    @Override
    public void onClick(View view){
    	
    	//�C���e���g�ݒ�
    	Intent intent = new Intent(this,FileQuestionIntent.class);
    	
    	//�C���e���g�����n���p
    	ArrayList<String> input_array = new ArrayList<String>();
    	
    	//���O�I�u�W�F�N�g�擾
    	EditText name = (EditText)findViewById(R.id.name);
    	if (!(name.getText().toString().equals(""))){
    		name_txt = name.getText().toString();
    	}
    	input_array.add(name_txt);
    	
    	//�Z���I�u�W�F�N�g�擾
    	EditText address = (EditText)findViewById(R.id.address);
    	if(!(address.getText().toString().equals(""))){
    		address_txt = address.getText().toString();
    	}
    	input_array.add(address_txt);
    	
    	//���I�u�W�F�N�g
    	Spinner month = (Spinner)findViewById(R.id.month);
    	input_array.add(month.getSelectedItem().toString());
    	
    	//���I�u�W�F�N�g
    	Spinner day = (Spinner)findViewById(R.id.day);
    	intent.putExtra("DAY", day.getSelectedItem().toString());
    	input_array.add(day.getSelectedItem().toString());
    	
    	//���ʃI�u�W�F�N�g
    	RadioGroup sex_group = (RadioGroup)findViewById(R.id.sexgroup);
    	if(sex_group.getCheckedRadioButtonId() != -1){
    		RadioButton sex = (RadioButton)findViewById(sex_group.getCheckedRadioButtonId());
    		sex_txt = sex.getText().toString();
    	}
    	input_array.add(sex_txt);
    	
    	//��񂲃I�u�W�F�N�g
    	CheckBox apple_chk = (CheckBox)findViewById(R.id.apple_chk);
    	if(apple_chk.isChecked()){
    		EditText apple_num = (EditText)findViewById(R.id.apple_num);
    		apple_txt = apple_num.getText().toString();
    	}
    	input_array.add(apple_txt);
    	
    	//�݂���I�u�W�F�N�g
    	CheckBox orange_chk = (CheckBox)findViewById(R.id.orange_chk);
    	if(orange_chk.isChecked()){
    		EditText orange_num = (EditText)findViewById(R.id.orange_num);
    		orange_txt = orange_num.getText().toString();
    	}
    	input_array.add(orange_txt);
    	
    	//�����I�u�W�F�N�g
    	CheckBox peach_chk = (CheckBox)findViewById(R.id.peach_chk);
    	if(peach_chk.isChecked()){
    		EditText peach_num = (EditText)findViewById(R.id.peach_num);
    		peach_txt = peach_num.getText().toString();
    	}
    	input_array.add(peach_txt);
    	
    	//�C���e���g�t�����ݒ�
    	intent.putExtra("DATA_ARRAY", input_array);
    	
    	//�A�N�e�B�r�e�B�N��
    	startActivity(intent);
    }
}