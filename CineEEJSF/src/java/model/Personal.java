package model;

public class Personal {
    // idPer nomPer apePer dniPer   dirPer tipPer   sexPer usuPer pwdPer  ubiPer
    private int idPer ;
    private String nomPer; 
    private String apePer;
    private String dniPer ; // de tipo entero max 8 
    private String dirPer ;
    private int tipPer; // 0: administrador, 1: usuario, 2: cliente
    private String sexPer;  // M: masculino, F: femenino
    private String usuPer;
    private String pwdPer;
    private String codUbi; // código ubigeo: 

    public int getIdPer() {
        return idPer;
    }

    public void setIdPer(int idPer) {
        this.idPer = idPer;
    }

    public String getNomPer() {
        return nomPer;
    }

    public void setNomPer(String nomPer) {
        this.nomPer = nomPer;
    }

    public String getApePer() {
        return apePer;
    }

    public void setApePer(String apePer) {
        this.apePer = apePer;
    }

    public String getDniPer() {
        return dniPer;
    }

    public void setDniPer(String dniPer) {
        this.dniPer = dniPer;
    }

    public String getDirPer() {
        return dirPer;
    }

    public void setDirPer(String dirPer) {
        this.dirPer = dirPer;
    }

    public int getTipPer() {
        return tipPer;
    }

    public void setTipPer(int tipPer) {
        this.tipPer = tipPer;
    }

    public String getSexPer() {
        return sexPer;
    }

    public void setSexPer(String sexPer) {
        this.sexPer = sexPer;
    }

    public String getUsuPer() {
        return usuPer;
    }

    public void setUsuPer(String usuPer) {
        this.usuPer = usuPer;
    }

    public String getPwdPer() {
        return pwdPer;
    }

    public void setPwdPer(String pwdPer) {
        this.pwdPer = pwdPer;
    }

    public String getCodUbi() {
        return codUbi;
    }

    public void setCodUbi(String codUbi) {
        this.codUbi = codUbi;
    }
            
}
