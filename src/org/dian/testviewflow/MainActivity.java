package org.dian.testviewflow;

import org.taptwo.android.widget.CircleFlowIndicator;
import org.taptwo.android.widget.ViewFlow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	/*ui�ؼ�*/
	/**ViewFlow*/
	private ViewFlow viewFlow;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("����ͬר��");
        
        //�ҵ�xml�ж�Ӧ��viewflow�ؼ�
        viewFlow = (ViewFlow) findViewById(R.id.viewFlow);
        //ͼƬ����Դid
        int[] drawableIds = {R.drawable.bb88,
        		R.drawable.ke_la_si_ke, 
        		R.drawable.la_kuo_concert, 
        		R.drawable.moov_live, 
        		R.drawable.one_world, 
        		R.drawable.orange_moon, 
        		R.drawable.soul_boy, 
        		R.drawable.this_love, 
        		R.drawable.timeless};
        //��ͼƬ��������0Ϊ��ʼλ��
		viewFlow.setAdapter(new ViewAdapter(this, drawableIds), 0); 
		//Բ����ָ��
        CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
        //��ָ��
        viewFlow.setFlowIndicator(indic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}