package sra.urm.vo;


public class Dept extends DeptBase {
	 private boolean checked = false;
	 public boolean getChecked() {return checked;}
	 public void setChecked(boolean checked) {this.checked = checked;}
	 private String rptStatus;
	 private String showOrder; 
	 public String getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(String showOrder) {
		this.showOrder = showOrder;
	}
	public String getRptStatus() {
	 	return rptStatus;
	 }
	 public void setRptStatus(String rptStatus) {
	 	this.rptStatus = rptStatus;
	 }
		private String sheetName;
		public String getSheetName() {
			return sheetName;
		}
		public void setSheetName(String sheetName) {
			this.sheetName = sheetName;
		}
		private String excelName;
		public String getExcelName() {
			return excelName;
		}
		public void setExcelName(String excelName) {
			this.excelName = excelName;
		}
		
}
