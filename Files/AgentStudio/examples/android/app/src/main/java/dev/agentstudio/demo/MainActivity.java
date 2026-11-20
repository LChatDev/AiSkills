package dev.agentstudio.demo;
import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
public class MainActivity extends Activity {
 private int dp(int v){return Math.round(v*getResources().getDisplayMetrics().density);}
 private int count=0;
 @Override public void onCreate(Bundle state){
  super.onCreate(state); if(state!=null) count=state.getInt("count");
  ScrollView scroll=new ScrollView(this);
  LinearLayout layout=new LinearLayout(this);
  layout.setOrientation(LinearLayout.VERTICAL); layout.setPadding(dp(24),dp(32),dp(24),dp(24)); layout.setGravity(Gravity.CENTER_HORIZONTAL); layout.setBackgroundColor(Color.rgb(244,246,250));
  layout.setOnApplyWindowInsetsListener((v,insets)->{v.setPadding(dp(24)+insets.getSystemWindowInsetLeft(),dp(32)+insets.getSystemWindowInsetTop(),dp(24)+insets.getSystemWindowInsetRight(),dp(24)+insets.getSystemWindowInsetBottom());return insets;});
  TextView title=new TextView(this); title.setText("Studio100"); title.setTextSize(32); title.setTextColor(Color.rgb(23,32,51)); layout.addView(title);
  TextView result=new TextView(this); result.setTextSize(48); result.setTextColor(Color.rgb(36,86,198)); result.setText(String.valueOf(count)); layout.addView(result);
  Button increment=new Button(this); increment.setText("Add one"); increment.setOnClickListener(v->{if(count<Integer.MAX_VALUE)count++;result.setText(String.valueOf(count));}); layout.addView(increment);
  Button reset=new Button(this); reset.setText("Reset"); reset.setOnClickListener(v->{count=0;result.setText("0");}); layout.addView(reset);
  scroll.addView(layout); setContentView(scroll);
 }
 @Override protected void onSaveInstanceState(Bundle out){out.putInt("count",count);super.onSaveInstanceState(out);}
}
