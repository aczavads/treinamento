package treinamento.guilhermeperes.dia5.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import treinamento.guilhermeperes.dia5.jpa.conta.Conta;
import treinamento.guilhermeperes.dia5.jpa.conta.ContaRepository;
import treinamento.guilhermeperes.dia5.jpa.pessoa.CNPJ;
import treinamento.guilhermeperes.dia5.jpa.pessoa.CPF;
import treinamento.guilhermeperes.dia5.jpa.pessoa.PessoaFisica;
import treinamento.guilhermeperes.dia5.jpa.pessoa.PessoaFisicaRepository;
import treinamento.guilhermeperes.dia5.jpa.pessoa.PessoaJuridica;
import treinamento.guilhermeperes.dia5.jpa.pessoa.PessoaJuridicaRepository;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		
		ContaRepository repoConta = new ContaRepository(manager);
		PessoaFisicaRepository repoPessoaFisica = new PessoaFisicaRepository(manager);
		PessoaJuridicaRepository repoPessoaJuridica = new PessoaJuridicaRepository(manager);
		
		PessoaFisica pessoaFisica = new PessoaFisica("Guilherme Beidaki", new CPF("278.320.040-61"));
		PessoaJuridica pessoaJuridica = new PessoaJuridica("Paulo Cesar", new CNPJ("34.135.835/0001-70"));
		
		Conta conta1 = new Conta(1, LocalDate.of(2020, 1, 10), pessoaFisica);
		Conta conta2 = new Conta(2, LocalDate.of(2020, 1, 10), pessoaJuridica);
		
		try {
			manager.getTransaction().begin();
			
			repoPessoaFisica.save(pessoaFisica);
			repoPessoaJuridica.save(pessoaJuridica);
			
			repoConta.save(conta1);
			repoConta.save(conta2);
			
			conta1.creditar(LocalDate.of(2020, 1, 10), new BigDecimal(1000), "investimento renda fixa");
			conta1.creditar(LocalDate.of(2020, 1, 10), new BigDecimal(1000), "investimento B3");
			conta1.debitar(LocalDate.of(2020, 1, 10), new BigDecimal(1000), "cartao de credito");
			
			conta2.creditar(LocalDate.of(2020, 1, 10), new BigDecimal(1000), "investimento B3");
			conta2.creditar(LocalDate.of(2020, 1, 10), new BigDecimal(1000), "investimento B3");
			conta2.debitar(LocalDate.of(2020, 1, 10), new BigDecimal(1000), "boleto");
			
			repoConta.save(conta1);
			repoConta.save(conta2);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
		
		manager.clear();
		
		Conta contaDb1 = repoConta.findById(conta1.getId());
		Conta contaDb2 = repoConta.findById(conta2.getId());
		
		PessoaFisica fisica = repoPessoaFisica.findById(pessoaFisica.getId());
		PessoaJuridica juridica = repoPessoaJuridica.findById(pessoaJuridica.getId());
		
		System.out.println("Conta: " + contaDb1.getNumero() + " - " + contaDb1.getPessoa().getNome());
		System.out.println("Conta: " + contaDb2.getNumero() + " - " + contaDb2.getPessoa().getNome());
		
		System.out.println("Pessoa: " + fisica.getNome() + " - " + fisica.getContas().size());
		System.out.println("Pessoa: " + juridica.getNome() + " - " + juridica.getContas().size());
		
		conta1.getMovimentos().forEach(movimento ->
				System.out.println(movimento.getTipo() + " - " + movimento.getValor() + " - " + movimento.getDescricao()));
		
		conta2.getMovimentos().forEach(movimento ->
			System.out.println(movimento.getTipo() + " - " + movimento.getValor() + " - " + movimento.getDescricao()));
	}
}
