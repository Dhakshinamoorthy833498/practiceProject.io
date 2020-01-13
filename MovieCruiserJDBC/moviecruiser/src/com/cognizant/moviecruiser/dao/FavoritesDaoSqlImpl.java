package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_MOVIES_TO_FAVORITES = "INSERT INTO `favorites` (`fv_us_id`, `fv_mo_id`) VALUES (?,?);";
	public static final String SHOW_FAVORITES_ITEMS = "select mo_id,mo_title, mo_gross, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie_list inner join favorites on fv_mo_id=mo_id where fv_us_id=?";
	public static final String GET_NO_OF_FAVORITES = "select count(mo_id) as Total_Favorites from movie_list inner join favorites on fv_mo_id=mo_id where fv_us_id=?";
	public static final String DELETE_FAVORITES = " delete from favorites where fv_us_id=? and fv_mo_id=? limit 1";

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
			int noOfRows = preparedStatement.executeUpdate();
			if (noOfRows > 0) {
				System.out.println("Insert Done");
			} else {
				System.out.println("No Insert");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}

		}

	}

	@Override
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ArrayList<Movies> moviesList = new ArrayList<Movies>();
		ResultSet resultSetList = null;
		ResultSet resultSetTotal = null;
		Favorites favorite = new Favorites();
		try {
			preparedStatement = connection.prepareStatement(SHOW_FAVORITES_ITEMS);
			preparedStatement.setLong(1, userId);
			resultSetList = preparedStatement.executeQuery();
			preparedStatementTotal = connection.prepareStatement(GET_NO_OF_FAVORITES);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			while (resultSetList.next()) {
				Movies movie = new Movies();
				movie = new Movies();
				movie.setId(resultSetList.getLong("mo_id"));
				movie.setTitle(resultSetList.getString("mo_title"));
				movie.setGross(resultSetList.getLong("mo_gross"));
				movie.setActive(resultSetList.getString("mo_active").equals("1"));
				movie.setDateOfLaunch(resultSetList.getDate("mo_date_of_launch"));
				movie.setGenre(resultSetList.getString("mo_genre"));
				movie.setHasTeaser(resultSetList.getString("mo_has_teaser").equals("1"));

				moviesList.add(movie);
			}
			while (resultSetTotal.next()) {
				favorite.setTotal(resultSetTotal.getInt("Total_Favorites"));
			}
			if (moviesList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			favorite.setMoviesList(moviesList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSetList != null)
					resultSetList.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (preparedStatementTotal != null)
					preparedStatementTotal.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return favorite;

	}

	@Override
	public void removeFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();

		@SuppressWarnings("unused")
		MoviesDao movieDao = new MoviesDaoSqlImpl();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(DELETE_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
			int noOfRows = preparedStatement.executeUpdate();
			if (noOfRows > 0) {
				System.out.println("Delete Done");
			} else {
				System.out.println("No Insert");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}

		}

	}

}
