package entities;

public class PessoaJuridica extends Contribuente {
	private Integer numeroFuncionarios;
	
	public PessoaJuridica() {
		super();
	}
		
	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	
	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public double calculaImposto() {
		Double taxa = 0.0;
		if (numeroFuncionarios <= 10) {
			 taxa = getRendaAnual() * 0.16;
		} else if (numeroFuncionarios > 10) {
			 taxa = getRendaAnual() * 0.14;
		
		}
		return taxa;
	}
	
	
	
	
	
}
