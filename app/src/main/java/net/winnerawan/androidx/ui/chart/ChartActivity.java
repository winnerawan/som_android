package net.winnerawan.androidx.ui.chart;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;
import net.winnerawan.androidx.R;
import net.winnerawan.androidx.ui.base.BaseActivity;
import net.winnerawan.androidx.utils.ViewUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends BaseActivity implements ChartView {

    @Inject
    ChartMvpPresenter<ChartView> presenter;

    @BindView(R.id.title_toolbar)
    TextView txtToolbar;
    @BindView(R.id.any_chart_view)
    AnyChartView anyChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_report);
        getActivityComponent().inject(this);

        ViewUtils.setStatusBar(this);
        setUnBinder(ButterKnife.bind(this));

        presenter.onAttach(this);
        setUp();
    }


    @Override
    protected void setUp() {
        setupChart();
        txtToolbar.setText("Customer Report");
    }


    private void setupChart() {
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));
        Cartesian cartesian = AnyChart.line();

        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);

        cartesian.title("");

        cartesian.yAxis(0).title("Customer Report");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);
        List<DataEntry> seriesData = new ArrayList<>();
        seriesData.add(new CustomDataEntry("1/Apr", 3, 2.3, 2.8));
        seriesData.add(new CustomDataEntry("4/Apr", 7, 4.0, 4.1));
        seriesData.add(new CustomDataEntry("7/Apr", 8, 6.2, 5.1));
        seriesData.add(new CustomDataEntry("10/Apr", 9, 11.8, 6.5));
        seriesData.add(new CustomDataEntry("13/Apr", 10, 13.0, 12.5));
        seriesData.add(new CustomDataEntry("16/Apr", 11, 13.9, 18.0));
        seriesData.add(new CustomDataEntry("19/Apr", 16, 18.0, 21.0));
        seriesData.add(new CustomDataEntry("22/Apr", 18, 23.3, 20.3));
        seriesData.add(new CustomDataEntry("25/Apr", 13, 24.7, 19.2));
        seriesData.add(new CustomDataEntry("28/Apr", 12, 18.0, 14.4));


        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");

        Line series1 = cartesian.line(series1Mapping);
        series1.name("");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);

        cartesian.legend().enabled(false);
        cartesian.legend().fontSize(13d);
        cartesian.legend().padding(0d, 0d, 10d, 0d);

        anyChartView.setChart(cartesian);
    }

    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value, Number value2, Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }

    }
}
