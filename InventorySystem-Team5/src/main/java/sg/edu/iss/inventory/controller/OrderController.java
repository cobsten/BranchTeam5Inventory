package sg.edu.iss.inventory.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.inventory.exception.MismatchPartNumException;
import sg.edu.iss.inventory.model.OrderCartItem;
import sg.edu.iss.inventory.service.OrderService;

@RequestMapping(value = "/admin/order")
@Controller
public class OrderController {

	@Autowired
	private OrderService oService;

	//
	//
	//
	//
	// list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpSession session) {

		// get orderList
		getOrderList(session);

		return new ModelAndView("order-list");
	}

	//
	//
	//
	//
	// add
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addOrderItem(HttpSession session, HttpServletRequest request) {

		// get orderList
		ArrayList<OrderCartItem> orderList = getOrderList(session);

		// update orderList
		updateOrderList(request, orderList);

		// add product to orderList
		try {
			String partNo = (String) request.getParameter("partNo");
			oService.addListItem(partNo, orderList);
		}
		catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
		}

		return new ModelAndView("order-list");
	}

	//
	//
	//
	//
	// reset
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView reset(HttpSession session, HttpServletRequest request) {

		// reset orderList
		session.setAttribute("USERSESSION", null);
		getOrderList(session);

		return new ModelAndView("order-new");
	}

	//
	//
	//
	//
	// submit
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView submitOrder(HttpSession session, HttpServletRequest request) {

		// get orderList
		ArrayList<OrderCartItem> orderList = ((UserSession) session.getAttribute("USERSESSION")).getOrderList();

		// update orderList with orderQty
		for (int i = 0; i < orderList.size(); i++) {

			int orderQty = (int) request.getAttribute("orderQty" + i);
			orderList.get(i).setQuantity(orderQty);
		}

		// submit orderList
		oService.submitOrder(orderList);
		return new ModelAndView("order-summary");
	}

	//
	//
	//
	//
	// autogenerate
	@RequestMapping(value = "/autogenerate", method = RequestMethod.POST)
	public ModelAndView autoGenerateOrderQty(HttpSession session, HttpServletRequest request) {

		// dont do
		return new ModelAndView("order-new");
	}

	//
	//
	//
	//
	// PRIVATE METHODS
	//
	//
	//
	//
	// getOrderList
	private ArrayList<OrderCartItem> getOrderList(HttpSession session) {

		ArrayList<OrderCartItem> orderList = (ArrayList<OrderCartItem>) session.getAttribute("ORDERLIST");
		if (orderList == null) {
			//
			try {
				orderList = oService.createToOrderList();
			}
			catch (MismatchPartNumException e) {
				e.printStackTrace();
			}
			session.setAttribute("ORDERLIST", orderList);
			//
		}
		return orderList;
	}

	//
	//
	//
	//
	// updateOrderList
	private void updateOrderList(HttpServletRequest request, ArrayList<OrderCartItem> orderList) {
		for (int i = 0; i < orderList.size(); i++) {
			int orderQty = Integer.parseInt(request.getParameter("orderQty" + i));
			orderList.get(i).setQuantity(orderQty);
		}
	}

}
