package gov.cdc.taxonomy.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import gov.cdc.taxonomy.model.TaxonomyNode;
import gov.cdc.taxonomy.util.TaxonomyFileParser;

@Controller
@RequestMapping("/")
public class BasicRestController {

	@RequestMapping("/")
	  public String home() {
	    return "index.html";
	  }
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	
	  @ResponseBody
	  public String selectTaxonomy(@RequestParam("nodeFile") MultipartFile nodeFile,@RequestParam("nameFile") MultipartFile nameFile, @RequestParam("term")String term) {
		if (!nodeFile.isEmpty() && !nameFile.isEmpty()) {
            try {
               /* byte[] bytes = nodeFile.getBytes();
                BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File(nodeFile.getName() + "-uploaded")));
                stream.write(bytes);
                stream.close();*/
            	File [] files = new File[] {new File(nodeFile.getOriginalFilename()), new File(nameFile.getOriginalFilename())};
            	TaxonomyNode node = TaxonomyFileParser.parse(files, term);
                return "You successfully uploaded " ;
            } catch (Exception e) {
                return "You failed to upload => " + e.getMessage();
            }
        } else {
            return "You failed to upload  because the file was empty.";
        }
	    //return "Hello World";
	  }

}
