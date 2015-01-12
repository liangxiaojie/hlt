package sra.param.service;

import java.util.Map;

import sra.param.vo.CodeCat;


import com.cmbc.edw.model.Page;

/**
 * 字典管理service
 * 
 * @author chenshiyang
 *
 */
public interface CodeCatService {

	public final static String SPRINT_ID = "CodeCatService";
	
	/**
	 * 字典查询列表
	 * @param map
	 * 			查询条件map
	 * @param pageNo
	 * 			当前页
	 * @param pageSize
	 * 			每页条数
	 * @return page
	 * 			查询结果分页对象
	 */
	public Page queryCodeCats(Map<String, String> map ,int pageNo, int pageSize);
	
	
	/**
	 * 新增字典
	 * @param codeCat
	 * 			字典对象
	 */
	public void addCodeCat (CodeCat codeCat);
	
	/**
	 * 修改字典
	 * @param codeCat
	 * 			字典对象
	 */
	public void updateCodeCat(CodeCat codeCat);

	/**
	 * 删除字典
	 * @param codeCatCodes
	 * 			字典code数组
	 */
	public void deleteCodeCat(String[] codeCatCodes);
	
	/**
	 * 查询单个字典
	 * @param codeCatCode
	 * 			字典code
	 * @return
	 * 			字典对象
	 */
	public CodeCat loadCodeCat (String codeCatCode);
	
	
	
}
