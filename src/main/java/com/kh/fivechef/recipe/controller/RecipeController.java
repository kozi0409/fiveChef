package com.kh.fivechef.recipe.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.service.RecipeService;

@Controller
public class RecipeController {
	@Autowired
	private RecipeService rService;
	
	@RequestMapping(value="/recipe/writeView.kh", method = RequestMethod.GET)
	public String showRecipeWrite() {
		return "recipe/recipeWriteForm";
	}
	
	@RequestMapping(value="/recipe/recipeRegister.kh" , method= RequestMethod.POST)
	public ModelAndView recipeRegist(
			ModelAndView mv
			,@ModelAttribute Recipe recipe
			,@ModelAttribute Ingradient ing
			,@ModelAttribute Order order
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,HttpServletRequest request) {
		
		try {
			String thumbnailName = uploadFile.getOriginalFilename();
			///////////////////////////경로,파일이름 설정
			if(!thumbnailName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\ruploadFiles";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhss");
				String thumbnailRename = sdf.format(new Date(System.currentTimeMillis()))+"." //시간
						+thumbnailName.substring(thumbnailName.lastIndexOf(".")+1); //확장자명
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				uploadFile.transferTo(new File(savePath+"\\"+thumbnailRename));//저장할때는 rename으로 저장 실제경로에 저장
				String thumbnailpath = savePath+"\\"+thumbnailRename;
				//파일을 ruploadFile경로에 저장하는 메소드
				recipe.setThumbnailName(thumbnailName);
				recipe.setThumbnailRename(thumbnailRename);
				recipe.setThumbnailpath(thumbnailpath);
			}
			int result = rService.registerRecipe(recipe);
			
			//list는 stream으로 사용해서 코드 단축 시킬 수 있음
			List<Ingradient> iList = new ArrayList<Ingradient>();
			for(int i = 0; i<ing.getIngAmount().split(",").length;i++) {
				Ingradient ingredient = new Ingradient();
				ingredient.setIngBundleName(ing.getIngBundleName());
				ingredient.setIngAmount(ing.getIngAmount().split(",")[i]);
				ingredient.setLargeCatId(ing.getLargeCatId().split(",")[i]);
				ingredient.setSmallCatId(ing.getSmallCatId().split(",")[i]);
				iList.add(ingredient);
			}
//			System.out.println(iList.get(0));
			for(int i = 0; i<iList.size();i++) {
				int result2=rService.registerIngradient(iList.get(i));
			}
			List<Order> oList = new ArrayList<Order>();
			for(int i = 0; i<order.getRecipeContents().split(",").length;i++) {
				Order ord = new Order();
				ord.setRecipeContents(order.getRecipeContents().split(",")[i]);
				ord.setRecipePhoto(order.getRecipePhoto().split(",")[i]);
				oList.add(ord);
			}
			for(int i = 0; i<oList.size();i++) {
				int result3 = rService.registerOrder(oList.get(i));
			}
			request.setAttribute("msg", "레시피 등록이 완료되었습니다.");
			request.setAttribute("url", "/recipe/writeView.kh");
			mv.setViewName("common/alert");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("msg","레시피등록 실패").setViewName("common/errorPage");
		}
		
		return mv;
	}
}
