package ru.netology.domain;

public class Radio {
    private int numberOfStations = 10;
    private int minRadioStation = 0;
    private int maxRadioStation = this.numberOfStations - 1;
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentRadioStation;
    private int currentVolume;

    public Radio(int numberOfStations) {
        if (numberOfStations > 0) {
            this.numberOfStations = numberOfStations;
        } else {
            this.numberOfStations = minRadioStation;
        }
        maxRadioStation = this.numberOfStations - 1;
    }

    public Radio() {
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }

    public int getMinRadiostation() {
        return minRadioStation;
    }

    public int getMaxRadioStation() {
        if (maxRadioStation < 0) {
            maxRadioStation = minRadioStation;
        }
        return maxRadioStation;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (this.minRadioStation <= newCurrentRadioStation & newCurrentRadioStation <= maxRadioStation) {
            this.currentRadioStation = newCurrentRadioStation;
        } else if (newCurrentRadioStation < this.minRadioStation) {
            this.currentRadioStation = minRadioStation;
        } else {
            this.currentRadioStation = maxRadioStation;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        this.currentVolume = newCurrentVolume;
    }

    public void next() {
        if (currentRadioStation >= maxRadioStation) {
            setCurrentRadioStation(minRadioStation);
        } else {
            setCurrentRadioStation(currentRadioStation + 1);
        }
    }

    public void prev() {
        if (currentRadioStation == minRadioStation) {
            setCurrentRadioStation(maxRadioStation);
        } else {
            setCurrentRadioStation(currentRadioStation - 1);
        }
    }

    public void increaseVolume() {
        if (currentVolume < minVolume) {
            setCurrentVolume(minVolume);
        } else if (currentVolume >= maxVolume) {
            setCurrentVolume(maxVolume);
        } else {
            setCurrentVolume(currentVolume + 1);
        }
    }

    public void decreaseVolume() {
        if (currentVolume <= minVolume) {
            setCurrentVolume(minVolume);
        } else if (currentVolume > maxVolume) {
            setCurrentVolume(maxVolume);
        } else {
            setCurrentVolume(currentVolume - 1);
        }
    }
}
