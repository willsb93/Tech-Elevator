package com.techelevator.npgeek;

import java.util.List;

public interface SurveyDAO {

	public void addNewSurveyToDatabase(Survey surveySubmitted);

	public List<PopularPark> listMostPopularParks();

}
