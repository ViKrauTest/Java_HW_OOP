package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

public class RadioTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/dataNumberOfStationsTest.csv")
    void numberOfStation(int numberOfStations, int expectedNumberOfStations, int expectedMinRadioStation, int expectedMaxRadioStation) {
        Radio radio = new Radio(numberOfStations);
        int actualNumberOfStations = radio.getNumberOfStations();
        int actualMinRadioStation = radio.getMinRadiostation();
        int actualMaxRadioStation = radio.getMaxRadioStation();
        assertEquals(expectedNumberOfStations, actualNumberOfStations);
        assertEquals(expectedMinRadioStation, actualMinRadioStation);
        assertEquals(expectedMaxRadioStation, actualMaxRadioStation);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataDefaultNumberOfStation.csv")
    void defaultNumberOfStation(int numberOfStations, int expectedNumberOfStations, int expectedMinRadioStation, int expectedMaxRadioStation) {
        Radio radio = new Radio();
        int actualNumberOfStations = radio.getNumberOfStations();
        int actualMinRadioStation = radio.getMinRadiostation();
        int actualMaxRadioStation = radio.getMaxRadioStation();
        assertEquals(expectedNumberOfStations, actualNumberOfStations);
        assertEquals(expectedMinRadioStation, actualMinRadioStation);
        assertEquals(expectedMaxRadioStation, actualMaxRadioStation);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataNextRadioStation.csv")
    void nextRadioStation(int currentRadioStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(currentRadioStation);
        radio.next();
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-29, 1",
            "-1, 1",
            "0, 1",
            "1, 2",
            "28, 0",
            "29, 0",
            "30, 0",
            "100, 0"
    })
    void nextRadioStationUserSettings(int currentRadioStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(currentRadioStation);
        radio.next();
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataPrevRadioStation.csv")
    void prevRadioStation(int currentRadioStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(currentRadioStation);
        radio.prev();
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-29, 28",
            "-1, 28",
            "0, 28",
            "1, 0",
            "28, 27",
            "29, 27",
            "30, 27",
            "100, 27"
    })
    void prevRadioStationUserSettings(int currentRadioStation, int expected) {
        Radio radio = new Radio(29);
        radio.setCurrentRadioStation(currentRadioStation);
        radio.prev();
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataIncreaseVolume.csv")
    void increaseVolumeTest(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataDecreaseVolume.csv")
    void decreaseVolumeTest(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }
}
