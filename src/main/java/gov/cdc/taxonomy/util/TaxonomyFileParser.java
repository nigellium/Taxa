
package gov.cdc.taxonomy.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gov.cdc.taxonomy.model.Authority;
import gov.cdc.taxonomy.model.ChildTaxonomyNode;
import gov.cdc.taxonomy.model.TaxonomyNode;

public class TaxonomyFileParser {
	
	/**
	 * Parse the taxonomy file into 
	 */
	public static TaxonomyNode parse(File[] files, String nodeId) throws IOException {
		Optional <String> node = Files.newBufferedReader(Paths.get(files[0].getAbsolutePath())).
				lines().filter(s->s.trim().startsWith(nodeId)).findFirst();
		if (node.isPresent()) {
			TaxonomyNode nd = new TaxonomyNode(node.get());
			//now parse the second file for descendents
			final List<Authority> authorities = new ArrayList<>();
			Files.newBufferedReader(Paths.get(files[1].getAbsolutePath())).
			lines().filter(s -> s.trim().startsWith(nodeId)).forEach( s -> {
				authorities.add( new Authority(s));
			});
			if (!authorities.isEmpty()) {
				nd.setAuthorities(authorities);
			}
			return nd;
		}
		return null;	
	}

}
