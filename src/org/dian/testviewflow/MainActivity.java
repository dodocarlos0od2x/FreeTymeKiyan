package org.dian.testviewflow;

import java.util.Iterator;

import org.taptwo.android.widget.CircleFlowIndicator;
import org.taptwo.android.widget.ViewFlow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	/*ui�ؼ�*/
	/**ViewFlow*/
	private ViewFlow viewFlow;
	/**viewFlow��������*/
	private ViewAdapter viewAdapter;
	/**ͼƬ����Դid*/
	private int[] drawableIds = {R.drawable.bb_88,
    		R.drawable.ke_la_si_ke, 
    		R.drawable.la_kuo_concert, 
    		R.drawable.moov_live, 
    		R.drawable.one_world, 
    		R.drawable.orange_moon, 
    		R.drawable.soul_boy, 
    		R.drawable.this_love, 
    		R.drawable.timeless};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("����ͬר��");
        
        //�ҵ�xml�ж�Ӧ��viewflow�ؼ�
        viewFlow = (ViewFlow) findViewById(R.id.viewFlow);
        //��ͼƬ��������0Ϊ��ʼλ��
        viewAdapter = new ViewAdapter(this, drawableIds);
		viewFlow.setAdapter(viewAdapter, 0); 
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
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	System.out.println("itemId--->" + item.getOrder());
    	switch (item.getOrder()) {
		case 0:
			// add
			break;
		case 1:
			// delete
			int position = viewFlow.getSelectedItemPosition();
			removeId(drawableIds, position);
			viewAdapter.notifyDataSetChanged();
		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }

	private void removeId(int[] drawableIds, int position) {
		Iterator<int[]> iterator = new Iterator<int[]>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		}; 
		
	}
}