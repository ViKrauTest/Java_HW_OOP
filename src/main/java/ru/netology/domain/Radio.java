package ru.netology.domain;

public class Radio {
    private int NumberOfStations = 10;
    private int minRadiostation = 0;
    private int maxRasiostation = NumberOfStations - 1;
    private int currentRadioStation;
    private int currentVolume;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (this.minRadiostation <= newCurrentRadioStation & newCurrentRadioStation <= 9) {
            this.currentRadioStation = newCurrentRadioStation;
        } else {
            return;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
            this.currentVolume = newCurrentVolume;
    }

    public void next() {
        if (currentRadioStation == 9) {
            setCurrentRadioStation(0);
        } else {
            setCurrentRadioStation(currentRadioStation + 1);
        }
    }

    public void prev() {
        if (currentRadioStation == 0) {
                setCurrentRadioStation(9);
        } else {
                setCurrentRadioStation(currentRadioStation - 1);
        }
    }

    public void increaseVolume() {
        if (currentVolume < 10 & currentVolume >= 0) {
            setCurrentVolume(currentVolume + 1);
        } else {
            return;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0 & currentVolume <= 10) {
            setCurrentVolume(currentVolume - 1);
        } else {
            return;
        }
    }
}
