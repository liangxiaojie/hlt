package sra.urm.vo;

public class TreeNode {
   private String id ;
   private String text;
   private String parentId;
   private boolean leaf;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getParentId() {
	return parentId;
}
public void setParentId(String parentId) {
	this.parentId = parentId;
}
public boolean isLeaf() {
	return leaf;
}
public void setLeaf(int leaf) {
	this.leaf = leaf == 0 ? true : false;
}
   
   
}
