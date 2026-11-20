package dev.agentstudio.demo;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final int BG=0xff0c1425, PANEL=0xff16253d, INK=0xffedf5ff, MUTED=0xffb5c8df, ACCENT=0xff8dd9ff;
    private int count;
    private int dp(int n){return Math.round(n*getResources().getDisplayMetrics().density);}
    private GradientDrawable bg(int color,int radius){
        GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(radius));return d;
    }
    private TextView label(String text,int size,int color,boolean bold){
        TextView t=new TextView(this);t.setText(text);t.setTextSize(size);t.setTextColor(color);
        if(bold)t.setTypeface(Typeface.DEFAULT,Typeface.BOLD);return t;
    }
    private void add(LinearLayout parent,View v,int top){
        LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,-2);p.topMargin=dp(top);parent.addView(v,p);
    }
    @Override public void onCreate(Bundle state){
        super.onCreate(state);if(state!=null)count=state.getInt("count");
        getWindow().setStatusBarColor(BG);getWindow().setNavigationBarColor(BG);
        getWindow().getDecorView().setSystemUiVisibility(0);
        ScrollView scroll=new ScrollView(this);scroll.setFillViewport(true);scroll.setBackgroundColor(BG);
        LinearLayout page=new LinearLayout(this);page.setOrientation(LinearLayout.VERTICAL);page.setPadding(dp(24),dp(32),dp(24),dp(24));
        page.setOnApplyWindowInsetsListener((v,insets)->{
            v.setPadding(dp(24)+insets.getSystemWindowInsetLeft(),dp(32)+insets.getSystemWindowInsetTop(),dp(24)+insets.getSystemWindowInsetRight(),dp(24)+insets.getSystemWindowInsetBottom());return insets;
        });
        add(page,label("AISKILLS  /  STUDIO100",12,ACCENT,true),0);
        add(page,label("Project counter",32,INK,true),16);
        add(page,label("Local demonstration · No network",16,MUTED,false),8);
        LinearLayout card=new LinearLayout(this);card.setOrientation(LinearLayout.VERTICAL);card.setPadding(dp(22),dp(22),dp(22),dp(22));card.setBackground(bg(PANEL,24));add(page,card,30);
        add(card,label("COMPLETED ITEMS",13,MUTED,true),0);
        TextView result=label(String.valueOf(count),58,INK,true);result.setGravity(Gravity.CENTER);result.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);add(card,result,18);
        Button increment=new Button(this);increment.setText("Add one");increment.setAllCaps(false);increment.setTextColor(BG);increment.setMinHeight(dp(52));increment.setBackgroundTintList(android.content.res.ColorStateList.valueOf(ACCENT));add(card,increment,22);
        increment.setOnClickListener(v->{if(count<Integer.MAX_VALUE)count++;result.setText(String.valueOf(count));});
        Button reset=new Button(this);reset.setText("Reset counter");reset.setAllCaps(false);reset.setTextColor(INK);reset.setMinHeight(dp(52));reset.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xff344963));add(card,reset,10);
        reset.setOnClickListener(v->{count=0;result.setText("0");});
        add(page,label("Version 1.1 · Offline demo",13,MUTED,false),24);
        scroll.addView(page);setContentView(scroll);
    }
    @Override protected void onSaveInstanceState(Bundle out){out.putInt("count",count);super.onSaveInstanceState(out);}
}
