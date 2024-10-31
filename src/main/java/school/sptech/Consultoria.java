package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
  private String nome;
  private Integer vagas;
  private List<Desenvolvedor> desenvolvedores;

  public Consultoria() {
  }

  public Consultoria(String nome, Integer vagas) {
    this.nome = nome;
    this.vagas = vagas;
    this.desenvolvedores = new ArrayList<Desenvolvedor>();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getVagas() {
    return vagas;
  }

  public void setVagas(Integer vagas) {
    this.vagas = vagas;
  }

  public Boolean contratar(Desenvolvedor desenvolvedor) {
    if (vagas > desenvolvedores.size()) {
      desenvolvedores.add(desenvolvedor);
      return true;
    }
    return false;
  }

  public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor) {
    if (desenvolvedor.isFullstack()) {
      contratar(desenvolvedor);
      return true;
    }
    return false;
  }

  public Double getTotalSalarios() {
    return desenvolvedores.stream().map(Desenvolvedor::calcularSalario).reduce(Double::sum).orElse(0.0);
  }

  public Integer qtdDesenvolvedoresMobile() {
    return (int) desenvolvedores.stream().filter(desenvolvedor -> desenvolvedor instanceof DesenvolvedorMobile).count();
  }

  public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
    return desenvolvedores.stream().filter(desenvolvedor -> desenvolvedor.calcularSalario() >= salario).toList();
  }

  public Desenvolvedor buscarMenorSalario() {
    return desenvolvedores.stream().reduce((menorSalario, desenvolvedor) -> desenvolvedor.calcularSalario() < menorSalario.calcularSalario() ? desenvolvedor : menorSalario).orElse(null);
  }

  public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
    return desenvolvedores.stream().filter(desenvolvedor -> {
      if (desenvolvedor instanceof DesenvolvedorMobile) {
        DesenvolvedorMobile desenvolvedorMobile = (DesenvolvedorMobile) desenvolvedor;
        if (
          desenvolvedorMobile.getPlataforma() != null
          && desenvolvedorMobile.getPlataforma().contains(tecnologia)
          || desenvolvedorMobile.getLinguagem() != null
          && desenvolvedorMobile.getLinguagem().contains(tecnologia)
        ) {
          return true;
        }
      } else if (desenvolvedor instanceof DesenvolvedorWeb) {
        DesenvolvedorWeb desenvolvedorWeb = (DesenvolvedorWeb) desenvolvedor;
        if (
          desenvolvedorWeb.getBackend() != null
          && desenvolvedorWeb.getBackend().contains(tecnologia)
          || desenvolvedorWeb.getFrontend() != null
          && desenvolvedorWeb.getFrontend().contains(tecnologia)
          || desenvolvedorWeb.getSgbd() != null
          && desenvolvedorWeb.getSgbd().contains(tecnologia)
        ) {
          return true;
        }
      }
      return false;
    }).toList();
  }

  public Double getTotalSalariosPorTecnologia(String tecnologia) {
    return buscarPorTecnologia(tecnologia).stream().map(Desenvolvedor::calcularSalario).reduce(Double::sum).orElse(0.0);
  }
}
