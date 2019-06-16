package com.prosayj.springboot.ppt;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFChart;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PPT图表测试类
 * 
 * @author cy
 *
 */
public class PPTGraphDemo
{

	public static void main(String[] args)
	{
		String basePath = System.getProperty("user.dir") + File.separator + "testFile";
		String templateFile = basePath + File.separator + "template.pptx";
		String destFile = basePath + File.separator + "dest.pptx";
		System.out.println("templateFile" + templateFile + " destFile:" + destFile);
		String result = createNewPPT(templateFile, destFile);
		System.out.println(result);
	}

	public static String createNewPPT(String templateFile, String destFile)
	{
		String result = "success";
		XMLSlideShow pptx = null;
		try
		{
			// 打开模板ppt
			pptx = new XMLSlideShow(new FileInputStream(templateFile));
			PPTGrapthUtils.judgeGraphSheetType(pptx);
			for (XSLFSlide slide : pptx.getSlides())
			{
				for (POIXMLDocumentPart part : slide.getRelations())
				{
					if (part instanceof XSLFChart)
					{
						PPTGrapthUtils.updateGraph((XSLFChart) part, getGraphData());
					}
				}
			}

			// 保存文件
			OutputStream out = new FileOutputStream(destFile);
			pptx.write(out);
			out.close();

		} catch (Exception e)
		{
			result = e.toString();
		} finally
		{
			if (pptx != null)
			{
				try
				{
					pptx.close();
				} catch (IOException e)
				{
					result = e.toString();
				}
			}
		}

		return result;
	}

	private static GraphData getGraphData()
	{
		List<SeriesData> dataList = new ArrayList<SeriesData>();
		SeriesData seriesData = new SeriesData("优", 10);
		dataList.add(seriesData);
		seriesData = new SeriesData("中", 150);
		dataList.add(seriesData);
		seriesData = new SeriesData("及格", 80);
		dataList.add(seriesData);
		seriesData = new SeriesData("不及格", 20);
		dataList.add(seriesData);

		GraphData graphData = new GraphData("成绩情况", dataList);

		return graphData;
	}

}
