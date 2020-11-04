package com.example.Util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentUtil 
{
	
	public void generatepic(String path, List<Object[]> data)
	{
		// create dataset and Add data in it 
		
		DefaultPieDataset dataset= new DefaultPieDataset();
		
		for(Object[] ob :data)
		{
			dataset.setValue(String.valueOf(ob[0]),
					Double.valueOf(ob[1].toString()));
		}
		
		// create dataset object  to chart
		JFreeChart chart= ChartFactory.createPieChart3D("Shipment Mode", dataset);

				PiePlot plot=(PiePlot) chart.getPlot();
				
				// 0 lable name 1 value 2 percentage
				PieSectionLabelGenerator gen= new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
				
				plot.setLabelGenerator(gen);
				
		//chart to image
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/ShipmentA.jpg"), chart, 500, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
		
	public void Generatebar(String path, List<Object[]> data)
	{
		DefaultCategoryDataset dataset= new DefaultCategoryDataset();
		
		for(Object[] ob :data)
		{
			dataset.setValue(Double.valueOf(ob[1].toString()), String.valueOf(ob[0]), "");
		}
		
		JFreeChart chart= ChartFactory.createBarChart("ShipmentMode", "ShipmentMode", "Count", dataset);
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/ShipmentB.jpg"), chart, 500, 500);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
