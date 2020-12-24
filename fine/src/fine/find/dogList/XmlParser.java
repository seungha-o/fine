package fine.find.dogList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XmlParser {
	private DocumentBuilderFactory documentBuilderFactory;
	private DocumentBuilder documentBuilder;
	private Document document;
	private NodeList nodeList;
	private NodeList nodeList2;

	public XmlParser(File file) {
		System.out.println(file + "파일보여줘");
		DomParser(file);
	}

	public void DomParser(File file) {
		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(file);
			System.out.println("document : " + document);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<XmlDataVO> parse(String tagName) {
		List<XmlDataVO> listOfData = new ArrayList<XmlDataVO>();
		nodeList = document.getElementsByTagName(tagName);
		System.out.println(nodeList2);

	
		System.out.println("nodeList.getLength(): " + nodeList.getLength());
		

		
		for (int i = 0; i < nodeList.getLength(); i++) {

			Element element = (Element) nodeList.item(i);
//			String dog_kind_no = this.getTagValue("kindCd", element);
//			String kind = this.getTagValue("KNm", element);
			
			String desertionNo = this.getTagValue("desertionNo", element);
			System.out.println(desertionNo);
			String happenPlace = this.getTagValue("happenPlace", element);
			System.out.println(happenPlace);
			String age = this.getTagValue("age", element);
			System.out.println(age);
			String careAddr = this.getTagValue("careAddr", element);
			System.out.println(careAddr);
			String careNm = this.getTagValue("careNm", element);
			System.out.println(careNm);
			String careTel = this.getTagValue("careTel", element);
			System.out.println(careTel);
			String color = this.getTagValue("colorCd", element);
			System.out.println(color);
			String filename = this.getTagValue("filename", element);
			System.out.println(filename);
			String happenDt =this.getTagValue("happenDt", element);
			System.out.println(happenDt);
			String kindCd =this.getTagValue("kindCd", element).substring(4);
			System.out.println(kindCd);
			String neuterYn =this.getTagValue("neuterYn", element);
			System.out.println(neuterYn);
			String noticeEdt =this.getTagValue("noticeEdt", element);
			System.out.println(noticeEdt);
			String noticeSdt =this.getTagValue("noticeSdt", element);
			System.out.println(noticeSdt);
			String officetel =this.getTagValue("officetel", element);
			System.out.println(officetel);
			String orgNm =this.getTagValue("orgNm", element);
			System.out.println(orgNm);
			String popfile =this.getTagValue("popfile", element);
			System.out.println(popfile);
			String processState =this.getTagValue("processState", element);
			System.out.println(processState);
			String sexCd =this.getTagValue("sexCd", element);
			System.out.println(sexCd);
			String specialMark =this.getTagValue("specialMark", element);
			System.out.println(specialMark);
			String weight =this.getTagValue("weight", element);
			System.out.println(weight);
//			
//			
//			XmlDataVO vo = new XmlDataVO(dog_kind_no, kind);
			XmlDataVO vo = new XmlDataVO(desertionNo, happenPlace, age,careAddr,  careNm, careTel,  color, filename, happenDt,
					kindCd, neuterYn, noticeEdt, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight);
			listOfData.add(vo);
			System.out.println("");
		}
		return listOfData;
	}

	private String getTagValue(String tagName, Element element) {
		NodeList nodeList= null;
		if(element.getElementsByTagName(tagName).item(0).getChildNodes() == null) {
			nodeList = null;
		}else {
			nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();			
		}
		System.out.println(nodeList);
		Node node = nodeList.item(0);
        System.out.println(node.getNodeName());
		return node.getNodeValue();
		
	}
}
