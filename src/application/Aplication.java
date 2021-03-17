package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Contribuente;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Aplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		List<Contribuente> lista = new ArrayList<>();

		System.out.print("Informe o numero de Contribuentes:");
		int n = teclado.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Contribuente #" + i + " Dados:");
			System.out.print("Pessoa Fisica ou Pessoa Juridica? (f/j)");
			char resp = teclado.next().charAt(0);
			System.out.print("Nome:");
			teclado.nextLine();
			String nome = teclado.nextLine();
			System.out.print("Renda Anual:");
			Double renda = teclado.nextDouble();

			if (resp == 'f' || resp == 'F') {
				System.out.print("Gasto com Saúde:");
				double saude = teclado.nextDouble();
				lista.add(new PessoaFisica(nome, renda, saude));
			} else {
				System.out.print("Numero de Funcionarios:");
				int numero = teclado.nextInt();
				lista.add(new PessoaJuridica(nome, renda, numero));
			}
		}
		System.out.println();
		System.out.println("TAXAS PAGAS:");

		Double soma = 0.0;
		for (Contribuente cont : lista) {
			System.out.print(cont.getNome() + ": $ " + String.format("%.2f%n", cont.calculaImposto()));
			soma += cont.calculaImposto();

		}
		System.out.println();
		System.out.printf("TOTAL TAXAS: $ %.2f", soma);

		teclado.close();
	}

}
