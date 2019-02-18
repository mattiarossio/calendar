/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circolarexml;

/**
 *
 * @author Mattia_Rossi
 */
public class CircolareXML {

   
    private String disciplina;
    private String docente;
    private String giorno;
    private float ora;

    public CircolareXML() {
        this.disciplina = "";
        this.docente = "";
        this.giorno = "";
        this.ora = 0;
    }

    public CircolareXML(String disciplina, String docente, String giorno,
            float ora) {
        this.disciplina = disciplina;
        this.docente = docente;
        this.giorno = giorno;
        this.ora = ora;
    }

    public CircolareXML(CircolareXML circolareXML) {
        this.disciplina = circolareXML.disciplina;
        this.docente = circolareXML.docente;
        this.giorno = circolareXML.giorno;
        this.ora = circolareXML.ora;
    }

    public String getdisciplina() {
        return disciplina;
    }

    public String getdocente() {
        return docente;
    }

    public String getgiorno() {
        return giorno;
    }

    public float getora() {
        return ora;
    }

    public void setdisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setdocente(String docente) {
        this.docente = docente;
    }

    public void setgiorno(String giorno) {
        this.giorno = giorno;
    }

    public void setPrezzo(float ora) {
        this.ora = ora;
    }

    public String toString() {
        return "[" + disciplina + "] " + docente + ", \"" + giorno + "\" (" + ora + "h)";
    }
}
