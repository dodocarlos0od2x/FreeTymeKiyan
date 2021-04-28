package org.dian.testviewflow;

import java.util.ArrayList;

import org.taptwo.android.widget.CircleFlowIndicator;
import org.taptwo.android.widget.ViewFlow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	/*ui�ؼ�*/
	/**ViewFlow*/
	private ViewFlow viewFlow;
	/**viewFlow��������*/
	private ViewAdapter viewAdapter;
	/**ͼƬ����Դid*/
	private Integer[] drawableIds = {R.drawable.bb_88,
    		R.drawable.ke_la_si_ke, 
    		R.drawable.la_kuo_concert, 
    		R.drawable.moov_live, 
    		R.drawable.one_world, 
    		R.drawable.orange_moon, 
    		R.drawable.soul_boy, 
    		R.drawable.this_love, 
    		R.drawable.timeless};
	/**ͼƬ��Դid��ArrayList*/
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	private ArrayList<Integer> removedList = new ArrayList<Integer>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("����ͬר��");
        
        //�ҵ�xml�ж�Ӧ��viewflow�ؼ�
        viewFlow = (ViewFlow) findViewById(R.id.viewFlow);
        //int[] -> arraylist
        integer2ArrayList(drawableIds);
        //��ͼƬ��������0Ϊ��ʼλ��
        viewAdapter = new ViewAdapter(this, drawableIds);
		viewFlow.setAdapter(viewAdapter, 0); 
		//Բ����ָ��
        CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
        //��ָ��
        viewFlow.setFlowIndicator(indic);
    }

    private void integer2ArrayList(Integer[] drawableIds) {
    	for (int i = 0; i < drawableIds.length; i++) {
    		arrayList.add(drawableIds[i]);
		}
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	System.out.println("itemId--->" + item.getOrder());
    	int position = viewFlow.getSelectedItemPosition();
    	switch (item.getOrder()) {
		case 0:
			// add
			drawableIds = addToLast();
			viewAdapter = new ViewAdapter(this, drawableIds);
			viewFlow.setAdapter(viewAdapter, position);
			break;
		case 1:
			// delete
			// remove from integer array
			drawableIds = remove(position);
			viewAdapter = new ViewAdapter(this, drawableIds);
			int i = position - 1;
			if (i > 0) {
				viewFlow.setAdapter(viewAdapter, i); 
			} else {
				viewFlow.setAdapter(viewAdapter, 0);
			}
//			viewAdapter.notifyDataSetChanged();
		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }

	private Integer[] addToLast() {
		Integer temp = removedList.remove(removedList.size() - 1);
		removedList.trimToSize();
		arrayList.add(temp);
		Integer[] i = arrayList.toArray(new Integer[arrayList.size()]);
		return i;
	}

	private Integer[] remove(int position) {
		removedList.add(arrayList.remove(position));
		arrayList.trimToSize();
		Integer[] i = arrayList.toArray(new Integer[arrayList.size()]);
		for (int j = 0; j < i.length; j++) {
			System.out.println("array--->" + i[j]);
		}
		return i;
	}
}