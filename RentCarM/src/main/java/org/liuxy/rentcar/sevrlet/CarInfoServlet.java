package org.liuxy.rentcar.sevrlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.service.BrandService;
import org.liuxy.rentcar.service.CarInfoService;
import org.liuxy.rentcar.service.CarTypeService;
import org.liuxy.rentcar.service.impl.BrandServiceImpl;
import org.liuxy.rentcar.service.impl.CarInfoServiceImpl;
import org.liuxy.rentcar.service.impl.CarTypeServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * Servlet implementation class CarInfoServlet
 */
@WebServlet("/CarInfoServlet")
public class CarInfoServlet extends HttpServlet {
	private static final String ENCODE = "UTF-8";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (ServletFileUpload.isMultipartContent(request)) {
			uploadFile(request, response);
		}
		
		// String oprA = (String)request.getAttribute("opr");
		String oprP = request.getParameter("opr");
//		if (opr != null && opr.equals("addBrandName")){
//			addBrandName(request, response);
//		}
		
		if (oprP != null) {
			switch (oprP) {
			case "addBrandName":
				addBrandName(request, response);
				break;
			case "alterCarInfoCon":
				alterCarInfoCon(request, response);
				break;
			case "delCarInfo":
				delCarInfo(request, response);
				break;
			case "getCarTypeOptions":
				getCarTypeOptions(request, response);
				break;
			case "addCarType":
				addCarType(request, response);
			default:
				break;
			}
		}
	}
	
	protected void addCarType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carTypeNameVal =  request.getParameter("carTypeName");
		Integer brandIDVal = Integer.parseInt(request.getParameter("brandId"));
		
		CarType carType = new CarType();
		Brand brand = new Brand();
		carType.setCartypeName(carTypeNameVal);
		brand.setBrandId(brandIDVal);
		carType.setBrand(brand);
		
		CarTypeService carTypeService = new CarTypeServiceImpl();
		PrintWriter out = response.getWriter();
		
		String carTypeString = JSONArray.toJSONString(carTypeService.getCarTypeOptionsByBrandID(brandIDVal));
		out.print(carTypeString);
		
		out.close();
	}
	
	protected void alterCarInfoCon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer carId = Integer.parseInt(request.getParameter("carInfoId"));
		CarInfoService carInfoService = new CarInfoServiceImpl();
		
		CarInfo carInfo = carInfoService.findCarInfoByCarId(carId);
		
		request.setAttribute("carInfo", carInfo);
		CarTypeService carTypeService = new CarTypeServiceImpl();
		request.setAttribute("carType", carTypeService.getCarTypeOptionsByBrandID(carInfo.getCarType().getBrand().getBrandId()));
		request.getRequestDispatcher("admin/alterCar.jsp").forward(request, response);
		
	}
	
	protected void getCarTypeOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brandIdVal = (String)request.getParameter("brandId");
		CarTypeService carTypeService = new CarTypeServiceImpl();
		List<CarType> list = carTypeService.getCarTypeOptionsByBrandID(Integer.parseInt(brandIdVal));
		PrintWriter out = response.getWriter();
		
		String carTypeOptions = JSONArray.toJSONString(list);
		out.print(carTypeOptions);
		
		out.close();
	}
	
	protected void delCarInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer carId = Integer.parseInt(request.getParameter("carInfoId"));
		
		CarInfoService carInfoService = new CarInfoServiceImpl();
		
		carInfoService.deleteCarInfoByCarId(carId);
	}
	
	protected void addBrandName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brandNameVal = (String)request.getParameter("brandName");
		
		Brand brandtmp = new Brand();
		brandtmp.setBrandName(brandNameVal);
		
		BrandService brandService = new BrandServiceImpl();
		PrintWriter out = response.getWriter();
		Brand brand = brandService.getBrandByBrandName(brandtmp);
		
		if (brand == null) {
			brandService.addBrandName(brandNameVal);
			brand = brandService.getBrandByBrandName(brandtmp);
			((List<Brand>)request.getSession().getAttribute("brandNames")).add(brand);
			String brandJson = JSON.toJSONString(brand);
			System.out.println(brandJson);
			out.print(brandJson);
		} else {
			out.print("false");
		}
		
		out.close();
	}

	protected void uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		((DiskFileItemFactory) factory).setSizeThreshold(50000);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(16*1024*1024);
		CarInfo carInfo = new CarInfo();
		CarType carType = new CarType();
		Brand brand = new Brand();
		CarInfoService carInfoService = new CarInfoServiceImpl();
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			carType.setBrand(brand);
			carInfo.setCarType(carType);
			
			carInfo.setCarState(1);
			
			Consumer<FileItem> opr = (FileItem fileItem) -> {
				
				if (fileItem.isFormField()) {
					String fieldName = fileItem.getFieldName();
					try {
						switch (fieldName) {
						case "brandName":
							String brandIdVal = fileItem.getString(ENCODE).trim();
							carInfo.getCarType().getBrand().setBrandId(Integer.parseInt(brandIdVal));
							break;
						case "carIdVal":
							String carIdVal = fileItem.getString(ENCODE).trim();
							carInfo.setCarId(Integer.parseInt(carIdVal));
							break;
						case "carJibie":
							String carJibieVal = fileItem.getString(ENCODE).trim();
							carInfo.setCarJibie(carJibieVal);
							break;
						case "cartypeName":
							String cartypeNameVal = fileItem.getString(ENCODE).trim();
							// carInfo.getCarType().setCartypeName(cartypeNameVal);
							carInfo.getCarType().setCartypeId(Integer.parseInt(cartypeNameVal));
							break;
						case "carJiegou":
							String carJiegouVal = fileItem.getString(ENCODE).trim();
							carInfo.setCarJiegou(carJiegouVal);
							break;
						case "carPailiang":
							String carPailiangVal = fileItem.getString(ENCODE).trim();
							carInfo.setCarPailiang(carPailiangVal);
							break;
						case "carBox":
							String carBoxVal = fileItem.getString(ENCODE).trim();
							carInfo.setCarBox(carBoxVal);
							break;
						case "carPeople":
							String carPeopleVal = fileItem.getString(ENCODE).trim();
							carInfo.setCarPeople(Integer.parseInt(carPeopleVal));
							break;
						case "price":
							String priceVal = fileItem.getString(ENCODE).trim();
							BigDecimal priceB = new BigDecimal(priceVal);
							carInfo.setPrice(priceB);
							break;
						case "discount":
							String discountVal = fileItem.getString(ENCODE).trim();
							BigDecimal discountB = new BigDecimal(discountVal);
							carInfo.setDiscount(discountB);
							break;
						default:
							break;
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else {
					try {
						InputStream stream = new BufferedInputStream(fileItem.getInputStream());
						
						carInfo.setImageData(stream);
					} catch (IOException e) {
						e.printStackTrace();
					}  
				}
			};
			
			items.forEach(opr);
			
			List<CarInfo> carInfos = ((List<CarInfo>)request.getSession().getAttribute("carInfos"));
			
			if (carInfo.getCarId() == null) {
				carInfo.setCarState(1);
				carInfoService.addCarInfoNot(carInfo);
				carInfos.add(carInfo);
			} else {
				carInfo.setCarState(1);
				carInfoService.updateCarInfoByCarId(carInfo);
				
				for (int i = 0; i < carInfos.size(); i++) {
					if(carInfos.get(i).getCarId() == carInfo.getCarId()){
						carInfos.set(i, carInfo);
					}
				}
				
			}
			
			response.sendRedirect("admin/updateCar.jsp");
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
