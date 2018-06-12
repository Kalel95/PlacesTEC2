/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Estructuras;

/**
 *
 * @author Joel
 */
public class Lugar {
    private int Codigo;
    private int Latitud;
    private int Longitud;
    private String Lugar;
    private String medio;
    private String dia;
    private String mes;
    private String año;

    public Lugar(int Codigo,int Latitud, int Longitud, String Lugar, String medio, String dia, String mes, String año) {
        this.Codigo = Codigo;
        this.Latitud = Latitud;
        this.Longitud = Longitud;
        this.Lugar = Lugar;
        this.medio = medio;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }  

    public Lugar(String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getLatitud() {
        return Latitud;
    }

    public void setLatitud(int Latitud) {
        this.Latitud = Latitud;
    }

    public int getLongitud() {
        return Longitud;
    }

    public void setLongitud(int Longitud) {
        this.Longitud = Longitud;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Usuario) {
        this.Codigo = Codigo;
    }


    
    public String toString() {
	String Dato= "\n| Código: "+this.Codigo+"\n| Latitud: "+this.Latitud+"\t| Longitud: "+this.Longitud+
				"\n| Lugar: "+this.Lugar+"\t| Medio: "+this.medio+"\t| dia: "+this.dia+"\t| mes: "+
                this.mes+"\t| año: "+this.año+"\n------------------------------------------------------------";
				
	return Dato;
	}
    public void modificarLugar(int Codigo,int Latitud, int Longitud, String Lugar, String medio, String dia, String mes, String año) {
	this.Codigo = Codigo;
        this.Latitud = Latitud;
        this.Longitud = Longitud;
        this.Lugar = Lugar;
        this.medio = medio;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
	}
    
}
