/*******************************************************************************
 * Copyright (c) 2015 David Lamparter, Daniel Marbach
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *******************************************************************************/
package ch.unil.genescore.vegas;

import java.io.File;
import java.util.ArrayList;

import ch.unil.genescore.main.Pascal;
import ch.unil.gpsutils.FileExport;

public class GeneResultsNoScore {
	
	private ArrayList<String> noScore_ = null;
	private FileExport exporter_ = null;
	public GeneResultsNoScore(){
		noScore_ = new ArrayList<String>(); 
		//exporter_ = new FileExport();
	}

	public void add(String str){
		noScore_.add(str);
	}
	
	public void setExporter(FileExport exp) {
		exporter_=exp;
	}
	
	public void setExporter(String additionalOutputFileSuffix) {
		File file = new File(Pascal.set.outputDirectory_, 
				Pascal.set.gwasName_+ additionalOutputFileSuffix + ".scoreComputeError" + Pascal.set.chromFileExtension_ + ".txt");		
		//exporter_.setWriter(filename);
		exporter_ = new FileExport(Pascal.log, file);
	}
	
	
public void writeResultsToFile(String additionalOutputFileSuffix){
		
		if (noScore_.size() == 0)
			return;
		
		Pascal.warning("Gene score computation did not converge at specified precision for some genes");
		setExporter(additionalOutputFileSuffix);
		String header = "chromosome\tstart\tend\tstrand\tgene_id\tsymbol\tScore\tStatus";		
		exporter_.println(header);		
		for (String line : noScore_)
			exporter_.println(line);
		exporter_.close();
		Pascal.println("");
	}
	
}
