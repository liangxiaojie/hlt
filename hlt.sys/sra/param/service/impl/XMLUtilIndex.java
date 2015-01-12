package sra.param.service.impl;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import sra.param.vo.Index;
import sra.pub.helper.SetFilePathManager;
import sra.pub.helper.SraKeys;

import com.cmbc.edw.dao.IIntegratedDAO;
/**
 * 指标XML创建工具
 */
public class XMLUtilIndex {
	@SuppressWarnings({ "rawtypes" })
	 public static void createXmlforPublic(Map rowset,IIntegratedDAO daoSupportTemplate) throws FileNotFoundException, IOException{//生成指标计算公式xml
		  String url  = SetFilePathManager.index(SraKeys.REF_SET_CODE,SraKeys.REF_VER_ID)+rowset.get("indexcd")+".xml";
		  Document document = DocumentHelper.createDocument();// 创建根节点  
		  Element root = document.addElement("INDEX_DEF");// 根节点添加子节点
		  Element vals =  root.addElement("VALUES");
		  Element ele =  null;
			  ele =  vals.addElement("CALC");
			  String v1 = (String) rowset.get("formula");
			  ele.addAttribute("SEQ","0");
			  ele.addAttribute("VALUE_CD","" + v1);
			  ele.add(DocumentHelper.createCDATA(v1));
			  List vs01 =  checkDataCat(v1,daoSupportTemplate);
			  addIndexItemforulpdate(rowset,vs01,v1,daoSupportTemplate);
			  try{
			      org.dom4j.io.XMLWriter output = new org.dom4j.io.XMLWriter(new FileOutputStream(url));
			      output.write( document );
			      output.close();
			  }catch(Exception e){
				  e.printStackTrace();
			  }
	  }
	 @SuppressWarnings({ "rawtypes"})
	 private static List dataList;
  public static void createXml(Index rowset,IIntegratedDAO daoSupportTemplate) throws FileNotFoundException, IOException{//生成指标计算公式xml
	  String url  = SetFilePathManager.index(rowset.getSetCode(),SraKeys.REF_VER_ID)+rowset.getIndexCd()+".xml";
	  Document document = DocumentHelper.createDocument();// 创建根节点  
	  Element root = document.addElement("INDEX_DEF");// 根节点添加子节点
	  Element vals =  root.addElement("VALUES");
	  Element ele =  null;
	  String vcd = "";
	  String cal = "";
	  for(int j=1;j<16;j++){
		  if(j<10){
			  vcd = "vcd0"+j;
			  cal = "calc0"+j;
			}else{
				vcd = "vcd"+j;
				cal = "calc"+j;
			}
		  ele =  vals.addElement("CALC");
		  String v1 = (String) rowset.get(vcd);
		  String a1 =  (String) rowset.get(cal);
		  ele.addAttribute("SEQ",String.valueOf(j));
		  ele.addAttribute("VALUE_CD","" + v1);
		  ele.add(DocumentHelper.createCDATA(a1));
	  }try{
	      org.dom4j.io.XMLWriter output = new org.dom4j.io.XMLWriter(new FileOutputStream(url));
	      output.write( document );
	      output.close();
	      //---保存指标依赖数据项及指标依赖数据项值列
	      dataList = new ArrayList();
	      for(int a=1;a<16;a++){
	    	  if(a<10){
				  vcd = "vcd0"+a;
				  cal = "calc0"+a;
				}else{
					vcd = "vcd"+a;
					cal = "calc"+a;
				}
			  String a1 =  (String) rowset.get(cal);
			  if(a1!=null && !a1.equals("")){
		    	  List formatList =  checkDataCat(a1,daoSupportTemplate);
		    	  for(int i=0;i<formatList.size();i++){//去除重复项
		    		  String[]ss01 = (String[]) formatList.get(i);
		    		  boolean bp = false;
		    		  for(int j=0;j<dataList.size();j++){
		    			  String[]ss02 = (String[]) dataList.get(j);
		    			  if(ss01[0].equals(ss02[0]) && ss01[1].equals(ss02[1])){
		    				  bp = true;break;
		    			  }
		    		  } if(bp==false)
		    			  dataList.add(ss01);
		    	  }
		      }
		  }if(dataList.size()>0){
			  daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteIndexItemforpublic", rowset);
			  addIndexItem(rowset,daoSupportTemplate);
		  }
	  } catch(IOException e){
		  System.out.println(e.getMessage());
	  }
  }
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void addIndexItem(Index index,IIntegratedDAO daoSupportTemplate){
	  String sqls[] = new String[dataList.size()];
	  for(int i=0;i<dataList.size();i++){
		  String[]ss = (String[]) dataList.get(i);
		  sqls[i] = "insert into T_DEF_INDEX_ITEM (INDEX_CD,SET_CODE,DATA_CAT,DATA_ITEM) values ('"+index.getIndexCd()+"','"+index.getSetCode()+"','"+ss[0]+"','"+ss[1]+"')";
	  }
	  daoSupportTemplate.batchUpdate(sqls);
}
  @SuppressWarnings({ "rawtypes", "unchecked" })
public static void addIndexItemforulpdate(Map index,List list,String v,IIntegratedDAO daoSupportTemplate){
	  List news = new ArrayList();
	  for(int i=0;i<list.size();i++){//去除重复项
		  String[]ss01 = (String[]) list.get(i);
		  boolean bp = false;
		  for(int j=0;j<news.size();j++){
			  String[]ss02 = (String[]) news.get(j);
			  if(ss01[0].equals(ss02[0]) && ss01[1].equals(ss02[1])){
				  bp = true;break;
			  }
		  } if(i==0 || (i>0 && bp==false))
			  news.add(ss01);
	  }
	  Map index1=new HashMap();
	  index1.put("indexCd",index.get("indexcd").toString() );//(ss[0]+"");//数据分类
	  index1.put("setCode", "T0000");
	  //index1.put("verId", value)
	  daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteIndexItemforpublic", index1);
	  
	  for(int i=0;i<news.size();i++){
		  String[]ss = (String[]) news.get(i);
		 
		  index1.put("etlDate", ss[0]+"");
		  index1.put("temp", ss[1]+"");
		 
		  daoSupportTemplate.getMybatisTemplate().insert("sra.param.insertIndexItemforpublic", index1);
	  }
}
  @SuppressWarnings({ "rawtypes", "unchecked" })
public static List checkDataCat(String formula,IIntegratedDAO daoSupportTemplate) {//解析计算项
		Matcher matcher = Pattern.compile("(G|P|I|Z|R)\\$\\w+(\\.\\w+)?(\\[.*?\\])?")
				.matcher(formula.replaceAll(" ", ""));
		List<String[]> list = new ArrayList<String[]>();
		while (matcher.find()) {
			String[] DataCat = new String[2];
			DataCat[0] = matcher.group().substring(0, 1);
			if(matcher.group().contains(".")){
			DataCat[1]=matcher.group().substring(matcher.group().indexOf("$")+1,matcher.group().indexOf("."));
			}else{
				DataCat[1]=matcher.group().substring(2);
			}
			if(DataCat[0].equalsIgnoreCase("R")){//公共指标
				Map map=new HashMap();
				map.put("setcode","T0000");
				map.put("indexcd", DataCat[1]);
				List listp=daoSupportTemplate.getMybatisTemplate().query4list("loadPublicIndexforindex",map);
				for(int i=0;i<listp.size();i++){
					String[] pdata=new String[2];
					Map mapp=(Map) listp.get(i);
					pdata[0]=mapp.get("datacat").toString();
					pdata[1]=mapp.get("dataitem").toString();
					list.add(pdata);
				}
			}else{
				list.add(DataCat);	
			}
		}
		return list;
	}
  
  public static void main(String[] args) throws Exception {
  }
}
