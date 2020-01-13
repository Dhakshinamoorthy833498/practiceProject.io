package com.cognizant.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;

import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.MenuItemDao;

import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long userId = 1L;
		long menuItemId = Long.parseLong(request.getParameter("id"));
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(userId, menuItemId);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemListCustomer = menuItemDao.getMenuItemListCustomer();
		request.setAttribute("menuItemList", menuItemListCustomer);
		request.setAttribute("addCartStatus", true);
		request.getRequestDispatcher("menu-item-list-customer.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}