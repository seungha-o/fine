package fine.find.findInfo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import fine.find.findInfo.service.FindService;

/**
 * Servlet implementation class Find_manage_update
 */
@WebServlet("/find_manage_update.do")
public class Find_manage_data_update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Find_manage_data_update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
			
		String fileName = "C:\\eclips_java\\fine\\dogNotice.xml";
		BufferedReader br = null;

		// DocumentBuilderFactory 생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		String today = sdf.format(cal.getTime());
		 
		


		try {
			// OpenApi호출
			int count = 0;
			String urlstr = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=z1Y%2B%2FKbcw8o3UyZuB3R%2BgSVOx1KhUHOFXWFNf9qVFHHj6bMePFYfs9cPFKx4L1CMZ6sFoWBAydrytd%2Br4aWySw%3D%3D&bgnde=20140601&endde="+today+"&upkind=417000&state=notice&pageNo=1&numOfRows=50000";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			// 응답 읽기
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result = result + line.trim();// result = URL로 XML을 읽은 값
			}

			// xml 파싱하기
			InputSource is = new InputSource(new StringReader(result));
			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			// XPathExpression expr = xpath.compile("/response/body/items/item");
			XPathExpression expr = xpath.compile("//items/item");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, false));
			fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r");
			fw.write("\t\t<items>\r");
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println("<item>");
				NodeList child = nodeList.item(i).getChildNodes();
				fw.write("\t\t\t<item>\r");
				count++;
//            	String childs = nodeList.item(i).getChildNodes().item(i).getNodeName();
//            	String a = nodeList.item(i).getChildNodes().item(i).getTextContent();
//            	if(childs.contains("noticeSdt") == true && Integer.parseInt(a) < 20201123) {
//            		
//            		int cnt=0;
//            		System.out.println(cnt++);
//            	}
//            	System.out.println(childs);
				for (int j = 0; j < child.getLength(); j++) {
					Node node = (Node) child.item(j);
					String as = "\t\t\t\t<" + node.getNodeName() + ">"
							+ node.getTextContent().replaceAll("&", "과").replace("과#", "ampS") + "</"
							+ node.getNodeName() + ">\r";
					fw.write(as);

				}

//	                    System.out.println("현재 노드 네임스페이스 : " + node.getPrefix());
//	                    System.out.println("현재 노드의 다음 노드 : " + node.getNextSibling());
//	                    System.out.println("");

				fw.write("\t\t\t</item>\r");
			}
			fw.write("\t\t</items>");
			fw.flush();
			fw.close();
			System.out.println("생성!");
			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		FindService fService = new FindService();
		int result = fService.insertNoticeSysDate();
		String ctxpath = request.getContextPath();
		if (result == 1) {
			System.out.println("DB저장성공");
		} else {
			System.out.println("db다시");
			
		}
		String ctx = request.getContextPath();
		PrintWriter out = response.getWriter();
		out.append("<script>alert('데이터를 최신화 하였습니다')</script>");
		out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>"); 
		
	}

}
