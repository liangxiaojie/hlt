package sra.param.service.impl;

import java.util.HashMap;
import java.util.Map;

import sra.param.service.CodeCatService;
import sra.param.vo.CodeCat;
import sra.param.vo.CodeItem;


import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;

/**
* 字典管理service实现类
* 
* @author chenshiyang
*
*/
public class CodeCatServiceImpl extends AbstractBizService implements
		CodeCatService {
	
	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}

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
	public Page queryCodeCats(Map<String, String> map, int pageNo, int pageSize) {
		if(map.get("catName")!=null&&!"".equals(map.get("catName"))){
			map.put("catName", "%"+map.get("catName")+"%");
		}
		return daoSupportTemplate.getMybatisTemplate().query4Page("sra.urm.queryCodeCats",
				"sra.urm.queryCodeCatTotal", map, pageNo, pageSize);
	}


	/**
	 * 新增字典
	 * @param codeCat
	 * 			字典对象
	 */
	public void addCodeCat(CodeCat codeCat) {
		daoSupportTemplate.getMybatisTemplate().insert("sra.urm.insertCodeCat", codeCat);

	}

	/**
	 * 修改字典
	 * @param codeCat
	 * 			字典对象
	 */
	public void updateCodeCat(CodeCat codeCat) {
		daoSupportTemplate.getMybatisTemplate().update("sra.urm.updateCodeCat", codeCat);

	}

	/**
	 * 删除字典
	 * @param codeCatCodes
	 * 			字典code数组
	 */
	public void deleteCodeCat(String[] codeCatCodes) {
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("codeCatCodes", codeCatCodes);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteCodeCats", map);
		//删除对应的字典项
		for(String codeCatCode:codeCatCodes){
			CodeItem codeItem = new CodeItem();
			codeItem.setCatCode(codeCatCode);
			daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteItemsByCat", codeItem);
		}
	}

	/**
	 * 查询单个字典
	 * @param codeCatCode
	 * 			字典code
	 * @return
	 * 			字典对象
	 */
	public CodeCat loadCodeCat(String codeCatCode) {
		CodeCat codeCat = new CodeCat();
		codeCat.setCatCode(codeCatCode);
		return (CodeCat)daoSupportTemplate.getMybatisTemplate().get("sra.urm.loadCodeCat",codeCat );
	}

	

}
