package org.dian.testviewflow;

import org.taptwo.android.widget.CircleFlowIndicator;
import org.taptwo.android.widget.ViewFlow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	/*ui控件*/
	/**ViewFlow*/
	private ViewFlow viewFlow;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("方大同专辑");
        
        //找到xml中对应的viewflow控件
        viewFlow = (ViewFlow) findViewById(R.id.viewFlow);
        //图片的资源id
        int[] drawableIds = {R.drawable.bb88,
        		R.drawable.ke_la_si_ke, 
        		R.drawable.la_kuo_concert, 
        		R.drawable.moov_live, 
        		R.drawable.one_world, 
        		R.drawable.orange_moon, 
        		R.drawable.soul_boy, 
        		R.drawable.this_love, 
        		R.drawable.timeless};
        //绑定图片适配器，0为起始位置
		viewFlow.setAdapter(new ViewAdapter(this, drawableIds), 0); 
		//圆点型指针
        CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
        //绑定指针
        viewFlow.setFlowIndicator(indic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}