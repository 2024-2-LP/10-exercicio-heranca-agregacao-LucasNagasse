package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor {
  private String plataforma;
  private String linguagem;
  private Integer horasPrototipacao;

  public DesenvolvedorMobile() {
  }

  public DesenvolvedorMobile(String nome, Integer qtdHoras, Double valorHora, String plataforma, String linguagem, Integer horasPrototipacao) {
    super(nome, qtdHoras, valorHora);
    this.plataforma = plataforma;
    this.linguagem = linguagem;
    this.horasPrototipacao = horasPrototipacao;
  }

  @Override
  public Double calcularSalario() {
    return super.calcularSalario() + horasPrototipacao * 200.0;
  }
}
