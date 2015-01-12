package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sra.urm.service.RptOrgService;
import sra.urm.vo.RptOrg;
import sra.urm.vo.RptOrgInterface;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.util.StringUtils;

/**
 * @author zhaoshuli
 *
 */
public class RptOrgServiceImpl extends AbstractBizService implements RptOrgService{
	
	private IIntegratedDAO daoSupportTemplate;
	
	
	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}
	
	
	public List<RptOrg> queryRptOrgs(Map<String, String> map) {
		if(map.get("orgName")!=null&&!"".equals(map.get("orgName"))){
			map.put("orgName", "%"+map.get("orgName")+"%");
		}
		
		List<RptOrgInterface> allRpts = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.RptOrg.queryRptOrgs",
				map);
		
		return generateRptOrgTree(allRpts);
	}
	
	
	/**
	 * @param rpts
	 * @return
	 */
	private List generateRptOrgTree(List<RptOrgInterface> rpts){
		
		Map<String,List<RptOrgInterface>> map = new HashMap<String,List<RptOrgInterface>>();
		List<RptOrgInterface> tmpRs; 
		for(RptOrgInterface rg : rpts){
			
			if(StringUtils.hasText(map.get(rg.getParentOrg()))){
				map.get(rg.getParentOrg()).add(rg);
			}else{
				tmpRs = new ArrayList<RptOrgInterface>();
				tmpRs.add(rg);
				map.put(rg.getParentOrg(), tmpRs);
			}
		}
		
		List<RptOrgInterface> orgTree = new ArrayList<RptOrgInterface>();
		List<String> deleteTree = new ArrayList<String>();
		for(RptOrgInterface rg : rpts){
			orgTree.add(doRptOrg(rg,map,deleteTree));
		}
		for(RptOrgInterface rg : rpts){
			if(deleteTree.contains(rg.getOrgNum())){
				orgTree.remove(rg);
			}
		}
		return orgTree;
	}
	
	/**
	 * @param parent
	 * @param map
	 * @return
	 */
	private RptOrgInterface doRptOrg(RptOrgInterface parentRo,Map<String,List<RptOrgInterface>> map,List<String> deleteTree){
		if(null!=map.get(parentRo.getOrgNum())&&map.get(parentRo.getOrgNum()).size()>0){
			for(RptOrgInterface r : map.get(parentRo.getOrgNum())){
				doRptOrg(r,map,deleteTree);
				//已经作为其他节点的子节点
				deleteTree.add(r.getOrgNum());
			}
			if(!parentRo.getChildren().containsAll(map.get(parentRo.getOrgNum()))){
				parentRo.getChildren().addAll(map.get(parentRo.getOrgNum()));
			}
		}
		return parentRo;
	}
	
	
	public void addRptOrg(RptOrg rptOrg) {
		daoSupportTemplate.getMybatisTemplate().insert("sra.urm.RptOrg.insertRptOrg", rptOrg);
	}

	
	public void updateRptOrg(RptOrg rptOrg) {
		daoSupportTemplate.getMybatisTemplate().update("sra.urm.RptOrg.updateRptOrg", rptOrg);
	}

	
	public void deleteRptOrg(String[] rptOrgCodes) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("rptOrgCodes", rptOrgCodes);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.RptOrg.deleteRptOrgs", map);
	}

	
	public RptOrg loadRptOrg(String rptOrgCode) {
		return (RptOrg)daoSupportTemplate.getMybatisTemplate().get("sra.urm.RptOrg.loadRptOrg", rptOrgCode);
	}

	
	public List<RptOrg> queryRptOrgs4Combo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List getRptOrgTree() {
		List allRptOrgs = daoSupportTemplate.getMybatisTemplate().selectList("sra.urm.RptOrg.loadAllRptOrg");
		return generateRptOrgTree(allRptOrgs);
	}

}
