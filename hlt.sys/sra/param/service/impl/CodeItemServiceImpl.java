package sra.param.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sra.param.service.CodeItemService;
import sra.param.vo.CodeItem;
import sra.param.vo.CodeItemBase;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.codestring.CodeString;
import com.cmbc.edw.codestring.CodeStringItem;
import com.cmbc.edw.codestring.CodeStringManager;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
import com.cmbc.edw.util.StringUtils;

/**
 * 字典项管理serviceImpl
 * 
 * @author chenshiyang
 *
 */
public class CodeItemServiceImpl extends AbstractBizService implements CodeItemService {

	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}

	/**
	 * 字典项查询列表
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page queryCodeItems(Map<String, String> map, int pageNo, int pageSize) {
		if(map.get("itemName")!=null&&!"".equals(map.get("itemName"))){
			map.put("itemName", "%"+map.get("itemName")+"%");
		}
		return daoSupportTemplate.getMybatisTemplate().query4Page("sra.urm.queryCodeItems",
				"sra.urm.queryCodeItemTotal", map, pageNo, pageSize);
	}
	/**
	 * 新增字典项
	 * @param codeItem
	 */
	public void addCodeItem(CodeItem codeItem) {
		if("root".equals(codeItem.getUpperCode())){
			codeItem.setUpperCode("");
		}
		daoSupportTemplate.getMybatisTemplate().insert("sra.urm.insertCodeItem", codeItem);

	}

	/**
	 * 更新字典项
	 * @param codeItem
	 */
	public void updateCodeItem(CodeItem codeItem) {
		daoSupportTemplate.getMybatisTemplate().update("sra.urm.updateCodeItem", codeItem);

	}

	/**
	 * 删除一条字典项
	 * @param codeItem
	 */
	public void deleteCodeItem(CodeItem codeItem){
		
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteCodeItem", codeItem);

	}

	/**
	 * 删除多条字典项
	 * @param codeItems
	 */
	public void deleteCodeItems(List<CodeItem> codeItems) {
		for(CodeItem codeItem : codeItems ){
			daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteCodeItem", codeItem);
		}
	}

	/**
	 * 查询单个字典项
	 * @param catCode
	 * @param itemCode
	 * @return
	 */
	public CodeItem loadCodeItem(String catCode, String itemCode) {
		CodeItem codeItem = new CodeItem();
		codeItem.setCatCode(catCode);
		codeItem.setItemCode(itemCode);
		return (CodeItem)daoSupportTemplate.getMybatisTemplate().get("sra.urm.loadCodeItem",codeItem );
	}

	/**
	 * 通过字典代码获取对用的字典项列表
	 * @param catCode
	 * @return list
	 */
	public List<CodeItemBase> loadItemListByCat4Combo(String catCode){
		Map<String, String> map = new HashMap();
		map.put("catCode", catCode);
		return daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryCodeItems",map);
	}
	
	/**
	 * 通过字典代码获取对应的字典项树（combo使用）
	 * @param catCode
	 * @return list
	 */
	public List<CodeItemBase> loadItemBaseTreeByCat4Combo(String catCode) {
		Map<String, String> map = new HashMap();
		map.put("catCode", catCode);
		List allCodeItems=new ArrayList();
		List buileTree = new ArrayList();
		allCodeItems = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryCodeItemBases",map);
		Iterator itr=allCodeItems.iterator();
		while (itr.hasNext()){
			CodeItemBase codeItemBase = (CodeItemBase)itr.next();
			if(codeItemBase.getItemCode().equals(codeItemBase.getUpperCode())){
				buileTree.add(buildTree(codeItemBase,allCodeItems));
			}
		}
		return buileTree;
	}

	/**
	 * 通过字典代码获取对应的字典项树
	 * @param catCode
	 * @return list
	 */
	public List<CodeItem> loadItemTreeByCat(String catCode) {
		Map<String, String> map = new HashMap();
		map.put("catCode", catCode);
		List allCodeItems=new ArrayList();
		List buileTree = new ArrayList();
		allCodeItems = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryCodeItems",map);
		Iterator itr=allCodeItems.iterator();
		while (itr.hasNext()){
			CodeItem codeItem = (CodeItem)itr.next();
			if(codeItem.getItemCode().equals(codeItem.getUpperCode())||"".equals(codeItem.getUpperCode())){
				buileTree.add(buildTree(codeItem,allCodeItems));
			}
		}
		return buileTree;
	}
	/**
	 * 构造CodeItem树
	 * @param codeItem
	 * @param list
	 * @return
	 */
	private CodeItem buildTree(CodeItem codeItem, List list){
		Iterator itr = list.iterator();
		while (itr.hasNext()){
			CodeItem codeItemChild = (CodeItem) itr.next();
			if(codeItemChild.getUpperCode().equals(codeItem.getItemCode())&&!codeItemChild.getItemCode().equals(codeItemChild.getUpperCode())){
				codeItem.getChildren().add(codeItemChild);
				buildTree(codeItemChild,list);
			}
		}
		return codeItem;
	}
	/**
	 * 构造CodeItemBase树
	 * @param codeItem
	 * @param list
	 * @return
	 */
	private CodeItemBase buildTree(CodeItemBase codeItem, List list){
		Iterator itr = list.iterator();
		while (itr.hasNext()){
			CodeItemBase codeItemChild = (CodeItemBase) itr.next();
			if(codeItemChild.getUpperCode().equals(codeItem.getItemCode())&&!codeItemChild.getItemCode().equals(codeItemChild.getUpperCode())){
				codeItem.getChildren().add(codeItemChild);
				buildTree(codeItemChild,list);
			}
		}
		return codeItem;
	}


}
