package com.prosayj.springboot.ppt;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFChart;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;

import java.io.IOException;
import java.io.OutputStream;

/**
 * PPT公具类
 * 
 * @author CAOYONG
 *
 */
public class PPTGrapthUtils
{
	public static void updateGraph(XSLFChart chart, GraphData graphData)
	{
		String type = PPTGrapthUtils.getGraphType(chart);
		if ("pie".equalsIgnoreCase(type))
		{
			PPTGrapthUtils.refreshPieGraph(chart, graphData);
		} else if ("bar".equalsIgnoreCase(type))
		{
			refreshBarGraph(chart, graphData);
		} else if ("line".equalsIgnoreCase(type))
		{
			refreshLineGraph(chart, graphData);
		} else if ("area".equalsIgnoreCase(type))
		{
			refreshAreaGraph(chart, graphData);
		}

		System.out.println("updateGraph type:" + type);
	}

	/**
	 * 判断PPT图表类型(注意需要依赖:ooxml-schemas-1.1.jar)
	 * 
	 * @param pptx
	 */
	public static void judgeGraphSheetType(XMLSlideShow pptx)
	{
		int pageIdx = 1;
		for (XSLFSlide slide : pptx.getSlides())
		{
			for (POIXMLDocumentPart part : slide.getRelations())
			{
				if (part instanceof XSLFChart)
				{
					XSLFChart chart = (XSLFChart) part;
					CTPlotArea plot = chart.getCTChart().getPlotArea();
					judgeGraphSheetType(plot, pageIdx);
				}
			}

			pageIdx++;
		}
	}

	// 具体判断
	private static void judgeGraphSheetType(CTPlotArea plot, int pageIdx)
	{
		StringBuffer infos = new StringBuffer();
		if (null != plot && plot.getBarChartList().size() > 0)
		{
			infos.append("pageIdx:" + pageIdx + " has 柱状图");
			infos.append(" DetailInfo: \n ");
			for (CTBarSer ser : plot.getBarChartList().get(0).getSerList())
			{
				infos.append(getGraphTitle(ser.getTx()));
				infos.append(" ");
				String info = getGraphDetailInfo(ser.getCat());
				ser.getTx();
				if (info.length() > 0)
				{
					infos.append(info + "\n");
				}
			}
		} else if (null != plot && plot.getPieChartList().size() > 0)
		{
			infos.append("pageIdx:" + pageIdx + " has 圆饼图");
			infos.append(" DetailInfo: \n ");
			for (CTPieSer ser : plot.getPieChartList().get(0).getSerList())
			{
				infos.append(getGraphTitle(ser.getTx()));
				infos.append(" ");
				String info = getGraphDetailInfo(ser.getCat());
				if (info.length() > 0)
				{
					infos.append(info + "\n");
				}
			}
		} else if (null != plot && plot.getLineChartList().size() > 0)
		{
			infos.append("pageIdx:" + pageIdx + " has 线性图");
			infos.append(" DetailInfo: \n ");
			for (CTLineSer ser : plot.getLineChartList().get(0).getSerList())
			{
				infos.append(getGraphTitle(ser.getTx()));
				infos.append(" ");
				String info = getGraphDetailInfo(ser.getCat());
				if (info.length() > 0)
				{
					infos.append(info + "\n");
				}
			}
		} else if (null != plot && plot.getAreaChartList().size() > 0)
		{
			infos.append("pageIdx:" + pageIdx + " has 面积图");
			infos.append(" DetailInfo: \n ");
			for (CTAreaSer ser : plot.getAreaChartList().get(0).getSerList())
			{
				infos.append(getGraphTitle(ser.getTx()));
				infos.append(" ");
				String info = getGraphDetailInfo(ser.getCat());
				if (info.length() > 0)
				{
					infos.append(info + "\n");
				}
			}
		}
		// 还可以判断其它图

		System.out.println(infos.toString());
	}

	// 得到图表标题
	private static String getGraphTitle(CTSerTx tx)
	{
		StringBuilder infos = new StringBuilder();
		if (null != tx && null != tx.getStrRef())
		{
			for (CTStrVal val : tx.getStrRef().getStrCache().getPtList())
			{
				infos.append("Title ID:" + val.getIdx() + " V:" + val.getV());
			}

			infos.append("\n");
		}

		return infos.toString();
	}

	// 得到第系值
	private static String getGraphDetailInfo(CTAxDataSource cat)
	{
		StringBuilder infos = new StringBuilder();
		if (null != cat && null != cat.getStrRef())
		{
			for (CTStrVal val : cat.getStrRef().getStrCache().getPtList())
			{
				infos.append("ser ID:" + val.getIdx() + " V:" + val.getV());
			}
		}

		return infos.toString();
	}

	/**
	 * 通过图表类型
	 * 
	 * @param chart
	 * @return
	 */
	private static String getGraphType(XSLFChart chart)
	{
		String graphTye = "noSupport";
		CTPlotArea plot = chart.getCTChart().getPlotArea();
		if (null != plot && plot.getBarChartList().size() > 0)
		{
			graphTye = "bar";
		} else if (null != plot && plot.getPieChartList().size() > 0)
		{
			graphTye = "pie";
		} else if (null != plot && plot.getLineChartList().size() > 0)
		{
			graphTye = "line";
		} else if (null != plot && plot.getAreaChartList().size() > 0)
		{
			graphTye = "area";
		}

		return graphTye;
	}

	// 刷新圆饼图
	private static boolean refreshPieGraph(XSLFChart chart, GraphData graphData)
	{
		boolean result = true;
		// 把图表绑定到Excel workbook中
		try
		{
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet();
			CTChart ctChart = chart.getCTChart();
			CTPlotArea plotArea = ctChart.getPlotArea();
			CTPieChart pieChart = plotArea.getPieChartArray(0);
			// 获取图表的系列
			CTPieSer ser = pieChart.getSerArray(0);
			// Series Text
			CTSerTx tx = ser.getTx();
			tx.getStrRef().getStrCache().getPtArray(0).setV(graphData.getTitle());
			sheet.createRow(0).createCell(1).setCellValue(graphData.getTitle());
			String titleRef = new CellReference(sheet.getSheetName(), 0, 1, true, true).formatAsString();
			tx.getStrRef().setF(titleRef);

			// Category Axis Data
			CTAxDataSource cat = ser.getCat();
			// 获取图表的值
			CTNumDataSource val = ser.getVal();
			refreshGraphContent(sheet, cat, val, graphData);

			// 更新嵌入的workbook
			POIXMLDocumentPart xlsPart = chart.getRelations().get(0);
			OutputStream xlsOut = xlsPart.getPackagePart().getOutputStream();
			try
			{
				wb.write(xlsOut);
				xlsOut.close();
			} catch (IOException e)
			{
				e.printStackTrace();
				result = false;
			} finally
			{
				if (wb != null)
				{
					try
					{
						wb.close();
					} catch (IOException e)
					{
						e.printStackTrace();
						result = false;
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	// 刷新柱状图
	private static boolean refreshBarGraph(XSLFChart chart, GraphData graphData)
	{
		boolean result = true;
		// 把图表绑定到Excel workbook中
		try
		{
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet();
			CTChart ctChart = chart.getCTChart();
			CTPlotArea plotArea = ctChart.getPlotArea();
			CTBarChart pieChart = plotArea.getBarChartArray(0);
			// 获取图表的系列
			CTBarSer ser = pieChart.getSerArray(0);
			// Series Text
			CTSerTx tx = ser.getTx();
			tx.getStrRef().getStrCache().getPtArray(0).setV(graphData.getTitle());
			sheet.createRow(0).createCell(1).setCellValue(graphData.getTitle());
			String titleRef = new CellReference(sheet.getSheetName(), 0, 1, true, true).formatAsString();
			tx.getStrRef().setF(titleRef);

			// Category Axis Data
			CTAxDataSource cat = ser.getCat();
			// 获取图表的值
			CTNumDataSource val = ser.getVal();
			refreshGraphContent(sheet, cat, val, graphData);

			// 更新嵌入的workbook
			POIXMLDocumentPart xlsPart = chart.getRelations().get(0);
			OutputStream xlsOut = xlsPart.getPackagePart().getOutputStream();
			try
			{
				wb.write(xlsOut);
				xlsOut.close();
			} catch (IOException e)
			{
				e.printStackTrace();
				result = false;
			} finally
			{
				if (wb != null)
				{
					try
					{
						wb.close();
					} catch (IOException e)
					{
						e.printStackTrace();
						result = false;
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	// 刷新线性图
	private static boolean refreshLineGraph(XSLFChart chart, GraphData graphData)
	{
		boolean result = true;
		// 把图表绑定到Excel workbook中
		try
		{
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet();
			CTChart ctChart = chart.getCTChart();
			CTPlotArea plotArea = ctChart.getPlotArea();
			CTLineChart pieChart = plotArea.getLineChartArray(0);
			// 获取图表的系列
			CTLineSer ser = pieChart.getSerArray(0);
			// Series Text
			CTSerTx tx = ser.getTx();
			tx.getStrRef().getStrCache().getPtArray(0).setV(graphData.getTitle());
			sheet.createRow(0).createCell(1).setCellValue(graphData.getTitle());
			String titleRef = new CellReference(sheet.getSheetName(), 0, 1, true, true).formatAsString();
			tx.getStrRef().setF(titleRef);

			// Category Axis Data
			CTAxDataSource cat = ser.getCat();
			// 获取图表的值
			CTNumDataSource val = ser.getVal();
			refreshGraphContent(sheet, cat, val, graphData);

			// 更新嵌入的workbook
			POIXMLDocumentPart xlsPart = chart.getRelations().get(0);
			OutputStream xlsOut = xlsPart.getPackagePart().getOutputStream();
			try
			{
				wb.write(xlsOut);
				xlsOut.close();
			} catch (IOException e)
			{
				e.printStackTrace();
				result = false;
			} finally
			{
				if (wb != null)
				{
					try
					{
						wb.close();
					} catch (IOException e)
					{
						e.printStackTrace();
						result = false;
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	// 刷新面积图
	private static boolean refreshAreaGraph(XSLFChart chart, GraphData graphData)
	{
		boolean result = true;
		// 把图表绑定到Excel workbook中
		try
		{
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet();
			CTChart ctChart = chart.getCTChart();
			CTPlotArea plotArea = ctChart.getPlotArea();
			CTAreaChart pieChart = plotArea.getAreaChartArray(0);
			// 获取图表的系列
			CTAreaSer ser = pieChart.getSerArray(0);
			// Series Text
			CTSerTx tx = ser.getTx();
			tx.getStrRef().getStrCache().getPtArray(0).setV(graphData.getTitle());
			sheet.createRow(0).createCell(1).setCellValue(graphData.getTitle());
			String titleRef = new CellReference(sheet.getSheetName(), 0, 1, true, true).formatAsString();
			tx.getStrRef().setF(titleRef);

			// Category Axis Data
			CTAxDataSource cat = ser.getCat();
			// 获取图表的值
			CTNumDataSource val = ser.getVal();
			refreshGraphContent(sheet, cat, val, graphData);

			// 更新嵌入的workbook
			POIXMLDocumentPart xlsPart = chart.getRelations().get(0);
			OutputStream xlsOut = xlsPart.getPackagePart().getOutputStream();
			try
			{
				wb.write(xlsOut);
				xlsOut.close();
			} catch (IOException e)
			{
				e.printStackTrace();
				result = false;
			} finally
			{
				if (wb != null)
				{
					try
					{
						wb.close();
					} catch (IOException e)
					{
						e.printStackTrace();
						result = false;
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	// 刷新图表内容
	private static void refreshGraphContent(Sheet sheet, CTAxDataSource cat, CTNumDataSource val, GraphData graphData)
	{
		CTStrData strData = cat.getStrRef().getStrCache();
		CTNumData numData = val.getNumRef().getNumCache();
		// strData.set
		strData.setPtArray((CTStrVal[]) null); // unset old axis text
		numData.setPtArray((CTNumVal[]) null); // unset old values

		// set model
		long idx = 0;
		int rownum = 1;
		for (SeriesData seriesData : graphData.getSerList())
		{
			CTNumVal numVal = numData.addNewPt();
			numVal.setIdx(idx);
			numVal.setV(seriesData.getSerVal() + "");

			CTStrVal sVal = strData.addNewPt();
			sVal.setIdx(idx);
			sVal.setV(seriesData.getSerName());

			idx++;
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(seriesData.getSerName());
			row.createCell(1).setCellValue(seriesData.getSerVal());
		}
		numData.getPtCount().setVal(idx);
		strData.getPtCount().setVal(idx);

		String numDataRange = new CellRangeAddress(1, rownum - 1, 1, 1).formatAsString(sheet.getSheetName(), true);
		val.getNumRef().setF(numDataRange);
		String axisDataRange = new CellRangeAddress(1, rownum - 1, 0, 0).formatAsString(sheet.getSheetName(), true);
		cat.getStrRef().setF(axisDataRange);
	}

}
