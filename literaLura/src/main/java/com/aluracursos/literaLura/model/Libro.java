package com.aluracursos.literaLura.model;

import com.aluracursos.literaLura.model.autor.Autor;
import com.aluracursos.literaLura.model.autor.DatosAutor;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro implements Comparable<Libro> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String titulo;

    // Un solo autor por libro
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id")  // Relación con autor, la clave foránea se define aquí
    private Autor autor;

    @Column(name = "idioma")
    private List<String> idiomas;

    @Column(unique = true)
    private Double numeroDeDescargas;

    // Nuevas columnas para cada tipo de formato
    @Column(name = "text_html")
    private String textHtml;

    @Column(name = "application_epub_zip")
    private String applicationEpubZip;

    @Column(name = "application_x_mobipocket_ebook")
    private String applicationXMobiPocketEbook;

    @Column(name = "application_rdf_xml")
    private String applicationRdfXml;

    @Column(name = "image_jpeg")
    private String imageJpeg;

    @Column(name = "text_plain")
    private String textPlain;

    @Column(name = "application_octet_stream")
    private String applicationOctetStream;

    @Override
    public int compareTo(Libro otroLibro) {
        return this.titulo.compareTo(otroLibro.getTitulo());
    }

    // Constructor sin parámetros
    public Libro() { }
    public void setLibros(Autor autor) {
    }

    // Constructor con DatosLibros
    public Libro(DatosLibros datos) {
        this.titulo = datos.titulo();

        // Suponiendo que solo hay un autor (y que datos.autor() es una lista de autores)
        if (datos.autor() != null && !datos.autor().isEmpty()) {
            DatosAutor autorData = datos.autor().get(0);  // Tomamos el primer autor de la lista
            this.autor = new Autor(null, autorData.nombre(), autorData.fechaDeNacimiento(), autorData.fechaDefallecimiento());
        }

        this.idiomas = datos.idiomas();
        this.numeroDeDescargas = datos.numeroDeDescargas();

        // Asigna los valores de los formatos a las nuevas columnas
        this.textHtml = datos.formatos().get("text/html");
        this.applicationEpubZip = datos.formatos().get("application/epub+zip");
        this.applicationXMobiPocketEbook = datos.formatos().get("application/x-mobipocket-ebook");
        this.applicationRdfXml = datos.formatos().get("application/rdf+xml");
        this.imageJpeg = datos.formatos().get("image/jpeg");
        this.textPlain = datos.formatos().get("text/plain; charset=us-ascii");
        this.applicationOctetStream = datos.formatos().get("application/octet-stream");
    }

    // Getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public String getTextHtml() {
        return textHtml;
    }

    public void setTextHtml(String textHtml) {
        this.textHtml = textHtml;
    }

    public String getApplicationEpubZip() {
        return applicationEpubZip;
    }

    public void setApplicationEpubZip(String applicationEpubZip) {
        this.applicationEpubZip = applicationEpubZip;
    }

    public String getApplicationXMobiPocketEbook() {
        return applicationXMobiPocketEbook;
    }

    public void setApplicationXMobiPocketEbook(String applicationXMobiPocketEbook) {
        this.applicationXMobiPocketEbook = applicationXMobiPocketEbook;
    }

    public String getApplicationRdfXml() {
        return applicationRdfXml;
    }

    public void setApplicationRdfXml(String applicationRdfXml) {
        this.applicationRdfXml = applicationRdfXml;
    }

    public String getImageJpeg() {
        return imageJpeg;
    }

    public void setImageJpeg(String imageJpeg) {
        this.imageJpeg = imageJpeg;
    }

    public String getTextPlain() {
        return textPlain;
    }

    public void setTextPlain(String textPlain) {
        this.textPlain = textPlain;
    }

    public String getApplicationOctetStream() {
        return applicationOctetStream;
    }

    public void setApplicationOctetStream(String applicationOctetStream) {
        this.applicationOctetStream = applicationOctetStream;
    }


}