import strategies.*;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class Chart extends ApplicationFrame {

	private Vector<Strategy> strategies;
	
	public Chart(Vector<Strategy> _strategies) {
		super("Prisoner's Dillema");
		this.strategies = _strategies;
		
		final XYSeriesCollection dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
	}
	
	private XYSeriesCollection createDataset() {
		final XYSeriesCollection dataset = new XYSeriesCollection();
        Vector<Integer> results;
		
        for (int i = 0; i < strategies.size(); i++) {
			results = strategies.get(i).get_past_scores();
			XYSeries series = new XYSeries(strategies.get(i).get_name());
			for (int j = 0; j < results.size(); j++) {
				series.add(j, results.get(j));
			}
			dataset.addSeries(series);
		}
        
        return dataset;        
    }
	
	private JFreeChart createChart(final XYSeriesCollection dataset) {
        
		// create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "",      // chart title
            "",                      // x axis label
            "",                      // y axis label
            (XYDataset) dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            false,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);
       
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
                
        return chart; 
    }
	
}
