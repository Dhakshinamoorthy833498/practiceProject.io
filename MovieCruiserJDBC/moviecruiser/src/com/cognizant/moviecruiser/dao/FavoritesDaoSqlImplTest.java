package com.cognizant.moviecruiser.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlImplTest {

	public static void testaddFavoriteMovies() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter user movie list id");
		long moviesId = Long.parseLong(bf.readLine());
		new FavoritesDaoSqlImpl().addFavoriteMovies(userId, moviesId);

	}

	public static void testAllFavoriteMovies() throws FavoritesEmptyException {

		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites favorite = favoritesDaoSqlImpl.getAllFavoriteMovies(1L);
		System.out.println(favorite.getMoviesList());
		System.out.println("No.of favorites= " + favorite.getTotal());

	}

	public static void testremoveFavoriteMovies() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter user menu item id");
		long moviesId = Long.parseLong(bf.readLine());
		new FavoritesDaoSqlImpl().removeFavoriteMovies(userId, moviesId);

	}

	public static void main(String[] args) throws NumberFormatException, IOException, FavoritesEmptyException {
		System.out.println("User Added Cart List for CheckOut");
		testaddFavoriteMovies();
		System.out.println("Favorites Items");
		testAllFavoriteMovies();
		System.out.println("Movies to be Removed");
		testremoveFavoriteMovies();
		Connection connection = ConnectionHandler.getConnection();
		System.out.println("Connection->" + connection);
	}

}
