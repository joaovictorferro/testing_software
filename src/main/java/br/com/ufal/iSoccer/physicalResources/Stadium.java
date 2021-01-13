package br.com.ufal.iSoccer.physicalResources;

public class Stadium {
    private boolean exist;
    private boolean available;
    private int chairsNumber;
    private int bathroomNumber;
    private int snackBarNumber;
    private int id_stadium;

    public Stadium(int id_stadium,boolean exist, boolean available, int chairsNumber, int bathroomNumber, int snackBarNumber) {
        this.id_stadium = id_stadium;
        this.exist = exist;
        this.available = available;
        this.chairsNumber = chairsNumber;
        this.bathroomNumber = bathroomNumber;
        this.snackBarNumber = snackBarNumber;
    }

    public Stadium(){};

    public int getId_stadium() {
        return id_stadium;
    }

    public void setId_stadium(int id_stadium) {
        this.id_stadium = id_stadium;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getChairsNumber() {
        return chairsNumber;
    }

    public void setChairsNumber(int chairsNumber) {
        this.chairsNumber = chairsNumber;
    }

    public int getBathroomNumber() {
        return bathroomNumber;
    }

    public void setBathroomNumber(int bathroomNumber) {
        this.bathroomNumber = bathroomNumber;
    }

    public int getSnackBarNumber() {
        return snackBarNumber;
    }

    public void setSnackBarNumber(int snackBarNumber) {
        this.snackBarNumber = snackBarNumber;
    }
}