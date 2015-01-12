package sra.param.service;

import java.util.List;
import java.util.Map;

import sra.param.vo.CodeItem;
import sra.param.vo.CodeItemBase;

import com.cmbc.edw.model.Page;

/**
 * 字典项管理service
 * 
 * @author chenshiyang
 *
 */
public interface CodeItemService {

	public final static String SPRINT_ID = "CodeItemService";
	
	/**
	 * 字典项查询列表
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page queryCodeItems(Map<String, String> map, int pageNo, int pageSize);
	
	/**
	 * 新增字典项
	 * @param codeItem
	 */
	public void addCodeItem(CodeItem codeItem);
	
	/**
	 * 更新字典项
	 * @param codeItem
	 */
	public void updateCodeItem(CodeItem codeItem);
	
	/**
	 * 删除一条字典项
	 * @param codeItem
	 */
	public void deleteCodeItem(CodeItem codeItem);
	
	/**
	 * 删除多条字典项
	 * @param codeItems
	 */
	public void deleteCodeItems(List<CodeItem> codeItems);
	
	/**
	 * 查询单个字典项
	 * @param catCode
	 * @param itemCode
	 * @return
	 */
	public CodeItem loadCodeItem(String catCode, String itemCode);
	/**
	 * 通过字典定义查询多个字典项
	 * @param catCode
	 * @return
	 */
	public List<CodeItem> loadItemTreeByCat(String catCode);
	/**
	 * 查询多个字典项
	 * @return
	 */
	public List<CodeItemBase> loadItemListByCat4Combo(String catCode);
	
	/**
	 * 查询多个字典项
	 * @return
	 */
	public List<CodeItemBase> loadItemBaseTreeByCat4Combo(String catCode);

	
}
