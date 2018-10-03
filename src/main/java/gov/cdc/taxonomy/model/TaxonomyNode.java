package gov.cdc.taxonomy.model;

import java.util.List;

public class TaxonomyNode {
	
	private List<ChildTaxonomyNode> children;
	
	public TaxonomyNode(String strNode) {
		
	}
	
	public void setChildren(List<ChildTaxonomyNode> children) {
		this.children = children;
	}

}
