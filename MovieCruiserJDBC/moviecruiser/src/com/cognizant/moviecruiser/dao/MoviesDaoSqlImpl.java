package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {
	public static final String MOVIE_LIST_DETAILS = "select * from movie_list";
	public static final String UPDATE_MOVIE_LIST = "update movie_list set mo_title=?,mo_gross=?,mo_active=?,mo_date_of_launch=?,mo_genre=?,mo_has_teaser=? where mo_id=?";
	public static final String ALL_MOVIE_CUSTOMER = "select mo_id,mo_title,mo_gross,mo_genre,mo_active,mo_date_of_launch,mo_has_teaser from movie_list where mo_active='1' and mo_date_of_launch<CURDATE()";
	public static final String MOVIE_DETAILS = "select * from movie_list where mo_id=?";

	@Override
	public ArrayList<Movies> getMoviesListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> moviesList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(MOVIE_LIST_DETAILS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movie = new Movies();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setTitle(resultSet.getString("mo_title"));
				movie.setGross(resultSet.getLong("mo_gross"));
				movie.setActive(resultSet.getString("mo_active").equals("1"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				moviesList.add(movie);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return moviesList;
	}

	@Override
	public ArrayList<Movies> getMoviesListCustomer() {
		ArrayList<Movies> moviesList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionHandler.getConnection();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(ALL_MOVIE_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movie = new Movies();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setTitle(resultSet.getString("mo_title"));
				movie.setGross(resultSet.getLong("mo_gross"));
				movie.setActive(resultSet.getString("mo_active").equals("1"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				moviesList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return moviesList;
	}

	@Override
	public void modifyMovies(Movies movies) {

		@SuppressWarnings("unused")
		ArrayList<Movies> moviesList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionHandler.getConnection();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(UPDATE_MOVIE_LIST);
			preparedStatement.setString(1, movies.getTitle());
			preparedStatement.setFloat(2, movies.getGross());
			preparedStatement.setBoolean(3, movies.getActive());
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			preparedStatement.setString(5, movies.getGenre());
			preparedStatement.setBoolean(6, movies.getHasTeaser());
			preparedStatement.setLong(7, movies.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}

	}

	@Override
	public Movies getMovies(Long moviesId) {
		ArrayList<Movies> movieList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionHandler.getConnection();
		Movies movie = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(MOVIE_DETAILS);
			preparedStatement.setLong(1, moviesId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movie = new Movies();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setTitle(resultSet.getString("mo_title"));
				movie.setGross(resultSet.getLong("mo_gross"));
				movie.setActive(resultSet.getString("mo_active").equals("1"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setHasTeaser(resultSet.getString("me_has_teaser").equals("1"));
				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return movie;
	}

}
