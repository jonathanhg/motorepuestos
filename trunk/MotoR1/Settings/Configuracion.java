/*
 * Esta clase mantiene la configuracion
 * de los parametros del programa
 */
package Settings;

import java.awt.Font;

/**
 *
 * @author Administrador
 */
public class Configuracion {

    private String rutaDeReportes; //ruta donde se guardan los reportes generados

    private int diasHabilesAnulacion; //cantidad de dias que pueden transcurrir para anular una factura

    private String nombreEmpresa;
    private String nombreDuenio;
    private String cedulaDuenio;
    private String direccion1;
    private String direccion2;
    private String telefono;
    private String nmroAutorizado; //autorizado mediante el oficio numero:
    private String paginaWeb;
    private int margenSup;
    private int margenIzq;
    private int tamLetra;
    private int interlineado;
    private Font fuente;

    public Configuracion() {
        rutaDeReportes = "\\ReportesMRSP\\";
        diasHabilesAnulacion = 6;
        parametrosEmpresa();
        parametrosImpresora();
    }

    private void parametrosEmpresa() {
        setNombreEmpresa("MOTO REPUESTOS SAN PEDRO");
        setNombreDuenio("XINIA CASTILLO HIDALGO");
        setCedulaDuenio("1-602-294");
        setDireccion1("B. SAPRISSA; SN PEDRO MONT. DE OCA");
        setDireccion2("400NE S. TACHO.");
        setTelefono("22340718");
        setNmroAutorizado("01-0308-8 DEL 05-D9-1997   D.G.T.D");
        setPaginaWeb("WWW.MRSANPEDRO.COM");

    }

    private void parametrosImpresora() {
        setMargenSup(15);
        setMargenIzq(30);
        setTamLetra(9);
        setInterlineado(11);
        setFuente(new Font("Dialog", Font.PLAIN, getTamLetra()));
    }
    
    public String getRutaDeReportes() {
        return rutaDeReportes;
    }

    public void setRutaDeReportes(String rutaDeReportes) {
        this.rutaDeReportes = rutaDeReportes;
    }

    public int getDiasHabilesAnulacion() {
        return diasHabilesAnulacion;
    }

    public void setDiasHabilesAnulacion(int diasHabilesAnulacion) {
        this.diasHabilesAnulacion = diasHabilesAnulacion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public String getCedulaDuenio() {
        return cedulaDuenio;
    }

    public void setCedulaDuenio(String cedulaDuenio) {
        this.cedulaDuenio = cedulaDuenio;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNmroAutorizado() {
        return nmroAutorizado;
    }

    public void setNmroAutorizado(String nmroAutorizado) {
        this.nmroAutorizado = nmroAutorizado;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getMargenSup() {
        return margenSup;
    }

    public void setMargenSup(int margenSup) {
        this.margenSup = margenSup;
    }

    public int getMargenIzq() {
        return margenIzq;
    }

    public void setMargenIzq(int margenIzq) {
        this.margenIzq = margenIzq;
    }

    public int getTamLetra() {
        return tamLetra;
    }

    public void setTamLetra(int tamLetra) {
        this.tamLetra = tamLetra;
    }

    public int getInterlineado() {
        return interlineado;
    }

    public void setInterlineado(int interlineado) {
        this.interlineado = interlineado;
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
    }

    
}
