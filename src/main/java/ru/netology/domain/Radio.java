package ru.netology.domain;

public class Radio {

    private int currentRadioStation;
    private int currentVolume;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (0 <= newCurrentRadioStation & newCurrentRadioStation <= 9) {
            this.currentRadioStation = newCurrentRadioStation;
        } else {
            return;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume >= 0 & newCurrentVolume <= 10) {
            this.currentVolume = newCurrentVolume;
        } else {
           return;
        }
    }

    public void next(int currentRadioStation) {
        if (currentRadioStation == 9) {
                setCurrentRadioStation(0);
            } else {
                setCurrentRadioStation(currentRadioStation + 1);
            }
        }

    public void prev(int currentRadioStation) {
        if (currentRadioStation >= 0 & currentRadioStation <= 9) {
            if (currentRadioStation == 0) {
                setCurrentRadioStation(9);
            } else {
                setCurrentRadioStation(currentRadioStation - 1);
            }
        } else {
            return;
        }
    }

    public void increaseVolume(int currentVolume) {
        if (currentVolume == 10) {
            setCurrentVolume(currentVolume);
        } else {
            setCurrentVolume(currentVolume + 1);
        }
    }

    public void decreaseVolume(int currentVolume) {
        if (currentVolume >= 0 & currentVolume <= 10) {
            if (currentVolume == 0) {
                return;
            } else {
                setCurrentVolume(currentVolume - 1);
            }
        }
    }
}
