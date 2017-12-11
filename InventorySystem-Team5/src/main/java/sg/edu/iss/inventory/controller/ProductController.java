package sg.edu.iss.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.inventory.model.Product;
import sg.edu.iss.inventory.service.ProductService;
import sg.edu.iss.inventory.validator.ProductValidator;

@RequestMapping(value="product")
@Controller
public class ProductController {

	@Autowired
	ProductService productService;	
	
	@Autowired
	private ProductValidator pValidator;

	@InitBinder("product")
	private void initEmployeeBinder(WebDataBinder binder) {
		binder.addValidators(pValidator);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage(Model model, @RequestParam(required = false) Integer page,@ModelAttribute("product") Product product) {
		model.addAttribute("product",new Product());
		ModelAndView mav = new ModelAndView("product-list");
		List<Product> productList = (List<Product>) productService.findAllProduct();
		PagedListHolder<Product> pagedListHolder = new PagedListHolder<>(productList);
		pagedListHolder.setPageSize(5);
		mav.addObject("maxPages", pagedListHolder.getPageCount());
		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		mav.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			mav.addObject("productList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			mav.addObject("productList", pagedListHolder.getPageList());
		}
		
		ArrayList<Product> carDealerList = (ArrayList<Product>)productService.searchAllCarDealer();
		mav.addObject("carDealerList", carDealerList);
		
		ArrayList<Product> partDescriptionList = (ArrayList<Product>)productService.searchAllPartDescription();
		mav.addObject("partDescriptionList", partDescriptionList);
		
		ArrayList<Product> colorList = (ArrayList<Product>)productService.searchAllColor();
		mav.addObject("colorList", colorList);
		
		return mav;
	}	
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchProduct(@ModelAttribute Product product, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("product-list");
		
		ArrayList<Product> productList = productService.searchProduct(product);		
			if(!productList.isEmpty())
			{
				mav.addObject("productList", productList);
			}
			else
			{
				//to add error message
				mav = new ModelAndView("redirect:/product/list");
			}				
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("product-edit");
		Product product = productService.findProducts(id);
		mav.addObject("product", product);
		mav.addObject("productlist", productService.findAllProduct());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute @Valid Product product, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) /* throws ProductNotFound */ {

		if (result.hasErrors())
			return new ModelAndView("product-edit");

		ModelAndView mav = new ModelAndView("redirect:/product/list");

		productService.changeProduct(product);		

		String message = "Product was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable String id, final RedirectAttributes redirectAttributes)
	/* throws ProductNotFound */ {

		ModelAndView mav = new ModelAndView("redirect:/product/list");
		Product product = productService.findProducts(id);

		productService.removeProduct(product);		
		
		String message = "The product " + product.getPartNo() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newProductPage() {
		ModelAndView mav = new ModelAndView("product-new", "product", new Product());
		//mav.addObject("productlist", productService.findAllProduct());
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewProduct(@ModelAttribute @Valid Product product, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()){
			return new ModelAndView("product-new");
			}

		ModelAndView mav = new ModelAndView();
		String message = "New product " + product.getPartNo() + " was successfully created.";

		productService.createProduct(product);
		mav.setViewName("redirect:/product/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}		
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView productDetailPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("product-detail");
		Product product = productService.findProducts(id);
		mav.addObject("product", product);
		mav.addObject("productlist", productService.findAllProduct());
		return mav;
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
	public ModelAndView productDetail(@ModelAttribute @Valid Product product, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) /* throws ProductNotFound */ {

		if (result.hasErrors())
			return new ModelAndView("product-detail");

		ModelAndView mav = new ModelAndView("redirect:/product/list");

		return mav;
	}
	
	@RequestMapping(value = "/use", method = RequestMethod.POST)
	public ModelAndView useProduct(@ModelAttribute Product product, BindingResult result) {
		ModelAndView mav = new ModelAndView("product-list");
		
		
				mav = new ModelAndView("redirect:/product/list");
		return mav;
	}	
}
