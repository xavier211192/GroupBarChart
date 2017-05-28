package app.num.groupbarchart;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarChart barChart = (BarChart) findViewById(R.id.chart);

        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(4500f, 0));
        group1.add(new BarEntry(8000f, 1));
        group1.add(new BarEntry(6000f, 2));
        group1.add(new BarEntry(1000f, 3));
        group1.add(new BarEntry(1800f, 4));
        group1.add(new BarEntry(9000f, 5));

        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(1250f, 0));
        group2.add(new BarEntry(1350f, 1));
        group2.add(new BarEntry(900f, 2));
        group2.add(new BarEntry(1100f, 3));
        group2.add(new BarEntry(1500f, 4));
        group2.add(new BarEntry(1000f, 5));

        BarDataSet barDataSet1 = new BarDataSet(group1, "Group 1");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(group2, "Group 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<BarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);


        BarData data = new BarData(getXAxisValues(), dataSets);
        barChart.setData(data);
        barChart.setDescription("My Grouped Bar Chart");
        barChart.animateXY(2000, 2000);
        barChart.invalidate();
    }


    private ArrayList<String> getXAxisValues() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("JAN");
        labels.add("FEB");
        labels.add("MAR");
        labels.add("APR");
        labels.add("MAY");
        labels.add("JUN");
        return labels;
    }

    public void graphView (View view)
    {
        Intent i = new Intent(MainActivity.this,chart.class);
        startActivity(i);
    }


}
