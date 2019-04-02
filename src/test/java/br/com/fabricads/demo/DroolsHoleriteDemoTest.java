package br.com.fabricads.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DroolsHoleriteDemoTest {

    KieSession kieSession;

    @Before
    public void init() {
        kieSession = KieServices.Factory.get().getKieClasspathContainer().newKieSession();
    }

    @Test
    public void calcularHolerite() {
        Double salario = 998d;
        Double diasTrabalhados = 22d;
        Double valorValeRefeicao = 20d;
        Double porcentagemGratificacao = 1d;
        TabelaIRPF tabelaIRPF = TabelaIRPF.builder()
                .deducaoLegal(189.59)
                .deduco(BaseIRPF.builder().valorInicial(0d).valorFinal(1903.98d).aliquota(0d).parcela(0d).build())
                .deduco(BaseIRPF.builder().valorInicial(1903.99d).valorFinal(2826.65d).aliquota(0.075d).parcela(142.80d).build())
                .deduco(BaseIRPF.builder().valorInicial(2826.66d).valorFinal(3751.05d).aliquota(0.15d).parcela(354.80d).build())
                .deduco(BaseIRPF.builder().valorInicial(3751.06d).valorFinal(4664.68d).aliquota(0.225d).parcela(636.13d).build())
                .deduco(BaseIRPF.builder().valorInicial(4664.69d).aliquota(0.275d).parcela(869.36d).build())
                .build();
        List<Verba> arrayLisVerbas = new ArrayList(Arrays.asList(
                Verba.builder().codigo(10).descricao("Salario").parametro(diasTrabalhados).valor(salario).tipo(Tipo.PROVENTO).medida(Medida.UNIDADE).incideIRRF(true).build(),
                Verba.builder().codigo(11).descricao("Gratificacao por desempenho").parametro(porcentagemGratificacao).tipo(Tipo.PROVENTO).medida(Medida.PORCENTAGEM).incideIRRF(true).build(),
                Verba.builder().codigo(19).descricao("Gratificacao periculosidade").parametro(0.4d).tipo(Tipo.PROVENTO).medida(Medida.PORCENTAGEM).incideIRRF(true).build(),
                Verba.builder().codigo(31).descricao("Auxilio refeicao").parametro(valorValeRefeicao).tipo(Tipo.PROVENTO).medida(Medida.UNIDADE).incideIRRF(true).build(),
                Verba.builder().codigo(22).descricao("Faltas").parametro(0d).tipo(Tipo.PROVENTO).medida(Medida.UNIDADE).incideIRRF(true).build(),
                Verba.builder().codigo(36).descricao("Plano saude").parametro(0.02d).tipo(Tipo.DESCONTO).medida(Medida.PORCENTAGEM).incideIRRF(false).build(),
                Verba.builder().codigo(39).descricao("Vale Transporte").parametro(0.06d).tipo(Tipo.DESCONTO).medida(Medida.PORCENTAGEM).incideIRRF(true).build()
        ));
        Funcionario funcionario = Funcionario.builder()
                .matricula(1)
                .nome("Paulo Henrique")
                .dependentes(0)
                .verbas(arrayLisVerbas)
                .build();

        kieSession.insert(tabelaIRPF);
        kieSession.insert(funcionario);
        kieSession.fireAllRules();
        kieSession.dispose();


        Assert.assertTrue(funcionario.getVerbas().stream().filter(verba -> verba.getCodigo() == 31).findFirst().get().getValor() == (diasTrabalhados * valorValeRefeicao)); // Valida regra CalcularVerbasPorUndidade
        Assert.assertTrue(funcionario.getVerbas().stream().filter(verba -> verba.getCodigo() == 11).findFirst().get().getValor() == (salario * porcentagemGratificacao)); // Valida regra CalcularVerbasPorPorcentagem
        System.out.println(funcionario);

    }

}
