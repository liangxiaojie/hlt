package sra.urm.vo;

import java.util.List;

/**
 * 机构接口
 * @author zhaoshuli
 *
 */
public interface RptOrgInterface {

	public String getOrgNum();
	
	public String getParentOrg();

	public List<RptOrgInterface> getChildren();
}
