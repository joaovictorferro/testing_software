package br.com.ufal.iSoccer.physicalResources;

public class TrainingCenter {
    private boolean exist;
    private boolean available;
    private int bedroomsNumber;
    private int id_trainingCenter;

    public TrainingCenter(int id_trainingCenter,boolean exist, boolean available, int bedroomsNumber) {
        this.id_trainingCenter = id_trainingCenter;
        this.exist = exist;
        this.available = available;
        this.bedroomsNumber = bedroomsNumber;
    }

    public TrainingCenter(){}

    public int getId_trainingCenter() {
        return id_trainingCenter;
    }

    public void setId_trainingCenter(int id_trainingCenter) {
        this.id_trainingCenter = id_trainingCenter;
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

    public int getBedroomsNumber() {
        return bedroomsNumber;
    }

    public void setBedroomsNumber(int bedroomsNumber) {
        this.bedroomsNumber = bedroomsNumber;
    }
}