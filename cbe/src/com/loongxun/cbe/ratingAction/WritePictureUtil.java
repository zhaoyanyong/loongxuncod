package com.loongxun.cbe.ratingAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WritePictureUtil {
	public static CustomXWPFDocument generatePicture(List<String> wordPath,String wpath,List<String> imgPath,String opath,List<Integer> wIntegers,List<Integer> yIntegers){
		CustomXWPFDocument doc=null;
		try{
			OPCPackage pack = POIXMLDocument.openPackage(wpath);
			doc = new CustomXWPFDocument(pack);
			
			Iterator<XWPFTable> it = doc.getTablesIterator();
			while(it.hasNext()){
				XWPFTable table = it.next();
				List<XWPFTableRow> rows = table.getRows();
				for(XWPFTableRow row:rows){
					List<XWPFTableCell> cells = row.getTableCells();
					for(XWPFTableCell cell:cells){
						for(int i=0;i<wordPath.size();i++){
							
						if(cell.getText().endsWith(wordPath.get(i))){
							cell.removeParagraph(0);
						//	cell.setText("aa");
							XWPFParagraph pargraph =	cell.addParagraph();
							//100为宽，150为高
							File pic = new File(imgPath.get(i));
							FileInputStream is = new FileInputStream(pic);
							String picId=doc.addPictureData(is, XWPFDocument.PICTURE_TYPE_JPEG);							
							doc.createPicture(picId,doc.getNextPicNameNumber(XWPFDocument.PICTURE_TYPE_JPEG), wIntegers.get(i), yIntegers.get(i),pargraph);
							is.close();
							File out=new File(wpath);
							if(out.isFile()||out.exists()){
								out.delete();
							}
						}
						}
						List<XWPFParagraph> pars = cell.getParagraphs();
						for(XWPFParagraph par:pars){
							List<XWPFRun> runs = par.getRuns();
							for(XWPFRun run:runs){
								run.removeBreak();
								
							}
						}
					}
				}
			}
			FileOutputStream fos = new FileOutputStream(opath);
			doc.write(fos);
			fos.flush();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return doc;
	}
}
