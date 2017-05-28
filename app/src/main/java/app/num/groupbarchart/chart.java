package app.num.groupbarchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by Prashanth on 5/14/2017.
 */

public class chart extends AppCompatActivity {


    private GraphView graph ;
    private int count = 0;
    private int countg=0;
    int[] weekStep = new int[] {9000,2500,3000,6000,9000};
    int[] glucose = new int[] {125,185,170,160,120};
    private  BarGraphSeries<DataPoint> series ;
    private LineGraphSeries<DataPoint> series2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        initGraph(graph);

    }

        public void initGraph(GraphView graph) {

            DataPoint [] values = new DataPoint[5];

            for(int i=0; i<weekStep.length;i++) {
                    int in = weekStep[i];

                        values[count] = new DataPoint(count, in);
                        count++;

                }


            series = new BarGraphSeries<>(values);
            graph.addSeries(series);
            series.setSpacing(50);
            StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
            staticLabelsFormatter.setHorizontalLabels(new String[] {"old", "middle", "new","screwed","why"});
            graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

            DataPoint [] valuesG = new DataPoint[5];

            for(int j = 0; j<glucose.length;j++){
                int in = glucose[j];
                valuesG[countg] = new DataPoint(countg,in);
                countg++;
            }
            series2 = new LineGraphSeries<>(valuesG);

            graph.getSecondScale().addSeries(series2);
// the y bounds are always manual for second scale
            graph.getSecondScale().setMinY(0);
            graph.getSecondScale().setMaxY(200);
            series2.setColor(Color.RED);
            graph.getGridLabelRenderer().setVerticalLabelsSecondScaleColor(Color.RED);
        }
    }
