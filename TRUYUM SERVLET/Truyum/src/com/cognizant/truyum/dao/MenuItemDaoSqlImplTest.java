package com.cognizant.truyum.dao;

import java.io.IOException;

import java.sql.Connection;

import java.sql.SQLException;

import java.text.DecimalFormat;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {

		Connection connection = ConnectionHandler.getConnection();
		System.out.println("Connection->" + connection);
		System.out.println("Item List for Admin");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		String active, freedelivery;
		System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name", "Price", "Active", "DateOFLaunch",
				"Category", "FreeDelivery");

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "yes";
			} else {
				active = "no";
			}
			if (menuItem.getFreeDelivery() == true) {
				freedelivery = "yes";
			} else {
				freedelivery = "no";
			}
			System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), freedelivery);
		}

	}

	public static void testGetMenuItemListCustomer() throws SQLException {

		System.out.println("Item List For Customer");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		System.out.format("%-10s%-20s%-10s%-10s%-15s%-15s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE_OF_LAUNCH",
				"CATEGORY", "FREE_DELIVERY");
		System.out.println();
		String active;
		String freedelivery;

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freedelivery = "Yes";
			} else {
				freedelivery = "No";
			}
			System.out.format("%-10s%-20s%-10s%-10s%-15s%-15s%-10s", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), freedelivery);
			System.out.println();
		}
	}

	public static void testModifyMenuItem() throws NumberFormatException, IOException {

		MenuItem menuItem = new MenuItem(1l, "Rice", 1100.00f, true, new DateUtil().convertToDate("12/12/2019"),
				"meals", true);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		System.out.println("Enter the item to be modified");
		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
	}

	public static void testgetMenuItem() {

		System.out.println("\n\n***Get Menu Item***");
		long menuItemId = 2;
		MenuItem menuItem = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###.00");
		System.out.format("\n\n%15s%25s%15s%15s%15s%15s%15s", "Id", "Name", "Price", "Date of Launch", "Active",
				"Category", "Free Delivery");
		System.out.format("\n" + "%15s%25s%15s%15s%15s%15s%15s", menuItem.getId(), menuItem.getName(),
				df.format(menuItem.getPrice()), sdf.format(menuItem.getDateOfLaunch()), menuItem.getActive(),
				menuItem.getCategory(), menuItem.getFreeDelivery());
	}

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItemListAdmin();
	}

}
