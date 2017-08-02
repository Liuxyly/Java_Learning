package org.liuxy.rentcar.sevrlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.entity.Page;
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
	
	private CarInfoService carInfoService = new CarInfoServiceImpl();
	private CarTypeService carTypeService = new CarTypeServiceImpl();
	private BrandService brandService = new BrandServiceImpl();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarInfoServlet() {
        super();
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
		
		String oprP = request.getParameter("opr");
		
		if (oprP != null) {
			switch (oprP) {
			case "addBrandName":
				addBrandName(request, response);
				break;
			case "getBrands":
				getBrands(request, response);
				break;
			case "choiceCar":
				choiceCar(request, response);
				break;
			case "alterCarInfoCon":
				alterCarInfoCon(request, response);
				break;
			case "queryByBrandName":
				queryByBrandName(request, response);
				break;
			case "delCarInfo":
				delCarInfo(request, response);
				break;
			case "getCarTypeOptions":
				getCarTypeOptions(request, response);
				break;
			case "addCarType":
				addCarType(request, response);
			case "pageControl":
				pageControl(request, response);
				break;
			case "getImg":
				getImgByCarId(request, response);
				break;
			default:
				break;
			}
		}
	}

	protected void getImgByCarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/gif");
		
		String carId = request.getParameter("carId");
		InputStream inputStream = this.carInfoService.getImgByCarId(Integer.parseInt(carId));
		int size = inputStream.available();
		byte[] image = new byte[size];
		
		inputStream.read(image);
		
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(image);
	}

	protected void choiceCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String[]> map = request.getParameterMap();
		List<String> levels = null;
		List<String> brands = null;
		List<String> prices = null;
		String defaultSort = null;
		String RrlPriceSort = null;
		String stockOnlySort = null;
		String pageNumber = null;
		 
		Pattern pattern = Pattern.compile("\\[([^\\]]*)\\]");
		Matcher matcher = null;
		
		String tmpKey = null;
		
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
	    	
			matcher = pattern.matcher(key);
			
			if (matcher.find()){
				tmpKey = matcher.group(1);
			} else {
				tmpKey = "";
			}
			
			switch (tmpKey) {
			case "level":
				levels = Arrays.asList((String[]) map.get(key));
				break;
			case "brand":
				brands = Arrays.asList((String[]) map.get(key));
				break;
			case "price":
				prices = Arrays.asList((String[]) map.get(key));
				break;
			case "defaultSort":
				for (Object obj : map.get(key)) {
					defaultSort = (String)obj;
				}
				break;
			case "RrlPriceSort":
				for (Object obj : map.get(key)) {
					RrlPriceSort = (String)obj;
				}
				break;
			case "stockOnlySort":
				for (Object obj : map.get(key)) {
					stockOnlySort = (String)obj;
				}
				break;
			case "pageNumber":
				for (Object obj : map.get(key)) {
					pageNumber = (String)obj;
				}
				break;
			default:
				break;
			}
	     } 
		
		Page<CarInfo> page = new Page<>(carInfoService.getCarInfoCountByCondition(levels, brands, prices, stockOnlySort), Integer.parseInt(pageNumber), 4);
		
		page.setPageList(carInfoService.findAllBycondition(levels, brands, prices, defaultSort, RrlPriceSort, stockOnlySort, page));
		
		String jsonString = JSONArray.toJSONString(page);
		
		System.out.println(jsonString);
		
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		
		out.close();
	}

	protected void getBrands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Brand> brandOptions = brandService.brandNameOptions();
		
		PrintWriter out = response.getWriter();
		
		String jsonString = JSONArray.toJSONString(brandOptions);
		
		out.print(jsonString);
		
		out.close();
	}

	protected void pageControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		String brandName = request.getParameter("brandName");
		Brand brand = null;
		if (!brandName.equals("")) {
			brand = new Brand();
			brand.setBrandName(brandName);
		}
		
		Page<CarInfo> paging =  carInfoService.listCarInfoByBrand(brand, Integer.parseInt(page), 6);
		
		String carInfoString = JSONArray.toJSONString(paging);
		
		PrintWriter out = response.getWriter();
		out.print(carInfoString);
		
		out.close();
	}

	protected void queryByBrandName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brandName = request.getParameter("brandName");
		Brand brand = null;
		if (!brandName.equals("")) {
			brand = new Brand();
			brand.setBrandName(brandName);
		}
		
		Page<CarInfo> paging =  carInfoService.listCarInfoByBrand(brand, 1, 6);
		
		String carInfoString = JSONArray.toJSONString(paging);
		
		PrintWriter out = response.getWriter();
		out.print(carInfoString);
		
		out.close();
		
	}

	protected void addCarType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carTypeNameVal =  request.getParameter("carTypeName");
		Integer brandIDVal = Integer.parseInt(request.getParameter("brandId"));
		
		CarType carType = new CarType();
		Brand brand = new Brand();
		carType.setCartypeName(carTypeNameVal);
		brand.setBrandId(brandIDVal);
		carType.setBrand(brand);
		
		boolean flag = true;
		
		List<CarType> list = carTypeService.getCarTypeOptionsByBrandID(brandIDVal);
		
		for (CarType carType2 : list) {
			if(carType2.getCartypeName().equals(carTypeNameVal)) {
				flag = false;
			}
		}
		if (flag) {
			carTypeService.addCarType(carType);
		}
		
		PrintWriter out = response.getWriter();
		
		String carTypeString = JSONArray.toJSONString(carTypeService.getCarTypeOptionsByBrandID(brandIDVal));
		out.print(carTypeString);
		
		out.close();
	}
	
	protected void alterCarInfoCon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer carId = Integer.parseInt(request.getParameter("carInfoId"));
		
		CarInfo carInfo = carInfoService.findCarInfoByCarId(carId);
		
		request.setAttribute("carInfo", carInfo);
		request.setAttribute("carType", carTypeService.getCarTypeOptionsByBrandID(carInfo.getCarType().getBrand().getBrandId()));
		request.getRequestDispatcher("admin/alterCar.jsp").forward(request, response);
		
	}
	
	protected void getCarTypeOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brandIdVal = (String)request.getParameter("brandId");
		List<CarType> list = carTypeService.getCarTypeOptionsByBrandID(Integer.parseInt(brandIdVal));
		PrintWriter out = response.getWriter();
		
		String carTypeOptions = JSONArray.toJSONString(list);
		out.print(carTypeOptions);
		
		out.close();
	}
	
	protected void delCarInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer carId = Integer.parseInt(request.getParameter("carInfoId"));
		Integer page = Integer.parseInt(request.getParameter("page"));
		String brandNameVal = (String)request.getParameter("brandName");
		
		Brand brandtmp = null;
		if (brandNameVal != null && !brandNameVal.equals("")) {
			brandtmp = new Brand();
			brandtmp.setBrandName(brandNameVal);
		}
		
		carInfoService.deleteCarInfoByCarId(carId);
		PrintWriter out = response.getWriter();
		
		Page<CarInfo> paging = carInfoService.listCarInfoByBrand(brandtmp, page, 6);
		
		String carTypeOptions = JSONArray.toJSONString(paging);
		out.print(carTypeOptions);
		
		out.close();
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
//		CarInfoService carInfoService = new CarInfoServiceImpl();
		
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
			
			if (carInfo.getCarId() == null) {
				carInfo.setCarState(1);
				carInfoService.addCarInfoNot(carInfo);
			} else {
				carInfo.setCarState(1);
				carInfoService.updateCarInfoByCarId(carInfo);
			}
			
			response.sendRedirect("admin/updateCar.jsp");
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
