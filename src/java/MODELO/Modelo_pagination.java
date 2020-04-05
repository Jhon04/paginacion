package MODELO;

public class Modelo_pagination {
    private int id_p;
    private String no_p;

    public Modelo_pagination() {
    }

    public Modelo_pagination(int id_p, String no_p) {
        this.id_p = id_p;
        this.no_p = no_p;
    }
    
    /**
     * @return the id_p
     */
    public int getId_p() {
        return id_p;
    }

    /**
     * @param id_p the id_p to set
     */
    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    /**
     * @return the no_p
     */
    public String getNo_p() {
        return no_p;
    }

    /**
     * @param no_p the no_p to set
     */
    public void setNo_p(String no_p) {
        this.no_p = no_p;
    }
    
}
