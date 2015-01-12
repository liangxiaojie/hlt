package sra.param.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cmbc.edw.app.ParameterManager;

/**
 * 此类专为指标的上传现在所用，其一为其生产模版，其二为其解析数据
 * @author User
 *
 */
public class OpearExcel {

	public XSSFWorkbook createPublicModel(List list){
		XSSFWorkbook modelbook = null;
		try {
			String filepath=ParameterManager.getParameter("APP_DATA_PATH")+"def"+File.separator+"index"+File.separator;
			modelbook = new XSSFWorkbook(filepath+"标准指标.xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=modelbook.getSheetAt(0);
		 for(int i=0;i<list.size();i++){
			 XSSFRow rowtmp=sheet.createRow(2+i);
			 Map map=(Map) list.get(i);
			 XSSFCell celltemp=rowtmp.createCell(0);
			  celltemp.setCellValue(map.get("indexcd").toString());
			  celltemp.setCellType(XSSFCell.CELL_TYPE_STRING);
			  XSSFCell celltemp1=rowtmp.createCell(1);
			  celltemp1.setCellValue(map.get("indexname").toString());
			  celltemp1.setCellType(XSSFCell.CELL_TYPE_STRING);
			  XSSFCell celltemp2=rowtmp.createCell(2);
			  celltemp2.setCellValue(map.get("formula").toString());
			  celltemp2.setCellType(XSSFCell.CELL_TYPE_STRING);
			  XSSFCell celltemp3=rowtmp.createCell(3);
			  celltemp3.setCellValue(map.get("indexdesc").toString());
			  celltemp3.setCellType(XSSFCell.CELL_TYPE_STRING);
		 }
		 return modelbook;
				
		
	}

	public  static void main(String[] args) throws IOException{
		OpearExcel op=new OpearExcel();
		//op.createByJxl();
		FileOutputStream out=new FileOutputStream("D:\\ss.xlsx");
		//op.createPublicModel(null).write(out);
		//op.createindexModel(null).write(out);
       // HSSFDateUtil.getJavaDate(date)
		/*args = "jg01-1.xls".split("\\.");
	    System.out.println(args[0]);*/

	}
	public XSSFWorkbook createindexModel(List list){
		XSSFWorkbook modelbook=null;
		try {
			String filepath=ParameterManager.getParameter("APP_DATA_PATH")+"def"+File.separator+"index"+File.separator;
			modelbook = new XSSFWorkbook(filepath+"体系指标.xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=modelbook.getSheetAt(0);
		 for(int i=0;i<list.size();i++){
			 Map map=(Map) list.get(i);
			 XSSFRow rowtmp=sheet.createRow(2+i);
			 
			 XSSFCell celltemp0=rowtmp.createCell(0);
			 celltemp0.setCellValue(map.get("setCode")==null?"":map.get("setCode").toString());
			 //celltemp.setCellStyle(style);
			 celltemp0.setCellType(XSSFCell.CELL_TYPE_STRING);
			
			 XSSFCell celltemp=rowtmp.createCell(1);
			 celltemp.setCellValue(map.get("indexCd")==null?"":map.get("indexCd").toString());
			 //celltemp.setCellStyle(style);
			 celltemp.setCellType(XSSFCell.CELL_TYPE_STRING);
			
			 XSSFCell cell1temp=rowtmp.createCell(2);
			 cell1temp.setCellValue(map.get("indexName")==null?"":map.get("indexName").toString());
			// cell1temp.setCellStyle(style);
			 cell1temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell4temp=rowtmp.createCell(3);
			 cell4temp.setCellValue(map.get("dtTable")==null?"":map.get("dtTable").toString());
			// cell4temp.setCellStyle(style);
			 cell4temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell5temp=rowtmp.createCell(4);
			 cell5temp.setCellValue(map.get("calcCircle")==null?"":map.get("calcCircle").toString());
			 //cell5temp.setCellStyle(style);
			 cell5temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell6temp=rowtmp.createCell(5);
			 cell6temp.setCellValue(map.get("calcOrg")==null?"":map.get("calcOrg").toString());
			 //cell6temp.setCellStyle(style);
			 cell6temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell7temp=rowtmp.createCell(6);
			 cell7temp.setCellValue(map.get("calcCurry")==null?"":map.get("calcCurry").toString());
			 //cell7temp.setCellStyle(style);
			 cell7temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			/* XSSFCell cell8temp=rowtmp.createCell(7);
			 cell8temp.setCellValue(map.get("calcOrder")==null?"":map.get("calcOrder").toString());
			// cell8temp.setCellStyle(style);
			 cell8temp.setCellType(XSSFCell.CELL_TYPE_STRING);*/
			 XSSFCell cell9temp=rowtmp.createCell(7);
			 cell9temp.setCellValue(map.get("superCd")==null?"":map.get("superCd").toString());
			// cell9temp.setCellStyle(style);
			 cell9temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell10temp=rowtmp.createCell(8);
			 cell10temp.setCellValue(map.get("dtClear")==null?"":map.get("dtClear").toString());
			// cell10temp.setCellStyle(style);
			 cell10temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell11temp=rowtmp.createCell(9);
			 cell11temp.setCellValue(map.get("indexDesc")==null?"":map.get("indexDesc").toString());
			 //cell11temp.setCellStyle(style);
			 cell11temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell12temp=rowtmp.createCell(10);
			 cell12temp.setCellValue(map.get("startDt")==null?"":map.get("startDt").toString());
			// cell12temp.setCellStyle(style);
			 cell12temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell13temp=rowtmp.createCell(11);
			 cell13temp.setCellValue(map.get("vcd01")==null?"":map.get("vcd01").toString());
			// cell13temp.setCellStyle(style);
			 cell13temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell14temp=rowtmp.createCell(12);
			 cell14temp.setCellValue(map.get("calc01")==null?"":map.get("calc01").toString());
			// cell14temp.setCellStyle(style);
			 cell14temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			
			 XSSFCell cell15temp=rowtmp.createCell(13);
			 cell15temp.setCellValue(map.get("vcd02")==null?"":map.get("vcd02").toString());
			// cell15temp.setCellStyle(style);
			 cell15temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell16temp=rowtmp.createCell(14);
			 cell16temp.setCellValue(map.get("calc02")==null?"":map.get("calc02").toString());
			// cell16temp.setCellStyle(style);
			 cell16temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 
			 XSSFCell cell17temp=rowtmp.createCell(15);
			 cell17temp.setCellValue(map.get("vcd03")==null?"":map.get("vcd04").toString());
			// cell17temp.setCellStyle(style);
			 cell17temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell18temp=rowtmp.createCell(16);
			 cell18temp.setCellValue(map.get("calc03")==null?"":map.get("calc03").toString());
			// cell18temp.setCellStyle(style);
			 cell18temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 
			 
			 XSSFCell cell19temp=rowtmp.createCell(17);
			 cell19temp.setCellValue(map.get("vcd04")==null?"":map.get("vcd04").toString());
			// cell19temp.setCellStyle(style);
			 cell19temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell120temp=rowtmp.createCell(18);
			 cell120temp.setCellValue(map.get("calc04")==null?"":map.get("calc04").toString());
			 //cell120temp.setCellStyle(style);
			 cell120temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			
			 XSSFCell cell121temp=rowtmp.createCell(19);
			 cell121temp.setCellValue(map.get("vcd05")==null?"":map.get("vcd05").toString());
			 //cell121temp.setCellStyle(style);
			 cell121temp.setCellType(XSSFCell.CELL_TYPE_STRING);
			 XSSFCell cell122temp=rowtmp.createCell(20);
			 cell122temp.setCellValue(map.get("calc05")==null?"":map.get("calc05").toString());
			// cell122temp.setCellStyle(style);
			 cell122temp.setCellType(XSSFCell.CELL_TYPE_STRING);
		 }
		 
		
		
		return modelbook;
				
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getfirstCell(String  filepath,int sheetnum,int rownum){
		List result=new ArrayList();
		InputStream in;
		try {
			in = new FileInputStream(filepath);
			XSSFWorkbook wb=new XSSFWorkbook(in);
			XSSFSheet sheet=wb.getSheetAt(sheetnum);//第一个sheet
			System.out.println(sheet.getFirstRowNum()+""+sheet.getLastRowNum());
			XSSFRow row=sheet.getRow(sheet.getFirstRowNum()+rownum);//第一行
			int fristcell=row.getFirstCellNum();
			int lastcell=row.getLastCellNum();
			for(int i=fristcell;i<lastcell;i++){
				Map map=new HashMap();
				XSSFCell cell=row.getCell(i);
				map.put("colunm", i);
				if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING){
					map.put("value",cell.getStringCellValue() );
				}
				if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){
					map.put("value",cell.getNumericCellValue() );
				}
				if(cell.getCellType()==XSSFCell.CELL_TYPE_FORMULA){
					map.put("value",cell.getCellFormula() );
				}
				result.add(map);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public List getotherCell(InputStream  in,int sheetnum,int rownum){
		List result=new ArrayList();
		//InputStream in;
		try {
			//in = new FileInputStream(filepath);
			XSSFWorkbook wb=new XSSFWorkbook(in);
			XSSFSheet sheet=wb.getSheetAt(sheetnum);//第一个sheet
			int start=sheet.getFirstRowNum();
			int end=sheet.getLastRowNum();
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			
			if(rownum>end){
				return result;
			}
					
			System.out.println(sheet.getFirstRowNum()+""+sheet.getLastRowNum());
			int rowstart=sheet.getFirstRowNum();
			int rowend=sheet.getLastRowNum();
			for(int j=rownum;j<=rowend;j++){
			XSSFRow row=sheet.getRow(sheet.getFirstRowNum()+j);//第一行
			Map map=new HashMap();
			int fristcell=row.getFirstCellNum();
			int lastcell=row.getLastCellNum();
			for(int i=fristcell;i<lastcell;i++){
				
				XSSFCell cell=row.getCell(i);
				String key=i+"";
				String value="";
				//map.put(""+i,i);
				if(cell!=null){
				if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING){
					value=cell.getStringCellValue();
				}
				if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){
					if(HSSFDateUtil.isCellInternalDateFormatted(cell)){
						value=sf.format(cell.getDateCellValue());
					}else{
							value=(cell.getNumericCellValue()+"").split("\\.")[0];
						
							
					}
					
				}
				if(cell.getCellType()==XSSFCell.CELL_TYPE_FORMULA){
				   value=cell.getCellFormula();
				   
				}
//				if(cell.getCellType()==XSSFCell)
				}
				if(value==null){
					value="";
				}
				map.put(key, value);
				
				//.put(j, map);
				
			}
			if(!map.get("0").equals("")){
			result.add(map);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
