package com.loongxun.cbe.ratingAction;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.batik.transcoder.SVGAbstractTranscoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

import sun.misc.BASE64Decoder;

import com.loongxun.cbe.enterprise.bean.Attribute;
import com.loongxun.cbe.enterprise.bean.Dataanalyh;
import com.loongxun.cbe.enterprise.bean.Operation;
import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.enterprise.dao.AttributeDao;
import com.loongxun.cbe.enterprise.dao.DataAnalyHDAO;
import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.enterprise.dao.RatingResultsHDAO;
import com.loongxun.cbe.until.PublicCompareUtil;
import com.loongxun.cbe.user.bean.Enterpriseinfo;

/**
 * 查出数据，并且替换模板中的数据;
 * 
 * @author LY
 */
public class WriteWordAction {
	// 输入
	private int companyId;
	// 输出
	
	private Enterpriseinfo enter;// 企业基本信息
	private Dataanalyh data;// 企业数据分析结果
	private Attribute att;// 企业指标信息查询结果
	private String ownerEquity;// 所有者权益 需要计算
	private String aaa;// 所属行业
	private String abc;//
	private int attributeId;
	// 注入DAO
	private RatingResultsHDAO ratingHDAO;
	private EnterpriseDAO enterpriseDAO;
	private DataAnalyHDAO analyHDAO;//数据分析DAO
	private AttributeDao attributeDao;
	private String companyName;
	private String imgBase64 = null;
	private int status;//报告处理状态
	private String reportText;
	private int isJob;
	private Operation operation;

	public String getImgBase64() {
		return imgBase64;
	}

	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getOwnerEquity() {
		return ownerEquity;
	}

	public void setOwnerEquity(String ownerEquity) {
		this.ownerEquity = ownerEquity;
	}

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}



	public void setRatingHDAO(RatingResultsHDAO ratingHDAO) {
		this.ratingHDAO = ratingHDAO;
	}


	public String execute() {
		saveString(imgBase64, "WEB-INF/file/spiderReport.svg");
		convertToPNG("WEB-INF/file/spiderReport.svg", "WEB-INF/file/spiderReport.jpg");
		try {
			// 获取模板的绝对路径;
			String telName = "oldreport.docx";
			/*if (imgBase64 != null && !"".endsWith(imgBase64)) {
				GenerateImage(imgBase64);
				imgBase64 = null;
			} else {
				telName = "oldreport.docx";
			}*/
			String worldpath = "doc/" + telName;
			String path = ServletActionContext.getServletContext().getRealPath(
					worldpath);
			// 查询评级结果
			 Ratingresultsh rating=ratingHDAO.findRathByAid(attributeId);
			// 查询企业基本信息
			 enter=enterpriseDAO.findById(companyId);
			// 读取配置文件
			Properties pro = new Properties();
			InputStream ins = FindRatingReportAction.class
					.getResourceAsStream("/123.properties");
			pro.load(ins);
			aaa = pro.getProperty(enter.getProfession().toString());
			// 查询企业数据分析后的结果
			data = analyHDAO.findByEIdAndAId(companyId, attributeId);
			// 查询指标信息；
			att = attributeDao.findByAbId(attributeId);
			// 所有者权益
			ownerEquity = PublicCompareUtil.choice(
					att.getTotalAssets() - att.getGrossLiabilities())
					.toString();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("${1}", rating.getCreateTime());
			map.put("${2}", rating.getRating());
			map.put("${3}", rating.getTotal()+"");
			map.put("${4}", enter.getEpname());
			String stage;
			if (enter.getStage() == 1) {
				stage = "初创";
			} else if (enter.getStage() == 2) {
				stage = "成长";
			} else {
				stage = "稳定";
			}
			map.put("${5}", stage);
			map.put("${6}", enter.getRegistMoney().toString());
			map.put("${7}", rating.getCreateTime());
			map.put("${8}", aaa);
			map.put("${9}", enter.getLegalPerson());
			map.put("${10}", enter.getRegistAddress());
			map.put("${11}", enter.getAddress());
			map.put("${12}", enter.getContactPhone());
			map.put("${13}", enter.getContactEmail());
			map.put("${14}", att.getShareholderNameOne());
			map.put("${15}", att.getShareholdingRatioOne().toString());
			map.put("${16}", att.getShareholderNameTwo());
			map.put("${17}", att.getShareholdingRatioTwo().toString());
			map.put("${18}", att.getShareholderNameThree());
			map.put("${19}", att.getShareholdingRatioThree().toString());
			map.put("${20}", att.getShareholderNameFour());
			map.put("${21}", att.getShareholdingRatioFour().toString());
			map.put("${22}", att.getShareholderNameFive());
			map.put("${23}", att.getShareholdingRatioFive().toString());
			map.put("${24}", att.getCreateTime());
			map.put("${25}", att.getTotalAssets().toString());
			map.put("${26}", ownerEquity);
			map.put("${27}", att.getMainOperationIncome().toString());
			map.put("${28}", att.getTotalProfit().toString());
			map.put("${29}", data.getNetAssetReturnRatioTarget().toString());
			map.put("${30}", data.getLiquidRatioTarget().toString());
			map.put("${31}", data.getQuickRatioTarget().toString());
			map.put("${32}", data.getTotalAssetReturnRatioTarget().toString());

			// 企业规模
			
			map.put("${33}", rating.getScale());
			// 偿债能力
			
			map.put("${34}", rating.getPayPower());
			// 营运能力
			
			map.put("${35}", rating.getRun());
			// 盈利能力
			
			map.put("${36}", rating.getGainPower());
			// 成长性
			
			map.put("${37}", rating.getGrowth());
			// 创新性
			
			map.put("${38}", rating.getCreative());
			// 信用履约能力
			
			map.put("${39}", rating.getCreditPerformance());
			// 管理水平
			
			map.put("${40}", rating.getManagePower());
			// 市场竞争力
		
			map.put("${41}", rating.getMarketCompetitive());

			map.put("${42}", att.getIinfoDisclosure());
			String paraphrase = "";
			if(("AAA").equals(rating.getRating())){
				paraphrase = "企业信用优秀。企业信用程度高，债务风险小，经营状况佳，盈利能力强，公司治理结构合理，管理制度十分完善，研发能力优异，科技创新能力很强，发展前景广阔，不确定性因素对其经营与发展影响极小。";
			}else if (("AA").equals(rating.getRating())) {
				paraphrase = "企业信用优良。企业的信用程度较高，债务风险较小，经营状况较佳，盈利水平较高，公司治理结构合理，管理制度比较完善，有较强的研发能力，科技创新能力也较强，发展前景较为广阔，不确定性因素对其经营与发展的影响很小。";
			}else if (("A").equals(rating.getRating())) {
				paraphrase = "企业信用较好。企业的信用程度良好，在正常情况下偿还债务没有问题，经营处于良性循环状态，盈利能力较好，公司治理结构比较合理，管理制度比较完善，研发能力较好，科技创新能力较强，发展前景较好，但是可能会有些影响其未来经营与发展的不确定因素，进而削弱其盈利能力和偿债能力。";
			}else if (("BBB").equals(rating.getRating())) {
				paraphrase = "企业信用一般。企业的信用程度一般，偿还债务的能力一般，易受外界影响而波动，各项指标处于中等水平，公司治理结构上课，管理制度不算特别完善，研发能力中等，科技创新能力一般，其经营状况、盈利水平及未来发展前景易受不确定因素影响。";
			}else if (("BB").equals(rating.getRating())) {
				paraphrase = "企业信用欠佳。企业的信用程度较差，资产质量和信用状况较差，盈利能力和偿债能力较弱，公司管理体系也较差，科技创新能力偏低，经营上存在一定风险发展前景不乐观，投资该企业含有投机性因素。";
			}else if (("B").equals(rating.getRating())) {
				paraphrase = "企业信用较差。资产质量和和信用状况差，经济实力低，经营业绩差，盈利能力和偿债能力偏低，公司管理结构不完善，研发能力不好，科技创新能力很差，经营风险较大，但目前尚有能力还本付息。";
			}else if (("CCC").equals(rating.getRating())) {
				paraphrase = "企业信用很差。企业信用程度很差，基本上没有或者已经没有了偿债能力，有的甚至处于破产边缘。公司管理结构处于瘫痪边缘，几乎没有研发能力和创新能力，经营具有重大风险，属于高度投机性公司。";
			}
			map.put("${43}", paraphrase);
			CustomXWPFDocument doc = WriteWordUtil.generateWord(map, path);
			// 过度文件的路径
			String fileName = enter.getEpname() + "2.docx";
			String paths = "WEB-INF/file/" + fileName;
			String realPath = ServletActionContext.getServletContext()
					.getRealPath(paths);
			// 下载的文件路径
			String filename = enter.getEpname() + ".docx";
			String filepath = "WEB-INF/file/" + filename;
			String realpaths = ServletActionContext.getServletContext()
					.getRealPath(filepath);
			// 图片的路径
			String pic = "spiderReport.jpg";
			String picpath = "WEB-INF/file/" + pic;
			String realpath = ServletActionContext.getServletContext()
					.getRealPath(picpath);
			FileOutputStream fopts = new FileOutputStream(realPath);
			String picA = "";
			if(("AAA").equals(rating.getRating())){
				picA = "AAA.png";
			}else if (("AA").equals(rating.getRating())) {
				picA = "A.png";
			}else if (("A").equals(rating.getRating())) {
				picA = "A.png";
			}else if (("BBB").equals(rating.getRating())) {
				picA = "BBB.png";
			}else if (("BB").equals(rating.getRating())) {
				picA = "BB.png";
			}else if (("B").equals(rating.getRating())) {
				picA = "B.png";
			}else if (("CCC").equals(rating.getRating())) {
				picA = "CCC.png";
			}
			 
			String picpathA = "doc/" + picA;
			String realpathA = ServletActionContext.getServletContext()
					.getRealPath(picpathA);
			 FileOutputStream foptsA = new FileOutputStream(realPath);
			 doc.write(fopts);
			 doc.write(foptsA);
			 List<String> wordPath = new ArrayList<String>();
			 wordPath.add("${img}");
			 wordPath.add("${imgA}");
			 List<Integer> wIntegers = new ArrayList<Integer>();
			 wIntegers.add(500);
			 wIntegers.add(135);
			 List<Integer> yIntegers = new ArrayList<Integer>();
			 yIntegers.add(300);
			 yIntegers.add(172);
			 List<String> imgPath = new ArrayList<String>();
			 imgPath.add(realpath);
			 imgPath.add(realpathA);
			 WritePictureUtil.generatePicture(wordPath,realPath, imgPath, realpaths,wIntegers,yIntegers);
			fopts.close();
			foptsA.close();
			abc = "666";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	/**
	 * 将svg字符串转换为png
	 * 
	 * @param svgCode
	 *            svg代码
	 * @param pngFilePath
	 *            保存的路径
	 * @throws TranscoderException
	 *             svg代码异常
	 * @throws IOException
	 *             io错误
	 */
	public static void convertToPng(String svgCode, String pngFilePath)
			throws IOException, TranscoderException {

		File file = new File(pngFilePath);

		FileOutputStream outputStream = null;
		try {
			file.createNewFile();
			outputStream = new FileOutputStream(file);
			convertToPng(svgCode, outputStream);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将svgCode转换成png文件，直接输出到流中
	 * 
	 * @param svgCode
	 *            svg代码
	 * @param outputStream
	 *            输出流
	 * @throws TranscoderException
	 *             异常
	 * @throws IOException
	 *             io异常
	 */
	public static void convertToPng(String svgCode, OutputStream outputStream)
			throws TranscoderException, IOException {
		try {

			SVGAbstractTranscoder t = new JPEGTranscoder();
			t.addTranscodingHint(SVGAbstractTranscoder.KEY_WIDTH,
					new Float(500));
			TranscoderInput input = new TranscoderInput(new StringReader(
					svgCode));
			//System.out.println(svgCode);
			TranscoderOutput output = new TranscoderOutput(outputStream);
			//System.out.println(input.getReader());
			//System.out.println(outputStream.toString());
			t.transcode(input, output);
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					System.out.println(e);
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean GenerateImage(String imgStr) {
		String imgFilePath = "WEB-INF/file/spiderReport.jpg";
		imgFilePath = ServletActionContext.getServletContext().getRealPath(
				imgFilePath);
		// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void saveString(String str, String filePath) {
		String imgFilePath = filePath;
		imgFilePath = ServletActionContext.getServletContext().getRealPath(
				imgFilePath);
		try {
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(imgFilePath),"UTF-8");
        out.write(str);
        out.flush();
        out.close();
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e){
        // TODO Auto-generated catch block
        e.printStackTrace();
    }}
	public static void convertToPNG(String inputPath, String outputPath) {
		String imgFilePath = outputPath;
		imgFilePath = ServletActionContext.getServletContext().getRealPath(
				imgFilePath);
		String svgFilePath = ServletActionContext.getServletContext().getRealPath(
				inputPath);
		PNGTranscoder t = new PNGTranscoder();
		t.addTranscodingHint(PNGTranscoder.KEY_GAMMA, new Float(.8));
		String svgURI;
		OutputStream ostream = null;
		try {
			svgURI = new File(svgFilePath).toURI().toString();
			TranscoderInput input = new TranscoderInput(svgURI);
			try {
				ostream = new FileOutputStream(imgFilePath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			TranscoderOutput output = new TranscoderOutput(ostream);
			try {
				t.transcode(input, output);
			} catch (TranscoderException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ostream.flush();
			ostream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}
	public String getReportText() {
		return reportText;
	}
	public void setIsJob(int isJob) {
		this.isJob = isJob;
	}
	public int getIsJob() {
		return isJob;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	
}
