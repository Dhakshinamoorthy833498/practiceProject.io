package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void testMoviesListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println("Connection->" + connection);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Title", "Gross", "Active", "DateOFLaunch",
				"Genre", "HasTeaser");

		String active, HasTeaser;
		for (Movies movie : moviesList) {
			if (movie.getActive() == true) {
				active = "yes";
			} else {
				active = "no";
			}
			if (movie.getHasTeaser() == true) {
				HasTeaser = "yes";
			} else {
				HasTeaser = "no";
			}
			System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", movie.getId(), movie.getTitle(),
					df.format(movie.getGross()), active, sdf.format(movie.getDateOfLaunch()), movie.getGenre(),
					HasTeaser);
		}

	}

	public static void testGetMoviesListCustomer() {

		System.out.println("Item List For Customer");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListCustomer();
		System.out.format("%-10s%-20s%-10s%-10s%-15s%-15s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE_OF_LAUNCH",
				"CATEGORY", "FREE_DELIVERY");
		System.out.println();
		String active;
		String hasTeaser;

		for (Movies movie : moviesList) {
			if (movie.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movie.getHasTeaser() == true) {
				hasTeaser = "Yes";
			} else {
				hasTeaser = "No";
			}
			System.out.format("%-10s%-20s%-10s%-10s%-15s%-15s%-10s", movie.getId(), movie.getTitle(),
					df.format(movie.getGross()), active, sdf.format(movie.getDateOfLaunch()), movie.getGenre(),
					hasTeaser);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Connection connection = ConnectionHandler.getConnection();

		System.out.println("Connection->" + connection);
		testMoviesListAdmin();
		testmodifyMovies();
		testGetMoviesListCustomer();
		testMoviesListAdmin();
	}

	public static void testgetMovies() {

		System.out.println("\n\n***Get Movies***");
		long moviesId = 2;
		Movies movie = new MoviesDaoSqlImpl().getMovies(moviesId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###.00");
		System.out.format("\n\n%15s%25s%15s%15s%15s%15s%15s", "Id", "Title", "gross", "Date of Launch", "Active",
				"Genre", "Has Teaser");
		System.out.format("\n" + "%15s%25s%15s%15s%15s%15s%15s", movie.getId(), movie.getTitle(),
				df.format(movie.getGross()), sdf.format(movie.getDateOfLaunch()), movie.getActive(), movie.getGenre(),
				movie.getHasTeaser());
	}

	private static void testmodifyMovies() {

		Movies movie = new Movies(1l, "MERSAL", 7845695451l, true, new DateUtil().convertToDate("12/12/2019"), "Sports",
				true);
		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();
		System.out.println("Enter the item to be modified");
		moviesDaoSqlImpl.modifyMovies(movie);

	}
}
