package Modelo;

import java.io.InputStream;

public class PdfVO {

    int codigopdf;
    String nombrepdf;
    String direccionpdf;
    InputStream archivopdf;
    private byte[] archivopdf2;
    int FirmaAdmin;

    public PdfVO(int id, String name,String direccion, byte[] archivo,int ad) {
        this.codigopdf = id;
        this.nombrepdf = name;
        this.direccionpdf = direccion;
        this.archivopdf2 = archivo;
        this.FirmaAdmin = ad;
    }

    public PdfVO() {
    }

    public int getFirmaAdmin() {
        return FirmaAdmin;
    }

    public void setFirmaAdmin(int FirmaAdmin) {
        this.FirmaAdmin = FirmaAdmin;
    }
    
    public String getDireccionpdf() {
        return direccionpdf;
    }

    public void setDireccionpdf(String direccionpdf) {
        this.direccionpdf = direccionpdf;
    }
    
    /*Todo los codigos get*/
    public int getCodigopdf() {
        return codigopdf;
    }

    public String getNombrepdf() {
        return nombrepdf;
    }

    public InputStream getArchivopdf() {
        return archivopdf;
    }


    /*Todo los codigos set*/
    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public void setNombrepdf(String nombrepdf) {
        this.nombrepdf = nombrepdf;
    }

    public void setArchivopdf(InputStream archivopdf) {
        this.archivopdf = archivopdf;
    }

    /**
     * @return the archivopdf2
     */
    public byte[] getArchivopdf2() {
        return archivopdf2;
    }

    /**
     * @param archivopdf2 the archivopdf2 to set
     */
    public void setArchivopdf2(byte[] archivopdf2) {
        this.archivopdf2 = archivopdf2;
    }

}
