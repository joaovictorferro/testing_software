package br.com.ufal.iSoccer.physicalResources;

public class Bus {
    private boolean exist;
    private boolean available;
    private int id_bus;

    public Bus(boolean exist, boolean available,int id_bus) {
        this.exist = exist;
        this.available = available;
        this.id_bus = id_bus;
    }

    public Bus(){}

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
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
}