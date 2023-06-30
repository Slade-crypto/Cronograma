package renansander.cronogramanovo.models;

public class ProfessorModel {
    String id;
    String nomeProfessor;
    String descricaoProfessor;
    String imageProfessor;

    public ProfessorModel(String id, String nomeProfessor, String descricaoProfessor, String imageProfessor) {
        this.id = id;
        this.nomeProfessor = nomeProfessor;
        this.descricaoProfessor = descricaoProfessor;
        this.imageProfessor = imageProfessor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getDescricaoProfessor() {
        return descricaoProfessor;
    }

    public void setDescricaoProfessor(String descricaoProfessor) {
        this.descricaoProfessor = descricaoProfessor;
    }

    public String getImageProfessor() {
        return imageProfessor;
    }

    public void setImageProfessor(String imageProfessor) {
        this.imageProfessor = imageProfessor;
    }
}

