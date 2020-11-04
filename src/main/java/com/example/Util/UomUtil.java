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
public class UomUtil 
{
	
	//1. create pic chart
	public void generatepic(String path, List<Object[]> data)
	{
		//a. create dataset for pic 
		
		DefaultPieDataset dataset= new DefaultPieDataset();
		
		
		for(Object[] ob: data)
		{
			dataset.setValue(
					String.valueOf(ob[0]), 
					Double.valueOf(ob[1].toString()));
			
		}
		
		
		JFreeChart chart=ChartFactory.createPieChart3D(
				"UomType AND COUNT", dataset);
		
		PiePlot plot=(PiePlot) chart.getPlot();
		
		PieSectionLabelGenerator gen= new StandardPieSectionLabelGenerator("{0} : {1} ({2})",new DecimalFormat("0"), new DecimalFormat("%0"));
		
		plot.setLabelGenerator(gen);
		
				try {
					ChartUtils.saveChartAsJPEG(
							new File(path+"/UomA.jpg"),
							chart, 500, 300);
				} catch (IOException e) {
					e.printStackTrace();
				}		
	}
	
	
	  public void generatebar(String path, List<Object[]> data)
	   {
		//a. Create DataSet for Bar and add data to it
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			for(Object[] ob:data) {
				//val,key, label to display
				dataset.setValue(
						Double.valueOf(ob[1].toString()),  //value
						String.valueOf(ob[0]),  //key
						""); // label
			}

			//b. Create JFreeCharts object with dataset and other details
			// title, x-axis label, y-axis label, dataset
			JFreeChart chart = ChartFactory.createBarChart("UOM TYPE COUNT", "UOM TYPE", "COUNT", dataset);


			try {
				ChartUtils.saveChartAsJPEG(
						new File(path+"/uomB.jpg"), //path + file name
						chart, 500, 500); // chart obj, width, height
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	 

}
