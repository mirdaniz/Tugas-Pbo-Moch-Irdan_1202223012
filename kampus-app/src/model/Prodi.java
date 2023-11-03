package model;

public class Prodi {
    private String id;
    private String namaprodi;

    public Prodi(String id, String namaprodi){
        this.id = id;
        this.namaprodi = namaprodi;
    }

    public String getId(){
        return id;
    }
    
    public String getNamaprodi(){
        return namaprodi;
    }
}
