package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
  private String backend;
  private String frontend;
  private String sgdb;
  private Integer horasMentoria;

  public DesenvolvedorWeb() {
  }

  public DesenvolvedorWeb(String nome, Integer qtdHoras, Double valorHora, String backend, String frontend, String sgdb, Integer horasMentoria) {
    super(nome, qtdHoras, valorHora);
    this.backend = backend;
    this.frontend = frontend;
    this.sgdb = sgdb;
    this.horasMentoria = horasMentoria;
  }

  @Override
  public Double calcularSalario() {
    return super.calcularSalario() + horasMentoria * 300.0;
  }

  public Boolean isFullstack() {
    if (backend != null && frontend != null && sgdb != null) {
      return true;
    } else {
      return false;
    }
  }
}
